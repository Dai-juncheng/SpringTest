package pojo;

public class Car {
    private String carNumber;
    private String type;

    public Car() {
    }

    public Car(String carNumber, String type) {
        this.carNumber = carNumber;
        this.type = type;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNumber='" + carNumber + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
