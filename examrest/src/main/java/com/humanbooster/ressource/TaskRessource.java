package com.humanbooster.ressource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import com.humanbooster.dao.TaskDAO;
import com.humanbooster.model.Task;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskRessource {
    private final TaskDAO dao = new TaskDAO();

    @GET
    public List<Task> getAll() {
        return dao.findAll();
    }

    @GET
    @Path("/{id}")
    public Task getById(@PathParam("id") Long id) {
        return dao.findById(id);
    }

    @POST
    public void create(Task person) {
        dao.save(person);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, Task person) {
        person.setId(id);
        dao.save(person);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        dao.delete(id);
    }
} 
