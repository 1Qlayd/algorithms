import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int[] player1Sequence = {4, 2, 4};
        int[] player2Sequence = {4, 4, 4};
        
        int numRolls = 1000;
        
        int simulations = 10000;

        int player1Wins = 0;
        int player2Wins = 0;
        int draws = 0;

        Random random = new Random();

        for (int i = 0; i < simulations; i++) {
            int player1Score = rollDiceAndCountMatches(random, player1Sequence, numRolls);
            int player2Score = rollDiceAndCountMatches(random, player2Sequence, numRolls);

            if (player1Score > player2Score) {
                player1Wins++;
            } else if (player2Score > player1Score) {
                player2Wins++;
            } else {
                draws++;
            }
        }

        double player1WinProbability = (double) player1Wins / simulations;
        double player2WinProbability = (double) player2Wins / simulations;
        double drawProbability = (double) draws / simulations;

        System.out.printf("Вероятность победы игрока 1: %.4f%n", player1WinProbability);
        System.out.printf("Вероятность победы игрока 2: %.4f%n", player2WinProbability);
        System.out.printf("Вероятность ничьей: %.4f%n", drawProbability);
    }

    private static int rollDiceAndCountMatches(Random random, int[] sequence, int numRolls) {
        int score = 0;
        int[] rolls = new int[numRolls];

        for (int i = 0; i < numRolls; i++) {
            rolls[i] = random.nextInt(6) + 1;
        }

        for (int i = 0; i <= rolls.length - sequence.length; i++) {
            boolean match = true;
            for (int j = 0; j < sequence.length; j++) {
                if (rolls[i + j] != sequence[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                score++;
                i += sequence.length - 1;
            }
        }

        return score;
    }
}
