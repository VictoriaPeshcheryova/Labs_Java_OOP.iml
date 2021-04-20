package Lab5;


import Lab5.daoimp.ProductDaoImpl;
import Lab5.daoimp.UserDaoImpl;
import Lab5.entities.Product;
import Lab5.entities.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class main {

    public static void main(String[] args) throws SQLException {

        UserDaoImpl udi=new UserDaoImpl();
        ProductDaoImpl pdi=new ProductDaoImpl();

        /**Insert a new record**/
       // User user = new User("admin","1111");
       // udi.insert(user);

       // Product product=new Product("Smart TV", "Apple",33000,true);
       // pdi.insert(product);

        /**Select by id**/
        //User userSelect = udi.selectBYId(1);
        //System.out.println(userSelect.getId()+", "+userSelect.getLogin()+", "+userSelect.getPassword());

       // Product productSelect = pdi.selectBYId(1);
       // System.out.println(productSelect.getId()+", " +
               // ""+productSelect.getNameOfTheProduct()+", " +
              //  ""+productSelect.getCompanyNameOfAProduct()+", " +
              //  ""+productSelect.getPriceOfAProduct()+"," +
             //   " "+ productSelect.isAvailable());


        /**Delete user/product by id**/
       // udi.delete(1);
        pdi.delete(1);

        /**Update user/product**/
        //User userUpdate = new User("Tom","J3333");
        //udi.update(userUpdate,1);

       // Product productUpdate = new Product("Watches", "Samsung",3300,false);
       // pdi.update(productUpdate,1);

        /**Select all users/products**/

        List<User> users = udi.selectAll();
        for(User u : users) {
            System.out.println(u.getId()+", "+u.getLogin()+", "+u.getPassword());
        }

        List<Product> products = pdi.selectAll();
        for(Product p : products) {
            System.out.println(p.getId()+", " +
                    ""+p.getNameOfTheProduct()+", " +
                    ""+p.getCompanyNameOfAProduct()+", " +
                    ""+p.getPriceOfAProduct()+"," +
                    " "+ p.isAvailable());
        }

    }

}
