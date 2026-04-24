Smart Campus REST API
Overview

The Smart Campus REST API is a Java-based RESTful web application developed using JAX-RS (Jersey) and deployed on Apache Tomcat.

This system is designed to manage rooms, sensors, and sensor readings within a campus environment. It demonstrates core RESTful concepts such as CRUD operations, filtering, sub-resource relationships, validation, and error handling.

Technologies Used

Java (JDK 8 or higher)
Maven
JAX-RS (Jersey)
Apache Tomcat
JSON

Base URL

http://localhost:8080/SmartCampuAPI/api/v1

Build and Run Instructions
Clone the repository
git clone https://github.com/Kasuni-Piyumanthi/SmartCampusAPI.git
Navigate to the project directory
cd SmartCampusAPI
Build the project using Maven
mvn clean install
Deploy to Apache Tomcat
Copy the generated WAR file from:
target/SmartCampuAPI-1.0-SNAPSHOT.war

Paste it into the Tomcat webapps directory

Start the Tomcat server
Open in browser
http://localhost:8080/SmartCampuAPI/
Verify the API
http://localhost:8080/SmartCampuAPI/api/v1
API Endpoints

Rooms
POST /rooms
GET /rooms
GET /rooms/{id}
DELETE /rooms/{id}

Sensors
POST /sensors
GET /sensors
GET /sensors/{id}

Filtering
GET /sensors?type=temperature
GET /sensors?status=active

Sub-Resources
POST /rooms/{roomId}/sensors/{sensorId}
GET /rooms/{roomId}/sensors

Sensor Readings
POST /sensors/{id}/readings
GET /sensors/{id}/readings

Sample curl Commands

Create a Room
curl -X POST http://localhost:8080/SmartCampuAPI/api/v1/rooms
 -H "Content-Type: application/json" -d "{"id":"R1","name":"Lecture Hall","capacity":100}"

Get All Rooms
curl http://localhost:8080/SmartCampuAPI/api/v1/rooms

Create a Sensor
curl -X POST http://localhost:8080/SmartCampuAPI/api/v1/sensors
 -H "Content-Type: application/json" -d "{"id":"S1","type":"temperature","status":"active"}"

Filter Sensors
curl "http://localhost:8080/SmartCampuAPI/api/v1/sensors?type=temperature"

Assign Sensor to Room
curl -X POST http://localhost:8080/SmartCampuAPI/api/v1/rooms/R1/sensors/S1

Add Sensor Reading
curl -X POST http://localhost:8080/SmartCampuAPI/api/v1/sensors/S1/readings
 -H "Content-Type: application/json" -d "{"id":"READ-1","timestamp":1710000000,"value":26.5}"

Get Sensor Readings
curl http://localhost:8080/SmartCampuAPI/api/v1/sensors/S1/readings

HTTP Status Codes

200 OK – Successful request
201 Created – Resource created
400 Bad Request – Invalid input
404 Not Found – Resource not found

Features

Room management with validation
Sensor management with filtering support
Sub-resource relationships between rooms and sensors
Sensor reading management
Structured error handling

Author

Kasuni Jayasekara
