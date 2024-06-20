package one.markeet.utils;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class IOUtil {

    public static void read(List<String> data, String fileName) {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {

            String line;

            while((line = br.readLine()) != null) {
                data.add(line);
            }

        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
