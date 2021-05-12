package vladimir.savin.utils.separators;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import vladimir.savin.utils.converters.ElementsToListConverter;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

class HtmlWordsSeparatorTest {

    @Mock
    private ElementsToListConverter converter;

    @Mock
    private Document document;

    private WordsSeparator separator;

    @BeforeEach
    public void init(){
        initMocks(this);
        separator = new HtmlWordsSeparator(converter);
    }

    @Test
    public void separateWordsTest(){

        List<String> lines = new ArrayList<>();
        lines.add("Hello; : ?One! Two? Three (Four)");
        lines.add("[Five], {six}, \"seven\" ");

        String[] expected = {"HELLO", "ONE", "TWO", "THREE",
                              "FOUR", "FIVE", "SIX", "SEVEN"};

        doReturn(lines).when(converter).convert(document);

        String[] actual = separator.separateWordsInFile(document);

        assertArrayEquals(expected, actual);
    }
}