package com.example.lab4.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "car_wash")
@Data
@NoArgsConstructor
public class Carwashes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial", insertable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car",nullable = true)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "place",nullable = true)
    private Box place;

    @Column(name = "date")
    private Date date;


    public void setDate(String date){
        String[] datee= date.split("-");
        Date date_ = new Date();
        date_.setYear(Integer.parseInt(datee[0])-1900);
        date_.setMonth(Integer.parseInt(datee[1])-1);
        date_.setDate(Integer.parseInt(datee[2]));
        this.date = date_;

        }

}
