# ACOL 2017/18
# ============================
#
# Ce Makefile permet de compiler le test de l'ihm en ligne de commande.
# Alternative (recommandee?): utiliser un IDE (eclipse, netbeans, ...)
# Le but est d'illustrer les notions de "classpath", a vous de l'adapter
# a votre projet.
#
# Organisation:
#  1) Les sources (*.java) se trouvent dans le repertoire src
#     Les classes d'un package toto sont dans src/toto
#     Les classes du package par defaut sont dans src
#
#  2) Les bytecodes (*.class) se trouvent dans le repertoire bin
#     La hierarchie des sources (par package) est conservee.
#     Pour un package (ici gui.jar), il est aussi dans bin.
#
# Compilation:
#  Options de javac:
#   -d : repertoire dans lequel sont places les .class compiles
#   -classpath : repertoire dans lequel sont cherches les .class deja compiles
#   -sourcepath : repertoire dans lequel sont cherches les .java (dependances)

all: test

test:
	javac -d bin -classpath bin  -sourcepath src src/IfBanque.java
	# javac -d bin -classpath bin/gui.jar -sourcepath src src/TestGUI.java

# Execution:
# on peut taper directement la ligne de commande :
#   > java -classpath bin TestGUI
# ou bien lancer l'execution en passant par ce Makefile:
#   > make exeIHM
exe:
	java -classpath bin IfBanque

# in:bin/gui.jar TestCohabitation

clean:
	rm -rf bin/utilitaires/*.class
	rm -rf bin/*.class
	rm -rf bin/controleur/*.class
	rm -rf bin/model/*.class
	rm -rf bin/vue/*.class
