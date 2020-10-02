### How to run this project ?

1. Start the 'Big json' service

```
cd json-server
npm install
node index.js
```

### Let's try to consume the big json with both a reactive and a vanilla http clients. We'll use only 200 mbs of memory to simulate a low memory environment.


2. Test the reactive client

```
cd reactive-client
./mvnw install
java -jar -Xmx200m target/reactive-client-0.0.1-SNAPSHOT.jar 
```


3. Test the reactive client

```
cd vanilla-client
./mvnw install
java -jar -Xmx200m target/vanilla-client-0.0.1-SNAPSHOT.jar 
```

- Run `curl -ki http://localhost:8080/Female/9000/count` to test both services.


