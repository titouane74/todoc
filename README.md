# OpenClassrooms

Le projet :
===========
Titre du projet : Todoc
------------------------------
L'objectif de ce projet est de rendre les données persistantes en étant stockées dans une base de données.


Fonctionnalités créées :
    - ajouter une tâche dans le base de données
    - supprimer une tâche de la base de données
    - récupérer la liste des tâches contenu dans la base de données

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
