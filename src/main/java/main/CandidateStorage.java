package main;

import main.entity.persons.Candidate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class CandidateStorage {

    public static List<Candidate> candidateList = new CopyOnWriteArrayList<>();

    static {
        candidateList.addAll(Arrays.asList(new Candidate("Zelenskiy", "Volodymir", "Sluga Naroda"),
                new Candidate("Poroshenko", "Petro", "Self-nomination"),
                new Candidate("Timoshenko", "Julia", "All-Ukrainian Association 'Batkivshchyna'"),
                new Candidate("Boyko", "Yurii", "Self-nomination")));
    }

    private CandidateStorage() {
    }

}
