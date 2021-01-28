package de.itemis.jmo.mockito.issue2154;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class MockitoIssue2154JUnit4Test {

    private MockitoIssue2154Main mock = Mockito.mock(MockitoIssue2154Main.class);
    
    @Test
	public void test_pure_to_string_works() {
        try {
            mock.toString();
        } catch (Exception e) {
            fail("Mockito's toString seems to be broken: " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
	}
    
    @Test
    public void test_stubbed_to_string_works() {
        String expectedReturnValue = "name";
        when(mock.toString()).thenReturn(expectedReturnValue);
        
        assertEquals(expectedReturnValue, mock.toString());
    }
}
