import java.util.*;

class VotingSystem {
    public static void main(String[] args) {
        Map<String, Integer> votes = new HashMap<>();
        votes.put("Candidate A", 5);
        votes.put("Candidate B", 3);
        votes.put("Candidate C", 8);
        displayResults(votes);
    }

    public static void displayResults(Map<String, Integer> votes) {
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(votes);
        System.out.println("Voting Results:");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}