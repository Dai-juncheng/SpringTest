package pojo;

public class User {
    private String username;
    private String passwrod;

    public User() {
    }

    public User(String username, String passwrod) {
        this.username = username;
        this.passwrod = passwrod;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passwrod='" + passwrod + '\'' +
                '}';
    }

}
