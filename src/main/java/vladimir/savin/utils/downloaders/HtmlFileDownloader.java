package vladimir.savin.utils.downloaders;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import java.io.IOException;

/*Downloads HTML-file and returns it*/
@Component
public class HtmlFileDownloader implements FileDownloader {

    /*Gets the HTML Document from URL passed by client and returns it for further
    processing. Throws IOException and exits program if specified URL is invalid or
    there are problems with connection*/
    /**
     *
     * @param from
     * @return
     */
    @Override
    public Object downloadFile(String from) {

        Document document = null;

        try {
            document = Jsoup.connect(from).get();
        }
        catch (IOException e) {
            System.out.println("Problems with connecting to URL, check the correctness of it");
            System.exit(1);
        }
        return document;
    }
}
