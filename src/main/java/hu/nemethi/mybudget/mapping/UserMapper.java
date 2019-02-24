package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.dto.UserDto;
import hu.nemethi.mybudget.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserMapper {

    User mapDtoToEntity(UserDto userDto);

    UserDto mapEntityToDto(User user);

}
