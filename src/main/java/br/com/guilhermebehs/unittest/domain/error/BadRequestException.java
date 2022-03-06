package br.com.guilhermebehs.unittest.domain.error;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }
}
