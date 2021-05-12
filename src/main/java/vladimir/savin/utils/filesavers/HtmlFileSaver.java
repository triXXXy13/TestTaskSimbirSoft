package vladimir.savin.utils.filesavers;

import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*Saves Document to the hard disk*/
@Component
public class HtmlFileSaver implements FileSaver {

    /*Saves the HTML file to the folder of application if no filepath is specified
    by client. Throws IOException and exits program if specified path is invalid
    or it cant save the file.*/
    /**
     *
     * @param file
     * @param saveTo
     */
    @Override
    public void saveFileToDisk(Object file, String saveTo) {

        Document document = (Document) file;

        String filename = saveTo + document.title() + ".html";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(document.outerHtml());
        } catch (IOException e) {
            System.out.println("Check the correctness of path to file");
            System.exit(1);
        }
    }
}
