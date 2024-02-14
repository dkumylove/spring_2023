package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void testAssertEquals() {
        String expected = "Hello";
        String actual = "Hello";
        assertEquals(expected, actual);
    }

    @Test
    void testAssertNotEquals() {
        String expected = "Hello";
        String actual = "World";
        assertNotEquals(expected, actual);
    }

    @Test
    void testAssertSame() {
        Object obj1 = new Object();
        Object obj2 = obj1;
        assertSame(obj1, obj2);
    }

    @Test
    void testAssertNotSame() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertNotSame(obj1, obj2);
    }

    @Test
    void testAssertTrue() {
        assertTrue(5 > 2);
    }

    @Test
    void testAssertFalse() {
        assertFalse(2 > 5);
    }

    @Test
    void testAssertNull() {
        Object obj = null;
        assertNull(obj);
    }

    @Test
    void testAssertNotNull() {
        Object obj = new Object();
        assertNotNull(obj);
    }

    @Test
    void testAssertThrows() {
        assertThrows(ArithmeticException.class, () -> divideByZero());
    }

    @Test
    void testAssertDoesNotThrow() {
        assertDoesNotThrow(() -> divide(10, 2));
    }

    private int divide(int a, int b) {
        return a / b;
    }

    private void divideByZero() {
        int result = 10 / 0;
    }
}
