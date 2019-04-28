import java.io.*;
import java.util.*;

public class Main {

    enum IO {
        COMMON_IO,
        FILE_IO
    }

    private static final IO FLAG = IO.FILE_IO;

    public static void main(String[] args) throws IOException {

        if (FLAG == IO.COMMON_IO) {
            useCommonIo();
        } else {
            useFileIo();
        }
    }

    private static void useCommonIo() throws IOException {
        // #1
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();

        // #2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input2 = br.readLine().split(" ");

        solve();

        // Output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("");
        bw.flush();
    }

    private static void useFileIo() {
        File inputFile = new File("asset/test_set.txt");
        File outputFile = new File("asset/result.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String input = br.readLine();

            String output = "test";
            solve();

            bw.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve() {
        // Implement solution
    }
}
