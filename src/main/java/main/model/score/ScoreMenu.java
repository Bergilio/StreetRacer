
package main.model.score;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreMenu {
    private List<Integer> listOfScores;

    public ScoreMenu() throws IOException {
        this.listOfScores = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("/home/pedro/LEIC/LDTS/project-t06g02/src/main/resources/Files/Scores.txt"));
        String line = reader.readLine();

        if (line != null) {
            String[] parts = line.split(" ");
            for (String part : parts) {
                this.listOfScores.add(Integer.parseInt(part.trim()));
            }
        }

        reader.close();
    }

    public List<Integer> getListOfScores() {
        return listOfScores;
    }

    public void setListOfScores(List<Integer> listOfScores) throws IOException {
        this.listOfScores = listOfScores;
        overwriteScoresFile();
    }

    private void overwriteScoresFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/pedro/LEIC/LDTS/project-t06g02/src/main/resources/Files/Scores.txt", false));

        for (Integer i : this.listOfScores) {
            writer.write(i.toString());
            writer.write(" ");
        }

        writer.close();
    }
}


