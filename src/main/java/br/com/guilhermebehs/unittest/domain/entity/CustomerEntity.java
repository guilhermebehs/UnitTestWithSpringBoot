package br.com.guilhermebehs.unittest.domain.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@Document("customer")
public class CustomerEntity {

    @Field("legal_document_number")
    @Indexed(unique = true)
    private String legalDocumentNumber;

    @Field("name")
    private String name;

    @Field("address")
    private String address;

    @Field("birth_date")
    private LocalDate birthDate;

    public CustomerEntity(String legalDocumentNumber, String name, String address, LocalDate birthDate){
        this.legalDocumentNumber = legalDocumentNumber;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }

}
