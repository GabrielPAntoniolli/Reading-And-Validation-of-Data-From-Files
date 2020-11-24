
package javaapplication28;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Gabriel Pereira Antoniolli - 2020352
 */
public class Gabriel_Antoniolli_CA_OOP_2020352 {

    
    public static void main(String[] args) {
        // TODO code application logic here
        String File = "people3.txt"; // Reading from this file
        String destinationFile = "output_Document.txt"; // outputing to this file
        try { //when reading from a file all the code has to be inside a try-catch, and its good for error situations as well.

            Scanner myReader = new Scanner(new FileReader(File));
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(destinationFile));
            while (myReader.hasNext()) { // this while loop is reponsible for making my code read all the document not only the first informations.
                int Age = -1; /* i set the age variable to -1 because the assigment asks for an age between 0 and 100, 
                               * so if my code haven't read the age input it would keep going without being catch in my conditions.
                               */
                String Name, Surname, Gender, Status = null;//status has to be set "null" because its only initialized in a condition.
                char firstInitial;

                Name = myReader.next();
                Name = Name.trim();

                Surname = myReader.nextLine(); /* there is no need to use the method .trim() in the surname because the assigment specifies 
                                                  that the surname is everything after the first space. */
               

                if (!Name.matches("[A-Za-z]+")) { //i want an imput with letters only
                    System.out.println("please the name must include text only");
                }
                firstInitial = Name.charAt(0); //after reading the name, i can take only the first letter and save it using this method.

                if (!Surname.matches("^[a-zA-Z\\s]*$")) { /* this regex, different from the first one for the name, accepts space between the letter.
                                                             this way, if the user has more than one surname it will read both.*/
                    System.out.println("please the surname must include text only");

                }

                Age = myReader.nextInt();

                if (Age == -1) {//if the age keeps the same is because the user havent inserted a number for age.
                    System.out.println("The age wasn't detected in the document, please insert an age!");
                } else if ((Age > 100) || (Age < 0)) //condition given at the CA for age
                {
                    System.out.println("Sorry the age must be a number between 0 - 100"); // in case the age fill the condition
                } else {
                    if (Age <= 18) { // assigning the status depending on the respective imput.
                        Status = "School";
                    } else if ((Age >= 19) && (Age <= 25)) {
                        Status = "College";
                    } else if ((Age >= 26) && (Age <= 66)) {
                        Status = "Worker";
                    } else {
                        Status = "Retired";
                    }
                }
                
                myReader.nextLine(); // its necessary to jump the line because in the previous block it was only looking for integers.
                Gender = myReader.nextLine();
                Gender = Gender.trim();
                Gender = Gender.toUpperCase(); // Using the method .toUpperCase() i made sure that the input wont be case sensetive.

                switch (Gender) { //assigning the correct title to the respective gendern and writing it to the document.
                    case "M":
                        myWriter.write("Mr. ");
                        break;
                    case "T":
                        myWriter.write("Mx. ");
                        break;
                    case "F":
                        myWriter.write("Ms. ");
                        break;
                    default:
                        System.out.println("Please Insert only M, T or F to define gender");
                }
                myWriter.write(Surname + ", " + firstInitial + "\n" + Status + "\n"); // here i made the correct output structure, and write it to the output document.
            }
            myWriter.close(); //Saving my output writing.
        } catch (Exception e) { // in case of failure of any of my conditions above.
            System.out.println("Sorry, Invalid Data, Please make sure that the informations are in order");
        }

    }

}
