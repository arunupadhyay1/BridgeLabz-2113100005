import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
        int[] studentMarks = {85, 70, 90, 60, 75};
        bubbleSort(studentMarks);
        System.out.println(Arrays.toString(studentMarks));
    }
	
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (marks[i] > marks[i + 1]) {
                    int temp = marks[i];
                    marks[i] = marks[i + 1];
                    marks[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

}