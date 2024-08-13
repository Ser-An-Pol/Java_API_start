package homework3.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task1 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 6, 2, 3, 4, 345, 345, 65, 34, 7, 64, 7, 34};
        
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) list.add(arr[i]);

        list = splitMerge(list);
        for (int i = 0; i < arr.length; i++) res[i] = list.get(i);

        return res;
    }

    public static List<Integer> splitMerge(List<Integer> list) {
        int size = list.size();
        if (size ==  1) return list;
        int mid = size/2;

        list = merge(
            splitMerge(list.subList(0, mid)), 
            splitMerge(list.subList(mid, size))
        );

        return list;
    }

    public static List<Integer> merge(List<Integer> a1, List<Integer> a2) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a1.size() && j < a2.size()) {
            if (a1.get(i) > a2.get(j)) list.add(a2.get(j++));
            else if (a1.get(i) < a2.get(j)) list.add(a1.get(i++));
            else {
                list.add(a1.get(i++));
                list.add(a2.get(j++));
            }
        }
        if (i < a1.size()) list.addAll(a1.subList(i, a1.size()));
        if (j < a2.size()) list.addAll(a2.subList(j, a2.size()));
        return list;
    }
}
