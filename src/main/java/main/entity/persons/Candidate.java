package main.entity.persons;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Candidate extends Person implements Voter {
    private static final AtomicInteger atomicInteger = new AtomicInteger(1);
    private int id;
    private int position;
    private String party;

    public Candidate(String lastName, String firstName, int position, String party) {
        super(lastName, firstName);
        this.position = position;
        this.party = party;
        id = atomicInteger.getAndIncrement();
    }

    public Candidate(@NonNull String lastName, @NonNull String firstName, String party) {
        super(lastName, firstName);
        this.party = party;
    }

    @Override
    public void electiion() {
        paper.vote(id);
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
