package vladimir.savin.utils.counters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vladimir.savin.utils.separators.WordsSeparator;

import java.util.LinkedHashMap;
import java.util.Map;

/*The goal of this class is to count unique words in the file,
put the result in the Map and return it*/
@Component
public class HtmlUniqueWordsCounter implements UniqueWordsCounter {

    private final WordsSeparator separator;

    @Autowired
    public HtmlUniqueWordsCounter(WordsSeparator separator) {
        this.separator = separator;
    }

    /*Passes the document to utility class to get the array of all words,
    then puts each unique word in LinkedHashMap, counts how many times this word
    is present in the document and returns the Map*/
    /**
     *
     * @param document
     * @return
     */
    @Override
    public Map<String, Integer> countUniqueWords(Object document) {

        Map<String, Integer> uniqueWords = new LinkedHashMap<>();

        String[] words = separator.separateWordsInFile(document);

        for(String s : words) {
            if(!uniqueWords.containsKey(s)){
                uniqueWords.put(s, 1);
            } else {
                Integer count = uniqueWords.get(s);
                count++;
                uniqueWords.put(s, count);
            }
        }
        return uniqueWords;
    }
}
