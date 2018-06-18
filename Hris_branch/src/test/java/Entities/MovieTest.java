package Entities;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTest {
    static final String TEST_VALUE = "TEST";
    private Movie testmovie = new Movie();
    static final Integer TEST_YEAR = 1996;

    @Test
    public void getGenre() {
        testmovie.setGenre(TEST_VALUE);

        Assert.assertEquals("Expected " + TEST_VALUE + " ,but received "+ testmovie.getGenre(), TEST_VALUE,testmovie.getGenre());
    }

    @Test
    public void getFormat() {
        testmovie.setFormat(TEST_VALUE);

        Assert.assertEquals("Expected " + TEST_VALUE + " ,but received "+ testmovie.getFormat(), TEST_VALUE,testmovie.getFormat());
    }

    @Test
    public void getName() {
        testmovie.setName(TEST_VALUE);

        Assert.assertEquals("Expected " + TEST_VALUE + " ,but received "+ testmovie.getName(), TEST_VALUE,testmovie.getName());
    }
    @Test
    public void getYear() {
        testmovie.setYear(TEST_YEAR);

        Assert.assertEquals("Expected " + TEST_YEAR + " ,but received "+ testmovie.getYear(), TEST_YEAR,testmovie.getYear());
    }

}