package pl.sii;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Map;

public class PopularWords {

    public static void main(String[] args) {
        PopularWords popularWords = new PopularWords();
        Map<String, Long> result = popularWords.findOneThousandMostPopularWords();
        result.entrySet().forEach(System.out::println);
    }

    public Map<String, Long> findOneThousandMostPopularWords() {
        throw new NotImplementedException("TODO implementation");
    }
}
