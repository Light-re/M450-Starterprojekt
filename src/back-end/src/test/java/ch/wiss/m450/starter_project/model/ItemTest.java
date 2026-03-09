package ch.wiss.m450.starter_project.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void whenDefaultConstructorCalled_thenInitializeEmpty() {
        // Arrange & Act
        Item item = new Item();
        
        // Assert
        assertNull(item.getId(), "Erwartung: ID ist null vor dem Speichern in der DB");
        assertNull(item.getName(), "Erwartung: Name ist bei Verwendung des Standardkonstruktors null");
    }

    @Test
    void whenParameterizedConstructorCalled_thenNameIsSet() {
        // Arrange
        String expectedName = "Test Monitor";
        
        // Act
        Item item = new Item(expectedName);
        
        // Assert
        assertEquals(expectedName, item.getName(), "Erwartung: Name entspricht 'Test Monitor'");
        assertNull(item.getId(), "Erwartung: ID ist immer noch null");
    }

    @Test
    void whenSettingIdTo99_thenGetIdReturns99() {
        // Arrange
        Item item = new Item();
        Integer expectedId = 99;
        
        // Act
        item.setId(expectedId);
        
        // Assert
        assertEquals(expectedId, item.getId(), "Erwartung: Die zurückgegebene ID ist exakt 99");
    }

    @Test
    void whenSettingNameToNotebook_thenGetNameReturnsNotebook() {
        // Arrange
        Item item = new Item();
        String expectedName = "Notebook";
        
        // Act
        item.setName(expectedName);
        
        // Assert
        assertEquals(expectedName, item.getName(), "Erwartung: Der gesetzte Name 'Notebook' wird zurückgegeben");
    }
}
