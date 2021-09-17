package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.service.Service;
import fr.istic.taa.jaxrs.service.domain.Board;
import fr.istic.taa.jaxrs.service.domain.Category;
import fr.istic.taa.jaxrs.service.domain.Post;
import fr.istic.taa.jaxrs.service.dto.BoardDTO;
import fr.istic.taa.jaxrs.service.dto.CategoryDTO;
import fr.istic.taa.jaxrs.service.dto.PostDTO;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/kaban/posts")
@Produces({"application/json", "application/xml"})
public class PostResource {

    Service service = Service.instance;

    @GET
    @Path("/id")
    @Tag(name="Post")
    public String getAllPostsIds(){
        return service.getAllPostsIds().toString();
    }

    @GET
    @Path("/")
    @Tag(name="Post")
    public List<PostDTO> getAllPosts(){
        return service.getAllPosts();
    }


    @POST
    @Path("/{categoryId}")
    @Consumes("application/json")
    @Tag(name="Post")
    public void addPost(@PathParam("categoryId") long categoryId,@Parameter(description = "post to add", required = true) Post post) {
        service.addPost(categoryId, post);
    }

    @DELETE
    @Path("/{postId}")
    @Tag(name="Post")
    public void removePost(@PathParam("postId") long postId) {
        service.removePost(postId);
    }

    @GET
    @Path("/{id}")
    @Tag(name="Post")
    public PostDTO getPost(@PathParam("id") Long id) {
        return service.getPostFromId(id);
    }

}
