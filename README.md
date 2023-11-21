# Compojure-api 2.0.0 demo
## bug demonstration:

Running main.clj - using http-kit server, will show the following bug when entering the server on `http://localhost:8010/index.html`

`500 : Receiver class linked.map.LinkedMap does not define or inherit an implementation of the resolved method 'abstract boolean isEmpty()' of interface java.util.Map. http://localhost:8010/api/v2`

## Usage

### Run the application locally

`lein ring server`

### Packaging and running as standalone jar

```
lein do clean, ring uberjar
java -jar target/server.jar
```

### Packaging as war

`lein ring uberwar`

## License

Copyright © 2017-2018 [Metosin Oy](http://www.metosin.fi)

Distributed under the Eclipse Public License, the same as Clojure.
