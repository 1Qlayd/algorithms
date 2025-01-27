import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 2, 3, 4, 2, 1, 3, 5, 2};

        System.out.print("Исходный массив: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        System.out.print("Наиболее часто встречающиеся числа: ");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
