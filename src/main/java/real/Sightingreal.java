package real;

import models.Sighting;

import java.util.List;

public interface Sightingreal {
    //implement CRUD
    void add(Sighting sighting);
    List<Sighting> getAll();

}
