package hu.nemethi.mybudget.service.impl;

import hu.nemethi.mybudget.entity.parameterencryption.ParameterEncryptedType;
import hu.nemethi.mybudget.interfaces.ParameterEncryptible;
import hu.nemethi.mybudget.interfaces.ParameterEncryption;
import hu.nemethi.mybudget.repository.parameterencryption.ParameterEncryptionRepository;
import hu.nemethi.mybudget.service.ParameterEncryptorService;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ParameterEncryptorServiceImpl implements ParameterEncryptorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParameterEncryptorServiceImpl.class);

    private ParameterEncryptionRepository encryptionRepository;

    public ParameterEncryptorServiceImpl(ParameterEncryptionRepository encryptionRepository) {
        this.encryptionRepository = encryptionRepository;
    }

    @Override
    public Integer decrypt(String enId) {
        ParameterEncryptedType encryptedTypes = encryptionRepository.findByEncryptedData(enId);

        LOGGER.info("Delegator name is {}", encryptedTypes.getDelegatorName());

        encryptionRepository.delete(encryptedTypes);

        return encryptedTypes.getEncryptedTypeId();
    }

    @Override
    public String encrypt(ParameterEncryptible tampered, Integer id) {
        String tamperedName = tamperedProperty(tampered);
        String encryptedString = getParameterEncryptedString();

        ParameterEncryptedType encryptedTypes = populateEncryptedTypes(tamperedName, encryptedString, id);
        encryptionRepository.save(encryptedTypes);

        return encryptedString;
    }

    private String tamperedProperty(ParameterEncryptible tampered) {
        return tampered.getClass().getAnnotation(ParameterEncryption.class).name();
    }

    private String getParameterEncryptedString() {
        return RandomStringUtils.random(32, true, true);
    }

    private ParameterEncryptedType populateEncryptedTypes(String delegatorName, String encryptedData, Integer typeId) {
        ParameterEncryptedType encryptedTypes = new ParameterEncryptedType();
        encryptedTypes.setDelegatorName(delegatorName);
        encryptedTypes.setEncryptedData(encryptedData);
        encryptedTypes.setEncryptedTypeId(typeId);
        return encryptedTypes;
    }
}
