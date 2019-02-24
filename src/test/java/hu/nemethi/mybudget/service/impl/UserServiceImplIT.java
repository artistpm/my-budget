package hu.nemethi.mybudget.service.impl;

import hu.nemethi.mybudget.dto.UserDto;
import hu.nemethi.mybudget.enums.Authority;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("test")
@SpringBootTest()
public class UserServiceImplIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImplIT.class);

    @Autowired
    private UserServiceImpl userService;

    private static final LocalDateTime now = LocalDateTime.now();

    @BeforeEach
    public void init() {
    }

    @Test
    void login() {
    }

    @Test
    void logout() {
    }

    @Test
    @Disabled
    void delete() {
        UserDto request = getUserDto();
        UserDto userDto = userService.create(request);

        userService.delete(userDto.getId());

        UserDto found = userService.findByUserId(userDto);

        assertEquals(found, null, "UserDto should be null!");
    }

    @Test
    void create() {
        UserDto request = getUserDto();
        UserDto userDto = userService.create(request);

        assertEquals(getUserDto().getAuthority(), request.getAuthority(), "Authority should be equal!");
    }

    @Test
    void modify() {
        UserDto createRequest = getUserDto();
        UserDto createResponse = userService.create(createRequest);

        createResponse.setAuthority(Authority.USER);
        createResponse.setPwrd("Timur Sun");

        UserDto modifyResponse = userService.modify(createResponse);

        assertEquals(modifyResponse.getAuthority(), Authority.USER);
        assertEquals(modifyResponse.getPwrd(), "Timur Sun");
    }


    private UserDto getUserDto() {
        return UserDto.builder()
                       .id(UUID.randomUUID())
                .authority(Authority.ADMIN)
                .created(now)
                .pwrd("batukan")
                .username("valaki@valaki.hu")
                       .loginDate(LocalDateTime.now())
                .build();
    }
}