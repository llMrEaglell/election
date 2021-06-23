package main;

import main.entity.persons.Person;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class VotingRoom {
    private ExecutorService service = Executors.newCachedThreadPool();
    private static List<VotingBooth> list = new CopyOnWriteArrayList<>();

    static {
        list.add(new VotingBooth());
        list.add(new VotingBooth());
        list.add(new VotingBooth());
        list.add(new VotingBooth());
    }

    public static void stayToQueueVotingBooth(Person person){
        list.stream().min(VotingBooth::compareTo).orElseThrow(NoSuchElementException::new).add(person);
    }

    public void election(){
        Thread thread = new Thread(()->{
            list.forEach(votingBooth -> service.submit(()-> {
                try {
                    votingBooth.election();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
            service.shutdown();
        });
        thread.setDaemon(true);
        thread.start();
    }
    public void close(){
    }
}
