package tests;

import org.junit.jupiter.api.*;

public class Junit_example_test {

    @BeforeAll
    static void initDB() {
        System.out.println("### BeforeAll");
    }

    @BeforeEach
    void openPage() {
        // Selenide.open("https://google.com");
        System.out.println("BeforeEach");
    }

    @AfterEach
    void closePage() {
        // Selenide.closeWebDriver();
        System.out.println("AfterEach");
    }

    @AfterAll
    static void cleanDB() {
        System.out.println("AfterAll");
    }

    @Test
    void assertTest() {
        Assertions.assertTrue(2<3);
        System.out.println("done");
    }
    @Test
    void assertTest1() {
        Assertions.assertTrue(2<3);
        System.out.println("###                                    Test 0");
    }

    @Test
    void assertTest2() {
        Assertions.assertTrue(2<3);
        System.out.println("###                                    Test 1");
    }

    @Test
    void assertTest3() {
        Assertions.assertTrue(2<3);
        System.out.println("###                                    Test 2");
    }

    @Test
    void assertTest4() {
        Assertions.assertTrue(2<3);
        System.out.println("###                                    Test 3");
    }

}
