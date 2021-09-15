package fr.istic.taa.jaxrs.service.domain;


import fr.istic.taa.jaxrs.service.dto.BoardDTO;
import fr.istic.taa.jaxrs.service.interfaces.DTOAble;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@XmlRootElement(name = "board")
public class Board implements Serializable, DTOAble<BoardDTO> {

    public Board(){
        posts = new LinkedList<>();
        categories = new LinkedList<>();
    }

    long id;

    List<Post> posts;

    List<Category> categories;

    String title;

    @Id
    @GeneratedValue
    @XmlElement(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToMany
    @XmlElement(name = "posts")
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany
    @XmlElement(name = "categories")
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public BoardDTO toDTO() {
        BoardDTO dto = new BoardDTO(this);

        return dto;
    }
}
