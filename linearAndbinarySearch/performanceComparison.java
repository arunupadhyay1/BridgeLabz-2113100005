public class performanceComparison {
    public static void comparePerformance() {
        StringBuffer sb = new StringBuffer();
        StringBuilder sbd = new StringBuilder();
        long startTime, endTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sb.append("hello");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sbd.append("hello");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime));
    }

    public static void main(String[] args) {
        comparePerformance();
    }
}