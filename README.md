# Algorithmique et Programmation Avancées

> Implémentations des exercices des fiches 1(A2) et 2(A3) du cours d'Algorithmique et Programmation Avancées pour la classe DIC2 de l'ESP/UCAD.

## 📑 Table des matières

- [Structure du projet](#-structure-du-projet)
- [Prérequis](#-prérequis)
- [Installation](#-installation)
- [Utilisation](#-utilisation)
- [Description des exercices](#-description-des-exercices)
- [Documentation](#-documentation)
- [Tests](#-tests)

## 📂 Structure du projet

```
Fiche_A2_A3_POO/
├── fiche1/
│   ├── src/
│   │   ├── demo/           # Classes de démonstration
│   │   │   └── testStatic/ # Tests statiques
│   │   ├── exercice1/      # Listes chaînées et QuickSort
│   │   ├── exercice3/      # Gestion de dates
│   │   ├── exercice4/      # Gestion de points
│   │   └── exercice5/      # Gestion de fractions
│   └── bin/                # Fichiers compilés
├── fiche2/
│   ├── src/
│   │   ├── demo/           # Classes de démonstration
│   │   │   └── testStatic/ # Tests statiques
│   │   ├── exercice1/      # Listes chaînées simples
│   │   ├── exercice2/      # Listes chaînées bidirectionnelles
│   │   ├── exercice3/      # Traitement de listes
│   │   ├── exercice4/      # Dérivée de polynômes
│   │   ├── exercice5/      # Vecteurs creux
│   │   ├── exercice6/      # Matrices symétriques
│   │   ├── exercice7/      # Arbres
│   │   └── exercice8/      # LCB et ABR
│   └── bin/                # Fichiers compilés
├── utils/                  # Utilitaires communs
├── doc/                    # Documentation générée
├── bin/                    # Fichiers compilés principaux
├── Main.java              # Point d'entrée du programme
├── Menu.java              # Menu principal
├── build.sh               # Script de build pour Unix
├── build.bat              # Script de build pour Windows
└── README.md              # Ce fichier
```

## 💻 Prérequis

- Java Development Kit (JDK) 8 ou supérieur
- Terminal ou invite de commande

## 🚀 Installation

### 1. Cloner le dépôt

```bash
git clone https://github.com/Aminadioulde/Fiche_A2_A3_POO.git
cd Fiche_A2_A3_POO
```

### 2. Compiler le projet

**Pour Unix/MacOS :**

```bash
./build.sh
```

**Pour Windows :**

```bash
build.bat
```

## 🔧 Utilisation

### Exécution normale

```bash
java -jar projet.jar
```

### Exécution des tests statiques

```bash
java -jar projet.jar test
```

## 📝 Description des exercices

### Fiche 2

1. **Listes chaînées et chaînes de caractères**

   - Implémentation d'une liste chaînée simple
   - Manipulation de chaînes de caractères

2. **Listes chaînées bidirectionnelles**

   - Implémentation d'une liste doublement chaînée
   - Gestion des pointeurs précédent et suivant

3. **Traitement de listes chaînées**

   - Opérations avancées sur les listes
   - Manipulation d'entiers

4. **Dérivée d'un polynôme**

   - Représentation de polynômes
   - Calcul de dérivées

5. **Vecteurs creux**

   - Implémentation efficace de vecteurs
   - Gestion des éléments non nuls

6. **Matrices symétriques**

   - Représentation optimisée
   - Opérations matricielles

7. **Terminologie sur les arbres**

   - Concepts fondamentaux des arbres
   - Manipulation de structures arborescentes

8. **LCB et ABR**
   - Listes Chaînées Bidirectionnelles
   - Arbres Binaires de Recherche

## 📚 Documentation

La documentation Javadoc est générée automatiquement lors de la compilation dans le dossier `doc/`.
Pour la consulter, ouvrez le fichier `doc/index.html` dans un navigateur web.

## 🧪 Tests

Les tests statiques sont disponibles pour chaque exercice dans le package `fiche2.src.demo.testStatic`.
Ils peuvent être exécutés individuellement depuis le menu ou tous ensemble via l'argument "test".

---
