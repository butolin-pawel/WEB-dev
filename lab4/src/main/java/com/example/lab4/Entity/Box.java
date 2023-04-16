package com.example.lab4.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity

@Table(name="box")

@NoArgsConstructor

@Data
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial", insertable = false, updatable = false)
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;

@Column(name="type", nullable = false)
private String type;



    @OneToMany(mappedBy = "place")
    private Set<Carwashes> washes = new HashSet<>();

    @Override
    public String toString(){
        return this.name;
    }
}
