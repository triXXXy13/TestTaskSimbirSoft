package vladimir.savin.utils.converters;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/*Converts HTML document into List of text lines */
@Component
public class ElementsToListConverter {

    /* Gets list of HTML elements from document by lines, gets the text of each line
     and adds it into ArrayList*/
    /**
     *
     * @param document
     * @return
     */
    public List<String> convert(Document document) {

        List<String> lines = new ArrayList<>();

        Elements elements = document.body().select("*");

        for (Element element : elements) {
            String line = element.ownText();

            if (!line.isEmpty()) {
                lines.add(line);
            }
        }
        return lines;
    }
}