@echo off
echo Compilation du projet...

REM Création des répertoires nécessaires
mkdir fiche1\bin 2>nul
mkdir fiche2\bin 2>nul
mkdir bin 2>nul
mkdir doc 2>nul

REM Compilation de la fiche 2
echo Compilation de la fiche 2...
javac -d fiche2\bin fiche2\src\MenuFiche2.java ^
    fiche2\src\exercice1\*.java ^
    fiche2\src\exercice2\*.java ^
    fiche2\src\exercice3\*.java ^
    fiche2\src\exercice4\*.java ^
    fiche2\src\exercice5\*.java ^
    fiche2\src\exercice7\*.java ^
    fiche2\src\exercice8\*.java ^
    fiche2\src\demo\*.java

REM Compilation des fichiers principaux
echo Compilation des fichiers principaux...
javac -cp fiche2\bin -d bin Main.java Menu.java

REM Création du fichier manifest
echo Création du fichier manifest...
echo Main-Class: Main> manifest.txt

REM Création du fichier JAR avec le manifest
echo Création du fichier JAR...
jar cvfm projet.jar manifest.txt -C bin . -C fiche2\bin .

REM Génération de la documentation
echo Génération de la documentation Javadoc...
javadoc -d doc -sourcepath fiche2\src;. -subpackages fiche2 Main.java Menu.java

echo Compilation terminée.
echo.
echo Pour exécuter l'application:
echo   java -jar projet.jar
echo.
echo Pour lancer les tests statiques directement:
echo   java -jar projet.jar test
echo.
echo Documentation générée dans le répertoire 'doc/'
pause

