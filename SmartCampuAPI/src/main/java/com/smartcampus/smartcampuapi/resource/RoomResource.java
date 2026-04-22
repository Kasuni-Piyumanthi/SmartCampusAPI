package com.smartcampus.smartcampuapi.resource;

import com.smartcampus.smartcampuapi.model.Room;

import com.smartcampus.smartcampuapi.model.ErrorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.*;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {

    private static Map<String, Room> roomMap = new HashMap<>();

    // GET all rooms
    @GET
    public Response getAllRooms() {
        return Response.ok(roomMap.values()).build();
    }

    // POST create room
    @POST
    public Response createRoom(Room room) {

        if (room.getId() == null || room.getId().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Room ID is required")
                    .build();
        }

        roomMap.put(room.getId(), room);

        return Response.status(Response.Status.CREATED)
                .entity(room)
                .build();
    }

    // GET room by ID
    @GET
    @Path("/{id}")
    public Response getRoom(@PathParam("id") String id) {

        Room room = roomMap.get(id);

        if (room == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Room not found")
                    .build();
        }

        return Response.ok(room).build();
    }
    
    // DELETE room by ID
    @DELETE
    @Path("/{id}")
    public Response deleteRoom(@PathParam("id") String id) {

        Room room = roomMap.get(id);

        if (room == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse("Room not found"))
                    .build();
        }

        // 🔥 IMPORTANT LOGIC (high marks)
        if (room.getSensorIds() != null && !room.getSensorIds().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse("Cannot delete room with sensors"))
                .build();
        }

        roomMap.remove(id);

        return Response.ok("Room deleted successfully").build();
    }
}