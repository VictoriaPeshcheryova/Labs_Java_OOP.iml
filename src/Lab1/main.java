package Lab1;

import java.util.*;

public class main {


    public static void main(String[] args) {
        main obj=new main();
        int [][]arr1={{3,88,44,6,2},{0,64,47,4}};
        int [][]arr2={{22,9,88,22},{90,9,0,4}};
        obj.Method2(arr1,arr2);
        System.out.println(" ");
        System.out.println(Arrays.toString(obj.Method10(new int[]{1, 7, 4}, new int[]{55, 3, 4})));
        System.out.println(obj.Method14("aDdA"));
        System.out.println(obj.Method18("lol","llool"));
        System.out.println(Arrays.toString(obj.Method30(new int[]{1, 7, 4}, new int[]{55, 3, 4})));
    }
    //Розробіть метод, який виводить на екран спільні елементи будь яких
    // двох 2-вимірних масивів int[][].
    // Результат роботи методу не повинен залежати від того чи є масив регулярним.
    void Method2(int [][]arr1,int [][]arr2) {
        for (int[] elem1 : arr1) {
            for (int elem2 : elem1) {
                for (int[] elem3 : arr2) {
                    for (int elem4 : elem3) {
                        if (elem4 == elem2) {
                            System.out.print(elem4+" ");
                        }
                    }
                }
            }
        }
    }

    //Створіть метод, який дозволяє поєднати між собою будь яку кількість
    // масивів int[] та повернути результуючий масив,
    // який буде складатися виключно з простих чисел, які були у складі масивів.
    int[] Method10(int[] ...arrays){
        Set<Integer> set = new HashSet<>();
        Set<Integer> result= new HashSet<>();
        for (int[] item : arrays) {
            for (int item1 :item) {
                if(isPrime(item1))
                {
                set.add(item1);
                }
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
    boolean isPrime(int n) {
        int temp;
        if (n == 1) return false;
        for (int i = 2; i <= n / 2; i++) {
            temp = n % i;
            if (temp == 0) return false;
        }
        return true;
    }

    //Створіть метод, який повертає найбільший збалансований підрядок у
    // складі параметру String, який передається у метод.
    // Збалансованим вважається рядок у якому всі літери представлені у двох регістрах.
    // Приклад: "wdDdddWd"- збалансований рядок,  "wzW"- незбалансований.
    String Method14(String str) {
        String result ="";
        int tmp;
        int tmpLength;
        int size = str.length();
        String tmpString;
        for (int i = 2; i <= size; i++) {
            tmpString = str.substring(0, i);
            tmpLength = tmpString.length();
            tmp = upperCaseLettersCount(tmpString);
            if(tmp == tmpLength - tmp && tmpLength > result.length())
                result = tmpString;
        }
        return result;
    }
    int upperCaseLettersCount(String str) {
        int result = 0;
        int size = str.length();
        for(int i =0; i < size ; i++)
        {
            if(Character.isUpperCase(str.charAt(i))) {
                result++;
            }
        }
        return result;
    }

    //Створіть метод, який  приймає два параметри типу String
    // та повертає кількість повних повторів одного слова літерами другого.
    int Method18(String str1, String str2) {
        Map<Character, Integer> letters = new HashMap<>();
        Integer countOfLetter;
        int sizeOfStr2 = str2.length();
        Character ch;
        for(int i = 0; i < sizeOfStr2; i++) {
            ch = str2.charAt(i);
            countOfLetter = letters.get(ch);
            if (countOfLetter != null){
                letters.replace(str2.charAt(i), countOfLetter, countOfLetter + 1);
            }
            else {
                letters.put(ch, 1);
            }
        }
        int str1Length;
        int count = 0;
        int sizeOfStr1 = str1.length();
        while (true) {
            str1Length = str1.length();
            for (int i = 0; i < sizeOfStr1; i++) {
                countOfLetter = letters.get(str1.charAt(i));
                if (countOfLetter == null) break;
                if (countOfLetter != 1)
                    letters.replace(str1.charAt(i), countOfLetter, countOfLetter - 1);
                else
                    letters.remove(str1.charAt(i));
                str1Length--;
            }
            if(str1Length != 0)
                break;
            count++;
        }
        return count;

    }

    //Створіть метод, який приймає будь яку кількість елементів int[] та повертає масив,
    // який складається тільки з елементів, які є в одному екземплярі серед усіх масивів.
    int[] Method30(int[] ...arrays){
        Set<Integer> set = new HashSet<>();
        for (int[] item : arrays) {
            for (int item1 :item) {
                set.add(item1);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

}






