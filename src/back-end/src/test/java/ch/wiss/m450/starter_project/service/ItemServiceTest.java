package ch.wiss.m450.starter_project.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import ch.wiss.m450.starter_project.model.Item;
import ch.wiss.m450.starter_project.repository.ItemRepository;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @Spy
    @InjectMocks
    private ItemService itemService;

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
    void testGetAllItems() {
        // Arrange
        List<Item> items = Arrays.asList(item1, item2);
        when(itemRepository.findAll()).thenReturn(items);

        // Act
        List<Item> result = itemService.getAllItems();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Test Item 1", result.get(0).getName());
        verify(itemRepository, times(1)).findAll();
    }

    @Test
    void testAddItem() {
        // Arrange
        String itemName = "New Item";
        Item savedItem = new Item(itemName);
        savedItem.setId(3);
        when(itemRepository.save(any(Item.class))).thenReturn(savedItem);

        // Act
        Item result = itemService.addItem(itemName);

        // Assert
        assertEquals("New Item", result.getName());
        verify(itemRepository, times(1)).save(any(Item.class));
    }

    @Test
    void testDeleteItem() {
        // Arrange
        int itemId = 1;

        // Act
        itemService.deleteItem(itemId);

        // Assert
        verify(itemRepository, times(1)).deleteById(itemId);
    }

    @Test
    void testItemExists() {
        // Arrange
        int itemId = 1;
        when(itemRepository.existsById(itemId)).thenReturn(true);

        // Act
        boolean exists = itemService.itemExists(itemId);

        // Assert
        assertTrue(exists);
        verify(itemRepository, times(1)).existsById(itemId);
    }

    @Test
    void testSpyFunctionality() {
        // Spy allows real method calls, but we can verify them
        // Since itemService is a spy, we can call real methods

        // This test demonstrates spy usage - real method is called
        // but we can still verify interactions
        doReturn(true).when(itemRepository).existsById(1);

        boolean result = itemService.itemExists(1);

        assertTrue(result);
        verify(itemService, times(1)).itemExists(1); // Verifies spy method call
    }
}