# Create image for docker 
## Make jar
```commandline
 mvn clean install
```
## Create docker image from jar

```commandline
docker build -t app-gateway:latest .
```