import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PathAndFilesExample {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("/Users/nataliya/Documents/untitled");
        System.out.println(path.getFileName());
        System.out.println(path.getParent());
        System.out.println(path.startsWith("/Users/nataliya/Documents/"));

        Path newFilePath = Path.of("/Users/nataliya/Documents/untitled/ex2");
        Path newDir = Path.of("/Users/nataliya/Documents/untitled/newDir");
        Path newSubDir = Path.of("/Users/nataliya/Documents/untitled/newDir/1");
        try {
            //create a new file
            Path exFile = Files.createFile(newFilePath);
            System.out.println(Files.exists(exFile));
            try {
                //create a new dir
                Files.createDirectory(newDir);
                System.out.println(Files.exists(newDir));
                try {
                    //move a file
                    Files.move(exFile, newSubDir);
                } catch (IOException e) {
                    System.out.println("Error while moving file");
                }
            } catch (FileAlreadyExistsException e) {
                System.out.println("Directory already exists");
            }
        }
        catch (FileAlreadyExistsException e) {
            System.out.println("File already exists");
        }

        //FileReader and FileWriter
        FileWriter fw = new FileWriter("/Users/nataliya/Documents/untitled/text.txt");
        fw.write("123");
        fw.close();

        FileReader fr = new FileReader("/Users/nataliya/Documents/untitled/text.txt");
        Scanner sc = new Scanner(fr);
        try {
            System.out.println(sc.nextLine());
        }
        catch (NoSuchElementException e) {
            System.out.println("Файл пуст");
        }
        fr.close();


        //Files
        try {
            Path pathForNewFile = Path.of("/Users/nataliya/Documents/untitled/text.txt");
            Files.newOutputStream(pathForNewFile);
        } catch (IOException e) {
            System.out.println("Проблема при записи в файл");
        }
    }
}
