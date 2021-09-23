package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.service.Service;
import fr.istic.taa.jaxrs.service.domain.Board;
import fr.istic.taa.jaxrs.service.dto.BoardDTO;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/kaban/boards")
@Produces({"application/json"})
public class BoardResource {
    private static final Logger logger = Logger.getLogger(BoardResource.class.getName());
    Service service = Service.instance;

    @GET
    @Path("/ids")
    @Tag(name = "Board")
    public String getAllBoardsIds(){
        logger.info("GET request received : getAllBoardsIds");
        return service.getAllBoardsIds().toString();
    }

    @GET
    @Path("/")
    @Tag(name = "Board")
    public List<BoardDTO> getAllBoards(){
        logger.info("GET request received : getAllBoards");
        return service.getAllBoards();
    }

    @POST
    @Path("/{title}")
    @Tag(name = "Board")
    public Response createBoard(@PathParam("title") String title) {
        logger.info("POST request received : createBoard");
        service.createNewBoard(title);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Tag(name = "Board")
    public BoardDTO getBoard(@PathParam("id") Long id) {
        logger.info("GET request received : getBoard");
        return service.getBoardFromId(id);
    }
}
