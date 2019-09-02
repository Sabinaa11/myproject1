package db;

import model.Worker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockDB {
    public static final List<Worker> workers = new ArrayList<>();

    static {
        workers.add(new Worker("Jack", LocalDate.parse("1999-01-01"), 'm', "123456789", "Manager", "Depart1", "John", LocalDate.parse("2019-01-01"), 1600));
        workers.add(new Worker("John", LocalDate.parse("2000-06-01"), 'm', "123456789", "Developer", "Depart2", "Jack", LocalDate.parse("2011-01-01"), 3600));
        workers.add(new Worker("Alice", LocalDate.parse("2000-02-02"), 'f', "123456789", "Manager", "Depart1", "Jack", LocalDate.parse("2013-01-08"), 6600));
        workers.add(new Worker("Elizabeth", LocalDate.parse("1998-11-01"), 'f', "123456789", "Developer", "Depart2", "Jack", LocalDate.parse("2013-01-01"), 4600));
        workers.add(new Worker("Jackson", LocalDate.parse("2000-12-21"), 'm', "123456789", "Manager", "Depart1", "Jack", LocalDate.parse("2013-01-05"), 5600));
    }
}
