package vladimir.savin.services;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vladimir.savin.utils.counters.UniqueWordsCounter;
import vladimir.savin.utils.downloaders.FileDownloader;
import vladimir.savin.utils.filesavers.FileSaver;
import java.util.Map;

/*The goal of this class is to print the results after processing arguments from
command line.*/
@Service
public class HtmlUniqueWordsHandler implements UniqueWordsHandler {

    private final FileDownloader downloader;
    private final FileSaver fileSaver;
    private final UniqueWordsCounter counter;

    @Autowired
    public HtmlUniqueWordsHandler(FileDownloader downloader,
                                  FileSaver fileSaver,
                                  UniqueWordsCounter counter) {
        this.downloader = downloader;
        this.fileSaver = fileSaver;
        this.counter = counter;
    }

    /*Method passes the arguments to utility classes and after utilities process them
     gets the Map with unique words and prints it to the console */
    /**
     *
     * @param getFrom
     * @param saveTo
     */
    @Override
    public void saveAndCount(String getFrom, String saveTo) {

        Document document = (Document) downloader.downloadFile(getFrom);

        fileSaver.saveFileToDisk(document, saveTo);

        Map<String, Integer> uniqueWords = counter.countUniqueWords(document);

        for(String key : uniqueWords.keySet()) {
            System.out.println(key + " - " + uniqueWords.get(key));
        }
    }
}