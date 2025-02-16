public class searchWord {
    public static String searchForWord(String[] sentences, String targetWord) {
        for (String sentence : sentences) {
            if (sentence.contains(targetWord)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {"Hello world", "Java programming", "Linear search example"};
        System.out.println(searchForWord(sentences, "search"));
    }
}