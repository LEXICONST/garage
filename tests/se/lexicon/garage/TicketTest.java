package se.lexicon.garage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void toStringTest() {
        Ticket testTicket = new Ticket(new Car("Mazda"), 1);
        System.out.println(testTicket.toString());
    }
}