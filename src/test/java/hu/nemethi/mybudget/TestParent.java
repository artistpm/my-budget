package hu.nemethi.mybudget;

import hu.nemethi.mybudget.entity.User;
import hu.nemethi.mybudget.enums.Authority;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class TestParent {

    protected User userEntity;

    protected User getUser() {
        return userEntity = User.builder()
                .authority(Authority.ADMIN)
                .created(LocalDateTime.now())
                .id(UUID.fromString("89f4a48a-1db7-48fa-9f46-c810a9ffc349"))
                .pwrd("batukan3")
                .username("artistpm@gmail.com")
                .build();
    }
}
