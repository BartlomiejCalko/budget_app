package com.budget.budgetappbackend.service;

import com.budget.budgetappbackend.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

    Optional<Tag> getTagByName(String name);

    Optional<List<Tag>> getAllTags();

    public void deleteTag(Long tagId);

    public Tag createTag(String tagName);

}
