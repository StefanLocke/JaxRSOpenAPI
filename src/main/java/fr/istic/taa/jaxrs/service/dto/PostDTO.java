package fr.istic.taa.jaxrs.service.dto;

import fr.istic.taa.jaxrs.service.domain.Category;
import fr.istic.taa.jaxrs.service.domain.Post;
import fr.istic.taa.jaxrs.service.domain.Tag;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "post")
public class PostDTO {

    public PostDTO(Post post) {
        id = post.getId();
        title = post.getTitle();
        content = post.getContent();
        categoryDTO = post.getCategory()!=null?post.getCategory().toDTO():null;


    }
    @XmlElement(name = "id")
    long id;
    @XmlElement(name = "title")
    String title;
    @XmlElement(name = "content")
    String content;
    @XmlElement(name = "category")
    CategoryDTO categoryDTO;
    @XmlElement(name = "tags")
    List<TagDTO> tagDTO;
}
