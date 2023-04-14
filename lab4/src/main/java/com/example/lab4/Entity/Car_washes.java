package com.example.lab4.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "car_wash")
@Data
@NoArgsConstructor
public class Car_washes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial", insertable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "place")
    private Box place;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Box getPlace() {
        return place;
    }

    public void setPlace(Box place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "date")
    private Date date;
}
