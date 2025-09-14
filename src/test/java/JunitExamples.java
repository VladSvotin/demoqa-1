import org.junit.jupiter.api.*;

public class JunitExamples {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Hsadas");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Hsadsassaas");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Hsadsassaas");
    }

    @AfterEach
    void afterEach(){
        System.out.println("Hsadsassaas");
    }

    @Test
    void firstTest(){
        System.out.println("Hey");
    }

    @Test
    void secTest(){
        System.out.println("Hqy");
    }
}
