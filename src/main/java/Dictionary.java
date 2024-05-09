import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {
    private HashMap<Character, Set<Word>> words;

    public Dictionary() {
        try {
            URL dictionary = new URL("https://raw.githubusercontent.com/eneko/data-repository/master/data/words.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(dictionary.openStream()));
            String inputLine;
            words = new HashMap<>();

            System.out.println("Getting words from dictionary...");
            while ((inputLine = in.readLine()) != null){
                Word word = new Word(inputLine);
                for(int i=0; i<word.getLength(); i++){
                    char c = word.getWord().charAt(i);
                    if(words.get(c) == null){
                        words.put(c, new HashSet<>());
                    }
                    words.get(c).add(word);
                }
            }
            in.close();
            System.out.println("Words successfully obtained");
        } catch (IOException e) {
            System.out.println("An error occurred while trying to get the dictionary: " + e.getMessage());
        }
    }

    public HashMap<Character, Set<Word>> getWords(){
        return words;
    }
}
