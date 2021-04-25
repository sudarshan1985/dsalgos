package searchalgo;

import java.lang.reflect.Array;

public class Searchdriver {
	
	public static void main(String args[])
	{
		int[] question = new int[10000];
		//Just a iterative function to store 1M numbers in an array
		for(int i=0;i<question.length;i++)
		{
		  question[i]=i;			
		}
		
		LinearSearch ln = new LinearSearch();
		long start = System.nanoTime();
		System.out.println("linear searching:"+ln.findIndex(question,9999));
		long end = System.nanoTime();
		System.out.println("Elap time for linear searching:"+ (end-start));

		
		
		Binarysearch bn = new Binarysearch();
		start = System.nanoTime();
		System.out.println("binary searching:"+bn.findIndex(question,9999));
		end = System.nanoTime();
		System.out.println("Elap time for binary searching:"+ (end-start));
		
		
		start = System.nanoTime();
		System.out.println("binary searching recursive:"+bn.findIndexRecurse(question,9999,0,question.length-1));
		end = System.nanoTime();
		System.out.println("Elap time for binary searching recursive:"+ (end-start));
		
		
	}
	

}
