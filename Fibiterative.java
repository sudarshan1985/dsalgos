package sudarshan.learn.java;

import java.util.Arrays;

class Findfibo {

	final int MAX=100;
	final int NIL=-1;
	int[] lookup = new int[MAX];
	
   //Tabulation  fibannoci number
	int findfib1(int num)
	{
		int[] fibresult = new int[num+1];
		
        if (num <= 1)
        {
        	return 1;
        }
		
        fibresult[0]=0;
        fibresult[1]=1;
        
        for(int i=2;i<=num;i++)
        {
           fibresult[i] = fibresult[i-1]+fibresult[i-2];
        }      
      
		return fibresult[num];
	}

 
   //Recursive function
   int findfib2(int num)
   {
	  if (num <= 1)
		  return num;
	  
	  return findfib2(num-1) + findfib2(num-2);
	   
   }
 
   
   //Recursive with Dynamic programming- using lookup to avoid additional recursions.
   
   /* Function to initialize NIL values in lookup table */
   void _initialize()
   {
	   Arrays.fill(lookup, -1);
   }
   
   
   int findfib3(int num)
   {
	   
	      
       if(lookup[num] == NIL)
       {
    	
    	   if(num <=1)
    	   {
    		   lookup[num]=num;
    	   }
    	   else
    	   {  		 
    	   lookup[num] = findfib3(num-1)+findfib3(num-2);
    	   }
       }
       
       return lookup[num];
             
	   
   }
      
   
 }
 
 public class Fibiterative {
	
	 public static void main(String args[])
	 {
		 Findfibo find = new Findfibo();
		 
		 //Tabulated call
		 long start1 = System.nanoTime();
		 System.out.println("result is"+find.findfib1(40));
		 long end1 = System.nanoTime();      
	     System.out.println("Elapsed Time in nano seconds for iterative method: "+ (end1-start1));  
		 
		 //Recursive call
	     start1 = System.nanoTime();
		 System.out.println("result is"+find.findfib2(40));
		 end1 = System.nanoTime();      
	     System.out.println("Elapsed Time in nano seconds for recursive method: "+ (end1-start1));  
		 
		 //Recursive with dynamic programming
	     start1 = System.nanoTime();
		 find._initialize();
		 System.out.println("result is"+find.findfib3(40));
		 end1 = System.nanoTime(); 
		 System.out.println("Elapsed Time in nano seconds for recursive+dynamic programming method: "+ (end1-start1));  
		 	 
	 }
   
 }
