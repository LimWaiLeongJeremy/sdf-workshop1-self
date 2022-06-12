package shop;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.crypto.AEADBadTagException;
import javax.lang.model.util.ElementScanner14;
import javax.sql.rowset.CachedRowSet;

public class App 
{
    public static void main( String[] args ) {
        
        List<String> cart = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        int index;
        boolean stop = false;
        
        System.out.println( "welcome to your cart !" );
        
        while(!stop){

            String command = input.nextLine();
            String[] terms = command.split(" ");
            String cmd = terms[0];

            switch(cmd) {
                case "list" :
                    if (cart.size() > 0) {
                        for (int i = 0; i < cart.size(); i++) {
                            System.out.printf("%d. %s\n", (i+1),cart.get(i));
                        }
                    }else{ System.out.println("Cart is empty");}
                break;
                
                
                case "add":
                    String fruitInput = terms[1];
                    String fruitReplace = fruitInput.replace(",", " ");
                    String[] fruit = fruitReplace.split(" ");

                    for (int i = 0; i < fruit.length; i++) {
                       boolean found = false;
                       for (int j = 0; j < cart.size(); j++) {
                            if (fruit[i].toUpperCase().equals(cart.get(j).toUpperCase())) {
                                found = true; 
                                System.out.println("Item already have la");
                                break;
                            }
                        }
                    
                        if (!found) {
                            cart.add(fruit[i]);
                            System.out.println("Item add le");
                        }
                    }  
                break;
                 

                case "delete":
                    int delIndex = Integer.parseInt(terms[1])-1;
                    if (delIndex <= 0 && delIndex > cart.size()) {
                        System.out.println("nmo go");
                    }else {cart.remove(delIndex);}

                break;
                

                case "end":
                    stop = true;
                    System.out.println("end");
                break;
                
            }
        }
        System.out.println("thank you");

    }

}
