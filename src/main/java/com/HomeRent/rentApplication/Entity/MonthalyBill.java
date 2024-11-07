package com.HomeRent.rentApplication.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class MonthalyBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  int roomId;

    private  Date billDate = new Date();

    private  long previousReading;

    private  long currentReading;

    private  long totalReading;

    private long totalBill;


}
