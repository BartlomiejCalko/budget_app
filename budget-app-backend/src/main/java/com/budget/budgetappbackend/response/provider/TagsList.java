package com.budget.budgetappbackend.response.provider;

import com.budget.budgetappbackend.model.Tag;

import java.util.List;

public class TagsList {

    private List<Tag> tags;

    public TagsList(List<Tag> tagsList) {
        super();
        this.tags = tagsList;
    }

    public TagsList() {
        super();
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTagsList(List<Tag> tagsList) {
        this.tags = tagsList;
    }
}
