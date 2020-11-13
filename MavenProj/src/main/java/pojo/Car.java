package pojo;

public class Car {
    int id;
    String carid;
    String type;
    public  Car(){

    }

    public Car(int id, String carid, String type) {
        this.id = id;
        this.carid = carid;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
