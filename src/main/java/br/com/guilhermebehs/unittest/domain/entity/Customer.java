package br.com.guilhermebehs.unittest.domain.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Customer {

    private String id;
    private String name;
    private String address;
    private LocalDate birthDay;

    public Customer(String id, String name, String address, LocalDate birthDay){
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthDay = birthDay;
    }

}
