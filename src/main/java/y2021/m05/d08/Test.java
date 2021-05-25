package y2021.m05.d08;

import java.io.*;

/**
 * TODO
 *
 * @author Julian
 * @className Test
 * @date 2021/5/25
 */
public class Test {
    public Test(int i) {

    }

    public static void main(String[] args) throws IOException {
//        new Test(5);


        File input = new File("D:\\a.txt");
        File output = new File("d:\\b.txt");

        FileReader in = new FileReader(input);
        FileWriter out = new FileWriter(output);

        int c;

        while ((c = in.read())!=-1) {
            out.write(c);
        }
        in.close();
        out.close();

    }
}
