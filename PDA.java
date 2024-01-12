import java.util.*;

/**
 * Permissible Dating Age program
 *
 * @author Mr. Jaffe
 * @version 2021-06-22 Version 1.0.0
 */
public class PDA
{

    /**
     * Constructor for objects of class PDA
     */
    public PDA()
    {
        // We don't need to do anything in the constructor for
        // our program.
    }
    Scanner scanner = new Scanner(System.in);
    int age = 0;
    int LOWER_BOUND = 18;
    int youngestAge;
    int oldestAge;
    boolean shouldContinue = true;
    public void getYoungerAge() {
        youngestAge = (int) Math.round((age/2)+ 7); // computes young age whilst cutting off decimal
    }

    public void getOlderAge() {
        oldestAge = (int) Math.round((age-7)*2);
    }

    /**
     * This is the main event loop for our PDA program
     */
    public void runEventLoop() {
        while (shouldContinue == true) { //while loop while these condition met..
            System.out.println("How old are you?"); // first line of output default
            try { // when there are exception/things that don't follow the requirements in the code, sends to catch. "catches input errors"
                age = scanner.nextInt();
                if (age == 0) { // If the users inputs 0, program quits refer step 7
                    System.out.println("quitting PDA program");
                    shouldContinue = false;
                }
                if (age < LOWER_BOUND && age !=0) { // most important part of program, refers to
                    System.out.println(age +" is too young to date.");
                } else if (age != 0) {
                    getYoungerAge();
                    getOlderAge();
                    System.out.println("The reasonable age range goes from "+ youngestAge + " to " + oldestAge);
                }

            } catch (InputMismatchException error) { // where everything that isn't valid is directed thanks to try block
                scanner.next();
                System.out.println("Please enter an integer");
            }

        }
    }

    /**
     * The main method instantiates and runs the program
     */
    public static void main (String[] args) {
        PDA pda = new PDA();
        pda.runEventLoop();
    }
}