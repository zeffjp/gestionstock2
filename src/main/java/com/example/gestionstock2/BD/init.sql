USE gestion_stock;

-- Table Client
CREATE TABLE Client (
                        client_id CHAR(36) NOT NULL,
                        client_nom VARCHAR(255),
                        client_prenom VARCHAR(255),
                        client_email VARCHAR(255),
                        client_contact VARCHAR(255),
                        client_tel VARCHAR(20),
                        client_adresse VARCHAR(255),
                        PRIMARY KEY (client_id)
);

-- Table Categorie
CREATE TABLE Categorie (
                           categorie_id CHAR(36) NOT NULL,
                           categorie_nom VARCHAR(255),
                           categorie_description VARCHAR(255),
                           PRIMARY KEY (categorie_id)
);

-- Table Commande
CREATE TABLE Commande (
                          commande_id CHAR(36) NOT NULL,
                          commande_dateCommande DATE,
                          commande_quantiteCommandee INT,
                          commande_prixUnitaire INT,
                          commande_statut VARCHAR(255),
                          client_id CHAR(36),
                          PRIMARY KEY (commande_id),
                          FOREIGN KEY (client_id) REFERENCES Client(client_id)
);

-- Table Vente
CREATE TABLE Vente (
                       vente_id CHAR(36) NOT NULL,
                       vente_dateVente DATE,
                       vente_quantiteVendue INT,
                       vente_prixUnitaire INT,
                       vente_statut VARCHAR(255),
                       client_id CHAR(36),
                       PRIMARY KEY (vente_id),
                       FOREIGN KEY (client_id) REFERENCES Client(client_id)
);

-- Table Article
CREATE TABLE Article (
                         article_id CHAR(36) NOT NULL,
                         article_nom VARCHAR(255),
                         article_description VARCHAR(255),
                         article_prix DOUBLE,
                         article_quantiteEnStock INT,
                         commande_id CHAR(36),
                         categorie_id CHAR(36),
                         vente_id CHAR(36),
                         PRIMARY KEY (article_id),
                         FOREIGN KEY (commande_id) REFERENCES Commande(commande_id),
                         FOREIGN KEY (categorie_id) REFERENCES Categorie(categorie_id),
                         FOREIGN KEY (vente_id) REFERENCES Vente(vente_id)
);

-- Table User
CREATE TABLE User (
                      user_id CHAR(36) NOT NULL,
                      user_nom VARCHAR(255),
                      user_prenom VARCHAR(255),
                      user_email VARCHAR(255),
                      user_mdp VARCHAR(255),
                      user_adresse VARCHAR(255),
                      user_contact VARCHAR(255),
                      user_tel VARCHAR(20),
                      PRIMARY KEY (user_id)
);