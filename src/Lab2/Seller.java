package Lab2;

import java.time.LocalDate;

public class Seller extends User{
int numSector;
LocalDate date;
int bonuses;

    public Seller(String login, String password,
                  String email, int phoneNum,
                  int numSector, LocalDate date, int bonuses ) {
        super(login, password, email, phoneNum);
        this.numSector=numSector;
        this.bonuses=bonuses;

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
        return "Seller{" +
                "numSector=" + numSector +
                ", date=" + date +
                ", bonuses=" + bonuses +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum=" + phoneNum +
                '}';
    }
}
