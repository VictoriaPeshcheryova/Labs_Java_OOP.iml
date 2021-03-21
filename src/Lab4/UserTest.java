package Lab4;

import Lab3.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getLogin() {
       User user=new User("1234admin","0000");
       String expected ="1234admin";
       assertEquals(expected,user.getLogin());
    }

    @Test
    void setLogin() {
        User user=new User("1234admin","0000");
        user.setLogin("2424smth");
        assertEquals("2424smth",user.getLogin());
    }

    @Test
    void getPassword() {
        User user=new User("1234admin","0000");
        String expected ="0000";
        assertEquals(expected,user.getPassword());
    }

    @Test
    void setPassword() {
        User user=new User("1234admin","0000");
        user.setPassword("9999");
        assertEquals("2424smth",user.getPassword());
    }
}