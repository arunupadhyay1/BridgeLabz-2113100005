import java.util.Stack;
public class SortStackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        
        SortStack sorter = new SortStack();
        sorter.sort(stack);
        
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
class SortStack {
    public Stack<Integer> sort(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        int temp = stack.pop();
        sort(stack);
        insertSorted(stack, temp);
        return stack;
    }

    private void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        insertSorted(stack, element);
        stack.push(temp);
    }
}

