import java.util.Scanner;

public class BT1_Eratosthenes 
{ 
	public void Eratosthenes(int n) 
	{ 
        //create a boolean array with value is "true"
        //if any index of array is true, that index is a prime number
		boolean prime[] = new boolean[n+1]; 
		for(int i=0;i<=n;i++) 
			prime[i] = true; 
		
		for(int p = 2; p*p <=n; p++) 
		{
			if(prime[p] == true) 
			{ 
				//It is not prime number
				for(int i = p*p; i <= n; i += p) 
					prime[i] = false; 
			} 
		} 
		
		// Print all prime numbers 
		for(int i = 2; i <= n; i++) 
		{ 
			if(prime[i] == true) 
				System.out.print(i + " "); 
		} 
	} 
	
	
	public static void main(String args[]) 
	{ 
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input number: ");
		int num = scan.nextInt();
		System.out.println("The prime numbers smaller than or equal to " + num + " are: "); 
		BT1_Eratosthenes g = new BT1_Eratosthenes(); 
		g.Eratosthenes(num);
		
	} 
} 
