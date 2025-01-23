import Lesson2.MyArrayList;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        var comparatorD = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        };
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(0);
        list.add(4);
        list.add(12);
        list.add(7);
        list.sort(comparatorD);
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}