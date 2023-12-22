package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static final int water = 200;
    public static final int milk = 50;
    public static final int coffeeBeans = 15;
    public static Scanner scanner = new Scanner(System.in);
    //Stock List
    public static int waterStock = 400;
    public static int milkStock = 540;
    public static int coffeeStock = 120;
    public static int disposableCupStock = 9;
    public static int money = 550;

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.print("\nWrite action (buy, fill, take, remaining, exit): ");
            String option = scanner.next();

            switch (option) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    stockIngredients();
                    break;
                case "take":
                    takeMachineBalance();
                    break;
                case "remaining":
                    printSummary();
                    break;
                case "exit":
                    exit = true; // Fix: Set exit to true to exit the loop
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void takeMachineBalance() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private static void stockIngredients() {
        System.out.print("Write how many ml of water you want to add: ");
        waterStock += scanner.nextInt();
        System.out.print("Write how many ml of milk you want to add: ");
        milkStock += scanner.nextInt();
        System.out.print("Write how many grams of coffee beans you want to add: ");
        coffeeStock += scanner.nextInt();
        System.out.print("Write how many disposable cups of coffee you want to add: ");
        disposableCupStock += scanner.nextInt();
    }

    private static void buyCoffee() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String drinkOrder = scanner.next();

        switch (drinkOrder) {
            case "1":
                buyEspresso();
                break;
            case "2":
                buyLatte();
                break;
            case "3":
                buyCappuccino();
                break;
            case "back":
                mainMenu();
                break;
            default:
                break;
        }
    }

    private static void buyEspresso() {
        if (waterStock >= 250 && coffeeStock >= 16 && disposableCupStock >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            waterStock -= 250;
            coffeeStock -= 16;
            money = money + 4;
            disposableCupStock -= 1;
        } else if (waterStock < 250) {
            System.out.println("Sorry, not enough water!");
        } else if (coffeeStock < 16) {
            System.out.println("Sorry, not enough beans!");
        } else if (disposableCupStock < 1) {
            System.out.println("Sorry, not enough cups!");
        }
    }

    private static void buyLatte() {
        if (waterStock >= 350 && milkStock >= 75 && coffeeStock >= 20 && disposableCupStock >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            waterStock -= 350;
            milkStock -= 75;
            coffeeStock -= 20;
            money = money + 7;
            disposableCupStock -= 1;
        } else if (waterStock < 350) {
            System.out.println("Sorry, not enough water!");
        } else if (coffeeStock < 20) {
            System.out.println("Sorry, not enough beans!");
        } else if (disposableCupStock < 1) {
            System.out.println("Sorry, not enough cups!");
        } else if (milkStock < 75) {
            System.out.println("Sorry, not enough milk!");
        }
    }

    private static void buyCappuccino() {
        if (waterStock >= 200 && milkStock >= 100 && coffeeStock >= 12 && disposableCupStock >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            waterStock -= 200;
            milkStock -= 100;
            coffeeStock -= 12;
            money = money + 6;
            disposableCupStock -= 1;
        } else if (waterStock < 200) {
            System.out.println("Sorry, not enough water!");
        } else if (coffeeStock < 12) {
            System.out.println("Sorry, not enough beans!");
        } else if (disposableCupStock < 1) {
            System.out.println("Sorry, not enough cups!");
        } else if (milkStock < 100) {
            System.out.println("Sorry, not enough milk!");
        }
    }

    private static void printSummary() {
        System.out.printf("The coffee machine has:\n%d ml of water\n%d ml of milk\n%d g of coffee beans\n%d disposable cups\n$%d of money\n", waterStock, milkStock, coffeeStock, disposableCupStock, money);
    }
}