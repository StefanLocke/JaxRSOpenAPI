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

    long id;

    String name;

    List<Long> postsId;

    @XmlElement(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "posts")
    public List<Long> getPostsId() {
        return postsId;
    }

    public void setPostsId(List<Long> postsId) {
        this.postsId = postsId;
    }
}
