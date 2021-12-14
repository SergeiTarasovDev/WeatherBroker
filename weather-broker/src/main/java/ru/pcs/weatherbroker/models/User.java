package ru.pcs.weatherbroker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String hashPassword;
    private String email;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City cityId;


}
