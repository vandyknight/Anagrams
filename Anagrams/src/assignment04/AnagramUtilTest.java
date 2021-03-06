/**
 * Mark Van der Merwe and Thomas Oh
 */
package assignment04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Test;

/**
 * Test class for our AnagramUtil functionality.
 * 
 * @author markvandermerwe and Thomas Oh
 *
 */
public class AnagramUtilTest {

	/**
	 * Tests insertion sort for Strings, Integers, and Characters.
	 */
	@Test
	public void testInsertionSort() {
		String[] wordsToSort = new String[] { "cat", "bear" };
		AnagramUtil.insertionSort(wordsToSort, new Comparator<String>() {
			@Override
			public int compare(String right, String left) {
				// Compare them lexographically in this case (by first letter).
				return right.compareTo(left);
			}
		});
		assertArrayEquals(new String[] { "bear", "cat" }, wordsToSort);

		Integer[] numsToSort = new Integer[] { 1, 45, 3, 79, 19, 3, 8, 5, 7, 4, 2, 5 };
		AnagramUtil.insertionSort(numsToSort, new Comparator<Integer>() {

			@Override
			public int compare(Integer right, Integer left) {
				// Compare them by simple integer value.
				return right - left;
			}

		});
		assertArrayEquals(new Integer[] { 1, 2, 3, 3, 4, 5, 5, 7, 8, 19, 45, 79 }, numsToSort);

		Character[] charsToSort = new Character[] { 'c', 'd', 'y', 'e' };
		AnagramUtil.insertionSort(charsToSort, new Comparator<Character>() {

			@Override
			public int compare(Character right, Character left) {
				// Compare characters lexographically.
				return right.compareTo(left);
			}

		});
		assertArrayEquals(new Character[] { 'c', 'd', 'e', 'y' }, charsToSort);
	}

	@Test
	public void testSort() {
		// will set letters to lowercase and organize them alphabetically
		String lettersToSort = "CaT";
		lettersToSort = AnagramUtil.sort(lettersToSort);
		assertEquals("act", lettersToSort);
	}

	@Test
	public void testAreAnagrams() {
		// checks to see if all letters are the same between two strings
		assertEquals(true, AnagramUtil.areAnagrams("NagARam", "Anagram"));
	}

	@Test
	public void testGetLargestAnagramGroup() {
		// finds largest group of anagrams within a given string array
		String[] wordsToSort = new String[] { "cat", "bear", "act", "erba", "aber", "tac", "atc" };
		String[] shouldReturn = new String[] { "cat", "act", "tac", "atc" };
		assertArrayEquals(shouldReturn, AnagramUtil.getLargestAnagramGroup(wordsToSort));
	}

	@Test
	public void testGetLargestAnagramGroupArrayListSort() {
		// finds largest group of anagrams within a given string arraylist
		ArrayList<String> words = new ArrayList<>();
		words.add("cat");
		words.add("bear");
		words.add("act");
		words.add("erba");
		words.add("aber");
		String[] shouldReturn = new String[] { "bear", "erba", "aber" };
		assertArrayEquals(shouldReturn, AnagramUtil.getLargestAnagramGroupArrayListSort(words));
	}

	@Test
	public void testGetLargestWithZeroArray() {
		// Make sure we can handle the sending of an empty string.
		String[] empty = new String[0];
		assertArrayEquals(empty, AnagramUtil.getLargestAnagramGroup(empty));
	}

	@Test
	public void testGetLargestAnagramGroupFromFile() {
		// finds largest group of anagrams within a file
		String fileName = "test";
		String[] shouldReturn = new String[] { "cat", "act" };
		assertArrayEquals(shouldReturn, AnagramUtil.getLargestAnagramGroup(fileName));
	}
}
