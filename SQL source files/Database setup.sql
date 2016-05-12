CREATE DATABASE IF NOT EXISTS STORE;
USE STORE;

/* must be dropped in this order to avoid constraint violations */
DROP TABLE IF EXISTS produktbatchkomponent;
DROP TABLE IF EXISTS produktbatch;
DROP TABLE IF EXISTS operatoer;
DROP TABLE IF EXISTS ansat;
DROP TABLE IF EXISTS receptkomponent;
DROP TABLE IF EXISTS recept;
DROP TABLE IF EXISTS leverandoer;
DROP TABLE IF EXISTS raavare;
 
CREATE TABLE ansat(cpr VARCHAR(15) PRIMARY KEY, opr_navn TEXT, ini TEXT, password TEXT, titel INT) ENGINE=innoDB;
 
CREATE TABLE raavare(raavare_id INT PRIMARY KEY, raavare_navn TEXT) ENGINE=innoDB;
 
CREATE TABLE leverandoer(raavare_id INT, leverandoer_navn varchar(64), maengde REAL,
   PRIMARY KEY (raavare_id, leverandoer_navn),
   FOREIGN KEY (raavare_id) REFERENCES raavare(raavare_id)) ENGINE=innoDB;
 
CREATE TABLE recept(recept_id INT PRIMARY KEY, recept_navn TEXT) ENGINE=innoDB;
 
CREATE TABLE receptkomponent(recept_id INT, raavare_id INT, nom_netto REAL, tolerance REAL,
   PRIMARY KEY (recept_id, raavare_id),
   FOREIGN KEY (recept_id) REFERENCES recept(recept_id),
   FOREIGN KEY (raavare_id) REFERENCES raavare(raavare_id)) ENGINE=innoDB;
 
CREATE TABLE produktbatch(pb_id INT PRIMARY KEY, status INT, recept_id INT,
   FOREIGN KEY (recept_id) REFERENCES recept(recept_id)) ENGINE=innoDB;
 
CREATE TABLE produktbatchkomponent(pb_id INT, raavare_id INT, tara REAL, netto REAL, cpr VARCHAR(10),
   PRIMARY KEY (pb_id, raavare_id),
   FOREIGN KEY (pb_id) REFERENCES produktbatch(pb_id),
   FOREIGN KEY (raavare_id) REFERENCES raavare(raavare_id),
   FOREIGN KEY (cpr) REFERENCES ansat(cpr)) ENGINE=innoDB;
 
 
INSERT INTO ansat(cpr, opr_navn, ini, password, titel) VALUES
('0707707007', 'Angelo A', 'AA', 'lKje4fa', 0),
('0808808008', 'Antonella B', 'AB', 'atoJ21v', 1),
('0909909009', 'Luigi C', 'LC', 'jEfm5aQ', 2);
 
INSERT INTO raavare(raavare_id, raavare_navn) VALUES
(1, 'dej'),
(2, 'tomat'),
(3, 'ost'),
(4, 'skinke'),
(5, 'champignon');
 
INSERT INTO leverandoer(raavare_id, leverandoer_navn, maengde) VALUES
(1, 'Wawelka', 1000),
(2, 'Knoor', 300),
(2, 'Veaubais', 300),
(2, 'Franz', 0),
(3, 'Ost & Skinke A/S', 100),
(4, 'Ost & Skinke A/S', 100),
(5, 'Igloo Frostvarer', 100);
 
INSERT INTO recept(recept_id, recept_navn) VALUES
(1, 'margherita'),
(2, 'prosciutto'),
(3, 'capricciosa');
 
 
INSERT INTO receptkomponent(recept_id, raavare_id, nom_netto, tolerance) VALUES
(1, 1, 10.0, 0.1),
(1, 2, 2.0, 0.1),
(1, 3, 2.0, 0.1),
 
(2, 1, 10.0, 0.1),
(2, 2, 2.0, 0.1),  
(2, 3, 1.5, 0.1),
(2, 4, 1.5, 0.1),
 
(3, 1, 10.0, 0.1),
(3, 2, 1.5, 0.1),
(3, 3, 1.5, 0.1),
(3, 4, 1.0, 0.1),
(3, 5, 1.0, 0.1);
 
INSERT INTO produktbatch(pb_id, recept_id, status) VALUES
(1, 1, 2),
(2, 1, 2),
(3, 2, 2),
(4, 3, 1),
(5, 3, 0);
 
 
INSERT INTO produktbatchkomponent(pb_id, raavare_id, tara, netto, cpr) VALUES
(1, 1, 0.5, 10.05, '0707707007'),
(1, 2, 0.5, 2.03, '0707707007'),
(1, 3, 0.5, 1.98, '0707707007'),
 
(2, 1, 0.5, 10.01, '0808808008'),
(2, 2, 0.5, 1.99, '0808808008'),
(2, 3, 0.5, 1.47, '0808808008'),
 
(3, 1, 0.5, 10.07, '0707707007'),
(3, 2, 0.5, 2.06, '0808808008'),
(3, 3, 0.5, 1.55, '0707707007'),
(3, 4, 0.5, 1.53, '0808808008'),
 
(4, 1, 0.5, 10.02, '0909909009'),
(4, 3, 0.5, 1.57, '0909909009'),
(4, 4, 0.5, 1.03, '0909909009'),
(4, 5, 0.5, 0.99, '0909909009');