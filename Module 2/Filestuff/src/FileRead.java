import java.io.*;
// Read the file created by Main program
public class FileRead {
    public static void main(String[] args) throws Exception {
        try (BufferedReader input = new BufferedReader(new FileReader("NoahMcCarthy_datafile.dat"))) {
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: ");
        }
    }
}
