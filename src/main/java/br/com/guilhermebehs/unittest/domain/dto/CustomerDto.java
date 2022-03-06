package br.com.guilhermebehs.unittest.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomerDto {

    private String legalDocumentNumber;
    private String name;
    private String address;
    private LocalDate birthDate;

    public CustomerDto(String legalDocumentNumber, String name, String address, LocalDate birthDate){
        this.legalDocumentNumber = legalDocumentNumber;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }


}
