package models;

public class Sighting extends Animal {

    public String rangerName;
  public String location;
  public String Timestamp;

    public Sighting(String rangerName, String location  ,String Name, String health, String age ) {
        super(Name,health ,age);
        this.rangerName=rangerName;
        this.location=location;


    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public String getLocation() {
        return location;
    }

//    public String getTimestamp() {
//        return Timestamp;
//    }
//
//    public void setTimestamp(String timestamp) {
//        Timestamp = timestamp;
//    }

    public void setLocation(String location) {
        this.location = location;
    }
}

