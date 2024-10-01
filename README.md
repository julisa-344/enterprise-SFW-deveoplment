> Made by: Julisa Leon Corrales


# Installing utilites

## Java and friends


### Installing java


```bash
sudo dnf update
sudo dnf install java-21-openjdk-devel
```

Test java
```bash
java -version
```

you should see:

```
openjdk version "21.0.4" 2024-07-16
OpenJDK Runtime Environment (build 21.0.4+7)
OpenJDK 64-Bit Server VM (build 21.0.4+7, mixed mode, sharing)
```

If not, try to modify your bash source: 

```bash
code ~/.bashrc
```

And insert the following lines: 

```bash
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk
export PATH=$JAVA_HOME/bin:$PATH
```

Then, run 
```bash
source ~/.bashrc
```



### Installing friends


#### Maven

```
dnf install maven
```

check: 


```bash
mvn -v
```

Expected 
```
Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: /usr/share/java/maven
Java version: 21.0.4, vendor: Arch Linux, runtime: /usr/lib/jvm/java-21-openjdk
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "6.10.10-arch1-1", arch: "amd64", family: "unix"
```

#### Tomcat

THis is kinda long, but just follow my lead, love of mine

1. First, download the packed tomcat installation

```bash
wget https://downloads.apache.org/tomcat/tomcat-9/v9.0.95/bin/apache-tomcat-9.0.95.tar.gz
```

Wait until it completes, you should see a file named `apache-tomcat-9.0.95.tar.gz` on the same folder you executed that cmd

2. Then, tar (unpack) the file

```bash
tar -xvzf apache-tomcat-9.0.95.tar.gz
```

3. Move the installation to the apps folder  
```bash
sudo mv apache-tomcat-9.0.95 /opt/tomcat
```

4. Edit your bash file: 


```bash
code ~/.bashrc
```

Add the following lines:

```bash
export CATALINA_HOME=/opt/tomcat
export PATH=$CATALINA_HOME/bin:$PATH
```

Reload
```bash
source ~/.bashrc
```

5. Test your tomcat installation: 

navigate to 
```bash
cd /opt/tomcat/bin
```

And run tomcat:
```bash
./startup.sh
```

Then, open in your browser `http://localhost:8080`

you should se THE CAT


Now your system is ready to run, my bububu!  



# Testing this code 


ASi como tu tienes tu `npm run start`, en java los abuelitos tienen `mvn clean package`, correlo cada vez que quieras probar algun cambio

Luego, tienes que mover tu archivo .war a tomcat:

```bash
sudo mv target/ISILRegalosERP-0.0.1-SNAPSHOT.war /opt/tomcat/webapps
```

Y tienes que reinicar al gateto: 
```bash
cd /opt/tomcat/bin
./shutdown.sh
./startup.sh
```

Te recomiendo que tengas una terminal dividad, en una la ruta de tu proyecto y en otra la del gateto
