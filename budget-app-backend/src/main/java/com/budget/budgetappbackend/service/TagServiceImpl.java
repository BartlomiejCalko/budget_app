package com.budget.budgetappbackend.service;

import com.budget.budgetappbackend.model.Tag;
import com.budget.budgetappbackend.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Optional<Tag> getTagByName(String tagName) {
        Tag tagByName = null;
        List<Tag> foundByName = tagRepository.findByName(tagName);
        if (foundByName.size() > 0) {
            tagByName = foundByName.get(0);
        }
        return Optional.of(tagByName);
    }

    @Override
    public Optional<List<Tag>> getAllTags() {
        List<Tag> allTags = tagRepository.findAll();
        return Optional.of(allTags);
    }

    @Override
    public void deleteTag(Long tagId) {
        tagRepository.deleteById(tagId);
    }

    @Override
    public Tag createTag(String tagName) {
        List<Tag> foundByName = tagRepository.findByName(tagName);
        if (foundByName.isEmpty()!=true) {
            return foundByName.get(0);
        }else {
            return tagRepository.save(new Tag(tagName));
        }
    }
}
