package hu.nemethi.mybudget.repository.parameterencryption;

import hu.nemethi.mybudget.entity.parameterencryption.CostParameterEncryption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostParameterEncryptionRepository extends JpaRepository<CostParameterEncryption, Integer> {
}
