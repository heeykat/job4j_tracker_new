package ru.job4j.ood.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class Cinema3DTest {
    @Test
    public void whenBuyThenGetTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Ticket ticket = cinema.buy(account, 1, 1, date);
        Assertions.assertThat(ticket).isEqualTo(new Ticket3D());
    }

    @Test
    public void whenAddSessionThenItExistsBetweenAllSessions() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(data -> true);
        Assertions.assertThat(sessions).contains(session);
    }

    @Test
    public void whenBuyOnInvalidRowThenGetException() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        Assertions.assertThatThrownBy(() -> cinema.buy(account, -1, 1, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenNoSessionsThenFindReturnsEmptyList() {
        Cinema cinema = new Cinema3D();
        List<Session> sessions = cinema.find(s -> true);
        Assertions.assertThat(sessions).isEmpty();
    }

    @Test
    public void whenBuyAlreadyTakenSeatThenGetException() {
        Account account1 = new AccountCinema();
        Account account2 = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();

        cinema.buy(account1, 1, 1, date);

        Assertions.assertThatThrownBy(() -> cinema.buy(account2, 1, 1, date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("seat is already taken");
    }

    @Test
    public void whenAddMultipleSessionsThenFindReturnsAll() {
        Cinema cinema = new Cinema3D();
        Session session1 = new Session3D();
        Session session2 = new Session3D();

        cinema.add(session1);
        cinema.add(session2);

        List<Session> sessions = cinema.find(s -> true);
        Assertions.assertThat(sessions).containsExactly(session1, session2);
    }
}
