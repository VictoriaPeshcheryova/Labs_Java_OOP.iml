package Lab2;

public class User {
    String login;
    String password;
    String email;
    int phoneNum;

    public User(String login,String password,String email,int phoneNum) {
        this.login = login;
        this.password = password;
        this.email= email;
        this.phoneNum=phoneNum;

    }
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
    public void Add(String email){
        System.out.println(this.email+email);
    }
    public void Add(int randomNum){
        System.out.println(getPhoneNum()+randomNum);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum=" + phoneNum +
                '}';
    }


}
