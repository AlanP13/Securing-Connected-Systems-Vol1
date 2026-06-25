/*
 * Prime Number Check for Project 2. 
 * Execute the program using Main.java.
*/
import java.math.BigInteger;
import java.util.Random;
public class Prime_Numbers {
  final BigInteger One = new BigInteger("1");
  public boolean primecheck(BigInteger check) {
    if (check.compareTo(One) <= 0)
        return false;
    if (check.compareTo(new BigInteger("3")) <= 0)
        return true;
    if (check.mod(new BigInteger("2")).equals(BigInteger.ZERO))
        return false;
    // Compute s and t such that check-1 = 2^s * t
    BigInteger t = check.subtract(BigInteger.ONE);
    int s = 0;
    while (t.mod(new BigInteger("2")).equals(BigInteger.ZERO)) {
        t = t.divide(new BigInteger("2"));
        s++;
    }
    // Repeat k times
    for (int k = 0; k < 100; k++) {
        BigInteger a = getRandomBase(check.subtract(BigInteger.ONE));
        BigInteger v = a.modPow(t, check);
        if (!v.equals(BigInteger.ONE)) {
            int i = 0;
            while (!v.equals(check.subtract(BigInteger.ONE))) {
                if (++i == s || v.modPow(new BigInteger("2"), check).equals(BigInteger.ONE))
                    return false;
                v = v.modPow(new BigInteger("2"), check);
            }
        }
    }
    return true;
  }
  public BigInteger primegen(int bits) {
    Random rand = new Random();
    BigInteger prime = BigInteger.ZERO;
    while (!prime.isProbablePrime(100)) {
        BigInteger maxVal = BigInteger.ONE.shiftLeft(bits).subtract(BigInteger.ONE);
        prime = new BigInteger(bits, rand);
        prime = prime.or(BigInteger.ONE.shiftLeft(bits - 1));
        prime = prime.or(BigInteger.ONE);
        while (prime.compareTo(maxVal) > 0) {
            prime = new BigInteger(bits, rand);
            prime = prime.or(BigInteger.ONE.shiftLeft(bits - 1));
            prime = prime.or(BigInteger.ONE);
        }
      }
    return prime;
  }
  private BigInteger getRandomBase(BigInteger n) {
    Random rand = new Random();
    BigInteger result = new BigInteger(n.bitLength(), rand);
    while (result.compareTo(n) >= 0) {
        result = new BigInteger(n.bitLength(), rand);
    }
    return result;
  } 
}