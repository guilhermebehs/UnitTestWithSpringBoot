package br.com.guilhermebehs.unittest.domain.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ErrorDto {

    private String message;

    public ErrorDto(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    private Integer statusCode;
}
