package main;

import main.entity.persons.Person;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;

public class VotingBooth implements Comparable<VotingBooth> {
    private Queue<Person> people = new ConcurrentLinkedDeque<>();
    private Random random = new Random();

    public void election() throws InterruptedException {
        while (true) {
            if (people.size() > 0) {
                people.peek().electiion();
                Thread.sleep(1_000);
            }
        }
    }

    public void add(Person person) {
        people.add(person);
    }

    public int size() {
        return people.size();
    }

    @Override
    public int compareTo(VotingBooth o) {
        return Integer.compare(size(), o.size());
    }
}
