import java.util.ArrayList;

public class AnagramSolver {

    public AnagramSolver() {
    }


    public static ArrayList<String> generateAnagrams(ArrayList<Word> words, int currentIndex, Word currentAnagram, Word word, ArrayList<String> anagrams) {
        if (word.isAnagram(currentAnagram)) {
            anagrams.add(currentAnagram.getWord());
            return anagrams;
        }

        if(currentAnagram.getLengthWithoutSpaces() > word.getLengthWithoutSpaces())
            return anagrams;

        for (int i = currentIndex; i < words.size(); i++) {
            anagrams = generateAnagrams(words, i + 1, new Word(currentAnagram.getWord() + " " + words.get(i).getWord()), word, anagrams);
        }
        return anagrams;
    }

}
