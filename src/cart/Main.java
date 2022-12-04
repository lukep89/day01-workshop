package cart;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> cart = new LinkedList<>();

    Console cons = System.console();
    Boolean stop = false;

    while (!stop) {
      String line = cons.readLine("> ");
      // command line delimited by space
      line = line.trim();
      // add apple => ["add" , "apple"]
      // list => ["list"]
      String[] terms = line.split(" ");

      // to check with term used
      System.out.printf("Command: %s\n", terms[0]);

      switch (terms[0].toLowerCase()) {

        case "list":
          if (cart.size() <= 0) {
            System.out.println("your cart is empty");
          } else {
            for (Integer i = 0; i < cart.size(); i++) {
              System.out.printf("%d. %s\n", i + 1, cart.get(i));
            }
          }
          break;

        case "add": // add apple orange pear
          // check if add has any items

          // if ((terms[1]).length() == 0) {
          // System.out.println("Nothing was added to list");
          // } else {
          cart.add(terms[1]);
          System.out.printf("Added %s to cart\n", terms[1]);
          // }

          break;

        case "delete":
          // delete has any number and if number is vaild
          if ((Integer.parseInt(terms[1]) < 0) || (Integer.parseInt(terms[1]) > cart.size())) {
            System.out.println("Entered wrong item number");
          } else {
            Integer i = Integer.parseInt(terms[1]) - 1;
            String itemRemoved = cart.remove((int) i);
            System.out.printf("%s was removed from cart\n", itemRemoved);
          }
          break;

        case "exit":
          stop = true;
          break;

        default:
          System.out.printf("Unknow command %s\n", terms[0]);
      }

    }
    System.out.println("Thank you for shopping\n");

  }

}