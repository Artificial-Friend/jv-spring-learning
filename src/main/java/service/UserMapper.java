package service;

import dto.UserResponseDto;
import java.util.List;
import model.User;

public interface UserMapper {
    List<User> getUserListFromDto(List<UserResponseDto> userResponseDto);

    User getUserFromDto(UserResponseDto userResponseDto);

    List<UserResponseDto> getUserDtoListFromUser(List<User> users);

    UserResponseDto getUserDtoFromUser(User user);
}
