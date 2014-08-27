# Sample Dropwizard Service

Use this service as a starting point to build **Dropwizard 7 Service + Frontend**.

## Required Technology
- [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)
- [Maven](http://maven.apache.org/download.cgi)

## How to run
Run the below command from your terminal
```sh
git clone git@github.com:TurtleShip/sample-dropwizard-service.git # download my repo
cd sample-dropwizard-service
mvn clean package
java -jar sample-service/target/sample-service-1.0-SNAPSHOT.jar server
```

Once you run the last command, the sample service will be up and running. At that point
- Check out **frontend** by typing ```http://localhost:8080``` in your favorite browser.
- Check out **backend** at work by visiting ```http://localhost:8080/api/hello```. You should see "hi" written in a very small font.
- Check out admin port at ```http://localhost:8081```
