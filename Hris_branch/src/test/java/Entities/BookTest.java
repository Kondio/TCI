package Entities;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    static final String TEST_VALUE = "TEST";
    private Book testbook = new Book();
    static final Integer TEST_YEAR = 1996;

    @Test
    public void getGenre() {
        testbook.setGenre(TEST_VALUE);

        Assert.assertEquals("Expected " + TEST_VALUE + " ,but received "+ testbook.getGenre(), TEST_VALUE,testbook.getGenre());
    }

    @Test
    public void getFormat() {
        testbook.setFormat(TEST_VALUE);

        Assert.assertEquals("Expected " + TEST_VALUE + " ,but received "+ testbook.getFormat(), TEST_VALUE,testbook.getFormat());
    }

    @Test
    public void getName() {
        testbook.setName(TEST_VALUE);

        Assert.assertEquals("Expected " + TEST_VALUE + " ,but received "+ testbook.getName(), TEST_VALUE,testbook.getName());

    }

    @Test
    public void getYear() {
        testbook.setYear(TEST_YEAR);

        Assert.assertEquals("Expected " + TEST_YEAR + " ,but received "+ testbook.getYear(), TEST_YEAR,testbook.getYear());
    }
}