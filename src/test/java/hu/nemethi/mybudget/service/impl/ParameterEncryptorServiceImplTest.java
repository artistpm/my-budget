package hu.nemethi.mybudget.service.impl;

import hu.nemethi.mybudget.dto.CostDto;
import hu.nemethi.mybudget.dto.UserDto;
import hu.nemethi.mybudget.entity.Currency;
import hu.nemethi.mybudget.entity.Language;
import hu.nemethi.mybudget.entity.Resources;
import hu.nemethi.mybudget.entity.User;
import hu.nemethi.mybudget.enums.Authority;
import hu.nemethi.mybudget.mapping.UserMapper;
import hu.nemethi.mybudget.repository.UserRepository;
import hu.nemethi.mybudget.service.ParameterEncryptorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest()
class ParameterEncryptorServiceImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParameterEncryptorServiceImplTest.class);
    private static final UUID userId = UUID.randomUUID();
    private static String encryptedData;
    private static CostDto costDto;
    @Autowired
    private CostServiceImpl costService;
    @Autowired
    private ParameterEncryptorService parameterEncryptorService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    private Currency currency;
    private Resources resources;
    private Language language;
    private User user;
    private UserDto managedUser;

    @BeforeEach
    public void setUp() throws Exception {

        LOGGER.info("BeforeEach start at {} ", LocalDateTime.now());

        currency = Currency.builder().currencyName("HUF").id(1).isDefault(true).build();
        language = Language.builder().languageName("hun").id(1).build();
        resources = Resources.builder().id(1).language(language).resourceKey("mybudget.resource").resourceName("resourcename").build();


        user =
                User.builder()
                        .loginDate(LocalDateTime.now())
                        .authority(Authority.ADMIN)
                        .created(LocalDateTime.now())
                        .id(userId)
                        .pwrd("batukan2")
                        .username("artistpm@gmail.com")
                        .build();

        LOGGER.info("user is {} ", user.toString());

        managedUser = userService.create(userMapper.mapEntityToDto(user));
    }


    @Test
    void decrypt() {
        Integer id = parameterEncryptorService.decrypt(encryptedData);

        assertEquals(id, costDto.getCostId(), "Cost id and the Integer which get from the dencrypted date should be equal!");

    }

    @Test
    void encrypt() {
        encryptedData = parameterEncryptorService.encrypt(getCost(), getCost().getCostId());
        assertNotEquals(null, encryptedData, "Encrypted data must not be null!");
    }

    CostDto getCost() {


        costDto = CostDto.builder()
                          .costId(1)
                          .costLabel("LTP István")
                          .costName("LTP_payment")
                          .costValue(20150.0)
                          .currency(currency)
                          .description("Lakástakarék pénztár")
                          .otherIdentifier("L1465993")
                          .payed(false)
                          .paymentDeadline(LocalDate.now())
                          .userId(managedUser.getId()).build();

        return costService.create(costDto);
    }
}