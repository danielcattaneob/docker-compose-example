# Practica Parcial

## General Architecture
This project consist of two services: car service and exchange service.
Each of them have a db associated.

## Run the project
In order to run the docker compose you need to build the images for the cars and exchange services.

Move into the folder, create the jar file and create the docker image
```
cd car-service
mvn package
docker build -t car-service:1.0.0 .
```
Return to the original folder 
```
cd ..
```

Move into the folder, build the project and create the Docker image
```
cd exchange-service
mvn package
docker build -t exchange-service:1.0.0 .
```
Then return to the original folder and run the docker compose
```
cd ..
docker compose up
```