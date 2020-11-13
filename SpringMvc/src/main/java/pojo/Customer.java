package pojo;

public class Customer {
    private String name;
    private String password;
    private String tel;
    private Car car;

    public Customer() {
    }

    public Customer(String name, String password, String tel, Car car) {
        this.name = name;
        this.password = password;
        this.tel = tel;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", car=" + car +
                '}';
    }

}

