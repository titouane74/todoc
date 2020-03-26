# OpenClassrooms

Le projet :
===========
Titre du projet : Todoc
------------------------------
L'objectif de ce projet est de rendre les données persistentes en étant stockées dans une base de données.
Les tests unitaires et instrumentalisés doivent s'exécutér sans échouer.

Fonctionnalités créées :
    - Ecran principale listant les réunions réservées :
        - alimenter la liste des réunions
        - ajouter un menu permetant de filtre les réunions par date ou par salle de réunion
        - ajouter un bouton d'ajout d'une nouvelle réunion
        - supprimer une réunion de la liste

Le programme :
==============
Adresse GitHub du programme :
-----------------------------
    https://github.com/titouane74/todoc.git

Installation :
------------
    - Télécharger le repository dans votre environnement local
    - Ouvrir Android Studio  et importer le projet Todoc

Exécution :
-----------
    - Choisir l'item "app" du Run/Debug configuration
    - Exécuter l'application


Les tests ajoutés:
==================
Exécution et résultat des tests unitaires :
-------------------------------------------

    Dans le repository : todoc/app/src/androidTest/java/com/cleanup/todocflb/database
    Particularité, ce test unitaire est stocké et exéctuté dans le répertoire des tests instrumentalisés
    car il utilise une @Rule d'exécution comme pour les tests instrumentalisés.

	- ouvrir le fichier : TaskDaoTest.java
	- lancer l'exécution sur la class TaskDaoTest
	- résultat d'exécution dans le reposotiry Todoc/Test_Results/ :  Passed - Test Results - TaskDaoTest.html

La License :
============
OpenClassrooms
