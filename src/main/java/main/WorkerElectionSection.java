package main;


import main.entity.ElectionPaper;
import main.entity.persons.Person;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;

public class WorkerElectionSection {
    private Queue<Person> people = new ConcurrentLinkedDeque<>();

    public int takeElectionPaper() throws InterruptedException {
        while (true) {
            if (people.size() > 0) {
                Person peek = people.peek();
                peek.setPaper(new ElectionPaper());
                VotingRoom.stayToQueueVotingBooth(peek);
                Thread.sleep(new Random().nextInt(100_000));
            }
        }
    }

    public synchronized int sizeQueue() {
        return people.size();
    }

    public synchronized void add(Person person) {
        people.add(person);
    }

}
