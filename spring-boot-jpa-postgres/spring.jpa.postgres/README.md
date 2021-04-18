# Tutorial API

Created using Spring Boot 2.4.3.

## Prerequisites

* Java JDK 8
* Docker
* PostgreSQL

## Run the app

### Run postgres DB

* Run PostgreSQL in docker as explained in 'PostgreSQL setup'
* execute sql script in docker (run from 'db' folder)
  * Copy script to container's root: `./copy_scripts_to_docker.sh`
  * Go inside container: `./exec_postgres_docker.sh`
  * Create DB: `psql -U postgres --file tutdb.sql`

### Run app from command line

* `$ mvn clean package -Dmaven.test.skip=true`
* `$ java -jar target/spring.jpa.postgres-{version}.jar`

or

* `mvn spring-boot:run`

### Run from IntelliJ

* run Application

## Test the app

Execute Postman requests as described in the Postman section.

## Setup

### PostgreSQL setup

Use docker [image](https://hub.docker.com/_/postgres).

* Run postgres docker: Run script `./run_postgres_docker.sh` from 'db' folder

Frequent docker commands:

* List running containers: `$ docker ps -a`
* Stop a container: `$ docker stop container_id`
* Remove a container: `$ docker rm container_id`
* Stop all containers: `$ docker stop $(docker ps -a -q)`
* Remove all containers: `$ docker rm $(docker ps -a -q)`

## Tools

### IntelliJ

Set project SDK to 1.8 and language level to 8.

### Postman

Use `Tutorial API.postman_collection.json` to test API.

### PostgreSQL commands

#### Connect to storedb inside the docker container

* Access postgres DB inside the docker container as postgres user: `docker exec -it postgresdb psql -U postgres`
* Connect to DB inside docker container: `\connect tutorialdb;`

#### Execute SQL

* Select all tutorials: `select * from tutorials;`

## Issues

None