import java.io.*;
public class StudentData {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("students.dat"))) {
            dos.writeInt(1);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);
            dos.writeInt(2);
            dos.writeUTF("Bob");
            dos.writeDouble(3.5);
        } catch (IOException e) {
            e.printStackTrace();
        }try (DataInputStream dis = new DataInputStream(new FileInputStream("students.dat"))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}