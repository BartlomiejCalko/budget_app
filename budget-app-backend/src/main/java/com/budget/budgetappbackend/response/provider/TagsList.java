package com.budget.budgetappbackend.response.provider;

import com.budget.budgetappbackend.model.Tag;

import java.util.List;

public class TagsList {

    private List<Tag> tagsList;

    public TagsList(List<Tag> tagsList) {
        super();
        this.tagsList = tagsList;
    }

    public TagsList() {
        super();
    }

    public List<Tag> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<Tag> tagsList) {
        this.tagsList = tagsList;
    }
}
