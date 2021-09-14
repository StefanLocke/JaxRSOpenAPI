package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.service.Service;
import fr.istic.taa.jaxrs.service.domain.Post;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/kaban")
@Produces({"application/json", "application/xml"})
public class PostResource {

    Service service = Service.instance;
    @GET
    @Path("/posts")
    public String getAllPosts(){
        return service.getAllPostsIds().toString();
    }

    @POST
    @Path("/new/{id}")
    @Consumes("application/json")
    public Response createPost(@PathParam("id") Long boardId, @Parameter(description = "post to add", required = true)Post post) {
        System.out.println(post);
        service.addPost(boardId,post);
        return Response.ok().build();
    }
}
