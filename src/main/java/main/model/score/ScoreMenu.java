package main.model.score;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreMenu {
    private List<Integer> listOfScores;

    public ScoreMenu() throws IOException {
        this.listOfScores = new ArrayList<>();
        File file = new File(System.getProperty("user.home"), "TraficRacerFiles/Scores.txt");
        file.getParentFile().mkdirs();

        if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(" ");
                for (String part : parts) {
                    this.listOfScores.add(Integer.parseInt(part.trim()));
                }
            }
        }
    }

    public List<Integer> getListOfScores() {
        return listOfScores;
    }

    public void setListOfScores(List<Integer> listOfScores) throws IOException {
        this.listOfScores = listOfScores;
        overwriteScoresFile();
    }

    private void overwriteScoresFile() throws IOException {
        File file = new File(System.getProperty("user.home"), "TraficRacerFiles/Scores.txt");
        file.getParentFile().mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (Integer i : this.listOfScores) {
                writer.write(i.toString());
                writer.write(" ");
            }
        }
    }
}


