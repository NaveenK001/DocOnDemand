package com.MedLink.DocOnDemand.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private int id;

    @Column(name = "username", nullable = false, unique = true)
    @Email(message = "Please provide a valid E-Mail")
    @NotEmpty(message = "Please provide an E-Mail")
    private String email;

    @Column(name = "Password")
    @Transient
    private String password;

    @Column(name = "First_Name")
    @NotEmpty(message = "Please provide your first name")
    private String firstName;

    @Column(name = "Last_Name")
    @NotEmpty(message = "Please provide your last name")
    private String lastName;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Role")
    private String role;

    @Column(name = "Confirmation_Token")
    private String confirmationToken;

    @Column(name = "Enabled")
    private boolean enabled;

    @Column(name = "Lastseen")
    private String lastSeen;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", confirmationToken='" + confirmationToken + '\'' +
                ", enabled=" + enabled +
                ", lastSeen='" + lastSeen + '\'' +
                '}';
    }
}
