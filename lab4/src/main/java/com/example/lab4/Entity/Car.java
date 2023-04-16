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



    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "number", nullable = false, length = 9)
    private String number;

    @Column(name = "status", nullable = true)
    private String status;

    @OneToMany(mappedBy = "car")
    private Set<Carwashes> washes= new HashSet<>();
    @Override
    public String toString(){
        return this.number;
    }
}
