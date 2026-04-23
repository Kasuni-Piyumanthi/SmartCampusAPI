📘 Smart Campus REST API

📌 Overview

The Smart Campus REST API is a Java-based web application developed using JAX-RS (Jersey) and deployed on Apache Tomcat.
It provides a RESTful interface to manage campus rooms, sensors, and real-time sensor readings.

The system demonstrates core REST principles including CRUD operations, filtering, sub-resource relationships, validation, and structured error handling.

🚀 Technologies Used

Java (JDK 8+)
Maven (Project Management)
JAX-RS (Jersey)
Apache Tomcat (Deployment Server)
JSON (Data Format)
NetBeans (IDE)

🌐 Base URL
http://localhost:8080/SmartCampuAPI/api/v1

📂 Project Structure
com.smartcampus.smartcampuapi
│
├── model        # Data models (Room, Sensor, SensorReading, ErrorResponse)
├── resource     # REST API endpoints
├── config       # Application configuration (JAX-RS setup)


🧱 Features

🏢 Room Management
Create, retrieve, and delete rooms
Prevent deletion of rooms with assigned sensors

🌡️ Sensor Management
Create and retrieve sensors

Filter sensors by:
Type
Status

🔗 Sub-Resources
Assign sensors to rooms

Retrieve sensors within a specific room

📊 Sensor Readings
Add real time sensor readings
Retrieve readings for a specific sensor

⚠️ Error Handling
Structured JSON error responses
Proper HTTP status codes

🔗 API Endpoints

🏢 Rooms
Method	Endpoint	Description
POST	/rooms	Create a room
GET	/rooms	Get all rooms
GET	/rooms/{id}	Get room by ID
DELETE	/rooms/{id}	Delete a room

🌡️ Sensors
Method	Endpoint	Description
POST	/sensors	Create a sensor
GET	/sensors	Get all sensors
GET	/sensors/{id}	Get sensor by ID

🔍 Filtering
GET /sensors?type=temperature
GET /sensors?status=active

🔗 Sub-Resources
Method	Endpoint	Description
POST	/rooms/{roomId}/sensors/{sensorId}	Assign sensor to room
GET	/rooms/{roomId}/sensors	Get sensors in room

📊 Sensor Readings
Method	Endpoint	Description
POST	/sensors/{id}/readings	Add sensor reading
GET	/sensors/{id}/readings	Get sensor readings

📥 Example Requests
✔ Create Sensor
{
  "id": "S1",
  "type": "temperature",
  "status": "active"
}
✔ Add Sensor Reading
{
  "id": "READ-1",
  "timestamp": 1710000000,
  "value": 26.5
}

📊 HTTP Status Codes
Code	Meaning
200	OK (Successful request)
201	Created (Resource created)
400	Bad Request (Invalid input)
404	Not Found (Resource does not exist)

🧪 Testing

The API was tested using Postman, covering:

CRUD operations
Filtering
Sub-resource endpoints
Validation and error handling

⚙️ Deployment

The application is deployed on Apache Tomcat and accessed locally via:

http://localhost:8080/SmartCampuAPI/
🎯 Conclusion

This project demonstrates a fully functional RESTful API system with:

Clean architecture
Proper endpoint design
Data validation
Error handling
Real world use case (Smart Campus)
👤 Author

Kasuni Jayasekara
Computer Science Undergraduate
