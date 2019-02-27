package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.dto.CostDto;
import hu.nemethi.mybudget.entity.Cost;
import hu.nemethi.mybudget.entity.Currency;
import hu.nemethi.mybudget.entity.User;
import hu.nemethi.mybudget.enums.Authority;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
@ActiveProfiles("test")
public class CostMapperTest {

    private static final UUID USER_ID = UUID.randomUUID();
    private static LocalDateTime now = LocalDateTime.now();
    @Autowired
    private CostMapper costMapper;

    @Test
    void mapDtoToEntity() {
        CostDto costDto = getCostDto();
        Cost cost = costMapper.mapDtoToEntity(costDto);

        assertThat(costDto).isEqualToComparingOnlyGivenFields(cost);
    }

    @Test
    void mapEntityToDto() {
        Cost cost = getCost();
        CostDto costDto = costMapper.mapEntityToDto(cost);

        assertThat(cost).isEqualToComparingOnlyGivenFields(costDto);
    }

    private User getUser() {
        return User.builder().id(USER_ID).username("artistpm@gmail.com").pwrd("batukan").authority(Authority.ADMIN).created(now).build();
    }

    private Currency getCurrency() {
        return Currency.builder().id(1).currencyName("hu").isDefault(Boolean.TRUE).created(now).build();
    }

    private Cost getCost() {
        return Cost.builder()
                       .id(1)
                       .costLabel("Lakástakarék Pénztár")
                       .costName("LTP_payment")
                       .costValue(20150.0)
                       .currency(getCurrency())
                       .description("Lakástakarék pénztár")
                       .otherIdentifier("L1465993")
                       .payed(false)
                       .paymentDeadline(LocalDate.now())
                       .user(getUser())
                       .build();
    }

    private CostDto getCostDto() {
        return CostDto.builder()
                       .costId(2)
                       .costLabel("Lakástakarék Pénztár")
                       .costName("LTP_payment")
                       .costValue(20150.0)
                       .currency(getCurrency())
                       .description("Lakástakarék pénztár")
                       .otherIdentifier("L1465993")
                       .payed(false)
                       .paymentDeadline(LocalDate.now())
                       .userId(USER_ID)
                       .build();
    }

}