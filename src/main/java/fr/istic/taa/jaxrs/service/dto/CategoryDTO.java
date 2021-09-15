package fr.istic.taa.jaxrs.service.dto;

import fr.istic.taa.jaxrs.service.domain.Category;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
public class CategoryDTO {

    public CategoryDTO(Category category) {
        id = category.getId();
        name = category.getName();
    }
    @XmlElement(name = "id")
    long id;
    @XmlElement(name = "name")
    String name;
}
