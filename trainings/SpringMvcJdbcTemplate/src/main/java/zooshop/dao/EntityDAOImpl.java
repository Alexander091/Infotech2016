package zooshop.dao;

import org.springframework.jdbc.core.RowMapper;
import zooshop.annotation.Attribute;
import zooshop.annotation.ObjectType;
import zooshop.model.Animal;
import zooshop.model.Entity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityDAOImpl implements EntityDAO {

    private JdbcTemplate jdbcTemplate;

	public EntityDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

    public List<Animal> listAnimal() {
        String sql = "SELECT object_id,name FROM objects";
        List<Animal> listAnimal = jdbcTemplate.query(sql, new RowMapper<Animal>() {

            @Override
            public Animal mapRow(ResultSet rs, int rowNum) throws SQLException {
                Animal animal = new Animal();
                animal.setObjectId(rs.getInt("object_id"));
                animal.setName(rs.getString("name"));
                return animal;
            }

        });

        return listAnimal;
    }


    public List<Animal>  list(int object_id){
        String sql ="select a.name,p.value from params p, attributes a" +
                " where a.attr_id in (select a.attr_id from attr_object_type " +
                "where object_type_id = 222) and p.attr_id = a.attr_id " +
                "and p.object_id = "+object_id;
        List<Animal> animal  = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(Animal.class));
        return animal;
    }



    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    private static List<Field> getInheritedFields(Class<?> type) {

        List<Field> fields = new ArrayList<>();
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }

    public <T extends Entity> void save(T obj) throws IllegalAccessException {
        Class clazz = obj.getClass();
        List<Field> fieldClass = getInheritedFields(obj.getClass());
        String o_id = "SELECT MAX (object_id) FROM objects";
        int total = getJdbcTemplate().queryForInt(o_id)+1;
        for (Field field : fieldClass) {
            if (field.isAnnotationPresent(Attribute.class)) {
                field.setAccessible(true);
                Attribute attribute = field.getAnnotation(Attribute.class);
                if (attribute.value() == 33) {if (clazz.isAnnotationPresent(ObjectType.class)) {
                    ObjectType objectType = (ObjectType) clazz.getAnnotation(ObjectType.class);
                    String sql = "INSERT INTO objects ( parent_id, object_type_id, name) VALUES ( ?, ?, ?)";
                    jdbcTemplate.update(sql, new Object[]{1, objectType.value(), field.get(obj).toString(),
                    });

                }
                } else {

                    String sql = "INSERT INTO params (attr_id, object_id, value) VALUES (?, ?, ?)";
                    jdbcTemplate.update(sql, new Object[]{attribute.value(),
                            total, field.get(obj).toString()
                    });
                }
            }
        }
    }

    public void delete(int objectId) {
        String sql = "DELETE FROM objects WHERE object_id=?";
        jdbcTemplate.update(sql, objectId);
        String sql2 = "DELETE FROM params WHERE object_id=?";
        jdbcTemplate.update(sql2, objectId);
    }
}
