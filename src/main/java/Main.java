import config.AppConfig;
import java.util.List;
import model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Bob", "Bobbinson", 10));
        userService.add(new User("Alice", "Alisson", 20));
        userService.add(new User("John", "Johnson", 30));

        List<User> users = userService.listUsers();
        System.out.println(users);
    }
}
