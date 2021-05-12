package vladimir.savin.utils.separators;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vladimir.savin.utils.converters.ElementsToListConverter;
import java.util.List;

/*Divides the HTML document into separate words and returns the array of this words*/
@Component
public class HtmlWordsSeparator implements WordsSeparator {

    private final String DELIMITERS_REGEX = "[ ]-[ ]|[\\s,.!?\";:\\[\\](){}]+";

    private final ElementsToListConverter converter;

    @Autowired
    public HtmlWordsSeparator(ElementsToListConverter converter) {
        this.converter = converter;
    }

    /*Passes the HTML document to the converter and then transforms the returned List
    into String and splits it to array of separate words by the regular expression
    to get rid of punctuation marks*/
    /**
     *
     * @param object
     * @return
     */
    @Override
    public String[] separateWordsInFile(Object object) {

        StringBuilder stringBuilder = new StringBuilder();

        Document document = (Document) object;

        List<String> lines = converter.convert(document);

        for(String line : lines){
            stringBuilder.append(line + "\n");
        }

        return stringBuilder.toString().toUpperCase().split(DELIMITERS_REGEX);
    }
}
