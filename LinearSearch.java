package searchalgo;

//This is a linear serach and runs a linear time on the worst case O(n)
public class LinearSearch {

	int findIndex(int[] array,int num)
	{
		for(int i=0;i<array.length;i++)
		{
			if(array[i] == num)
				return i;
		}
		
		return -1;
	}
	
}
