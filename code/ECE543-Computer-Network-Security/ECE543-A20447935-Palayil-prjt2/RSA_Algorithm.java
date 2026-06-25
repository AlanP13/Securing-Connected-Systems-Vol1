/*
 * RSA Algorithm for Project 2. 
 * Execute the program using Main.java.
*/
import java.math.BigInteger;
public class RSA_Algorithm {
  final BigInteger One = new BigInteger("1");
  public void keygen(String primeOne, String primeTwo) {
    BigInteger p = new BigInteger(primeOne);
    BigInteger q = new BigInteger(primeTwo);
    BigInteger n = p.multiply(q);
    //Calculate f(n)
    BigInteger phi = p.subtract(One).multiply(q.subtract(One));
    //Public Key Value
    BigInteger e = new BigInteger("65537");
    //Private Key Value
    BigInteger d = e.modInverse(phi);
    System.out.println("Public Key (n, e): (" + n + ", " + e + ")");
    System.out.println("Private Key (n, d): (" + n + ", " + d + ")");
  }
  public String encrypt(String nIn, String eIn, String cIn) {    
    BigInteger n = new BigInteger(nIn);
    BigInteger e = new BigInteger(eIn);
    BigInteger c = new BigInteger(cIn);
    BigInteger cipher = c.pow(e.intValue()).mod(n);
    System.out.println("Encrypted message: " + cipher);
    return cipher.toString();
  }
  public String decrypt(String nIn, String dIn, String mIn) {
    BigInteger n = new BigInteger(nIn);
    BigInteger d = new BigInteger(dIn);
    BigInteger m = new BigInteger(mIn);
    BigInteger plaintext = m.pow(d.intValue()).mod(n);
    System.out.println("Decrypted message: " + plaintext);
    return plaintext.toString();
  }
}