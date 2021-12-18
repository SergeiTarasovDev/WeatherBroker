package ru.pcs.weatherbroker.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    public enum Role {
        ADMIN, USER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(unique = true)
    private String email;

    private String hashPassword;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
