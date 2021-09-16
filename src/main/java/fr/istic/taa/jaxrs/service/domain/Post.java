package fr.istic.taa.jaxrs.service.domain;

import fr.istic.taa.jaxrs.service.dto.PostDTO;
import fr.istic.taa.jaxrs.service.interfaces.DTOAble;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@XmlRootElement(name = "post")
public class Post implements Serializable, DTOAble<PostDTO> {

    public Post() {
        tags = new LinkedList<>();
    }
    long id;

    String title;

    String content;

    Category category;

    List<Tag> tags;



    @Id
    @GeneratedValue
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

    @OneToOne
    @XmlElement(name = "category")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @XmlElement(name = "tags")
    @OneToMany
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public PostDTO toDTO() {
        return new PostDTO(this);
    }
}
