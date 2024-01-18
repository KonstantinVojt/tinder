package institute;

import java.util.Random;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        Random random = new Random();

        // Початкова генерація першого випадкового числа
        int currentRandomNumber = random.nextInt(100); // Змініть діапазон за потребою
        System.out.println("Поточне випадкове число: " + currentRandomNumber);

        // Генерація наступного випадкового числа, відмінного від поточного
        int nextRandomNumber;
        do {
            nextRandomNumber = random.nextInt(100); // Змініть діапазон за потребою
        } while (nextRandomNumber == currentRandomNumber);

        System.out.println("Наступне випадкове число: " + nextRandomNumber);
        System.out.println("Це число: " + currentRandomNumber);

    }
}
