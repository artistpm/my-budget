package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.dto.UserDto;
import hu.nemethi.mybudget.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface UserMapper {

    @Mapping(source = "userId", target = "id")
    User mapDtoToEntity(UserDto userDto);

    @Mapping(source = "id", target = "userId")
    UserDto mapEntityToDto(User user);

}
