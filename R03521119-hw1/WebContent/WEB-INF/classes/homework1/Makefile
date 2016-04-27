# Project name
PRJ_SRC = $(CATALINA_HOME)/webapps/R03521119

# Package name
PKG = homework1

# Compiler
JC = javac

# Compile options
JFLAGS = -cp $(CATALINA_HOME)/lib/servlet-api.jar

# Suffix rule
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java ;
	make deploy

# Source files
CLASSES = \
	DataUploader.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

deploy:
	if [ ! -d "$(PRJ_SRC)/WEB-INF/classes/$(PKG)" ]; then \
		sudo mkdir $(PRJ_SRC)/WEB-INF/classes/$(PKG) ; \
	fi 
	sudo cp *.class $(PRJ_SRC)/WEB-INF/classes/$(PKG) ; \
	make restart

restart:
	sudo $(CATALINA_HOME)/bin/startup.sh ;
	sudo $(CATALINA_HOME)/bin/shutdown.sh ;

start:
	sudo $(CATALINA_HOME)/bin/startup.sh

stop:
	sudo $(CATALINA_HOME)/bin/shutdown.sh
