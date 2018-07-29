package com.sda.problems;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


 class Problems {
     static String last(List<String> strings) {
        return strings.get(strings.size()-1);
    }

    static Integer secondLast(List<Integer> numbers) {
        return numbers.get(numbers.size()-2);
    }

    static int length(List<Object> objects) {
        return objects.size();
    }

    static List<Integer> reverse(List<Integer> numbers) {

        List<Integer> reversNumbers= new ArrayList<>();
        for (int i=1;i<numbers.size()+1;i++){
            reversNumbers.add(numbers.get(numbers.size()-i));
        }
        return reversNumbers;
    }

    static List<String> duplicate(List<String> strings) {

        List<String> duplicateStrings = new ArrayList<>();

        for (int i=0;i<(strings.size()*2);i++) {
            if (i % 2 == 0) {
                duplicateStrings.add(strings.get(i/2));
            } else {
                duplicateStrings.add(duplicateStrings.get(i - 1));
            }
        }
        return duplicateStrings;
    }

    static List<String> randomSelect(List<String> strings, int i) {

        List<String> randomStrings = new ArrayList<>();
        Random random = new Random();

        for (int j = 0; j < i; j++) {
            randomStrings.add(strings.get(random.nextInt(strings.size())));
        }
        return randomStrings;
    }

    static List<Integer> primeNumbers(IntStream intStream) {

        List<Integer> primeNumbersList= new ArrayList<>();
        List <Integer> primeRange = intStream.boxed().collect(Collectors.toList());

        int min= primeRange.stream().reduce((Integer::min)).get();
        int max= primeRange.stream().reduce((Integer::max)).get();

        for (int i = min; i <= max; i++)
        {
            int num=0;
            int counter=0;
            for(num =i; num>=1; num--)
            {
                if(i%num==0)
                {
                    counter = counter + 1;
                }
            }
            if (counter ==2)
            {
                primeNumbersList.add(i);
            }
        }

        return primeNumbersList;
    }

     public static List<String> rotate(List<String> strings, int i) {
         List<String> rotateStrings = new ArrayList<>();
         if(i>0) {
                for (int j = i; j < strings.size(); j++) {
                rotateStrings.add(strings.get(j)); }

                for (int j = 0; j < i; j++) {
                 rotateStrings.add(strings.get(j));
                }
                }else{
             for (int j = 0; j < -i; j++) {
                 rotateStrings.add(strings.get(strings.size()+j+i));
             }
             for (int j = 0; j < strings.size()+i; j++) {
                 rotateStrings.add(strings.get(j)); }

         }
                return rotateStrings;
     }

     public static Object[] removeAt(List<String> strings, int i) {
        Object [] removeAtTable = new Object[2];
        List<String> stringsWithoutI = new ArrayList<>();

         for (int j = 0; j < strings.size(); j++) {
             if (j!=i-1) {
                 stringsWithoutI.add(strings.get(j));
             }
         }
        removeAtTable[0]=stringsWithoutI;
        removeAtTable[1]=strings.get(i-1);

        return removeAtTable;
     }

     public static List<String> insertAt(List<String> input, int i, String alfa) {
         List<String> insertAtList = new ArrayList<>();
         for (int j = 0; j < input.size()+1; j++) {
             if (j < i - 1) {
                 insertAtList.add(input.get(j));
             }
             if (j == i - 1) {
                 insertAtList.add(alfa);
             }
             if (j > i - 1) {
                 insertAtList.add(input.get(j - 1));
             }
         }
     return insertAtList;
     }

     public static List<String> randomPermutation(List<String> collect) {
         List<String> randomStrings = new ArrayList<>();
         Random random = new Random();
         int startlenght = collect.size();
         for (int j = 0; j < startlenght; j++) {
             int z = random.nextInt(collect.size());
             randomStrings.add(collect.get(z));
             collect.remove(z);
         }
         return randomStrings;
     }
 }
