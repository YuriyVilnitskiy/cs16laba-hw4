
package ua.edu.ucu.autocomplete;

import static org.hamcrest.Matchers.containsInAnyOrder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import ua.edu.ucu.tries.RWayTrie;

/**
 *
 * @author Andrii_Rodionov
 */
public class PrefixMatchesITTest {

    private PrefixMatches pm;

    @Before
    public void init() {
        pm = new PrefixMatches(new RWayTrie());
        pm.load("abc", "abce", "abcd", "abcde", "abcdef");
    }

    @Test
    public void testWordsWithPrefix_String() {
        String pref = "ab";

        Iterable<String> result = pm.wordsWithPrefix(pref);
        System.out.println(result);

        String[] expResult = {"abc", "abce", "abcd", "abcde", "abcdef"};

        assertThat(result, containsInAnyOrder(expResult));
    }

    @Test
    public void testWordsWithPrefix_String_and_K() {
        String pref = "abc";
        int k = 3;

        Iterable<String> result = pm.wordsWithPrefix(pref, k);

        String[] expResult = {"abc", "abce", "abcd", "abcde"};

        assertThat(result, containsInAnyOrder(expResult));
    }

    @Test
    public void testLoad_WithOneArgument() {
        String arg = "Shadow";

        int result = pm.load(arg);

        int expResult = 1;

        assertEquals(result, expResult);
    }
    @Test
    public void testLoad_WithFewArgument() {
        String arg = "Shadow";
        String arg1 = "Gravedigger";

        int result = pm.load(arg, arg1);

        int expResult = 2;

        assertEquals(result, expResult);
    }
    @Test
    public void testLoad_WithOneArgumentWithSpace() {
        String arg = "Shadow Moses";

        int result = pm.load(arg);

        int expResult = 2;

        assertEquals(result, expResult);
    }
    @Test
    public void testLoad_WithOneListArgument() {
        String[] arg = new String[]{"Shadow"};

        int result = pm.load(arg);

        int expResult = 1;

        assertEquals(result, expResult);
    }
    @Test
    public void testLoad_WithFewListArgument() {
        String[] arg = new String[]{"Shadow Moses"};

        int result = pm.load(arg);

        int expResult = 2;

        assertEquals(result, expResult);
    }
    @Test
    public void testContains_True() {

        boolean result = pm.contains("abc");

        boolean expResult = true;

        assertEquals(result, expResult);
    }
    @Test
    public void testContains_False() {

        boolean result = pm.contains("shadow");

        boolean expResult = false;

        assertEquals(result, expResult);
    }

    @Test
    public void testDelete_True() {

        boolean result = pm.delete("abc");

        boolean expResult = true;

        assertEquals(result, expResult);
    }
    @Test
    public void testSize() {

        int result = pm.size();

        int expResult = 5;

        assertEquals(result, expResult);
    }



}
