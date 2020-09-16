package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private static final Scanner scanner = new Scanner(System.in);

    private static final int waterServing = 200;
    private static final int milkServing = 50;
    private static final int coffeeServing = 15;

    private static int waterReq;
    private static int milkReq;
    private static int coffeeReq;

    private static int coffeeCupsReq;

    public static void main(String[] args) {

        ingredientsRequest();

        askAmountCupsOfCoffee();

        calculate();

    }

    private static void ingredientsRequest() {
        System.out.println("Write how many ml of water the coffee machine has:");
        waterReq = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milkReq = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        coffeeReq = scanner.nextInt();
    }

    private static void askAmountCupsOfCoffee() {
        System.out.println("Write how many cups of coffee you will need:");
        coffeeCupsReq = scanner.nextInt();
    }

    private static void calculate() {

        if (waterReq <= 0 || milkReq <= 0 || coffeeReq <= 0) {
            if (coffeeCupsReq == 0) {
                System.out.println("Yes, I can make that amount of coffee");
            } else {
                System.out.println("No, I can make only 0 cup(s) of coffee");
            }
        } else {
            int maxAmountCoffeeCups = maximumCoffeeCupsAmountCanMake();
            int differentCoffeeCups = maxAmountCoffeeCups - coffeeCupsReq;

            if (maxAmountCoffeeCups == coffeeCupsReq) {
                System.out.println("Yes, I can make that amount of coffee");
            } else if (maxAmountCoffeeCups > coffeeCupsReq) {
                System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", differentCoffeeCups);
            } else {
                System.out.printf("No, I can make only %d cup(s) of coffee", maxAmountCoffeeCups);
            }
        }
    }

    private static int maximumCoffeeCupsAmountCanMake() {
        int waterInCups = waterReq / waterServing;
        int milkInCups = milkReq / milkServing;
        int coffeeInCups = coffeeReq / coffeeServing;

        return Math.min(Math.min(waterInCups, milkInCups), coffeeInCups);
    }
}
