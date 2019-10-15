# mars-rover
Robot on mars

I presume where ever the rover landed is north and location (x:0,y:0) 

Tech stack i used for this project

- Google code style 
- Lombok
- Docker
- Junit
- Sonar 

Run the below command to run tests locally 

```
mvn test
```


Run the below command to check code coverage locally (Might need access rights from sonar cloud)

```
mvn verify sonar:sonar \
     -Dsonar.projectKey=dvsgvarma_mars-rover \
     -Dsonar.organization=dvsgvarma \
     -Dsonar.host.url=https://sonarcloud.io \
     -Dsonar.login= eea86ab08e257d0c2831802540a0ab7fb2d1aaea
```


To run any MarsRover-service locally we need below prerequisites
Docker Env : You need to install docker on your local machine
Mac: https://docs.docker.com/docker-for-windows/
Win: https://docs.docker.com/docker-for-mac/

Run the below command or we can just run all commands above inside the running container as well to check the results
 with out any major setup
```
docker build ./ -t mars-rover
docker run mars-rover
```
