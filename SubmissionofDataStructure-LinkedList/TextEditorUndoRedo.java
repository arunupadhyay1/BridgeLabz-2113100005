public class TextEditorUndoRedo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);
        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.addState("Hello, World! How are you?");

        System.out.println("Current State: " + editor.getCurrentState());

        editor.undo();
        System.out.println("After Undo: " + editor.getCurrentState());

        editor.undo();
        System.out.println("After Undo: " + editor.getCurrentState());

        editor.redo();
        System.out.println("After Redo: " + editor.getCurrentState());

        editor.addState("Hello, World! How are you doing?");
        System.out.println("Current State: " + editor.getCurrentState());

        editor.addState("Hello, World! How are you doing? Let's add more text.");
        System.out.println("Current State: " + editor.getCurrentState());
    }
}
class TextState {
    String content;
    TextState next;
    TextState prev;

    public TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private TextState head;
    private TextState tail;
    private TextState current;
    private int maxSize;
    private int size;

    public TextEditor(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.current = null;
    }

    public void addState(String content) {
        TextState newState = new TextState(content);
        if (size == maxSize) {
            removeOldestState();
        }
        if (head == null) {
            head = newState;
            tail = newState;
            current = newState;
        } else {
            newState.prev = current;
            current.next = newState;
            current = newState;
            tail = newState;
        }
        size++;
    }

    private void removeOldestState() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public String getCurrentState() {
        return current != null ? current.content : "No content";
    }
}
