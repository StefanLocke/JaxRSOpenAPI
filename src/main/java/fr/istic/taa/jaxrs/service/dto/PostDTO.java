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
    }

    long id;

    String title;

    String content;

    List<TagDTO> tagDTO;

    @XmlElement(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @XmlElement(name = "tags")
    public List<TagDTO> getTagDTO() {
        return tagDTO;
    }

    public void setTagDTO(List<TagDTO> tagDTO) {
        this.tagDTO = tagDTO;
    }



}
