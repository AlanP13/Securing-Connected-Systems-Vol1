/*
 * ECE-543 Project 2: Implement RSA Algorithm
 * Execute this file first.
 * After running the test cases for each method, the program's menu will display the available functions and their syntax.
*/
import java.math.*;

public class RSA_Main {
  private static Prime_Numbers prime = new Prime_Numbers();
  private static RSA_Algorithm rsa = new RSA_Algorithm();
  private static User_Interface ui = new User_Interface();

  public static void main(String args[]) {
    runTestCases();
    ui.run();
  }

  public static void runTestCases() {
    testPrimecheck();
    testPrimegen();
    testKeygen();
    testEncrypt();
    testDecrypt();
  }

  public static void testPrimecheck() {
    System.out.println("------Primecheck Test Cases------");
    BigInteger bigInt = new BigInteger("32401");
    System.out.println("primecheck " + bigInt);
    System.out.println(prime.primecheck(bigInt));
    bigInt = new BigInteger("3244568");
    System.out.println("primecheck " + bigInt);
    System.out.println(prime.primecheck(bigInt));
    //Possible additional primegen test cases here
    System.out.println("------End Primecheck Test Cases------\n");
    }

  public static void testPrimegen() {
    System.out.println("------Primegen Test Cases------");
    int bits = 1024;
    System.out.println("primegen " + bits);
    BigInteger gen = prime.primegen(bits);
    System.out.println("primecheck " + gen);
    System.out.println(prime.primecheck(gen));
    //Possible additional primegen test cases here
    System.out.println("------End Primegen Test Cases------\n");
  }

  public static void testKeygen() {
    System.out.println("------Keygen Test Cases------");
    String primeOne = "127";
    String primeTwo = "131";
    System.out.println("keygen " + primeOne + " " + primeTwo);
    rsa.keygen(primeOne, primeTwo);
    // Additional keygen test cases here
    primeOne = "1019";
    primeTwo = "1021";
    System.out.println("keygen " + primeOne + " " + primeTwo);
    rsa.keygen(primeOne, primeTwo);
    primeOne = "1093";
    primeTwo = "1097";
    System.out.println("keygen " + primeOne + " " + primeTwo);
    rsa.keygen(primeOne, primeTwo);
    primeOne = "433";
    primeTwo = "499";
    System.out.println("keygen " + primeOne + " " + primeTwo);
    rsa.keygen(primeOne, primeTwo);
    primeOne = "1061";
    primeTwo = "1063";
    System.out.println("keygen " + primeOne + " " + primeTwo);
    rsa.keygen(primeOne, primeTwo);
    primeOne = "1217";
    primeTwo = "1201";
    System.out.println("keygen " + primeOne + " " + primeTwo);
    rsa.keygen(primeOne, primeTwo);
    primeOne = "313";
    primeTwo = "337";
    System.out.println("keygen " + primeOne + " " + primeTwo);
    rsa.keygen(primeOne, primeTwo);
    primeOne = "419";
    primeTwo = "463";
    System.out.println("keygen " + primeOne + " " + primeTwo);
    rsa.keygen(primeOne, primeTwo);
    System.out.println("------End Keygen Test Cases------\n");
  }

  public static void testEncrypt() {
    System.out.println("------Encrypt Test Cases------");
    String n = "16637";
    String e = "11";
    String c = "20";
    System.out.println("encrypt " + n + " " + e + " " + c);
    rsa.encrypt(n, e, c);
    // Additional encrypt test cases here
    n = "1040399";
    e = "7";
    c = "99";
    System.out.println("encrypt " + n + " " + e + " " + c);
    rsa.encrypt(n, e, c);
    n = "1199021";
    e = "5";
    c = "70";
    System.out.println("encrypt " + n + " " + e + " " + c);
    rsa.encrypt(n, e, c);
    n = "216067";
    e = "5";
    c = "89";
    System.out.println("encrypt " + n + " " + e + " " + c);
    rsa.encrypt(n, e, c);
    n = "1127843";
    e = "7";
    c = "98";
    System.out.println("encrypt " + n + " " + e + " " + c);
    rsa.encrypt(n, e, c);
    n = "1461617";
    e = "7";
    c = "113";
    System.out.println("encrypt " + n + " " + e + " " + c);
    rsa.encrypt(n, e, c);
    n = "105481";
    e = "5";
    c = "105";
    System.out.println("encrypt " + n + " " + e + " " + c);
    rsa.encrypt(n, e, c);
    n = "193997";
    e = "5";
    c = "85";
    System.out.println("encrypt " + n + " " + e + " " + c);
    rsa.encrypt(n, e, c);
    System.out.println("------End Encrypt Test Cases------\n");
  }

  public static void testDecrypt() {
    System.out.println("------ decrypt test cases ------");
    String n = "16637";
    String d = "14891";
    String m = "12046";
    System.out.println("decrypt " + n + " " + d + " " + m);
    rsa.decrypt(n, d, m);
    // Additional decrypt test cases here
    n = "1040399";
    d = "890023";
    m = "16560";
    System.out.println("decrypt " + n + " " + d + " " + m);
    rsa.decrypt(n, d, m);
    n = "1199021";
    d = "478733";
    m = "901767";
    System.out.println("decrypt " + n + " " + d + " " + m);
    rsa.decrypt(n, d, m);
    n = "216067";
    d = "172109";
    m = "169487";
    System.out.println("decrypt " + n + " " + d + " " + m);
    rsa.decrypt(n, d, m);
    n = "1127843";
    d = "964903";
    m = "539710";
    System.out.println("decrypt " + n + " " + d + " " + m);
    rsa.decrypt(n, d, m);
    n = "1461617";
    d = "1250743";
    m = "93069";
    System.out.println("decrypt " + n + " " + d + " " + m);
    rsa.decrypt(n, d, m);
    n = "105481";
    d = "41933";
    m = "78579";
    System.out.println("decrypt " + n + " " + d + " " + m);
    rsa.decrypt(n, d, m);
    n = "193997";
    d = "154493";
    m = "1583";
    System.out.println("decrypt " + n + " " + d + " " + m);
    rsa.decrypt(n, d, m);
    System.out.println("------ end decrypt test cases ------\n");
  }
}