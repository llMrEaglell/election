package main.entity.persons.electorat;

import lombok.NonNull;
import main.CandidateStorage;
import main.entity.persons.Person;
import main.entity.persons.Voter;

public class PorosheknoElectorat extends Person implements Voter {

    public PorosheknoElectorat(@NonNull String lastName, @NonNull String firstName) {
        super(lastName, firstName);
    }

    @Override
    public void electiion() {
        CandidateStorage.candidateList.stream()
                .filter(candidate -> candidate.getLastName().equals("Poroshenko"))
                .findFirst()
                .ifPresent(candidate -> paper.vote(candidate.getId()));
    }
}
