import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordTest {

    @Test
    public void testCanBeAnagram(){
        Word word = new Word("listen");
        Word canBeAnagram = new Word("silent");
        Word canBeAnagram2 = new Word("netsil");
        Word cantBeAnagram = new Word("hello");
        Word cantBeAnagram2 = new Word("listeni");

        assertTrue(word.canBeAnagram(canBeAnagram));
        assertTrue(word.canBeAnagram(canBeAnagram2));
        assertFalse(word.canBeAnagram(cantBeAnagram));
        assertFalse(word.canBeAnagram(cantBeAnagram2));
    }

    @Test
    public void testIsAnagram(){
        Word word = new Word("listen");
        Word anagram = new Word("silent");
        Word anagram2 = new Word("netsil");
        Word notAnagram = new Word("hello");

        assertTrue(word.isAnagram(anagram));
        assertTrue(word.isAnagram(anagram2));
        assertTrue(anagram.isAnagram(anagram2));
        assertFalse(word.isAnagram(notAnagram));
    }

    @Test
    public void testIsValid() {
        Word word = new Word("-");
        Word word2 = new Word("1");
        Word word3 = new Word("a");
        Word word4 = new Word("Z");
        assertFalse(word.isValid());
        assertFalse(word2.isValid());
        assertTrue(word3.isValid());
        assertTrue(word4.isValid());
    }
}
