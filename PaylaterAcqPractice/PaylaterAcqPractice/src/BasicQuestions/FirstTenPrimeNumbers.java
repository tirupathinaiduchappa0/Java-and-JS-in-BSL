package BasicQuestions;

public class FirstTenPrimeNumbers {
	//“If no number from 2 to √n divides n, then n is prime.”
	public static boolean isPrime(int n) {
		for (int i = 2; i*i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int count =0;
		int number =2;
		
		while(count< 10) {
			if( isPrime(number)) {
				System.out.println(number);
				count++;
			}
			number++;
		}
	}
}
