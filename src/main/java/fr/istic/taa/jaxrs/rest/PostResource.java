package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.service.Service;
import fr.istic.taa.jaxrs.service.domain.Board;
import fr.istic.taa.jaxrs.service.domain.Post;
import fr.istic.taa.jaxrs.service.dto.BoardDTO;
import fr.istic.taa.jaxrs.service.dto.PostDTO;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/kaban/posts")
@Produces({"application/json", "application/xml"})
public class PostResource {

    Service service = Service.instance;

    @GET
    @Path("/id")
    public String getAllPostsIds(){
        return service.getAllPostsIds().toString();
    }

    @GET
    @Path("/")
    public List<PostDTO> getAllPosts(){
        return service.getAllPosts();
    }

    @POST
    @Path("/{id}")
    @Consumes("application/json")
    public Response createPost(@PathParam("id") long boardId, @Parameter(description = "post to add", required = true)Post post) {
        System.out.println(post);
        service.addPost(boardId,post);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    public BoardDTO getBoard(@PathParam("id") Long id) {

        return service.getBoardFromId(id);
    }




}
