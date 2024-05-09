import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
    private String word;
    private int length;

    public Word(String word) {
        this.word = word;
        this.length = word.length();
    }

    public String getWord() {
        return word;
    }

    public int getLength() {
        return length;
    }

    public String getWordWithoutSpaces() {
        return word.replaceAll("\\s+","");
    }

    public int getLengthWithoutSpaces() {
        return getWordWithoutSpaces().length();
    }

    public boolean canBeAnagram(Word word){
        if(word.getLength() > this.length)
            return false;

        for(int i=0; i<word.getLength(); i++){
            if(this.word.indexOf(word.getWord().charAt(i)) == -1){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(Word word){
        if (word.getLengthWithoutSpaces() != this.getLengthWithoutSpaces()) {
            return false;
        }
        char[] a1 = word.getWordWithoutSpaces().toCharArray();
        char[] a2 = this.getWordWithoutSpaces().toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    public boolean isValid() {
        String regex = "^[a-zA-Z\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }
}
