/*
 Принимать на вход массив целых чисел для сортировки. 
 Если массив не предоставлен, программа использует массив по умолчанию.

Сначала выводить исходный массив на экран.

Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива в порядке возрастания.

Выводить отсортированный массив на экран.

Ваше решение должно содержать два основных метода: buildTree, который строит сортирующее дерево на основе массива, 
и heapSort, который выполняет собственно сортировку кучей.

Программа должна быть способной сортировать массив, даже если он состоит из отрицательных чисел и имеет дубликаты.

На входе:


'5 8 12 3 6 9'
На выходе:


Initial array:
[5, 8, 12, 3, 6, 9]
Sorted array:
[3, 5, 6, 8, 9, 12]
 */

import java.util.Arrays;

public class task3 {

    public static void main(String[] args) {
        int[] initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}

class HeapSort {

    public static void buildTree(int[] tree, int sortLength) {
        // Введите свое решение ниже
        for (int i = (sortLength + 2) / 2; i >= 0; i--) {
            getRightNode(tree, i, sortLength);
        }

    }

    public static void getRightNode(int[] tree, int apex, int sortLength) {
        int ap_l = 2 * apex + 1;
        if (ap_l >= sortLength) {
            return;
        }
        int ap_r = ap_l + 1;

        int largest;

        if (ap_r < sortLength) {
            largest = (tree[apex] > tree[ap_l])
                    ? ((tree[apex] > tree[ap_r]) ? apex : ap_r)
                    : ((tree[ap_l] > tree[ap_r]) ? ap_l : ap_r); 
        }else {
            largest = (tree[apex] > tree[ap_l]) ? apex : ap_l;
        }

        if (largest != apex) {
            swap(tree, apex, largest);
            getRightNode(tree, largest, sortLength);
        }

    }

    public static void swap(int[] tree, int n1, int n2) {
        int tmp = tree[n1];
        tree[n1] = tree[n2];
        tree[n2] = tmp;
    }

    public static void heapSort(int[] sortArray, int sortLength) {
// Введите свое решение ниже
        do {
            buildTree(sortArray, sortLength);
            swap(sortArray, 0, --sortLength);
        } while (sortLength > 0);
    }
}
