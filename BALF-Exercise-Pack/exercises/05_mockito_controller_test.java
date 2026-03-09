import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemControllerMockitoExercise {

    @Test
    void shouldCallServiceAndReturnItems() {
        // Given:
        // - create a mock ItemService
        // - create ItemController with that mock
        // - configure mock behavior with when(...).thenReturn(...)

        // When:
        // - call controller.getItems()

        // Then:
        // - assert expected result
        // - verify service.getAllItems() was called exactly once

        fail("Implement me");
    }
}

/*
TASKS:
1) Use @Mock and @InjectMocks OR manual construction.
2) Add a second test for addItem(name) with verify(...).
3) Bonus: Add one test with @Spy and explain in one sentence why spy differs from mock.
*/
