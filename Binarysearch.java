package searchalgo;

//This is a binary search and the array is expected to be in a sorted order	O(logn)
public class Binarysearch {

	int findIndex(int[] array,int num)
	{
	  
	  //Just do the base case to avoid confusion
	  if(array.length==1)
	  {
		 if (num == array[0])
	       return 0;
		 else
		   return -1;
	  }
	  
      // Start of the actual logic 
	  int start = 0;    //start from here
	  int end  = array.length-1; //end of the array
	  
	  //Go from start to end, but change start and end based on mid point value
	  for(int i=start;i<end;i++)
	  {
		  int mid=(start+end)/2;
			  
		  if(array[mid]==num)
		  {
			  return mid;
		  }
		  else if(array[mid]<num)
		  {
			  start = mid+1;
		  }
		  else
		  {
			  end = mid-1;
		  }
	  
	  }
	
	  
	   return -1;  //Binary search was unsuccessful. 
	}
	

	int findIndexRecurse(int[] array,int num,int start,int end)
	{
	   
	  if(end>=start)
	  {	 
	   int mid = (start+end)/2;
	   if (array[mid]==num) {
		   return mid;
	   }
	   
	   else if(array[mid]<num)
	   {
		 return findIndexRecurse(array,num,mid+1,end); 
	   }
	   else
	   {
		 return findIndexRecurse(array,num,start,mid-1); 
	   }
	  }
	 	  return -1;
	}
	
}
