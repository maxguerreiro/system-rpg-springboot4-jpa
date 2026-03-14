# RPG Character API

A RESTful API for managing RPG characters built with **Java, Spring Boot, and JPA**.

This project simulates a basic RPG character system where characters belong to different classes and possess attribute statistics such as strength, dexterity, and intelligence.

The API provides endpoints to retrieve characters and their classes while following a layered architecture with DTOs to separate the API contract from the persistence model.

---

## Features

- RPG character management
- Character classes with attribute bonuses
- Embedded attribute system
- DTO layer for API responses
- Database seeding with example characters
- RESTful endpoints using Spring Boot

---

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (for development)
- Maven

---

## Project Structure

## Domain Model

### Character

A character has:

- name
- age
- base attributes
- character class

### Attributes

Attributes are embedded in the character and include:

- HP
- Strength
- Dexterity
- Intelligence
- Resistance
- Mana

### Character Class

Each class provides attribute bonuses.

Available classes:

- Warrior
- Mage
- Rogue
- Cleric
- Paladin

---

## API Endpoints

### Get all characters

[
  {
    "name": "Thorin Ironfist",
    "idade": 42,
    "attributes": {
      "hp": 15,
      "strength": 13,
      "dexterity": 7,
      "intelligence": 6,
      "resistance": 11,
      "mana": 5
    },
    "characterClass": "Warrior"
  }
]

GET /characters/{id}

GET /characterclasses

GET /characterclasses/{id}

## Architecture

This project follows a layered architecture:

Controller → Service → Repository → Database

DTOs are used to avoid exposing JPA entities directly through the API.
