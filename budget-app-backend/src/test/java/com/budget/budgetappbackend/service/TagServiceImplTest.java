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
    }

    @Test
    void getTagByName() {
    }

    @Test
    void getAllTags() {
    }

    @Test
    void deleteTag() {
    }

    @Test
    void createTag() {
        Tag createdTag = tagService.createTag(newTagName);
        assertNotNull(createdTag);
        assertEquals(createdTag.getName(), newTagName);
    }
}