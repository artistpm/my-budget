package hu.nemethi.mybudget.service.impl;

import org.springframework.stereotype.Service;

@Service
public class ParameterEncryptorServiceImpl {

    public Integer decrypt(String enId){
        return Integer.parseInt(enId);
    }

    public String encrypt(Integer id){
        return String.valueOf(id);
    }
}
