package ua.training;

import java.util.*;

/**
 * Created by Roman Prokopenko on 18.11.2016.
 */
public class ArraysTest {
    public static void main(String[] args) {
        int arrayFirst[] = { 1, 3, 2, 4, 4, 3, 3 };
        int secondArray[] = { 2, 1, 5, 19, 17 , 8, 10, 8};
        System.out.println(findNotEquals(arrayFirst, secondArray));
        System.out.println(sortArrayByNumberOfOccurrences(arrayFirst));
    }

    private static List<Integer> findNotEquals(int[] arrayFirst, int[] secondArray) {
        List<Integer> result = new ArrayList<>();

        outer:
        for (int i = 0; i < arrayFirst.length; i++) {
            for (int k = i + 1; k < arrayFirst.length; k++) {
                if (arrayFirst[k] == arrayFirst[i]) {
                    continue outer;
                }
            }
            for (int aSecondArray : secondArray) {
                if (arrayFirst[i] == aSecondArray) {
                    continue outer;
                }
            }
            result.add(arrayFirst[i]);
        }

        outer2:
        for (int i = 0; i < secondArray.length; i++) {
            for (int k = i + 1; k < secondArray.length; k++) {
                if (secondArray[k] == secondArray[i]) {
                    continue outer2;
                }
            }
            for (int anArrayFirst : arrayFirst) {
                if (secondArray[i] == anArrayFirst) {
                    continue outer2;
                }
            }
            result.add(secondArray[i]);
        }
        return result;
    }

    public static List<Integer> sortArrayByNumberOfOccurrences(int[] array) {

        Map<Integer, Integer> occurrenceElementNumber = new HashMap<>();
        Map<Integer, Set<Integer>> elementSetsByOccurrence = new TreeMap<>();
        for (int anArray : array) {
            if (!occurrenceElementNumber.containsKey(anArray)) {
                occurrenceElementNumber.put(anArray, 0);
            }
            occurrenceElementNumber.put(anArray, occurrenceElementNumber.get(anArray) + 1);
        }

        for (int k : occurrenceElementNumber.keySet()) {
            int occurrenceNumber = occurrenceElementNumber.get(k);
            if (!elementSetsByOccurrence.containsKey(occurrenceNumber)) {
                elementSetsByOccurrence.put(occurrenceNumber, new TreeSet<>());
            }
            Set<Integer> elementsWithSameOccurrenceNumber = elementSetsByOccurrence.get(occurrenceNumber);
            elementsWithSameOccurrenceNumber.add(k);
            elementSetsByOccurrence.put(occurrenceNumber, elementsWithSameOccurrenceNumber);
        }

        List<Integer> sortedElements = new ArrayList<>();

        for (Map.Entry<Integer, Set<Integer>> entry : elementSetsByOccurrence.entrySet()) {
            for (Integer k : entry.getValue()) {
                for (int i = 0; i < entry.getKey(); i++) {
                    sortedElements.add(k);
                }
            }
        }

        return sortedElements;
    }

}
