package Lab2;

public class Client extends User {
int bill;
String address;


    public Client(int bill, String address,String login, String password, String email, int phoneNum) {
        super(login, password, email, phoneNum);
        this.bill=bill;
        this.address=address;
    }

    @Override
    public void Add(String email) {
        super.Add(email);
    }

    @Override
    public void Add(int randomNum) {
        super.Add(randomNum);
    }

    @Override
    public String toString() {
        return "Client{" +
                "bill=" + bill +
                ", address='" + address + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum=" + phoneNum +
                '}';
    }
}
