public class StringConcatenation {
    public static void main(String[] args) {
        int N = 10000;
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) strings[i] = "String" + i;

        long startTime, endTime;

        // Using String
        startTime = System.nanoTime();
        String result = "";
        for (String s : strings) {
            result += s;
        }
        endTime = System.nanoTime();
        System.out.println("String Concatenation Time: " + (endTime - startTime) + " ns");

        // Using StringBuilder
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Concatenation Time: " + (endTime - startTime) + " ns");

        // Using StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (String s : strings) {
            sbf.append(s);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Concatenation Time: " + (endTime - startTime) + " ns");
    }
}