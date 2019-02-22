package hu.nemethi.mybudget.service.impl;

import hu.nemethi.mybudget.dto.CostDto;
import hu.nemethi.mybudget.dto.UserDto;
import hu.nemethi.mybudget.entity.Currency;
import hu.nemethi.mybudget.entity.Language;
import hu.nemethi.mybudget.entity.Resources;
import hu.nemethi.mybudget.entity.User;
import hu.nemethi.mybudget.enums.Authority;
import hu.nemethi.mybudget.exceptions.MissingEntityException;
import hu.nemethi.mybudget.mapping.UserMapper;
import hu.nemethi.mybudget.repository.UserRepository;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest()
@ActiveProfiles("test")
public class CostServiceImplIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(CostServiceImplIT.class);

    public static final String COST_LABEL = "LTP István";
    private static final UUID userId = UUID.randomUUID();

    @Autowired
    private CostServiceImpl costDtoCostService;

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
        currency = Currency.builder().currencyName("HUF").id(1).isDefault(true).build();
        language = Language.builder().languageName("hun").id(1).build();
        resources = Resources.builder().id(1).language(language).resourceKey("mybudget.resource").resourceName("resourcename").build();

        user =
                User.builder()
                    .authority(Authority.ADMIN)
                    .created(LocalDate.now())
                    .id(userId)
                    .pwrd("batukan2")
                    .username("batukan")
                    .build();

        managedUser = userService.create(userMapper.mapEntityToDto(user));

        CostDto costDto = CostDto.builder()
                .costId(1)
                .costLabel(COST_LABEL)
                .costName("LTP_payment")
                .costValue(20150.0)
                .currency(currency)
                .description("Lakástakarék pénztár")
                .otherIdentifier("L1465993")
                .payed(false)
                .paymentDeadline(LocalDate.now())
                .userId(managedUser.getUserId())
                .paymentMonth(Month.FEBRUARY).build();

        costDtoCostService.create(costDto);
    }

    @Test
    public void createCostShouldBeOk() {

        CostDto costDto = CostDto.builder()
                .costId(2)
                .costLabel(COST_LABEL)
                .costName("LTP_payment")
                .costValue(20150.0)
                .currency(currency)
                .description("Lakástakarék pénztár")
                .otherIdentifier("L1465993")
                .payed(false)
                .paymentDeadline(LocalDate.now())
                .userId(managedUser.getUserId())
                .paymentMonth(Month.FEBRUARY).build();

        CostDto response = costDtoCostService.create(costDto);

        assertEquals(response.getCostId().intValue(), 2);
        assertEquals(response.getCostName(), "LTP_payment");
        assertEquals(new Double(response.getCostValue().doubleValue()), new Double(20150.0));
    }

    @Test
    public void deleteCostShouldBeOk() throws SQLException {

        CostDto costDto = CostDto.builder()
                .costId(10)
                .costLabel(COST_LABEL)
                .costName("LTP_payment")
                .costValue(20150.0)
                .currency(currency)
                .description("Lakástakarék pénztár")
                .otherIdentifier("L1465993")
                .payed(false)
                .paymentDeadline(LocalDate.now())
                .userId(managedUser.getUserId())
                .paymentMonth(Month.FEBRUARY).build();

        costDtoCostService.create(costDto);

        costDtoCostService.delete("10");
        List<CostDto> costDtos = costDtoCostService.listAllByUserId(managedUser.getUserId());
        costDtos.forEach(costDto1 -> {
                assertNotEquals(costDto1.getUserId(),"10","Should not find cost in db!");
            });
    }

    @Test
    public void modifyCostShouldBeOk() {

        List<CostDto> costDtos = costDtoCostService.listAllByUserId(managedUser.getUserId());

        CostDto createdCost = costDtos.get(0);
        createdCost.setCostLabel("Aegon önkéntes nyugdíj");
        createdCost.setCostName("Aegon Önkéntes Nyugdíj Biztosítás");
        createdCost.setDescription("Aegon Önkéntes Nyugdíj Biztosítás");
        createdCost.setOtherIdentifier("AÖ0210-110");


        CostDto response = costDtoCostService.modify(createdCost);
        assertEquals(response.getCostName(),"Aegon Önkéntes Nyugdíj Biztosítás", "Cost name should be equal!");
    }

    @Test
    public void listAllCostsByUserIdShouldBeOk() throws SQLException {
        List<CostDto> costDtos = costDtoCostService.listAllByUserId(managedUser.getUserId());
        assertTrue(costDtos.size() > 0, "Should be greater then 0!");
    }

    @Test
    public void deleteAllCostsByUserIdShouldBeOk() {

    }


    private void insertCosts(int... id){

        CostDto fistCost = CostDto.builder()
                .costId(id[0])
                .costLabel(COST_LABEL)
                .costName("LTP_payment")
                .costValue(20150.0)
                .currency(currency)
                .description("Lakástakarék pénztár")
                .otherIdentifier("L1465993")
                .payed(false)
                .paymentDeadline(LocalDate.now())
                .userId(managedUser.getUserId())
                .paymentMonth(Month.FEBRUARY).build();

        costDtoCostService.create(fistCost);

        CostDto firstCost = CostDto.builder()
                .costId(id[1])
                .costLabel(COST_LABEL)
                .costName("LTP_payment 2")
                .costValue(20150.0)
                .currency(currency)
                .description("Lakástakarék pénztár 2")
                .otherIdentifier("L1465996")
                .payed(false)
                .paymentDeadline(LocalDate.now())
                .userId(managedUser.getUserId())
                .paymentMonth(Month.FEBRUARY).build();

        costDtoCostService.create(firstCost);
    }
}