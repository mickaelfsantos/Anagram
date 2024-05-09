import java.util.*;

public class WordFilter {
    private ArrayList<Word> possibleWords;

    public WordFilter() {
    }

    public ArrayList<Word> filterWords(HashMap<Character, Set<Word>> dictionary, Word word){
        possibleWords = new ArrayList<>();
        ArrayList<Word> wordsWithLetters = getAllWordsWithLetters(dictionary, word);
        for(Word possibleWord : wordsWithLetters){
            if(word.canBeAnagram(possibleWord)){
                possibleWords.add(possibleWord);
            }
        }
        return possibleWords;
    }

    public ArrayList<Word> getAllWordsWithLetters(HashMap<Character, Set<Word>> dictionary, Word word){
        HashSet<Word> words = new HashSet<>();
        for(int i=0; i<word.getWord().length(); i++){
            char c = word.getWord().charAt(i);
            Set<Word> wordsWithLetter = dictionary.get(c);
            if(wordsWithLetter != null)
                words.addAll(wordsWithLetter);
        }
        return new ArrayList<>(words);
    }
}
