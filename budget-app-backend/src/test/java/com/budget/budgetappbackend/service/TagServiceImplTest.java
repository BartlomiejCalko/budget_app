package com.budget.budgetappbackend.service;

import com.budget.budgetappbackend.model.Tag;
import com.budget.budgetappbackend.repository.TagRepository;
import com.budget.budgetappbackend.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TagServiceImplTest {

    @InjectMocks
    private TagServiceImpl tagService;
    @Mock
    private TagRepository tagRepository;

    private TestUtils testUtils;

    private List<Tag> allGeneratedTestTags;

    private String newTagName;

    @BeforeEach
    void setUp() throws Exception{
        testUtils = new TestUtils();
        allGeneratedTestTags = testUtils.generateTestTags(10, true);

        Tag generatedTag = allGeneratedTestTags.get(0);
        newTagName = generatedTag.getName();

        Mockito.when(tagRepository.save(Mockito.any(Tag.class))).thenReturn(generatedTag);
        Mockito.when(tagRepository.findAll()).thenReturn(allGeneratedTestTags);
        Mockito.when(tagRepository.findByName(newTagName)).thenReturn(java.util.Arrays.asList(generatedTag));
    }

    @Test
    void getTagByName() {
        Tag retreivedTagByName = tagService.getTagByName(newTagName).get();
        assertEquals(retreivedTagByName.getName(), newTagName);
    }

    @Test
    void getAllTags() {
        List<Tag> allTags = tagService.getAllTags().get();
        assertEquals(allTags.size(), allGeneratedTestTags.size());
    }

    @Test
    void deleteTag() {
        Tag tag = tagService.getAllTags().get().get(0);
        tagService.deleteTag(tag.getId());
        Optional<Tag> tagWhichShouldNotExist = tagRepository.findById(tag.getId());
        assertFalse(tagWhichShouldNotExist.isPresent());
    }

    @Test
    void createTag() {
        Tag createdTag = tagService.createTag(newTagName);
        assertNotNull(createdTag);
        assertEquals(createdTag.getName(), newTagName);
    }
}