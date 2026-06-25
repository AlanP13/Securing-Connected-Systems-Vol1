/*
 * User Interface for Project 2. 
 * Execute the program using Main.java.
*/
import java.util.Scanner;
import java.math.*;

public class User_Interface {
    private boolean maintain = true;
    private static Prime_Numbers prime = new Prime_Numbers();
    private static RSA_Algorithm rsa = new RSA_Algorithm();
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (maintain) {
            System.out.println("Choose an operation: [Enter the number]");
            System.out.println("1. Check Prime No.");
            System.out.println("2. Check Primegen no. of bits");
            System.out.println("3. Generate Key of Two Primes");
            System.out.println("4. Encrypt 'n' 'e' 'c'");
            System.out.println("5. Decrypt 'n' 'd' 'm'");
            System.out.println("6. Quit");
            System.out.println("\nEnter the operation you wish");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    String[] answer = scanner.nextLine().split(" ");
                    try	{
                        BigInteger num = new BigInteger(answer[1]);
                        System.out.println(prime.primecheck(num));
                    }
                    catch(Exception e)	{
                        System.out.println("Missing values");
                    }
                    break;
                case 2:
                    try	{
                        System.out.println("Enter the number of bits:");
                        int bits = scanner.nextInt();
                        BigInteger generatedPrime = prime.primegen(bits);
                        System.out.println("Generated prime number: " + generatedPrime);
                    }
                    catch(Exception e)	{
                        System.out.println("Missing values");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Enter two prime numbers (separated by space):");
                        String primeOne = scanner.next();
                        String primeTwo = scanner.next();
                        rsa.keygen(primeOne, primeTwo);
                    }
                    catch(Exception e)	{
                        System.out.println("Missing values");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Enter the values n, e, and c (separated by space):");
                        String n = scanner.next();
                        String e = scanner.next();
                        String c = scanner.next();
                        rsa.encrypt(n, e, c);
                    }    
                    catch(Exception e)	{
                        System.out.println("Missing values");
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Enter the values n, d, and m (separated by space):");
                        String n = scanner.next();
                        String d = scanner.next();
                        String m = scanner.next();
                        rsa.decrypt(n, d, m);
                    }
                    catch(Exception e)	{
                        System.out.println("Missing values");
                    }
                    break;
                case 6:
                    maintain = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");       
            }  
        }
        scanner.close();
    }
}
