package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.dto.UserDto;
import hu.nemethi.mybudget.entity.User;
import hu.nemethi.mybudget.enums.Authority;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
@ActiveProfiles("test")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void mapDtoToEntity() {
        User user = this.getUser();
        UserDto userDto = userMapper.mapEntityToDto(user);

        assertThat(userDto).isEqualToComparingOnlyGivenFields(user);
    }

    @Test
    public void mapEntityToDto() {
        UserDto userDto = this.getUserDto();

        User user = userMapper.mapDtoToEntity(userDto);

        assertThat(user).isEqualToComparingFieldByField(userDto);
    }

    protected User getUser() {
        return User.builder()
                       .authority(Authority.ADMIN)
                       .created(LocalDateTime.now())
                       .id(UUID.fromString("89f4a48a-1db7-48fa-9f46-c810a9ffc349"))
                       .pwrd("batukan3")
                       .username("artistpm@gmail.com")
                       .loginDate(LocalDateTime.now())
                       .build();
    }

    protected UserDto getUserDto() {
        return UserDto.builder()
                       .username("artistpm@gmail.com")
                       .pwrd("batukan2")
                       .authority(Authority.USER)
                       .id(UUID.randomUUID())
                       .created(LocalDateTime.now().minusDays(1))
                       .loginDate(LocalDateTime.now())
                       .build();
    }
}