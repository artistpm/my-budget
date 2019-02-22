package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.TestParent;
import hu.nemethi.mybudget.dto.UserDto;
import hu.nemethi.mybudget.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
        assertEquals(userDto.getUserId(), user.getId(), "User ids should be equal!");
    }
}