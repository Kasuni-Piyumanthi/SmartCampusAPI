# Smart Campus REST API

##  Overview
The Smart Campus REST API is a Java-based RESTful web service developed using JAX-RS (Jersey) and deployed on Apache Tomcat.

This API manages:
- Rooms
- Sensors
- Sensor Readings

It demonstrates key REST principles including:
- CRUD operations
- Query-based filtering
- Sub-resource relationships
- Input validation
- Structured error handling

---

##  Technologies Used
- Java (JDK 8+)
- Maven
- JAX-RS (Jersey)
- Apache Tomcat
- JSON

---

##  Base URL
http://localhost:8080/SmartCampuAPI/api/v1

---

##  Build & Run Instructions

1. Clone the repository
git clone https://github.com/Kasuni-Piyumanthi/SmartCampusAPI.git

2. Navigate to the project
cd SmartCampusAPI

3. Build using Maven
mvn clean install

4. Deploy to Apache Tomcat
Copy the WAR file:
target/SmartCampuAPI-1.0-SNAPSHOT.war

Paste into:
Tomcat/webapps/

5. Start Tomcat server

6. Open in browser
http://localhost:8080/SmartCampuAPI/

7. Verify API
http://localhost:8080/SmartCampuAPI/api/v1

---

##  API Endpoints

### Rooms
POST /rooms  
GET /rooms  
GET /rooms/{id}  
DELETE /rooms/{id}  

### Sensors
POST /sensors  
GET /sensors  
GET /sensors/{id}  

### Filtering
GET /sensors?type=temperature  
GET /sensors?status=active  

### Sub-Resources
POST /rooms/{roomId}/sensors/{sensorId}  
GET /rooms/{roomId}/sensors  

### Sensor Readings
POST /sensors/{id}/readings  
GET /sensors/{id}/readings  

---

##  Sample curl Commands

Create a Room
curl -X POST http://localhost:8080/SmartCampuAPI/api/v1/rooms \
-H "Content-Type: application/json" \
-d '{"id":"R1","name":"Lecture Hall","capacity":100}'

Get All Rooms
curl http://localhost:8080/SmartCampuAPI/api/v1/rooms

Create a Sensor
curl -X POST http://localhost:8080/SmartCampuAPI/api/v1/sensors \
-H "Content-Type: application/json" \
-d '{"id":"S1","type":"temperature","status":"active"}'

Filter Sensors
curl "http://localhost:8080/SmartCampuAPI/api/v1/sensors?type=temperature"

Assign Sensor to Room
curl -X POST http://localhost:8080/SmartCampuAPI/api/v1/rooms/R1/sensors/S1

Add Sensor Reading
curl -X POST http://localhost:8080/SmartCampuAPI/api/v1/sensors/S1/readings \
-H "Content-Type: application/json" \
-d '{"id":"READ-1","timestamp":1710000000,"value":26.5}'

Get Sensor Readings
curl http://localhost:8080/SmartCampuAPI/api/v1/sensors/S1/readings

---

##  HTTP Status Codes
- 200 OK → Successful request
- 201 Created → Resource created
- 400 Bad Request → Invalid input
- 404 Not Found → Resource not found

---

##  Features
- Room management
- Sensor management
- Filtering support
- Sub-resource relationships
- Sensor readings handling
- Validation and error handling

---

## 👤 Author
Kasuni Jayasekara  
Computer Science Undergraduate
