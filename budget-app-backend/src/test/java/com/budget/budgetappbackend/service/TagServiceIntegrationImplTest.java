package com.budget.budgetappbackend.service;

import com.budget.budgetappbackend.model.Tag;
import com.budget.budgetappbackend.repository.TagRepository;
import com.budget.budgetappbackend.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TagServiceIntegrationImplTest {

    @Autowired
    private TagService tagService;

    @Autowired
    private TagRepository tagRepository;

    private String tagName;

    private TestUtils testUtils;

    @BeforeEach
    void setUp() {
        testUtils = new TestUtils();
        tagName = testUtils.getRandomTextFromUUID();
        for (int i = 0; i < 10; i++) {
            tagService.createTag(testUtils.getRandomTextFromUUID());
        }
    }

    @Test
    void getTagByName() {
        String retreivedTagName = tagService.getAllTags().get().get(0).getName();
        Optional<Tag> retreivedTagByName = tagService.getTagByName(retreivedTagName);
        assertTrue(retreivedTagByName.isPresent());
        assertEquals(retreivedTagByName.get().getName(), retreivedTagName);
    }

    @Test
    void getAllTags() {
        assertTrue(tagService.getAllTags().get().size() > 0);
        assertTrue(tagService.getAllTags().get().size() >= 10);
    }

    @Test
    void deleteTag() {
        Long retreivedTagId = tagService.getAllTags().get().get(0).getId();
        tagService.deleteTag(retreivedTagId);
        Optional<Tag> foundById = tagRepository.findById(retreivedTagId);
        assertFalse(foundById.isPresent());
    }

    @Test
    void createTag() {
        Tag createdTag = tagService.createTag(tagName);
        assertEquals(createdTag.getName(), tagName);
    }
}