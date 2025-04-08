#!/bin/bash
echo "Compilation du projet..."

# Création des répertoires nécessaires
mkdir -p fiche1/bin
mkdir -p fiche2/bin
mkdir -p bin
mkdir -p doc

# Compilation de utils first
echo "Compilation des utilitaires..."
javac -d bin utils/Utilitaires.java

# Compilation de la fiche 1
echo "Compilation de la fiche 1..."
javac -cp bin -d fiche1/bin fiche1/src/MenuFiche1.java \
    fiche1/src/exercice1/*.java \
    fiche1/src/exercice3/*.java \
    fiche1/src/exercice4/*.java \
    fiche1/src/exercice5/*.java \
    fiche1/src/demo/*.java \
    fiche1/src/demo/testStatic/*.java

# Compilation de la fiche 2
echo "Compilation de la fiche 2..."
javac -cp bin -d fiche2/bin \
    fiche2/src/exercice1/*.java \
    fiche2/src/exercice2/*.java \
    fiche2/src/exercice3/*.java \
    fiche2/src/exercice4/*.java \
    fiche2/src/exercice5/*.java \
    fiche2/src/exercice7/*.java \
    fiche2/src/exercice8/*.java \
    fiche2/src/demo/*.java 2>/dev/null || true

# Compilation des fichiers principaux
echo "Compilation des fichiers principaux..."
javac -cp bin:fiche1/bin:fiche2/bin -d bin Main.java Menu.java

# Création du fichier manifest
echo "Création du fichier manifest..."
echo "Main-Class: Main" > manifest.txt

# Création du fichier JAR avec le manifest
echo "Création du fichier JAR..."
jar cvfm projet.jar manifest.txt -C bin . -C fiche1/bin fiche1 -C fiche2/bin fiche2

# Génération de la documentation
echo "Génération de la documentation Javadoc..."
javadoc -d doc -sourcepath .:fiche1/src:fiche2/src -subpackages fiche1.src fiche2.src utils Main Menu 2>/dev/null || true

echo "Compilation terminée."
echo ""
echo "Pour exécuter l'application:"
echo "  java -jar projet.jar"
echo ""
echo "Pour lancer les tests statiques directement:"
echo "  java -jar projet.jar test"
echo ""
echo "Documentation générée dans le répertoire 'doc/'."

