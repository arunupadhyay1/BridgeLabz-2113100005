import java.io.*;
 
public class FileReadWrite{
	public static void main(String[] args){
		File sourceFile = new File("reader.txt");
		File destFile = new File("writer.txt");
		try(FileInputStream fis = new FileInputStream(sourceFile);
		    FileOutputStream fos = new FileOutputStream(destFile)){
				int data;
				while((data = fis.read()) != -1){
					fos.write(data);
				}
			}
			catch(FileNotFoundException e){
				System.out.println("Source file does not exist");
			}
			catch(IOException e){
				e.printStackTrace();
			}
	}
}