package com.sda.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;

class ProblemsTest {

    @Test
    public void shouldFindLastElementFromAListOfAlphabets() throws Exception {
        assertThat(Problems.last(asList("a", "b", "c", "d")),
                is(equalTo("d")));
    }

    @Test
    public void shouldFindSecondLastElementFromAList() throws Exception {
        List<Integer> numbers = asList(1, 2, 11, 4, 5, 8, 10, 6);
        assertThat(Problems.secondLast(numbers), is(equalTo(10)));
    }

    @Test
    public void listOfEmptyListShouldBe0() throws Exception {
        int length = Problems.length(Collections.emptyList());
        assertThat(length, is(equalTo(0)));
    }

    @Test
    public void shouldFindListOfNonEmptyList() throws Exception {
        assertThat(Problems.length(Arrays.asList(1, 2, 3, 4, 5)), is(equalTo(5)));
    }

    @Test
    public void shouldReverseAList() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(Problems.reverse(numbers), is(equalTo(Arrays.asList(5, 4, 3, 2, 1))));
    }

    @Test
    public void shouldDuplicateElementsInAList() throws Exception {
        List<String> duplicates = Problems.duplicate(Arrays.asList("a", "b", "c", "d"));
        assertThat(duplicates, hasSize(8));
        assertThat(duplicates, contains("a", "a", "b", "b", "c", "c", "d", "d"));
    }

    @Test
    public void shouldReturnAListOfThreeRandomSelectedElements() throws Exception {
        List<String> result = Problems.randomSelect(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 3);
        System.out.println(result);
        assertThat(result, hasSize(3));
    }

    @Test
    public void shouldGiveAllPrimeNumbersBetween2And10() throws Exception {
        List<Integer> primeNumbers = Problems.primeNumbers(IntStream.rangeClosed(2, 10));
        assertThat(primeNumbers, hasSize(4));
        assertThat(primeNumbers, hasItems(2, 3, 5, 7));
    }

    @Test
    public void shouldGiveAllPrimeNumbersBetween7And31() throws Exception {
        List<Integer> primeNumbers = Problems.primeNumbers(IntStream.rangeClosed(7, 31));
        assertThat(primeNumbers, hasSize(8));
        assertThat(primeNumbers, hasItems(7, 11, 13, 17, 19, 23, 29, 31));
    }


    @Test
    public void shouldRotateAListByThreeElementsWhenNIs3() throws Exception {
        List<String> rotated = Problems.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 3);
        assertThat(rotated, equalTo(Arrays.asList("d", "e", "f", "g", "h", "a", "b", "c")));
    }

    @Test
    public void shouldReturnSameListWhenNIs0() throws Exception {
        List<String> rotated = Problems.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 0);
        assertThat(rotated, equalTo(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h")));
    }

    @Test
    public void shouldRotateWhenNIsNegative() throws Exception {
        List<String> rotated = Problems.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), -2);
        assertThat(rotated, equalTo(Arrays.asList("g", "h", "a", "b", "c", "d", "e", "f")));
    }

    @Test
    public void shouldRemoveKthElementFromList() throws Exception {
        Object[] result = Problems.removeAt(Arrays.asList("a", "b", "c", "d"), 2);
        assertThat(result[0], equalTo(Arrays.asList("a", "c", "d")));
        assertThat(result[1], equalTo("b"));
    }

    @Test
    public void shouldInsertElementAtSecondPosition() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
        List<String> result = Problems.insertAt(input, 2, "alfa");
        assertThat(result, hasSize(5));
        assertThat(result, contains("a", "alfa", "b", "c", "d"));

    }

    @Test
    public void shouldInsertElementAtFirstPosition() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
        List<String> result = Problems.insertAt(input, 1, "alfa");
        assertThat(result, hasSize(5));
        assertThat(result, contains("alfa", "a", "b", "c", "d"));

    }

    @Test
    public void shouldInsertElementAtEnd() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
        List<String> result = Problems.insertAt(input, 5, "alfa");
        assertThat(result, hasSize(5));
        assertThat(result, contains("a", "b", "c", "d", "alfa"));
    }

    @Test
    public void shouldGenerateRandomPermutationOfElementsOfAList() throws Exception {
        List<String> permutation = Problems.randomPermutation(Stream.of("a", "b", "c", "d", "e", "f").collect(toList()));
        assertThat(permutation, hasSize(6));
        assertThat(permutation, containsInAnyOrder("a", "b", "c", "d", "e", "f"));
        System.out.println(permutation); // np. [a, e, f, c, b, d]
    }

}