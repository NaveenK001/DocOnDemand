package com.MedLink.DocOnDemand.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_Id")
    private int id;

    @Column(name = "User_Username", nullable = false, unique = true)
    @Email(message = "Please provide your valid Email-Id")
    @NotEmpty(message = "Please provide an E-Mail")
    private String email;

    @Column(name = "User_Password")
    @Transient
    private String password;

    @Column(name = "User_First_Name")
    @NotEmpty(message = "Please provide your first name")
    private String firstName;

    @Column(name = "User_Last_Name")
    @NotEmpty(message = "Please provide your last name")
    private String lastName;

    @Column(name = "User_Enabled")
    private boolean enabled;

    @Column(name = "User_Confirmation_Token")
    private String confirmationToken;

    @Column(name = "User_Gender")
    private String gender;

    @Column(name = "User_Role")
    private String role;

    @Column(name = "User_Lastseen")
    @Transient
    private String lastseen;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", enabled=" + enabled +
                ", confirmationToken='" + confirmationToken + '\'' +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", lastseen='" + lastseen + '\'' +
                '}';
    }
}
