package main;

import main.entity.ElectionPaper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class BalletBox {
    private static List<ElectionPaper> papers = new ArrayList<>();

    public static void add(ElectionPaper paper) {
        papers.add(paper);
    }

    public static void getStatistics() {
        long zelenskiy = papers.stream().filter(paper -> paper.getChooseCandidate() == 1).count();
        long timoshenko = papers.stream().filter(paper -> paper.getChooseCandidate() == 3).count();
        long poroshenko = papers.stream().filter(paper -> paper.getChooseCandidate() == 2).count();
        long boyko = papers.stream().filter(paper -> paper.getChooseCandidate() == 4).count();
        long failed = papers.stream().filter(paper -> paper.getChooseCandidate() == 0).count();
        String result = "Result of election:\nZelenskiy:" + zelenskiy +
                "\nTimoshenko:" + timoshenko +
                "\nPoroshenko:" + poroshenko +
                "\nBoyko:" + boyko +
                "\nFailed election paper:" + failed;
        System.out.println(result);
        try(FileOutputStream fileOutputStream = new FileOutputStream(new File("Result.txt"))){
            fileOutputStream.write(result.getBytes(StandardCharsets.UTF_8));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
