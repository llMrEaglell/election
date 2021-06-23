package main;

import main.entity.persons.Person;
import main.entity.persons.Voter;
import main.entity.persons.electorat.BoykoElectorat;
import main.entity.persons.electorat.PorosheknoElectorat;
import main.entity.persons.electorat.TimoshenkoElectorat;
import main.entity.persons.electorat.ZelenskiyElectorat;

import java.util.Random;

public final class ElectoratFactory {

    static Voter genereateVoter() {
        var random = new Random();
        var electorat = "Electorat";
        switch (random.nextInt(4)) {
            case 1:
                return new ZelenskiyElectorat("The", electorat);
            case 2:
                return new PorosheknoElectorat("Poro", electorat);
            case 3:
                return new TimoshenkoElectorat("Timo", electorat);
            case 4:
                return new BoykoElectorat("Boyko", electorat);
            default:
                return new Person("ln", "fn");
        }

    }

}
