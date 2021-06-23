package main.entity;

import lombok.Getter;
import main.BalletBox;
import main.CandidateStorage;
import main.entity.persons.Candidate;

import java.util.List;

import static java.lang.System.out;

@Getter
public class ElectionPaper {
    private int chooseCandidate = 0;

    private static final List<Candidate> candidates = CandidateStorage.candidateList;

    public boolean vote(int id) {
        if (candidates.stream().map(Candidate::getId).anyMatch(match -> match == id)) {
            chooseCandidate = id;
            BalletBox.add(this);
            return true;
        }
        out.println("Candidate not found, election paper has been failed");
        return false;
    }
}
