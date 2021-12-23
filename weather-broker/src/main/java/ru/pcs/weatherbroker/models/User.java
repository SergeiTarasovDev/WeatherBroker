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
    private String telegramId;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public void setRole(String role) {
        if (role.equals("ADMIN")) {
            this.role = Role.ADMIN;
        } else {
            this.role = Role.USER;
        }
    }
}


