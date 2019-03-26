# Pact, The Workshop
[Work in progress]
Enjoy testing microservices with Pact https://docs.pact.io/

# Agenda
##### Talk
- Brief intro to Consumer Driven Contract and Pact - 20 minutes

##### Hands-on

- Pact creation and testing - 30 minutes
- Pact Broker - 30 minutes
- Tags: how to overcome the version hell - 40 minutes

#### Language
At the moment, this workshop is made for Java. Soon it'll be extended with Javascript and many more languages.

---
# The Broker, the Consumer and the Provider
#### Broker

If you came across this repo and wanna try Pact, you can just follow the following commands: 

```
cd broker 
docker-compose up
```

The you'll be able to access it from the browser at:

```
http://localhost:8000
```

#### Consumer
Find the consumer at 

```
cd consumerA
``` 

Create pact file running its tests with 

```
./gradlew tests
```

and then publish it to the broker with

```
./gradlew pactPublish
```

#### Provider
Find the provider at 

```
cd provider
``` 

Verify pacts running its tests with 

```
./gradlew tests
```

If they verify, they will be published to the broker as well


# Enjoy!



