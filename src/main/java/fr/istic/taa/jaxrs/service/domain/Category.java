package fr.istic.taa.jaxrs.service.domain;

import fr.istic.taa.jaxrs.service.dto.CategoryDTO;
import fr.istic.taa.jaxrs.service.interfaces.DTOAble;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@XmlRootElement(name = "category")
public class Category implements Serializable, DTOAble<CategoryDTO> {

    public Category(){
        posts = new LinkedList<>();
    }

    long id;

    String name;

    List<Post> posts;

    Board board;

    @Id
    @GeneratedValue
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
   @OneToMany
   @XmlElement(name = "posts")
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @OneToOne
    public Board getBoard() {
        return board;
    }
    @XmlElement(name = "boards")
    public void setBoard(Board board) {
        this.board = board;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    @Override
    public CategoryDTO toDTO() {
        return new CategoryDTO(this);
    }
}
