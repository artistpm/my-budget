package hu.nemethi.mybudget.repository;

import hu.nemethi.mybudget.entity.Cost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CostRepository extends JpaRepository<Cost, Integer> {

    @Query("SELECT c FROM Cost c WHERE c.user.id = ?1")
    List<Cost> findAllCostsByUserId(UUID id);

    @Query("DELETE FROM Cost c WHERE c.user.id = :userId")
    void deleteCostsByUserId(@Param("userId") UUID id);
}
