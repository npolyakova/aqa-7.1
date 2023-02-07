import java.io.File;
import java.io.IOException;

public class FileExample {

    public static void main(String[] args) throws IOException {
        File newDir = new File("/Users/nataliya/Documents/untitled");
        File newFile = new File("/Users/nataliya/Documents/untitled", "untitled.iml");

        System.out.println(newFile.exists());
        System.out.println(newFile.canExecute());
        System.out.println(newDir.isDirectory());
        System.out.println(newFile.getParentFile().getParentFile());

        File fileToCreate = new File("/Users/nataliya/Documents/untitled/example");
        System.out.println(fileToCreate.createNewFile());

        System.out.println(fileToCreate.renameTo(new File("/Users/nataliya/Documents/untitled/ex")));

        System.out.println(fileToCreate.delete());
    }
}
