import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String choice;
        boolean running = true;

        while (running) {
            displayMenu();
            choice = SafeInput.getRegExString(in, "Enter your choice: ", "[AaDdIiPpQq]");
            switch (choice.toUpperCase()) {
                case "A":
                    addItem(in);
                    break;
                case "D":
                    deleteItem(in);
                    break;
                case "I":
                    insertItem(in);
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    running = !SafeInput.getYNConfirm(in, "Are you sure you want to quit? ");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem(Scanner in) {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to add");
        list.add(item);
        System.out.println("Item added.");
    }

    private static void deleteItem(Scanner in) {
        printList();
        int index = SafeInput.getRangedInt(in, "Enter the number of the item to delete", 1, list.size()) - 1;
        list.remove(index);
        System.out.println("Item deleted.");
    }

    private static void insertItem(Scanner in) {
        printList();
        int index = SafeInput.getRangedInt(in, "Enter the position to insert the item", 1, list.size() + 1) - 1;
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to insert");
        list.add(index, item);
        System.out.println("Item inserted.");
    }

    private static void printList() {
        System.out.println("\nCurrent List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}
