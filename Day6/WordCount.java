package Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class WordCount {

    public static void findWordCount(String word, String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner input = new Scanner(file);
        int count = 0;

        while (input.hasNext()){
            if(Objects.equals(word.toLowerCase(), input.next().toLowerCase().replaceAll("[^\\sa-zA-Z0-9]", ""))){
                count +=1;
            }
        }
        System.out.println("Total occurrence of word " + word + ": " + count);
        input.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner Sc = new Scanner(System.in);
        
        System.out.println("Enter the file path");
        String path = Sc.nextLine();
        System.out.println("Enter word you want to find the count of: ");
        String word = Sc.nextLine();
        
        findWordCount(word, path);
    }

}
