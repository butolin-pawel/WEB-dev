package com.example.lab4.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial", insertable = false, updatable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<Car_washes> getWashes() {
        return washes;
    }

    public void setWashes(Set<Car_washes> washes) {
        this.washes = washes;
    }

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "number", nullable = false, length = 9)
    private String number;

    @Column(name = "status", nullable = true)
    private String status;

    @OneToMany(mappedBy = "car")
    private Set<Car_washes> washes= new HashSet<>();
}
