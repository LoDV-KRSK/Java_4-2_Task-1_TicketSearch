package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket one = new Ticket(1, 14000, "SVO", "KJA", 200);
    private Ticket two = new Ticket(2, 13000, "SVO", "KJA", 240);
    private Ticket three = new Ticket(3, 6000, "DME", "LPK", 100);
    private Ticket four = new Ticket(7, 5000, "LED", "SVO", 60);
    private Ticket five = new Ticket(5, 16000, "IKT", "VKO", 300);
    private Ticket six = new Ticket(6, 4000, "KJA", "IKT", 120);
    private Ticket seven = new Ticket(7, 5000, "LED", "SVO", 60);


    @Test
    void shouldFindFew() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);

        Ticket[] actual = manager.searchBy("SVO", "KJA");
        Ticket[] expected = {two, one};
        Arrays.sort(actual);
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindSeveralWithSamePrice() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);

        Ticket[] actual = manager.searchBy("LED", "SVO");
        Ticket[] expected = {four, seven};
        Arrays.sort(actual);
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindOne() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);

        Ticket[] actual = manager.searchBy("KJA", "IKT");
        Ticket[] expected = {six};
        Arrays.sort(actual);
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotFindAnything() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);

        Ticket[] actual = manager.searchBy("SVO", "LED");
        Ticket[] expected = {};
        Arrays.sort(actual);
        assertArrayEquals(actual, expected);
    }
}