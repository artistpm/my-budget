package hu.nemethi.mybudget.service;

import hu.nemethi.mybudget.dto.IncomeDto;
import hu.nemethi.mybudget.entity.Resources;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 *
 * @param <T>
 */
public interface IncomeService<T> extends GenericService<IncomeDto> {

    List<T> findALlByUserIdAndLabel(UUID userId, String label);

    List<T> findAllByUserIdAndValue(UUID userId, Double amount);

    List<T> findAllByUserIdAndReceiptDate(UUID userId, LocalDate receiptDate);

    List<T> findAllByUserIdAndReceived(UUID userId, Boolean received);

    List<T> findAllByUserIdAndReceiptPeriod(UUID userId, Resources period);

}
