package main;

import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
public class Person implements Viborets {
    @NonNull
    protected String lastName;
    @NonNull
    protected String firstName;
    protected boolean vote;
    protected int electionCandidateId;

    @Override
    public void electiion(Candidate candidate) {
        if (!isVote()) {
            vote = true;
            electionCandidateId = candidate.id;
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
