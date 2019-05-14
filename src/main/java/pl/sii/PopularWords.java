package pl.sii;

import java.io.*;
import java.util.*;


public class PopularWords {

    public static void main(String[] args) {
        PopularWords popularWords = new PopularWords();
        Map<String, Long> result = popularWords.findOneThousandMostPopularWords();
        result.entrySet().forEach(System.out::println);
    }

    public Map<String, Long> findOneThousandMostPopularWords(){
        Map<String, Long> wordFrequency = convertFileToFrequencyMap();
        wordFrequency = sortMapDescendingByValueAndLimitToThousand(wordFrequency);

        return wordFrequency;
    }

    private Map<String, Long> convertFileToFrequencyMap(){
        File input = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("3esl.txt")).getFile());
        Map<String, Long> wordFrequency = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] wordsInLine = line.split(" ");

                for (String word : wordsInLine) {
                    if(!wordFrequency.containsKey(word)){
                        Long value = 1L;
                        wordFrequency.put(word, value);
                    }else{
                        Long value = wordFrequency.get(word) + 1;
                        wordFrequency.put(word, value);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordFrequency;
    }

    private Map<String,Long> sortMapDescendingByValueAndLimitToThousand(Map<String,Long> map){
        List<Map.Entry<String, Long> > list =
                new LinkedList<>(map.entrySet());

        Collections.sort(list, new Comparator<>() {
            public int compare(Map.Entry<String, Long> o1,
                               Map.Entry<String, Long> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        int i = 0;
        HashMap<String, Long> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Long> aa : list) {
            if( i == 1000){
                break;
            }
            temp.put(aa.getKey(), aa.getValue());
            i++;
        }


        return temp;
    }

}
