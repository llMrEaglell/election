package main.entity.persons.electorat;

import lombok.NonNull;
import main.CandidateStorage;
import main.entity.persons.Person;
import main.entity.persons.Voter;

public class BoykoElectorat extends Person implements Voter {
    public BoykoElectorat(@NonNull String lastName, @NonNull String firstName) {
        super(lastName, firstName);
    }

    @Override
    public void electiion() {
        CandidateStorage.candidateList.stream()
                .filter(candidate -> candidate.getLastName().equals("Boyko"))
                .findFirst()
                .ifPresent(candidate -> paper.vote(candidate.getId()));
    }
}
