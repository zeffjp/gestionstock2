package com.example.gestionstock2.modele;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "Commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "commande_id", columnDefinition = "CHAR(36)")
    private UUID commandeId;

    @Column(name = "commande_dateCommande")
    private Date commandeDateCommande;

    @Column(name = "commande_quantiteCommandee")
    private Integer commandeQuantiteCommandee;

    @Column(name = "commande_prixUnitaire")
    private Integer commandePrixUnitaire;

    @Column(name = "commande_statut", length = 255)
    private String commandeStatut;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

    public UUID getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(UUID commandeId) {
        this.commandeId = commandeId;
    }

    public Date getCommandeDateCommande() {
        return commandeDateCommande;
    }

    public void setCommandeDateCommande(Date commandeDateCommande) {
        this.commandeDateCommande = commandeDateCommande;
    }

    public Integer getCommandeQuantiteCommandee() {
        return commandeQuantiteCommandee;
    }

    public void setCommandeQuantiteCommandee(Integer commandeQuantiteCommandee) {
        this.commandeQuantiteCommandee = commandeQuantiteCommandee;
    }

    public Integer getCommandePrixUnitaire() {
        return commandePrixUnitaire;
    }

    public void setCommandePrixUnitaire(Integer commandePrixUnitaire) {
        this.commandePrixUnitaire = commandePrixUnitaire;
    }

    public String getCommandeStatut() {
        return commandeStatut;
    }

    public void setCommandeStatut(String commandeStatut) {
        this.commandeStatut = commandeStatut;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
