package com.example.gestionstock2.modele;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "Vente")
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vente_id", columnDefinition = "CHAR(36)")
    private UUID venteId;

    @Column(name = "vente_dateVente")
    private Date venteDateVente;

    @Column(name = "vente_quantiteVendue")
    private Integer venteQuantiteVendue;

    @Column(name = "vente_prixUnitaire")
    private Integer ventePrixUnitaire;

    @Column(name = "vente_statut", length = 255)
    private String venteStatut;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

    public UUID getVenteId() {
        return venteId;
    }

    public void setVenteId(UUID venteId) {
        this.venteId = venteId;
    }

    public Date getVenteDateVente() {
        return venteDateVente;
    }

    public void setVenteDateVente(Date venteDateVente) {
        this.venteDateVente = venteDateVente;
    }

    public Integer getVenteQuantiteVendue() {
        return venteQuantiteVendue;
    }

    public void setVenteQuantiteVendue(Integer venteQuantiteVendue) {
        this.venteQuantiteVendue = venteQuantiteVendue;
    }

    public Integer getVentePrixUnitaire() {
        return ventePrixUnitaire;
    }

    public void setVentePrixUnitaire(Integer ventePrixUnitaire) {
        this.ventePrixUnitaire = ventePrixUnitaire;
    }

    public String getVenteStatut() {
        return venteStatut;
    }

    public void setVenteStatut(String venteStatut) {
        this.venteStatut = venteStatut;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
