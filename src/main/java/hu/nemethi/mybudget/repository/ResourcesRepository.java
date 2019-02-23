package hu.nemethi.mybudget.repository;

import hu.nemethi.mybudget.entity.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourcesRepository extends JpaRepository<Resources, Integer> {

    @Query( value="SELECT r FROM Resources  r WHERE r.id = ?1" )
    List<Resources> findAllResourcesById(Integer id);
}
