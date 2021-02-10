package controllers;

import dto.UserResponseDto;
import java.util.List;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserMapper;
import service.UserService;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserControllerImpl(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    @GetMapping("/inject")
    public String injectMockUsersData() {
        userService.add(new User("Bob", "Bobbinson", 10));
        userService.add(new User("Alice", "Alisson", 20));
        userService.add(new User("John", "Johnson", 30));
        userService.add(new User("Bruce", "Brussinson", 40));
        return "Mock data were injected";
    }

    @Override
    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return userMapper.getUserDtoFromUser(userService.get(userId));
    }

    @Override
    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        return userMapper.getUserDtoListFromUser(userService.listUsers());
    }
}
