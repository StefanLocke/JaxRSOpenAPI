package fr.istic.taa.jaxrs.service.dto;

import fr.istic.taa.jaxrs.service.domain.Category;
import fr.istic.taa.jaxrs.service.domain.Post;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "category")
public class CategoryDTO {

    public CategoryDTO(Category category) {
        id = category.getId();
        name = category.getName();
        postsId = new LinkedList<>();
        for (Post post : category.getPosts()) {
            postsId.add(post.getId());
        }
    }
    @XmlElement(name = "id")
    long id;
    @XmlElement(name = "name")
    String name;
    @XmlElement(name = "posts")
    List<Long> postsId;
}
