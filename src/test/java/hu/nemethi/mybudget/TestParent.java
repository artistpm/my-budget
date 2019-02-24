package hu.nemethi.mybudget;

import hu.nemethi.mybudget.dto.UserDto;
import hu.nemethi.mybudget.entity.User;
import hu.nemethi.mybudget.enums.Authority;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class TestParent {

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
