

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  static ArrayList<String> list = new ArrayList<>(); //list outside of main so it works with displayList
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        final String menu = "A: Add D: Delete P: Print Q:quit";
        boolean done = false;
        String cmd = " ";
        String addItem = "";
        int itemToDel = 0;



        do{
        //display menu, get menu choice, execute choice
            displayList();
            cmd =SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            switch(cmd)
            {
                case "A":
                    addItem = SafeInput.getNonZeroLenString(console, "Add an item to the list: ");
                    list.add(addItem);
                    break;
                case "D":
                    System.out.println("Delete an item from the list");
                    itemToDel = SafeInput.getInt(console, "Enter the number of the item you want to remove");

                    // Adjust the index to make it 0-based
                    int adjustedIndex = itemToDel - 1;

                    if (adjustedIndex >= 0 && adjustedIndex < list.size()) {
                        list.remove(adjustedIndex);
                    } else {
                        System.out.println("Invalid index. Please enter a valid index.");
                    }
                    break;
                case "P":
                    System.out.println();
                    System.out.println("Printing your list");
                    for(String f  : list)
                    {
                        System.out.println(f);
                    }
                    break;
                case "Q":
                    System.exit(0);
                    break;
            }



        }while (!done);


    }

    private static void displayList() {

        System.out.println("***");
        if(!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%3d%5s", i + 1, list.get(i));
            }
        }
        else
            System.out.println("****                List is empty              ****");
        System.out.println("***");


    }
}