package Пр2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAuthor {

    private Author author;

    @Before
    public void setUp() {
        author = new Author("Katerina Polanskay", "Katerina12345@mail.ru", 'W');
    }

    @Test
    public void toStringMethodTest() {
        String expectedResult = "Katerina Polanskay (W) at Katerina12345@mail.ru";
        assertEquals(expectedResult, author.toString());
        System.out.println(author);
    }
}



