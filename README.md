# search-module

Basic Search module which returns result based on the query params passed.

This module is created using following stacks

1. Spring-boot
2. WebFlux for non-blocking calls
3. Actuator for node health
4. Swagger for API documentation.
5. JsonPath , to parse Json

# Design

# Requirement 

At this URL: https://api.myjson.com/bins/1f2r2v?pretty=true. You will find a JSON file with a
sample “Mobile handset” database. The data in this JSON is static, it doesn’t get updated.
1. Create a Spring Boot application exposing a search API as following:
GET /mobile/search? API: search API will be able to retrieve one or more mobile
handsets information based on search criteria. Criteria can be any field in the
handset data along with any value. Examples:
- /search?priceEur=200. Will return 10 devices.
- /search?sim=eSim. Will return 18 devices.
- /search?announceDate=1999&price=200. Will return 2 devices.
2. Consume the JSON API in the best way you see suitable.
3. Create Unit Test cases as you see suitable.
4. Provide a documentation and a high-level architecture of your application. You can
do one or more diagrams, as you see suitable, to describe your application
functionality.



# Solution :

We are using static data from https://api.myjson.com/bins/1f2r2v?pretty=true json.

So in the application I have loaded this data in memory only first time during startup of application. For in memory we can use multiple ways, like Couchbase, in memory database etc.

I have used JSONPath library to parse the json and query on json data.

I have used webflux spring boot reactive java for non blocking calls.

I have used actuator to check if appplication health is okay and running.

Swagger for Documentation.

# Steps to run application 

1. Download the code or clone it
2. cmd:\search-module> mvn clean install -DskipTests=true
3. cmd:\search-module> cd target
4. cmd:\search-module\target> java -jar search-module-0.0.1-SNAPSHOT.jar

now on brower you can hit below urls 

1. http://localhost:8080/criteria
2. http://localhost:8080/criteria?announceDate=1999
3. http://localhost:8080/criteria?priceEur=200
4. http://localhost:8080/criteria?announceDate=1999&priceEur=200
