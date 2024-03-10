import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] lets_start) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String csa=sc.nextLine();

        String dq= readFile(csa);
        System.out.println("File contents:"); 
        System.out.println(dq);

        System.out.println("Enter the new content or keep it empty to  unchange content:");
        String newContent = sc.nextLine();

        if (!newContent.isEmpty()) {
            writeToFile(csa, newContent);
            System.out.println("Content saved");
        } 
        else 
        {
            System.out.println("No changes found");
        }
        
        sc.close();
    }

    private static String readFile(String csa) {
        StringBuilder content= new StringBuilder();

        try (BufferedReader detector= new BufferedReader(new FileReader(csa))) {
            String line;
            while ((line = detector.readLine()) != null) {
                content.append(line).append("\n");
            }
        } 
        catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return content.toString();
    }

    private static void writeToFile(String csa, String content) {
        try (BufferedWriter honka=new BufferedWriter(new FileWriter(csa))) {
            honka.write(content);
        } 
        catch (IOException e) {
            System.err.println("Error found on writing to file: " + e.getMessage());
        }
    }
}
