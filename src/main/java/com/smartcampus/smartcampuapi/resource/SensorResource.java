package com.smartcampus.smartcampuapi.resource;

import com.smartcampus.smartcampuapi.model.Sensor;
import com.smartcampus.smartcampuapi.model.ErrorResponse;
import com.smartcampus.smartcampuapi.model.SensorReading;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.*;

@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {

    private static Map<String, Sensor> sensorMap = new HashMap<>();
    

    //POST create sensor
    @POST
    public Response createSensor(Sensor sensor) {

        if (sensor.getId() == null || sensor.getId().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse("Sensor ID is required"))
                    .build();
        }

        sensorMap.put(sensor.getId(), sensor);

        System.out.println("Creating sensor: " + sensor.getId());

        return Response.status(Response.Status.CREATED)
                .entity(sensor)
                .build();
    }

    //GET all sensors + FILTERING
    @GET
    public Response getSensors(@QueryParam("type") String type,
                               @QueryParam("status") String status) {

        List<Sensor> result = new ArrayList<>(sensorMap.values());

        if (type != null) {
            result.removeIf(s -> !s.getType().equalsIgnoreCase(type));
        }

        if (status != null) {
            result.removeIf(s -> !s.getStatus().equalsIgnoreCase(status));
        }

        return Response.ok(result).build();
    }

    //GET sensor by ID
    @GET
    @Path("/{id}")
    public Response getSensor(@PathParam("id") String id) {

        Sensor sensor = sensorMap.get(id);

        if (sensor == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse("Sensor not found"))
                    .build();
        }

        return Response.ok(sensor).build();
    }
    
    private static Map<String, List<SensorReading>> readingMap = new HashMap<>();
    
    @POST
    @Path("/{id}/readings")
    public Response addReading(@PathParam("id") String id, SensorReading reading) {

        Sensor sensor = sensorMap.get(id);

        if (sensor == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse("Sensor not found"))
                    .build();
        }

        if (reading.getId() == null || reading.getId().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse("Reading ID is required"))
                    .build();
        }

        readingMap.putIfAbsent(id, new ArrayList<>());
        readingMap.get(id).add(reading);

        return Response.status(Response.Status.CREATED)
                .entity(reading)
                .build();
    }
    
    @GET
    @Path("/{id}/readings")
    public Response getReadings(@PathParam("id") String id) {

        Sensor sensor = sensorMap.get(id);

        if (sensor == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse("Sensor not found"))
                    .build();
        }

        return Response.ok(readingMap.getOrDefault(id, new ArrayList<>())).build();
    }
}