package hu.nemethi.mybudget.repository.parameterencryption;

import hu.nemethi.mybudget.entity.parameterencryption.ParameterEncryptedType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterEncryptionRepository extends JpaRepository<ParameterEncryptedType, Integer> {

    @Query("SELECT p FROM ParameterEncryptedType p WHERE p.encryptedData =?1")
    ParameterEncryptedType findByEncryptedData(String id);
}
