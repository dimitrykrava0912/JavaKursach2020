package com.example.test.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class File1 {
    private String address;
    private LocalDate date;
    public File1(){
        super();
    }

    public File1 (String addr , LocalDate dt){
        this.address = addr;
        this.date = dt;
    }
    public File1 (String addr){
        this.address = addr;
    }
    public File1 (LocalDate dt){
        this.date = dt;
    }


}
