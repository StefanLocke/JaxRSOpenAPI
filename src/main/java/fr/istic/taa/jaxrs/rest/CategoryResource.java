package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.service.Service;
import fr.istic.taa.jaxrs.service.domain.Board;
import fr.istic.taa.jaxrs.service.domain.Category;
import fr.istic.taa.jaxrs.service.domain.Post;
import fr.istic.taa.jaxrs.service.dto.BoardDTO;
import fr.istic.taa.jaxrs.service.dto.CategoryDTO;
import io.swagger.v3.oas.annotations.Parameter;

import javax.validation.constraints.Positive;
import javax.ws.rs.*;
import java.util.List;

@Path("/kaban/category")
@Produces({"application/json", "application/xml"})
public class CategoryResource {

    Service service = Service.instance;

    @GET
    @Path("/ids")
    public List<Long> getAllCategoryIds(){
        return service.getAllCategoryIds();
    }

    @GET
    @Path("/")
    public List<CategoryDTO> getAllCategory(){
        return service.getAllCategories();
    }

    @POST
    @Path("/{boardId}")
    @Consumes("application/json")
    public void addCategory(@PathParam("boardId") long boardId,@Parameter(description = "post to add", required = true)Category category) {
        service.addCategory(boardId, category);
    }

    @GET
    @Path("/{id}")
    public CategoryDTO getCategory(@PathParam("id") Long id) {
        return service.getCategoryFromId(id);
    }

}
