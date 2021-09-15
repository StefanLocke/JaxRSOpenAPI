package fr.istic.taa.jaxrs.service.domain;

import fr.istic.taa.jaxrs.service.dto.TagDTO;
import fr.istic.taa.jaxrs.service.interfaces.DTOAble;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Tag implements Serializable, DTOAble<TagDTO> {

    long id;

    String name;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public TagDTO toDTO() {
        return new TagDTO(this);
    }
}
