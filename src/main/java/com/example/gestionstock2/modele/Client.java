package com.example.gestionstock2.modele;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id", columnDefinition = "CHAR(36)")
    private UUID clientId;

    @Column(name = "client_nom", length = 255)
    private String clientNom;

    @Column(name = "client_prenom", length = 255)
    private String clientPrenom;

    @Column(name = "client_email", length = 255)
    private String clientEmail;

    @Column(name = "client_contact", length = 255)
    private String clientContact;

    @Column(name = "client_tel")
    private Long clientTel;

    @Column(name = "client_adresse", length = 255)
    private String clientAdresse;

    // Exemple de relation OneToMany vers Commande
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Commande> commandes;

    // Exemple de relation OneToMany vers Vente
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Vente> ventes;

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public String getClientNom() {
        return clientNom;
    }

    public void setClientNom(String clientNom) {
        this.clientNom = clientNom;
    }

    public String getClientPrenom() {
        return clientPrenom;
    }

    public void setClientPrenom(String clientPrenom) {
        this.clientPrenom = clientPrenom;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientContact() {
        return clientContact;
    }

    public void setClientContact(String clientContact) {
        this.clientContact = clientContact;
    }

    public Long getClientTel() {
        return clientTel;
    }

    public void setClientTel(Long clientTel) {
        this.clientTel = clientTel;
    }

    public String getClientAdresse() {
        return clientAdresse;
    }

    public void setClientAdresse(String clientAdresse) {
        this.clientAdresse = clientAdresse;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public List<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(List<Vente> ventes) {
        this.ventes = ventes;
    }
}
