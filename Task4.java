import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите числа (через пробел): ");
        String input = scanner.nextLine();
        String[] inputNumbers = input.split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (String num : inputNumbers) {
            numbers.add(Integer.parseInt(num));
        }

        System.out.print("Введите число K: ");
        int K = scanner.nextInt();

        System.out.print("Введите число L: ");
        int L = scanner.nextInt();

        int[] targetSums = new int[K];
        for (int i = 0; i < K; i++) {
            targetSums[i] = L + i;
        }

        if (partition(numbers, targetSums)) {
            System.out.println("Разделение возможно.");
        } else {
            System.out.println("Разделение невозможно.");
        }
    }

    private static boolean partition(List<Integer> numbers, int[] targetSums) {
        int totalSum = 0;
        for (int num : numbers) {
            totalSum += num;
        }

        int requiredSum = 0;
        for (int sum : targetSums) {
            requiredSum += sum;
        }

        if (totalSum != requiredSum) {
            return false;
        }

        int[] currentSums = new int[targetSums.length];
        boolean[] used = new boolean[numbers.size()];

        return canPartition(numbers, currentSums, targetSums, used, 0);
    }

    private static boolean canPartition(List<Integer> numbers, int[] currentSums, int[] targetSums, boolean[] used, int index) {
        if (index == numbers.size()) {
            for (int i = 0; i < currentSums.length; i++) {
                if (currentSums[i] != targetSums[i]) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < currentSums.length; i++) {
            if (currentSums[i] + numbers.get(index) <= targetSums[i]) {
                currentSums[i] += numbers.get(index);
                used[index] = true;

                if (canPartition(numbers, currentSums, targetSums, used, index + 1)) {
                    return true;
                }

                currentSums[i] -= numbers.get(index);
                used[index] = false;
            }
            if (currentSums[i] == targetSums[i]) {
                continue;
            }
        }

        return false;
    }
}
