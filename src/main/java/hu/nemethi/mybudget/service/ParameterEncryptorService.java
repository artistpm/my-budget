package hu.nemethi.mybudget.service;

import hu.nemethi.mybudget.interfaces.ParameterEncryptible;

public interface ParameterEncryptorService {

    /**
     * Find delegator and provides its real identifier, also deletes the entry from the database.
     *
     * @param enId
     * @return
     */
    Integer decrypt(String enId);

    /**
     * Encrypts the identifier and persist into the database.
     *
     * @param tampered
     * @param id
     * @return
     */
    String encrypt(ParameterEncryptible tampered, Integer id);
}
