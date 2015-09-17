package singletonpattern;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Madalin.Colezea on 9/17/2015.
 */
public enum  EnumSingletonPattern {
    INSTANCE;

    private Set<String> seats;

    private EnumSingletonPattern(){
        seats = new HashSet<>();
        seats.add("1A");
        seats.add("1B");
    }

    public boolean bookSeat(String seat){
        return seats.remove(seat);
    }

    public static void main(String[] args) {
        ticketBook("1A");
        ticketBook("1A");
    }

    private static void ticketBook(String seat){
        EnumSingletonPattern sp = EnumSingletonPattern.INSTANCE;
        System.out.println(sp.bookSeat(seat));
    }
}
