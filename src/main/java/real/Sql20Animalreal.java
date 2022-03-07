package real;

import models.Animal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql20Animalreal implements Animalreal {

    private Sql2o sql2o;

    public Sql20Animalreal(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Animal animals) {
        String insert = "INSERT INTO animals (name, age, health) VALUES (:name, :age, :health)";

        try(Connection con = sql2o.open()){
            int id;
            id = (int) con.createQuery(insert, true)
                    .bind(animals)
                    .executeUpdate()
                    .getKey();
            animals.setId(id);
        }catch (Sql2oException error){
            System.out.println("Object was not possible to add because of " + error);
        }

    }


    @Override
    public List<Animal> getAll(){
        String sql = "SELECT * FROM animals";
        try(Connection con = sql2o.open()){
            return  con.createQuery(sql)
                    .executeAndFetch(Animal.class);

        }
    }
}
