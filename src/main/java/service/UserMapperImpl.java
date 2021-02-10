package service;

import dto.UserResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public List<User> getUserListFromDto(List<UserResponseDto> userResponseDto) {
        return userResponseDto
                .stream()
                .map(this::convertUserResponseDtoToUser)
                .collect(Collectors.toList());
    }

    @Override
    public User getUserFromDto(UserResponseDto userResponseDto) {
        return convertUserResponseDtoToUser(userResponseDto);
    }

    @Override
    public List<UserResponseDto> getUserDtoListFromUser(List<User> users) {
        return users
                .stream()
                .map(this::convertUserToUserResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserDtoFromUser(User user) {
        return convertUserToUserResponseDto(user);
    }

    private User convertUserResponseDtoToUser(UserResponseDto dtoUser) {
        User user = new User();
        user.setAge(dtoUser.getAge());
        user.setName(dtoUser.getName());
        user.setSurname(dtoUser.getSurname());
        user.setId(dtoUser.getId());
        return user;
    }

    private UserResponseDto convertUserToUserResponseDto(User user) {
        UserResponseDto dtoUser = new UserResponseDto();
        dtoUser.setAge(user.getAge());
        dtoUser.setName(user.getName());
        dtoUser.setSurname(user.getSurname());
        dtoUser.setId(user.getId());
        return dtoUser;
    }
}
