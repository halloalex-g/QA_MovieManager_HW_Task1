package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    @Test
    public void addFilmsAndFindAllTest() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film1");
        manager.addMovie("Film2");
        manager.addMovie("Film3");

        String[] actual = manager.findAll();
        String[] expected = {"Film1", "Film2", "Film3"};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void revertedResultTestLessLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film1");
        manager.addMovie("Film2");
        manager.addMovie("Film3");

        String[] actual = manager.findLast();
        String[] expected = {"Film3", "Film2", "Film1"};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void revertedResultTestEqualsLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Film1");
        manager.addMovie("Film2");
        manager.addMovie("Film3");

        String[] actual = manager.findLast();
        String[] expected = {"Film3", "Film2", "Film1"};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void revertedResultTestExceedsLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Film1");
        manager.addMovie("Film2");
        manager.addMovie("Film3");
        manager.addMovie("Film4");

        String[] actual = manager.findLast();
        String[] expected = {"Film4", "Film3", "Film2"};

        Assertions.assertArrayEquals(expected, actual);
    }
}
