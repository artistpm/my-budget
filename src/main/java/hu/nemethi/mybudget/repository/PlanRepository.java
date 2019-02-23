package hu.nemethi.mybudget.repository;

import hu.nemethi.mybudget.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {

    @Query("SELECT p FROM Plan p WHERE p.user.id = :userId")
    List<Plan> findAllByUserId(@Param("userId") UUID userId);

    @Query("DELETE FROM Plan p WHERE p.user.id = :userId")
    void deleteAllByUserId(@Param("userId") UUID userId);
}
