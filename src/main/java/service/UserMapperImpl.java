package service;

import dto.UserResponseDto;
import model.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {
    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto dtoUser = new UserResponseDto();
        dtoUser.setAge(user.getAge());
        dtoUser.setName(user.getName());
        dtoUser.setSurname(user.getSurname());
        dtoUser.setId(user.getId());
        return dtoUser;
    }
}
