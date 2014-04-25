package javaeetutorial.compositecomponentexample;

import java.io.Serializable;
import java.math.BigInteger;
import javax.enterprise.inject.Model;
import javax.validation.constraints.Size;

@Model
public class PrimeBean implements Serializable {

	private static final long serialVersionUID = -50939649434906127L;
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private static int[] primes;
	@Size(min = 1, max = 45)
	private String name;
	private boolean prime;
	private String response;
	private int totalSum;

	/**
	 * Creates a new instance of PrimeBean
	 */
	public PrimeBean() {
		setPrimes();
	}

	/**
	 * Sum up the letter values, then determine if the sum is prime.
	 *
	 * @return String the index page
	 */
	public String calculate() {
		int sum = 0;

		for (char c : name.toCharArray()) {
			String letter = String.valueOf(c).toLowerCase();

			if (ALPHABET.contains(letter)) {
				int letVal = ALPHABET.indexOf(letter) + 1;
				sum += letVal;
			}
		}

		prime = false;

		if (sum == 0) {
			response = "String contains no letters";
		} else if (sum % 2 == 0 && sum != 2) {
			response = "Sum of letters is not prime";
		} else if (sum % 3 == 0 && sum != 3) {
			response = "Sum of letters is not prime";

		} else {
			for (int p : primes) {
				if (sum == p) {
					prime = true;
					break;
				}
			}

			if (prime) {
				response = "Sum of letters is prime";
			} else {
				response = "Sum of letters is not prime";
			}
		}

		totalSum = sum;
		return "index";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPrime() {
		return prime;
	}

	public void setPrime(boolean prime) {
		this.prime = prime;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}

	public int[] getPrimes() {
		return primes;
	}

	/**
	 * Creates an array of all primes up through 1171 (one greater than the sum of
	 * 45 Z's, since the maximum string length is 45)
	 */
	public static void setPrimes() {
		primes = new int[194];
		BigInteger i = new BigInteger("1"), lastNum = new BigInteger("1171");
		int count = 0;

		do {
			primes[count] = i.intValue();
			i = i.nextProbablePrime();
			count++;

		} while (i.compareTo(lastNum) <= 0x0);
	}
}
