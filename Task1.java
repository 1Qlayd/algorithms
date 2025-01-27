import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        int arraySize = 20;
        int[] randomArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            randomArray[i] = random.nextInt(101) - 50;
        }

        System.out.println("Исходный массив:");
        printArray(randomArray);

        Arrays.sort(randomArray);

        int[] sortedArray = new int[arraySize];
        int index = 0;

        for (int num : randomArray) {
            if (num % 2 != 0) {
                sortedArray[index++] = num;
            }
        }

        for (int num : randomArray) {
            if (num == 0) {
                sortedArray[index++] = num;
            }
        }

        for (int i = randomArray.length - 1; i >= 0; i--) {
            if (randomArray[i] % 2 == 0 && randomArray[i] != 0) {
                sortedArray[index++] = randomArray[i];
            }
        }

        System.out.println("Переупорядоченный массив:");
        printArray(sortedArray);
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
