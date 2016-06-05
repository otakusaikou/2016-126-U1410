# Project name
PRJ_NAME = practice4

# Package name
PKG = practice0523

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
	model/User.java \
	model/AccountUtil.java \
	controller/AddNewUser.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) -r model/*.class controller/*.class $(PKG)


deploy:
	make stop ; \
	if [ ! -d "../../WebContent/WEB-INF/classes" ]; then \
		sudo mkdir ../../WebContent/WEB-INF/classes ; \
	fi
	sudo rm -r ../../WebContent/WEB-INF/classes/$(PKG) ; \
	sudo rm -r $(PRJ_SRC) ; \
	sudo cp -r Makefile controller model $(PKG) ; \
	sudo mv $(PKG) ../../WebContent/WEB-INF/classes ; \
	make clean ; \
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
