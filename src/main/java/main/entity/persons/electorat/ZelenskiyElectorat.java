package main.entity.persons.electorat;

import lombok.NonNull;
import main.CandidateStorage;
import main.entity.persons.Person;
import main.entity.persons.Voter;

public class ZelenskiyElectorat extends Person implements Voter {

    public ZelenskiyElectorat(@NonNull String lastName, @NonNull String firstName) {
        super(lastName, firstName);
    }

    @Override
    public void electiion() {
        CandidateStorage.candidateList.stream()
                .filter(candidate -> candidate.getLastName().equals("Zelenskiy"))
                .findFirst()
                .ifPresent(candidate -> paper.vote(candidate.getId()));
    }
}
