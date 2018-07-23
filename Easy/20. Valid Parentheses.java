package TopGoogleQuestions;
/*
*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*
* */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Map<Character,Character> openingToClosingMap = new HashMap<Character,Character>();
        openingToClosingMap.put('(',')');
        openingToClosingMap.put('[',']');
        openingToClosingMap.put('{','}');

        Map<Character,Character> closingToOpeningMap = new HashMap<Character,Character>();
        closingToOpeningMap.put(')','(');
        closingToOpeningMap.put(']','[');
        closingToOpeningMap.put('}', '{');

        Stack<Character> stack = new Stack<Character>();

        for(char c : s.toCharArray()){
            if(openingToClosingMap.containsKey(c)){
                stack.push(c);
            } else{
                if(stack.isEmpty())
                    return false;
                char bracketType = closingToOpeningMap.get(c);
                if(bracketType!=stack.peek())
                    return false;
                stack.pop();
            }
        }

        if(!stack.isEmpty())
            return false;

        return true;
    }
}
