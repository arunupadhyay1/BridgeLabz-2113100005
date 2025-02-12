public class TaskScheduler {
    public static void main(String[] args) {
        CircularLinkedList taskList = new CircularLinkedList();
        
        taskList.addAtEnd(1, "Task 1", 2, "2023-10-01");
        taskList.addAtEnd(2, "Task 2", 1, "2023-10-02");
        taskList.addAtBeginning(3, "Task 3", 3, "2023-10-03");
        
        System.out.println("All Tasks:");
        taskList.displayTasks();
        
        System.out.println("\nViewing current task:");
        taskList.viewCurrentTask();
        
        System.out.println("\nMoving to next task:");
        taskList.moveToNextTask();
        taskList.viewCurrentTask();
        
        System.out.println("\nSearching for tasks with priority 1:");
        taskList.searchByPriority(1);
        
        System.out.println("\nRemoving Task with ID 2:");
        taskList.removeByTaskId(2);
        
        System.out.println("\nAll Tasks after removal:");
        taskList.displayTasks();
        
        System.out.println("\nAdding Task at position 1:");
        taskList.addAtPosition(4, "Task 4", 2, "2023-10-04", 1);
        
        System.out.println("\nAll Tasks after adding at position 1:");
        taskList.displayTasks();
    }
}class Node {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Node next;

    public Node(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    public CircularLinkedList() {
        this.head = null;
    }

    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        Node newNode = new Node(taskId, taskName, priority, dueDate);
        if (position == 0) {
            addAtBeginning(taskId, taskName, priority, dueDate);
        } else {
            Node temp = head;
            for (int i = 0; i < position - 1; i++) {
                temp = temp.next;
                if (temp == head) break;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void removeByTaskId(int taskId) {
        if (head == null) return;
        Node temp = head;
        Node prev = null;
        do {
            if (temp.taskId == taskId) {
                if (prev == null) {
                    Node last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    if (last == head) {
                        head = null;
                    } else {
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void viewCurrentTask() {
        if (head != null) {
            System.out.println("Current Task: ID: " + head.taskId + ", Name: " + head.taskName + ", Priority: " + head.priority + ", Due Date: " + head.dueDate);
        }
    }

    public void moveToNextTask() {
        if (head != null) {
            head = head.next;
        }
    }

    public void displayTasks() {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        Node temp = head;
        boolean found = false;
        if (head != null) {
            do {
                if (temp.priority == priority) {
                    System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate);
                    found = true;
                }
                temp = temp.next;
            } while (temp != head);
        }
        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }
}