package br.com.guilhermebehs.unittest.domain.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerEntity {

    private String legalDocumentNumber;
    private String name;
    private String address;
    private LocalDate birthDate;

    public CustomerEntity(String legalDocumentNumber, String name, String address, LocalDate birthDate){
        this.legalDocumentNumber = legalDocumentNumber;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }

}
