# MIS_PROJECT
==============================

Repository comportant l'ensemble des codes à exécuter pour l'application de gestion de stockage développé lors du cours de "Medical Information System -  INFO H 400".


Organisation du projet
------------

├── .gitignore
├── .idea                       <- Dossier projet IntelliJ
│   ├── compiler.xml      
│   ├── encodings.xml
│   ├── .gitignore
│   ├── jarRepositories.xml
│   ├── misc.xml
│   ├── MIS_PROJECT.iml
│   ├── modules.xml
│   ├── shelf
│   │   ├── Uncommitted_changes_before_Update_at_5_16_20,_10_54_AM_[Default_Changelist]
│   │   │   └── shelved.patch
│   │   └── Uncommitted_changes_before_Update_at_5_16_20__10_54_AM__Default_Changelist_.xml
│   ├── uiDesigner.xml
│   ├── vcs.xml
│   └── workspace.xml
├── pom.xml                <- Fichier comportant les dépendances
├── README.md              <- Fichier comportant les instructions à destination des développeurs désirant utiliser l'application
├── src                    <- Dossier comportant l'entièreté des codes exécutables + ressources
│   └── main               <- Dossier comportant l'entièreté des codes exécutables + ressources
│       ├── java           <- Dossier comportant l'entièreté des codes exécutables
│       │   ├── actors     <- Package comportant les scripts permettant les autorisations, les actions autorisables, les différents acteurs de l'hôpital ainsi que le rangement de ces acteurs dans des catégories ayant différents accès propre

│       │   │   ├── Actor.java                     <- Code permettant de crée l'objet "acteur" de l'hopîtal
│       │   │   ├── ActorType.java                 <- Code permettant d'attribuer le type d'acteur à l'objet acteur
│       │   │   ├── authorization                  <- Package comportant les actions autorisables
│       │   │   │   └── action                     <- Package comportant l'ensemble des scripts des actions autorisables
│       │   │   │       ├── ActionType.java        <- Script implémentant l'interface IAction regroupant les différentes actions
│       │   │   │       ├── ApproveOrder.java      <- Script décrivant l'action d'approbation des commandes
│       │   │   │       ├── CreateOrder.java       <- Script décrivant l'action de création de commande
│       │   │   │       ├── IAction.java           <- Interface renvoyant le type de d'action
│       │   │   │       ├── ReadAction.java  <- Script permettant d'enrichir l'objet acteur d'attribut + ajotu de méthodes liées.
│       │   │   │       └── Update.java            <- Script décrivant l'action de mise à jour de la database affichée
│       │   │   ├── AuthorizationManager.java      <- Script créant des listes regroupant les types d'acteurs autorisés ou non ainsi que les méthodes renvoyant si la personne est autorisée ou non a effectuer une action ainsi que la méthode permettant la lecture de la base de donnée.

│       │   │   └── IAuthorizationManager.java     <- Interface décrivant la méthode pour renvoyer un booléan annonçant si l'objet est autorisé ou non à effectuer une action.

│       │   └── window                             <- Package regroupant les différentes fenêtres de l'application
│       │       ├── MainWindow.form      
│       │       ├── MainWindow.java                <- Fenêtre de bienvenue   
│       │       ├── NewOrder.form               
│       │       ├── NewOrder.java                  <- Fenêtre permettant la création d'une commande 
│       │       ├── RequestedOrderWindow.form
│       │       ├── RequestedOrderWindow.java      <- Fenêtre permettant d'accepter ou de rejeter les commandes 
│       │       ├── StockWindow.form
│       │       └── StockWindow.java               <- Fenêtre permettant d'afficher les différents stocks 
│       └── resources    <- Dossier comportant l'entièreté des ressources
│        ├── logo2.png   <- Ancienne photo pouvant apparaître sur la fenêtre d'ouverture
│        └── logo.png    <- Photo s'affichant sur la fenêtre d'ouverture
│   
│       
└── stock_management.sql  <- Rattachement de la base de donnée affiliée à l'application

