package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.service.Service;
import fr.istic.taa.jaxrs.service.domain.Board;
import fr.istic.taa.jaxrs.service.dto.BoardDTO;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/kaban/boards")
@Produces({"application/json"})
public class BoardResource {

    Service service = Service.instance;

    @GET
    @Path("/ids")
    @Tag(name = "Board")
    public String getAllBoardsIds(){
        return service.getAllBoardsIds().toString();
    }

    @GET
    @Path("/")
    @Tag(name = "Board")
    public List<BoardDTO> getAllBoards(){
        return service.getAllBoards();
    }

    @POST
    @Path("/{title}")
    @Tag(name = "Board")
    public Response createBoard(@PathParam("title") String title) {
            service.createNewBoard(title);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Tag(name = "Board")
    public BoardDTO getBoard(@PathParam("id") Long id) {
        return service.getBoardFromId(id);
    }
}
