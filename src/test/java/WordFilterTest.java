import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordFilterTest {
    @Test
    public void testFilterWords() {
        WordFilter wordFilter = new WordFilter();
        Dictionary dictionary = new Dictionary();
        Word word = new Word("a");
        Word word2 = new Word("A");
        assertEquals(1, wordFilter.filterWords(dictionary.getWords(), word).size());
        assertEquals(1, wordFilter.filterWords(dictionary.getWords(), word2).size());
    }

    @Test
    public void testGetAllWordsWithLetters(){
        WordFilter wordFilter = new WordFilter();
        Dictionary dictionary = new Dictionary();
        HashMap<Character, Set<Word>> words = dictionary.getWords();
        Word word = new Word("abc");

        ArrayList<Word> wordsWithLetters = wordFilter.getAllWordsWithLetters(words, word);
        Set<Word> setWithLetters = new HashSet<>();

        for(int i=0; i<word.getLength(); i++){
            if(words.get(word.getWord().charAt(i)) != null)
                setWithLetters.addAll(words.get(word.getWord().charAt(i)));
        }

        assertEquals(new ArrayList<>(setWithLetters), wordsWithLetters);
    }
}
