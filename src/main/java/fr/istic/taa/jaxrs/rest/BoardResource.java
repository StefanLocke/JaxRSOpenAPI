package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.service.Service;
import fr.istic.taa.jaxrs.service.domain.Board;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/kaban/boards")
@Produces({"application/json", "application/xml"})
public class BoardResource {

    Service service = Service.instance;

    @GET
    @Path("/")
    public String getAllBoards(){
        return service.getAllBoardIds().toString();
    }

    @POST
    @Path("/{title}")
    public Response createBoard(@PathParam("title") String title) {
            service.createNewBoard(title);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public Board getBoard(@PathParam("id") Long id) {
        return service.getBoardFromId(id);
    }
}
