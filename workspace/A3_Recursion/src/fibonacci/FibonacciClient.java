package fibonacci;

import sun.awt.www.content.audio.x_aiff;

public class FibonacciClient {

	/***********************************************************
	 * returns the result of the Fibonacci sequence of numbers.
	 * @param n the integer n
	 * @throws IllegalArgumentException for negative numbers.
	 * *********************************************************/
	public static int fib(int n) {
		String str = "Number cannot be a negative! n = ";
		int[] a = new int[n+1];
		
		if(n < 0) {
			throw new IllegalArgumentException(str + n);
			
		}else if (n == 0 ) {
			return 0;
			
		}else if (n == 1) {
			return 1;
			
		}else {
			a[0] = 0;
			a[1] = 1;
			return fib(n,a);
		}
	}
	
	/***********************************************************
	 * returns the fibonacci sequence of numbers, with improved 
	 * efficiency.
	 * @param n the integer n
	 * @throws IllegalArgumentException for negative numbers.
	 * *********************************************************/
	public static int fib(int n, int[] a) {
		if (a[n] == 0) {
			a[n] = fib(n-1,a) + a[n-2];
		}
		return a[n];
	}
	
	/****************************************
	 *   main: runs the program.
	 ****************************************/
	public static void main(String[] args) {
		
		int n = 25;
		System.out.println();
		
		//nth value in fibonacci series
		System.out.println("---- Memoization with " + n + " values -----");
		for (int i = 0; i < n; i++ ) {
			System.out.println(fib(i) + " ");
		}
		System.out.println();

	}

}
