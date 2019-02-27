package hu.nemethi.mybudget.repository;

import hu.nemethi.mybudget.MyBudgetTest;
import hu.nemethi.mybudget.entity.User;
import hu.nemethi.mybudget.enums.Authority;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
@EnableTransactionManagement
public class UserRepositoryTest extends MyBudgetTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save() {
        User detachedUser = getDetachedUser();
        User managedUser = userRepository.save(getDetachedUser());

        assertThat(managedUser).isEqualToComparingOnlyGivenFields(detachedUser);
    }

    @Test
    public void modify() {
        User detachedUser = this.getDetachedUser();
        User managedUser = userRepository.save(detachedUser);

        LocalDateTime created = LocalDateTime.now();
        managedUser.setCreated(created);
        managedUser.setAuthority(Authority.USER);
        managedUser.setUsername("inemeth83@yahoo.com");

        User modifiedUser = userRepository.save(managedUser);

        assertThat(managedUser).isEqualToComparingOnlyGivenFields(modifiedUser);
    }

    @Test
    public void deleteByUserId() {
        User detachedUser = this.getDetachedUser();
        User managedUser = userRepository.save(detachedUser);
        userRepository.deleteById(managedUser.getId());

        Optional<User> deletedUser = userRepository.findById(managedUser.getId());
        assertEquals(deletedUser.isPresent(), false, "user id should be null!");
    }


    private User getDetachedUser() {
        return User.builder()
                       .authority(Authority.ADMIN)
                       .created(LocalDateTime.now())
                       .id(UUID.randomUUID())
                       .pwrd("batukan3")
                       .username("artistpm@gmail.com")
                       .build();
    }


}