package com.example.enquetebackend.exceptions;

public class ErroPadrao extends RuntimeException{
    public ErroPadrao(String mensagem){
        super(mensagem);
    }
}