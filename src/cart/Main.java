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

        case "add":
          // add apple orange pear
          // check if add has any items

          // loop to add more then 1 item. e.g. add apple orange pear grape
          for (Integer i = 0; i < terms.length; i++) {

            // to skip the "add" word
            if (terms[i].equalsIgnoreCase("add")) {
              continue;

            } else {
              if (cart.contains(terms[i])) {
                // check if item already in cart
                System.out.printf("%s is already in cart \n", terms[i]);
                continue;

              }
              // else add item to cart
              cart.add(terms[i]);
              System.out.printf("Added %s to cart\n", terms[i]);
            }
          }

          // to add 1 item only
          // cart.add(terms[1]);
          // System.out.printf("Added %s to cart\n", terms[1]);

          break;

        case "delete":
          // delete has any number and if number is vaild
          if ((Integer.parseInt(terms[1]) <= 0) || (Integer.parseInt(terms[1]) > cart.size())) {
            System.out.println("Incorrect item index");

          } else {
            Integer i = Integer.parseInt(terms[1]) - 1;
            String itemRemoved = cart.remove(i.intValue());
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
