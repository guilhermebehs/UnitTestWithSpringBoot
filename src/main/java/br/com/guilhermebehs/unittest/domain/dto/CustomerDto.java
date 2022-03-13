package br.com.guilhermebehs.unittest.domain.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomerDto {

    @NotNull
    @Length(max = 15)
    private String legalDocumentNumber;

    @NotNull
    @Length(max = 50)
    private String name;

    @NotNull
    @Length(max = 50)
    private String address;

    @NotNull
    @PastOrPresent
    private LocalDate birthDate;

    public CustomerDto(String legalDocumentNumber, String name, String address, LocalDate birthDate){
        this.legalDocumentNumber = legalDocumentNumber;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
    }


}
