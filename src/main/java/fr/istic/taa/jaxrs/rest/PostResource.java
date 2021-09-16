package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.service.Service;
import fr.istic.taa.jaxrs.service.domain.Board;
import fr.istic.taa.jaxrs.service.domain.Category;
import fr.istic.taa.jaxrs.service.domain.Post;
import fr.istic.taa.jaxrs.service.dto.BoardDTO;
import fr.istic.taa.jaxrs.service.dto.CategoryDTO;
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
    @Path("/{categoryId}")
    @Consumes("application/json")
    public void addPost(@PathParam("categoryId") long categoryId,@Parameter(description = "post to add", required = true) Post post) {
        service.addPost(categoryId, post);
    }

    @GET
    @Path("/{id}")
    public PostDTO getPost(@PathParam("id") Long id) {
        return service.getPostFromId(id);
    }

}
