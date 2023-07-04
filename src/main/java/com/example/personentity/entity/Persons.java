package com.example.personentity.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "persons")
public class Persons {
    @Id
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private int age;
    @Column(name = "phone", length = 11)
    private String phoneNumber;
    @Column(name = "city", nullable = false)
    private String cityOfLiving;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "contactId")
    private Contact contact;

}
