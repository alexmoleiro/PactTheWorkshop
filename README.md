# Pact, TheWorkshop
Enjoy testing microservices with Pact https://docs.pact.io/

So far, this workshop will let you:
- Define a contract from a Consumer and publish it to the broker
- Verify the contract with a Provider
- Run a broker to share pacts and verifications

### Language
At the moment, this workshop is made for Java. Soon it'll be extended with Javascript and many more languages.

### Start the Pact Broker

```
cd broker 
docker-compose up
```
The you'll be able to access it from the browser at:

```localhost:8000```

### Consumer
Find the consumer at 

```cd consumerA``` 

Create pact file running its tests with 

```./gradlew tests```

and the publish it to the broker with

```./gradlew pactPublish```

### Provider
Find the provider at 

```cd provider``` 

Verify pacts running its tests with 

```./gradlew tests```

If the verify, they will be published to the broker as well


#Enjoy!



