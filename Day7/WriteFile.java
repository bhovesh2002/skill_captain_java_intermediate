package Day7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {

    public static void writeIntoFile(String filePath, String content) throws IOException {
        File file = new File(filePath);
        FileWriter writer;

        if(file.exists()){
            writer = new FileWriter(file, true);
            writer.write(" "+content);
        }else {
            file.createNewFile();
            writer = new FileWriter(file);
            writer.write(content);
        }

        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner Sc = new Scanner(System.in);

        System.out.println("Enter filepath along with its name: ");
        String filePath = Sc.nextLine();
        System.out.println("Enter the content you want to write: ");
        String content = Sc.nextLine();

        writeIntoFile(filePath, content);
        Sc.close();
    }
}
