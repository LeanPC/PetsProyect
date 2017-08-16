package com.example.lean.pets.Models;

import java.util.List;

/**
 * Created by LEAN on 14/08/2017.
 */

public class Pet {

    private Category category;
    private String id;
    private String name;
    private List<String> photoUrls;
    private String status;
    private List<Tag> tags;

    public Category getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public String getStatus() {
        return status;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
