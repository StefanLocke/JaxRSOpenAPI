package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.service.Service;
import fr.istic.taa.jaxrs.service.domain.Board;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/kaban")
@Produces({"application/json", "application/xml"})
public class BoardResource {

    Service service = Service.instance;

    @GET
    @Path("/boards")
    public String getAllBoards(){
        return service.getAllBoardIds().toString();
    }

    @POST
    @Path("/board/{title}")
    public Response createBoard(@PathParam("title") String title) {
            service.createNewBoard(title);
        return Response.ok().build();
    }

    @GET
    @Path("board/{id}")
    public Board getBoard(@PathParam("id") Long id) {
        return service.getBoardFromId(id);
    }
}
