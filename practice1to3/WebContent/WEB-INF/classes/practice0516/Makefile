# Project name
PRJ_NAME = practice1to3

# Package name
PKG = practice0516

# Project source
PRJ_SRC = $(CATALINA_HOME)/webapps/$(PRJ_NAME)

# Compiler
JC = javac

# Compile options
JFLAGS = -cp .:$(CATALINA_HOME)/lib/servlet-api.jar -d .

# Suffix rule
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

# Source files
CLASSES = \
	AddNewUser.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) -r *.class $(PKG)


deploy:
	make stop ; \
	if [ ! -d "../../WebContent/WEB-INF/classes" ]; then \
		sudo mkdir ../../WebContent/WEB-INF/classes ; \
	fi
	sudo rm -r ../../WebContent/WEB-INF/classes/$(PKG) ; \
	sudo rm -r $(PRJ_SRC) ; \
	sudo cp *.java Makefile $(PKG) ; \
	sudo mv $(PKG) ../../WebContent/WEB-INF/classes ; \
	cd ../../WebContent ; \
	jar -cMf $(PRJ_NAME).war * ; \
	mv $(PRJ_NAME).war $(CATALINA_BASE) ; \
	cd - ; \
	make start ; \

restart:
	sudo $(CATALINA_HOME)/bin/shutdown.sh ; \
	sudo $(CATALINA_HOME)/bin/startup.sh ; \

start:
	sudo $(CATALINA_HOME)/bin/startup.sh

stop:
	sudo $(CATALINA_HOME)/bin/shutdown.sh
