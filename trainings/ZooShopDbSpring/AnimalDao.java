import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public  class AnimalDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void saveAnimal(Animal animal) {
        String sql = "INSERT INTO animal_table ( name, age, colour)"
                + " VALUES ( ?, ?, ?)";
        jdbcTemplate.update(sql, animal.getName(), animal.getAge(), animal.getColour());
    }
    public void delete(int id) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "DELETE FROM cat_table WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
    public List<Animal> getAllCats() {

        String sql = "SELECT * FROM animal_table";
        List<Animal> listAnimal = jdbcTemplate.query(sql, new RowMapper<Animal>() {
            @Override
            public Animal mapRow(ResultSet rs, int rowNum) throws SQLException {
                Animal animals = new Animal();
                animals.setName(rs.getString("name"));
                animals.setAge(rs.getInt("age"));
                animals.setColour(rs.getString("colour"));
                return animals;
            }
        });
        for (Animal aAnimal : listAnimal) {
            System.out.println(aAnimal);

        }return listAnimal;
    }
    }
