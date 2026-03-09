package ch.wiss.m450.starter_project.controller;

import ch.wiss.m450.starter_project.model.Item;
import ch.wiss.m450.starter_project.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemControllerMockTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    @Spy
    private List<Item> spyItems = new ArrayList<>();

    @Captor
    private ArgumentCaptor<String> itemNameCaptor;

    @BeforeEach
    void setUp() {
        spyItems.clear();
        spyItems.add(new Item("Keyboard"));
        spyItems.add(new Item("Mouse"));
    }

    @Test
    void getItemsReturnsRepositoryContentAndUsesSpyList() {
        when(itemService.getAllItems()).thenReturn(spyItems);

        Iterable<Item> result = itemController.getItems();

        verify(itemService, times(1)).getAllItems();
        assertEquals(2, spyItems.size());
        assertEquals(spyItems, result);
    }

    @Test
    void addItemCapturesDelegatedNameWithExpectedValue() {
        itemController.addItem("Monitor");

        verify(itemService, times(1)).addItem(itemNameCaptor.capture());
        assertEquals("Monitor", itemNameCaptor.getValue());
    }

    @Test
    void deleteItemDelegatesToRepositoryById() {
        itemController.deleteItem(7);

        verify(itemService, times(1)).deleteItem(7);
    }
}
