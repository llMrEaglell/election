package main;


import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Candidate extends Person {
    private static final AtomicInteger atomicInteger = new AtomicInteger();
    public int id;
    private int position;
    private String party;

    public Candidate(String lastName, String firstName, int position, String party) {
        super(lastName, firstName);
        this.position = position;
        this.party = party;
        id = atomicInteger.getAndIncrement();
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "position=" + position +
                ", party='" + party + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", vote=" + vote +
                '}';
    }
}
