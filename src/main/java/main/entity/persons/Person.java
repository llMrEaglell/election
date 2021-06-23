package main.entity.persons;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import main.CandidateStorage;
import main.entity.ElectionPaper;

import java.util.Random;

@RequiredArgsConstructor
@Getter
@Setter
public class Person implements Voter {
    @NonNull
    protected String lastName;
    @NonNull
    protected String firstName;
    protected boolean vote = false;
    protected ElectionPaper paper;

    @Override
    public void electiion() {
        if (!isVote()) {
            var candidateId = new Random().ints(1, 4).findFirst().getAsInt();
            vote = true;
            paper.vote(CandidateStorage.candidateList.get(candidateId-1).getId());
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", vote=" + vote +
                '}';
    }
}
