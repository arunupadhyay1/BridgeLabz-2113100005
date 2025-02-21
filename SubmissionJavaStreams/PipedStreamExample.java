import java.io.*;

public class PipedStreamExample {
    public static void main(String[] args) {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();
        try {
            pos.connect(pis);
            new WriterThread(pos).start();
            new ReaderThread(pis).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WriterThread extends Thread {
    private PipedOutputStream pos;
    
    WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }
    
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                pos.write(("Message " + i + "\n").getBytes());
                Thread.sleep(1000);
            }
            pos.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;
    
    ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }
    
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(pis))) {
            String message;
            while ((message = br.readLine()) != null) {
                System.out.println("Received: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

