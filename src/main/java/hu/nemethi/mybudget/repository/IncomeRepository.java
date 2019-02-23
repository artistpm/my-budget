package hu.nemethi.mybudget.repository;

import hu.nemethi.mybudget.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer> {

    @Query("SELECT i FROM Income i WHERE i.id = ?1")
    List<Income> findAllIncomesByUserId(UUID userId);

    @Query("DELETE FROM Income i WHERE i.userId = :userId")
    void deleteAllByUserId(UUID userId);

}
