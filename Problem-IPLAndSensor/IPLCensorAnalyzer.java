import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IPLCensorAnalyzer {
    public static void main(String[] args) throws Exception {
        processJSON("ipl_data.json", "censored_ipl_data.json");
        processCSV("ipl_data.csv", "censored_ipl_data.csv");
    }

    private static void processJSON(String inputFile, String outputFile) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(inputFile)));
        JSONArray matches = new JSONArray(content);
        for (int i = 0; i < matches.length(); i++) {
            JSONObject match = matches.getJSONObject(i);
            match.put("team1", censorTeamName(match.getString("team1")));
            match.put("team2", censorTeamName(match.getString("team2")));
            match.put("player_of_match", "REDACTED");
            JSONObject score = match.getJSONObject("score");
            JSONObject newScore = new JSONObject();
            for (String key : score.keySet()) {
                newScore.put(censorTeamName(key), score.getInt(key));
            }
            match.put("score", newScore);
            match.put("winner", censorTeamName(match.getString("winner")));
        }
        Files.write(Paths.get(outputFile), matches.toString(4).getBytes());
    }

    private static void processCSV(String inputFile, String outputFile) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get(inputFile));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(lines.get(0) + "\n");
            for (int i = 1; i < lines.size(); i++) {
                String[] values = lines.get(i).split(",");
                values[1] = censorTeamName(values[1]);
                values[2] = censorTeamName(values[2]);
                values[5] = censorTeamName(values[5]);
                values[6] = "REDACTED";
                writer.write(String.join(",", values) + "\n");
            }
        }
    }

    private static String censorTeamName(String team) {
        String[] words = team.split(" ");
        return words[0] + " ***";
    }
}
