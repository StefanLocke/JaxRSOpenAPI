package fr.istic.taa.jaxrs.service.dto;

import fr.istic.taa.jaxrs.service.domain.Board;
import fr.istic.taa.jaxrs.service.domain.Category;
import fr.istic.taa.jaxrs.service.domain.Post;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;
@XmlRootElement(name = "board")
public class BoardDTO {

    public BoardDTO(Board board) {
        id = board.getId();
        title = board.getTitle();
        posts = new LinkedList<>();
        for (Post post : board.getPosts()) {
            posts.add(post.toDTO());
        }
        categories = new LinkedList<>();
        for (Category category : board.getCategories()) {
            categories.add(category.toDTO());
        }
    }
    @XmlElement(name = "id")
    long id;
    @XmlElement(name = "title")
    String title;
    @XmlElement(name = "posts")
    List<PostDTO> posts;
    @XmlElement(name = "categories")
    List<CategoryDTO> categories;


}
