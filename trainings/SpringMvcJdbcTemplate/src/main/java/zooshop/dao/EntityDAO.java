package zooshop.dao;

import zooshop.model.Animal;
import zooshop.model.Entity;

import java.util.List;


public interface EntityDAO {

    public List<Animal> list (int object_id);
    public <T extends Entity> void save (T obj) throws IllegalAccessException;
    public void delete(int objectId);
    public List<Animal>  listAnimal();


}
