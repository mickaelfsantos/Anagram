import java.util.*;

public class Main {
    static Dictionary dictionary;
    static Word word;
    static WordFilter wordFilter;
    static AnagramSolver anagramSolver;

    public static void main(String[] args) {
        dictionary = new Dictionary();
        wordFilter = new WordFilter();
        anagramSolver = new AnagramSolver();


        while(true){
            word = scanWord();
            ArrayList<Word> wordsToCombine = wordFilter.filterWords(dictionary.getWords(), word);
            ArrayList<String> anagrams = new ArrayList<>();
            anagrams = anagramSolver.generateAnagrams(wordsToCombine, 0, new Word(""), word, anagrams);
            for(String anagram : anagrams){
                System.out.println(anagram);
            }
        }
    }

    private static Word scanWord() {
        Scanner scanner;
        boolean isValid;
        Word word;
        do{
            scanner = new Scanner(System.in);
            System.out.print("Enter word: ");
            word = new Word(scanner.nextLine());
            isValid = word.isValid();
            if(!isValid){
                System.out.println("Invalid input. Please enter a word with only letters");
                isValid = false;
            }
        } while(!isValid);

        return word;
    }
}
