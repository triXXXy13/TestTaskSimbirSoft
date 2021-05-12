package vladimir.savin.utils.counters;

import java.util.Map;

public interface UniqueWordsCounter {
    Map<String, Integer> countUniqueWords(Object document);
}
