package vladimir.savin.services;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import vladimir.savin.utils.counters.UniqueWordsCounter;
import vladimir.savin.utils.downloaders.FileDownloader;
import vladimir.savin.utils.filesavers.FileSaver;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

class HtmlUniqueWordsHandlerTest {

    @Mock
    private Document document;

    @Mock
    private FileDownloader downloader;

    @Mock
    private FileSaver saver;

    @Mock
    private UniqueWordsCounter counter;

    private UniqueWordsHandler handler;

    @BeforeEach
    public void init(){
        initMocks(this);
        handler = new HtmlUniqueWordsHandler(downloader, saver, counter);
    }

    @Test
    public void saveAndCountCorrectTest(){

        String url = "https://www.simbirsoft.com/";
        String filePath = "/Users/vital/Downloads/htmls/";

        doReturn(document).when(downloader).downloadFile(url);

        handler.saveAndCount(url, filePath);

        verify(saver, times(1)).saveFileToDisk(document, filePath);

        verify(counter, times(1)).countUniqueWords(document);
    }

    @Test
    public void wrongUrlTest(){

        String url = "";
        String filePath = "/Users/vital/Downloads/htmls/";

        doReturn(null).when(downloader).downloadFile(url);

        handler.saveAndCount(url, filePath);

        verify(saver, times(0)).saveFileToDisk(document, filePath);

        verify(counter, times(0)).countUniqueWords(document);
    }
}