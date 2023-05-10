package com.example.lab4.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "car_wash")
@Data
@NoArgsConstructor
public class Carwashes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",columnDefinition = "serial", insertable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car",nullable = true)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "place",nullable = true)
    private Box place;

    @Column(name = "date")
    private Date date;

    @Column(name = "active",nullable = false)
    private boolean active;

    public void setDate(String date){
        String[] datee= date.split("-");
        Date date_ = new Date();
        date_.setYear(Integer.parseInt(datee[0])-1900);
        date_.setMonth(Integer.parseInt(datee[1])-1);
        date_.setDate(Integer.parseInt(datee[2]));
        this.date = date_;

        }
        public void setLocDate(LocalDate ld){
            Date date_ = new Date();
            date_.setYear(ld.getYear()-1900);
            date_.setMonth(ld.getMonthValue() -1);
            date_.setDate(ld.getDayOfMonth());
            this.date = date_;
        }
        public LocalDate getLocDate(){
        return LocalDate.of(date.getYear()+1900,date.getMonth()+1,date.getDate());
    }


}
