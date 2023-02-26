# Projet Clean Code 4AL2 : Card-Game

Enzo Soares et Loic Vanden Bossche

## Repository

Le repo est publique sur github: https://github.com/enzoSoa/card-game 

## Lancer le projet

Normalement le script bootRun fonctionne mais dans le doute la fonction pour dermarrer le serveur se trouve dans la class Main du module infrastructure 

## BDD

La BDD tourne sur mongo atlas la connexion est parametré de base il n'y a rien a faire pour faire fonctionner le projet (c'est pas securiser mais ca fait le job)


string de connexion mongodb compass si jamais: `mongodb+srv://mongo-clean:<password>@cleancode.uhoviaa.mongodb.net/test`

## API

### Hero

#### Creation

method: `POST`

url: `http://localhost:8080/hero`

body: `{
"name": String,
"speciality": "TANK" | "ASSASSIN" | "MAGE",
"rarity": "COMMON" | "RARE" | "LEGENDARY"
}`

#### List

method: `GET`

url: `http://localhost:8080/hero`

#### Hero par id

method: `GET`

url: `http://localhost:8080/hero/{heroId}`


### User

#### Creation

method: `POST`

url: `http://localhost:8080/user`

body: `{
"nickname": String
}`

#### Liste

method: `GET`

url: `http://localhost:8080/user`

#### User par id

method: `GET`

url: `http://localhost:8080/user/{userId}`

#### Deck d'un user

method: `GET`

url: `http://localhost:8080/user/{userId}/deck`

#### Ouverture d'un deck par un user

method: `PATCH`

url: `http://localhost:8080/user/{userId}/deck`

body: `{
"type": "SILVER" | "DIAMOND"
}`

#### Combat

method: `POST`

url: `http://localhost:8080/user/{attackerId}/fight`

body: `{
"defenderId": String,
"attackerHeroIndex": Int,
"defenderHeroIndex": Int
}`
