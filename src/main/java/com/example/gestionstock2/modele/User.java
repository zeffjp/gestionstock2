package com.example.gestionstock2.modele;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", columnDefinition = "CHAR(36)")
    private UUID userId;

    @Column(name = "user_nom", length = 255)
    private String userNom;

    @Column(name = "user_prenom", length = 255)
    private String userPrenom;

    @Column(name = "user_email", length = 255)
    private String userEmail;

    @Column(name = "user_mdp", length = 255)
    private String userMdp;

    @Column(name = "user_adresse", length = 255)
    private String userAdresse;

    @Column(name = "user_contact", length = 255)
    private String userContact;

    @Column(name = "user_tel")
    private Integer userTel;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserNom() {
        return userNom;
    }

    public void setUserNom(String userNom) {
        this.userNom = userNom;
    }

    public String getUserPrenom() {
        return userPrenom;
    }

    public void setUserPrenom(String userPrenom) {
        this.userPrenom = userPrenom;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMdp() {
        return userMdp;
    }

    public void setUserMdp(String userMdp) {
        this.userMdp = userMdp;
    }

    public String getUserAdresse() {
        return userAdresse;
    }

    public void setUserAdresse(String userAdresse) {
        this.userAdresse = userAdresse;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public Integer getUserTel() {
        return userTel;
    }

    public void setUserTel(Integer userTel) {
        this.userTel = userTel;
    }
}
