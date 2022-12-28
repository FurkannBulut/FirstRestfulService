package com.garanti.endpoints;

import com.garanti.model.Ders;
import com.garanti.repo.DersRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path(value = "ders")
public class DersEndPoints
{
    private DersRepo repo;

    public DersEndPoints()
    {
        this.repo = new DersRepo();
    }
    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ders> getAll()
    {
        // localhost:9090/FirstRestfulService/ders/getAll
        return repo.getAll();
    }
    @GET
    @Path(value = "getByIdHeader")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders getByIdHeader(@HeaderParam(value = "id")Integer id)
    {
        return repo.getById(id);
    }
    @GET
    @Path(value = "getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ders getByIdPathParam(@PathParam(value = "id") Integer id)
    {
        // localhost:9090/FirstRestfulService/ders/getById/1
        return repo.getById(id);
    }

    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ders ders)
    {
       // localhost:9090/FirstRestfulService/ders/save
        repo.save(ders);
        return "Başarı ile kaydedildi.";
    }
    @DELETE
    @Path(value = "deleteById/{id}")
    public String deleteById(@PathParam(value = "id")Integer id)
    {
        // localhost:9090/FirstRestfulService/ders/deleteById
        if (repo.deleteById(id)){
            return "Başarı ile silindi.";

        }
        else {
            return "Başarı ile silinemedi.";
        }
    }
}
