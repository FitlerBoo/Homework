package Lesson1;

import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

class Homework {

    // Перевернуть строку и вывести на консоль
    //  String string = "I love Java";
    public static void turnString(String string) {
        var strArray = string.toCharArray();
        for (var i = (string.length() - 1); i >= 0; i--){
            System.out.print(strArray[i]);
        }
    }

    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] ints) {
        Set<Integer> res = new HashSet<Integer>();
        for (var e : ints) res.add(e);
        for (var e : res) System.out.print(e + " ");
    }

    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        int previous = Integer.MIN_VALUE;
        for (var e : arr){
            if(max < e){
                previous = max;
                max = e;
            }else if (previous < e) {
                previous = e;
            }
        }
        return previous;
    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    public static Integer lengthOfLastWord(String string) {
        var arr = string.split(" ");
        return arr[arr.length - 1].length();
    }

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    public static boolean isPalindrome(String string) {
        var arr = string.toCharArray();
        int startIndex = 0;
        int endIndex = string.length() - 1;
        while (endIndex > startIndex){
            if (arr[startIndex] != arr[endIndex]) {
                return false;
            }
            ++startIndex;
            --endIndex;
        }
        return true;
    }
}
