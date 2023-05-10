package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Mercedes", 1);
      Car car2 = new Car("Audi", 2);
      Car car3 = new Car("Dodge", 3);
      Car car4 = new Car("DeLorean", 4);

      List<User> users = userService.getUserList();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
      }

      userService.add(new User("Bruce", "Wayne", "wayne@mail.ru", car1));
      userService.add(new User("Tony", "Stark", "stark@mail.ru", car2));
      userService.add(new User("Dominic ", "Toretto", "toretto@mail.ru", car3));
      userService.add(new User("Marty", "McFly", "mcfly@mail.ru", car4));


      System.out.println(userService.getUserCar(new Car("Mercedes", 1)));

      context.close();
   }
}
