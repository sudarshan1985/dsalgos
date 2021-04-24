
public class BalanceParanthesis {
  public boolean isValid(String s) throws java.util.EmptyStackException {
    
    //Three types of open bracets
    // ( { [ 
    //Three types of close brackets
    // ) } ]
    
    Stack<Character> bstack = new Stack<Character>();
    
    HashMap<Character,Character> valid = new HashMap<Character,Character>();
    
    //Store the valid mappings of brackets in the hashmap
    valid.put(')','(');
    valid.put('}','{');
    valid.put(']','[');
    
    for(int i=0;i<s.length();i++)
    {
       char c = s.charAt(i);
       //Only value i.e open bracked should be added to the stack.
       if(!(valid.containsKey(c))) {
         
         bstack.push(s.charAt(i));
       }
       else {
         //If you get a key without anything in stack it is bad
         if(valid.containsKey(s.charAt(i)) && bstack.size() >=1)
         {
            try{
               //Pop the stack and see if it has a matching value to key
               if(bstack.pop() != valid.get(s.charAt(i)))
               return false;
               }catch(EmptyStackException e){}
         }
         else
         {
           return false;
         }
       }
    }
    
    //There are still some open brackets without its matching close bracket
    if(!bstack.empty())
       return false;
    
    //Gets here when none of the false cases are satisfied
    return true;
    
  }
}
