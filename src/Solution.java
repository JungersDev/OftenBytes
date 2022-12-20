/**
 * create by Zaryvnoire Alexandr on 20.12.2022
 **/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream input = new FileInputStream(buffer.readLine());

        findMaxCounter(input);

        buffer.close();
        input.close();
    }

    public static void findMaxCounter(FileInputStream filePath) throws IOException {
        Map<Integer, Integer> count = new HashMap<>();
        int[] bytes = new int[255];
        int data;

        while ((data = filePath.read()) != -1) { // * Заполнение массива bytes значениями(по индексу) и количеством(значению ячейки)
            bytes[data]++;
        }

        for (int i = 0; i < bytes.length; i ++) { // * Заполнение Мапы <Байт, Сколько раз встречался>
            if (bytes[i] != 0) {
                count.put(i, bytes[i]);
            }
        }

        List list = new ArrayList(count.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        Collections.reverse(list);

        String regex = "=(\\d+)";

        System.out.print(list.get(0).toString().replaceFirst(regex, "") + " ");
        System.out.print(list.get(1).toString().replaceFirst(regex, "") + " ");
        System.out.print(list.get(2).toString().replaceFirst(regex, "") + " ");
        System.out.print(list.get(3).toString().replaceFirst(regex, "") + " ");
        System.out.print(list.get(4).toString().replaceFirst(regex, "") + " ");
    }
}
