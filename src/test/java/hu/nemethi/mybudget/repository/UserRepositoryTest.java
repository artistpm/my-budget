package hu.nemethi.mybudget.repository;

import hu.nemethi.mybudget.TestParent;
import hu.nemethi.mybudget.entity.User;
import hu.nemethi.mybudget.enums.Authority;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DataJpaTest
@ActiveProfiles("test")
@EnableTransactionManagement
public class UserRepositoryTest extends TestParent {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    private UserRepository userRepository;

    private User superUser;

    private UUID uuid;

    @BeforeEach
    public void init(){
        superUser = super.getUser();
    }

    @Test
    public void save() {
        User response = userRepository.save(superUser);
        assertEquals(response.getUsername(), superUser.getUsername(), "Usernames should be equals!");
    }

    @Test
    public void modify(){
        User localUser = this.getNewUser();
        User savedUser = userRepository.save(localUser);

        LocalDate created = LocalDate.now();
        savedUser.setCreated(created);
        savedUser.setAuthority(Authority.USER);
        savedUser.setUsername("inemeth83@yahoo.com");

        User modifiedUser = userRepository.save(savedUser);


        assertEquals(modifiedUser.getUsername(), "inemeth83@yahoo.com");
        assertEquals(modifiedUser.getAuthority(), Authority.USER);
        assertEquals(modifiedUser.getCreated(), created);
    }

    @Test
    public void deleteByUserId(){
        User localUser = this.getNewUser();
        User response = userRepository.save(localUser);
        userRepository.deleteById(response.getId());

        Optional<User> deletedUser = userRepository.findById(response.getId());
        assertEquals(deletedUser.isPresent(), false, "user id should be null!");
    }

    private User getNewUser(){
        uuid = UUID.randomUUID();

        return User.builder()
                .authority(Authority.ADMIN)
                .created(LocalDate.now())
                .id(uuid)
                .pwrd("batukan3")
                .username("artistpm@gmail.com")
                .build();
    }
}