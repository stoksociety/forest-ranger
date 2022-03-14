package real;


import models.Sighting;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql20Sightingreal implements Sightingreal {

    private Sql2o sql2o;

    public Sql20Sightingreal(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Sighting sighting) {
        String insert = "INSERT INTO animals (name, age, health) VALUES (:name, :age, :health)";

        try(Connection con = sql2o.open()){
            int id;
            id = (int) con.createQuery(insert, true)
                    .bind(sighting)
                    .executeUpdate()
                    .getKey();
            sighting.setId(id);
        }catch (Sql2oException error){
            System.out.println("Object was not possible to add because of " + error);
        }

    }


    @Override
    public List<Sighting> getAll(){
        String sql = "SELECT * FROM animals";
        try(Connection con = sql2o.open()){
            return  con.createQuery(sql)
                    .executeAndFetch(Sighting.class);

        }
    }
}
