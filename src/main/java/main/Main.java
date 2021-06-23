package main;

import main.entity.persons.Voter;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        out.println("Enter count of humans in election section");
        int countHumans = scanner.nextInt();
        out.println("Enter duration of modeling");
        int durationOnMinutes = scanner.nextInt() * 60_000;
        Queue<Voter> voters = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < countHumans; i++) voters.add(ElectoratFactory.genereateVoter());
        long timeStart = System.currentTimeMillis();
        long div = System.currentTimeMillis() - timeStart;
        while (div <= durationOnMinutes) {
            div = System.currentTimeMillis() - timeStart;

        }
    }

}
