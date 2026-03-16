package ch.wiss.m450.starter_project.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ch.wiss.m450.starter_project.model.Item;
import ch.wiss.m450.starter_project.service.ItemService;

@ExtendWith(MockitoExtension.class)
class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    private Item item1;
    private Item item2;

    @BeforeEach
    void setUp() {
        item1 = new Item("Test Item 1");
        item1.setId(1);
        item2 = new Item("Test Item 2");
        item2.setId(2);
    }

    @Test
    void testGetItems() {
        // Arrange
        List<Item> items = Arrays.asList(item1, item2);
        when(itemService.getAllItems()).thenReturn(items);

        // Act
        Iterable<Item> result = itemController.getItems();

        // Assert
        assertEquals(items, result);
        verify(itemService, times(1)).getAllItems();
    }

    @Test
    void testAddItem() {
        // Arrange
        String itemName = "New Item";

        // Act
        itemController.addItem(itemName);

        // Assert
        verify(itemService, times(1)).addItem(itemName);
    }

    @Test
    void testDeleteItem() {
        // Arrange
        int itemId = 1;

        // Act
        itemController.deleteItem(itemId);

        // Assert
        verify(itemService, times(1)).deleteItem(itemId);
    }
}