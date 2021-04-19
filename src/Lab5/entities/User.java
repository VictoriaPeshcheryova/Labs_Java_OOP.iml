package Lab5.entities;

import java.io.Serializable;

public class User implements Serializable {

    int id;
    String login;
    String password;

    public User() { }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public int getId() { return id; }

    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setId(int id) { this.id = id; }

    public User( String login, String password) {
        this.login = login;
        this.password = password;
    }
}
