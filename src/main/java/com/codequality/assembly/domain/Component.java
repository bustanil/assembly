package com.codequality.assembly.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ComponentType type;
    private String shortName;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = Attribute.class)
    List<Attribute> attributes = new ArrayList<Attribute>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public ComponentType getType() {
        return type;
    }

    public void setType(ComponentType type) {
        this.type = type;
    }
}
