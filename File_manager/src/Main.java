import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        FileManager fileManager = new FileManager();
        Scanner input = new Scanner(System.in);
        File myFile = null;



        while (true){
            System.out.println("Enter option from 1-9:");
            System.out.println("Enter 'exit' to EXIT");
            System.out.println("Enter '1' to CREATE FILE");
            System.out.println("Enter '2' to WRITE NUMBERS TO FILE");

            String choice = input.next();

            if (choice.equals("exit") ){
                break;
            }
            // CREATING FILE ---------------------------------------------------------------------
            else if (choice.equals("1")) {
                while (true){
                    System.out.println("Enter 'exit' to EXIT");
                    System.out.println("or NAME your file");

                    String fileName = input.next();

                    if (fileName.equals("exit") ) {
                        break;
                    }
                    else {
                        myFile = fileManager.createFile(fileName);
                    }
                }
            }

            else if (choice.equals("2")) {
                while (true){
                    System.out.println("Enter 'exit' to EXIT");
                    System.out.println("or ENTER your numbers");

                     String data = input.next();

                     if (data.equals("exit")){
                         break;
                     }
                     else{
                         while (true){
                             if (FileManager.isNumeric(data)){
                                 fileManager.writeToFile(myFile, Integer.parseInt(data));
                                 break;
                             }
                             else {
                                 System.out.println("Enter NUMBER not a string");
                             }
                             data = input.next();
                         }
                     }
                }
            }
        }
    }
}