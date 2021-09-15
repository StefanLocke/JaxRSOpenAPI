package fr.istic.taa.jaxrs.service.dto;

import fr.istic.taa.jaxrs.service.domain.Tag;

public class TagDTO {

    public TagDTO(Tag tag){
        id = tag.getId();
        name = tag.getName();
    }
    long id;
    String name;
}
