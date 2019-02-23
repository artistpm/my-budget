package hu.nemethi.mybudget.repository;

import hu.nemethi.mybudget.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

    @Query("SELECT c FROM Currency c WHERE c.id = ?1")
    List<Currency> findAllCurrenciesByUserId(UUID id);

}
