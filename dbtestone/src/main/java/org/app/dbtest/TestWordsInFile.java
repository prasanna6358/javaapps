import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestWordsLines {

    public static void main(String[] args) throws Exception {

        InputStream targetStream = new FileInputStream(new File("/home/halcyon/prasanna/gajanan.txt"));
        String content = readStream(targetStream);
        System.out.println(content);
        String[] lines = content.split(System.getProperty("line.separator"));
        int totalLines = lines.length;
        System.out.println(totalLines);
        int totalwords = totalLines+content.split(" ").length-1;
        System.out.println("words "+totalwords);
        System.out.println("Total no of Characters " +content.length());

        String longString ="";
        for(String item:lines) {
            if (item != null) {
                if (item.length() > longString.length()) {
                    longString = item;
                }
            }
        }
        System.out.println(longString);
    }

    public static String readStream(InputStream stream) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
