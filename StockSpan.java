package sudarshan.learn.java;
import java.util.Arrays;
import java.util.Stack;

class Span {

   //Creates a new stack
   Stack<Integer> s = new Stack<Integer>();
  
   //The actual function  
   void calculateSpan(int[] price,int[] span)
   {
	   
	   int tempspan=1;
	   	   //Do some base checks
	   if (price.length!=span.length)
	   {
		   System.out.println("Price and span arrays are not of equal length---exiting");
		   return;
	   }
	  
	   //If the array input just had 1 element, then the span will be 1 for it, and exit
	   if (price.length == 1)
	   {
		   span[0]=tempspan;
		   return;
	   }
	   
	   //The first element is always going to have 1 as the span
	   span[0] = tempspan;
	   //Push that element in
	   s.push(price[0]);
	   
	   //Now iterate through every single price array element and start inserting the span values
	   for(int i=1;i<price.length;i++)
	   {
		   //Until the stack is not empty, and the last value is less or equal to ith price
		   Stack<Integer> temp = (Stack<Integer>)s.clone();
		   while(!temp.empty() && temp.peek() <= price[i])
		   {
			   //increment span and pop
			   tempspan++;
			   temp.pop();
		   }
		   
		   
		   //Now add the span value .
		   span[i] = tempspan;
		   tempspan = 1;
		   
		   //Push the current element to the stack
		   s.push(price[i]);
			   
	   }
	   
   } 
   
// A utility function to print elements of array
   static void printArray(int arr[])
   {
       System.out.print(Arrays.toString(arr));
   }
	
}

public class StockSpan 
{
 
 public static void main(String args[]) { 
	 
  Span cs = new Span();
 //Price of stock 
  int[] price = {100,80,60,70,60,75,85};
  
  //Have an empty array for the stock span values
  int[] span  = new int[price.length];
  
   
  cs.calculateSpan(price, span);

  Span.printArray(price);
  System.out.println();
  Span.printArray(span);

	
  
}
 
}

