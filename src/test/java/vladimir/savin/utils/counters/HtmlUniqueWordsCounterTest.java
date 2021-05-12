package vladimir.savin.utils.counters;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import vladimir.savin.utils.separators.WordsSeparator;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

class HtmlUniqueWordsCounterTest {

    @Mock
    private WordsSeparator separator;

    @Mock
    private Document document;

    private UniqueWordsCounter counter;

    @BeforeEach
    public void init(){
        initMocks(this);
        counter = new HtmlUniqueWordsCounter(separator);
    }

    @Test
    public void countUniqueWordsTest(){

        String[] words = {"One", "Two", "Three", "One", "One", "Two"};

        doReturn(words).when(separator).separateWordsInFile(document);

        Map<String, Integer> uniqueWords = counter.countUniqueWords(document);

        assertEquals(3, uniqueWords.size());
        assertEquals(2, uniqueWords.get("Two"));
        assertEquals(3, uniqueWords.get("One"));
    }
}