package hu.nemethi.mybudget.mapping;

import hu.nemethi.mybudget.dto.CurrencyDto;
import hu.nemethi.mybudget.entity.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest()
@ActiveProfiles("test")
class CurrencyMapperTest {

    private static LocalDateTime now = LocalDateTime.now();


    @Autowired
    private CurrencyMapper currencyMapper;

    @Test
    void mapDtoToEntity() {
        CurrencyDto currencyDto = this.getCurrrencyDto();
        Currency currency = currencyMapper.mapDtoToEntity(currencyDto);

        assertThat(currencyDto).isEqualToComparingOnlyGivenFields(currency);

    }

    @Test
    void mapEntityToDto() {
        Currency currency = this.getCurrency();
        CurrencyDto currencyDto = currencyMapper.mapEntityToDto(currency);

        assertThat(currency).isEqualToComparingOnlyGivenFields(currencyDto);
    }

    private CurrencyDto getCurrrencyDto() {
        return CurrencyDto.builder().currencyId(1).currencyName("hu").isDefault(Boolean.TRUE).created(now).build();
    }

    private Currency getCurrency() {
        return Currency.builder().id(1).currencyName("hu").isDefault(Boolean.TRUE).created(now).build();
    }
}