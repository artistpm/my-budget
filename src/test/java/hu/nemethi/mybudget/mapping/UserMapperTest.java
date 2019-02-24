package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.TestParent;
import hu.nemethi.mybudget.dto.UserDto;
import hu.nemethi.mybudget.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
@ActiveProfiles("test")
public class UserMapperTest extends TestParent {

    private static final Logger LOGGER = LogManager.getLogger(UserMapperTest.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void mapDtoToEntity() {
        User user = super.getUser();
        UserDto userDto = userMapper.mapEntityToDto(user);

        assertThat(userDto).isEqualToComparingOnlyGivenFields(user);
    }

    @Test
    public void mapEntityToDto() {
        UserDto userDto = super.getUserDto();
        User user = userMapper.mapDtoToEntity(userDto);

        assertThat(user).isEqualToComparingFieldByField(userDto);
    }
}