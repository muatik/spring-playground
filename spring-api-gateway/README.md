## Spring-Api-Gateway using Netflix Zuul

This example shows how to use Netflix Zuul to route requests coming to an api gateway to api server application.

There are two Spring boot application in this example:

1. Api-Application
2. Api-Gateway

## 1. Api-Application
This application servers a REST API by which you can list available songs and insert new Songs.

`Port: 8081`

##### GET /songs/

##### POST /songs/
Song data as JSON in request body

##### DELETE /songs/1/


## 2. Api-Gateway
This is the gateway application which routes all requests coming to `http://localhost:8080/api/songs` to the app-application's `http://localhost:8081/songs/`. The rule is defined in application.yml.

`Port: 8080`
