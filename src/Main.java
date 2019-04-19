import java.io.*;
import java.util.*;

public class Main {

    enum IO {
        COMMON_IO,
        FILE_IO
    }

    private static final IO FLAG = IO.FILE_IO;

    public static void main(String[] args) {

        if (FLAG == IO.COMMON_IO) {
            useCommonIo();
        } else {
            useFileIo();
        }
    }

    private static void useCommonIo() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // Use input
    }

    private static void useFileIo() {
        File inputFile = new File("asset/test_set.txt");
        File outputFile = new File("asset/result.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String input = br.readLine();

            // Use input and write file

            String output = "test";
            bw.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
