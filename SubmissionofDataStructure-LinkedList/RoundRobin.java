public class RoundRobin {
    public static void main(String[] args) {
        CircularLinkedList processQueue = new CircularLinkedList();
        processQueue.addProcess(1, 10, 1);
        processQueue.addProcess(2, 5, 2);
        processQueue.addProcess(3, 8, 3);
        processQueue.addProcess(4, 6, 4);

        System.out.println("Initial Process List:");
        processQueue.displayProcesses();

        int timeQuantum = 3;
        processQueue.roundRobinScheduling(timeQuantum);
        
        System.out.println("\nProcesses after scheduling:");
        processQueue.displayProcesses();
    }
}
class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class CircularLinkedList {
    private Process head;
    private Process tail;

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void removeProcess(int processId) {
        if (head == null) return;
        Process current = head;
        Process previous = tail;
        do {
            if (current.processId == processId) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
    }

    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) return;
        Process current = head;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int processCount = 0;

        do {
            if (current.burstTime > 0) {
                if (current.burstTime > timeQuantum) {
                    current.burstTime -= timeQuantum;
                    totalWaitingTime += processCount * timeQuantum;
                    processCount++;
                } else {
                    totalTurnAroundTime += (totalWaitingTime + current.burstTime);
                    totalWaitingTime += (processCount * timeQuantum);
                    processCount++;
                    current.burstTime = 0;
                    removeProcess(current.processId);
                }
            }
            current = current.next;
        } while (current != head);

        System.out.println("Average Waiting Time: " + (totalWaitingTime / processCount));
        System.out.println("Average Turn-Around Time: " + (totalTurnAroundTime / processCount));
    }

    public void displayProcesses() {
        if (head == null) return;
        Process current = head;
        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }
}