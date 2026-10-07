# Storefront Platform

Projet de gestion de boutique réalisé avec Spring Boot.

Au départ, c'est une application monolithique. On la transforme petit à petit en architecture microservices, au fur et à mesure des séances de cours.

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok et ModelMapper

## Structure du projet

L'application est divisée en deux parties :

- **catalogue** : gestion des catégories et des produits
- **commande** : gestion des clients, des adresses et des commandes

## Lancer le projet

1. Installer JDK 17 et MySQL.
2. Créer la base de données :
   ```sql
   CREATE DATABASE boutique;
   ```
3. Vérifier la configuration dans `src/main/resources/application.properties` (username et password MySQL).
4. Lancer l'application :
   ```bash
   mvnw.cmd spring-boot:run
   ```

L'application démarre sur `http://localhost:8080`.

## Endpoints

- `/categories`
- `/produits`
- `/clients`
- `/commandes`

## Avancement

- Version monolithique (tag `v0-monolithe`)
- Passage vers les microservices (en cours)

## Auteur

Nour El Houda Achour, ITBS Nabeul
