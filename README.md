Update conf directory files
===========================

conf/janus.properties
```
storage.cql.keyspace - \key space name\
storage.cql.internal.file-configuration - \astra conf file path\
```

conf/astra.conf
```
secure-connect-bundle = "/path/to/secure/bundle/zip/file"
username = "clientId"
password = "clientSecret"
``


1) Compile project: `./gradlew clean build`

.
2) Start project with JanusGraph configuration:
```
java -Djanusgraph.config.path=/path/to/janusgraph/config -jar build/libs/mapped-astradb-test.jar
```
