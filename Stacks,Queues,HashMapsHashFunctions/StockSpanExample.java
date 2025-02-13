import java.util.Stack;
public class StockSpanExample {
    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        System.out.println(spanner.next(100)); // 1
        System.out.println(spanner.next(80));  // 1
        System.out.println(spanner.next(60));  // 1
        System.out.println(spanner.next(70));  // 2
        System.out.println(spanner.next(60));  // 1
        System.out.println(spanner.next(75));  // 4
        System.out.println(spanner.next(85));  // 6
    }
}

class StockSpanner {
    private Stack<int[]> stack;
    private int index;

    public StockSpanner() {
        stack = new Stack<>();
        index = 0;
    }

    public int next(int price) {
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }
        int span = stack.isEmpty() ? index + 1 : index - stack.peek()[1];
        stack.push(new int[]{price, index});
        index++;
        return span;
    }
}

