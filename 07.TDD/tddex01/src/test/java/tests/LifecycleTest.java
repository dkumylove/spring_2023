package tests;

import org.junit.jupiter.api.*;

public class LifecycleTest {

    @BeforeAll
    static void setupOnce() {
        System.out.println("@BeforeAll tests");
    }

    @BeforeEach
    void setup() {
        System.out.println("@BeforeEach test");
    }

    @Test
    void test1() {
        System.out.println("Test 1");
    }

    @Test
    void test2() {
        System.out.println("Test 2");
    }

    @AfterEach
    void teardown() {
        System.out.println("@AfterEach test");
    }

    @AfterAll
    static void teardownOnce() {
        System.out.println("@AfterAll tests");
    }

}
