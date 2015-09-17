package singletonpattern;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Madalin.Colezea on 9/17/2015.
 */
public class SingletonPattern {
    // eager
//    private static final singletonpattern.SingletonPattern INSTANCE = new singletonpattern.SingletonPattern();
    private static SingletonPattern INSTANCE;

    private Set<String> seats;

    private SingletonPattern(){
        seats = new HashSet<>();
        seats.add("1A");
        seats.add("1B");
    }

    public static synchronized SingletonPattern getInstance(){
        if (INSTANCE == null) INSTANCE = new SingletonPattern();
        return INSTANCE;
    }

    public boolean bookSeat(String seat){
        return seats.remove(seat);
    }

    public static void main(String[] args) {
        ticketBook("1A");
        ticketBook("1A");
    }

    private static void ticketBook(String seat){
        SingletonPattern sp = SingletonPattern.getInstance();
        System.out.println(sp.bookSeat(seat));
    }

}
