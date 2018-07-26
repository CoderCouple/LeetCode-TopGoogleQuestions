package TopGoogleQuestions;

/**
 *
 Given a nested list of integers, implement an iterator to flatten it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Given the list [[1,1],2,[1,1]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

 Example 2:
 Given the list [1,[4,[6]]],

 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 *
 * **/

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedListIterator implements Iterator<Integer> {
    List<NestedInteger> nestedList;
    Stack<NestedInteger> nestedListStack;
    public NestedListIterator(List<NestedInteger> nestedList) {
        this.nestedList=nestedList;
        nestedListStack = new Stack<NestedInteger>();
        for(int i=nestedList.size()-1;i>=0;i--)
            nestedListStack.push(nestedList.get(i));
        flattenList();
    }

    @Override
    public Integer next() {
        int val=nestedListStack.pop().getInteger();
        flattenList();
        return val;
    }

    @Override
    public boolean hasNext() {
        return !nestedListStack.isEmpty();
    }

    public void flattenList(){
        while(!nestedListStack.isEmpty() && !nestedListStack.peek().isInteger()){
            List<NestedInteger> curr= nestedListStack.pop().getList();
            for(int i=curr.size()-1;i>=0;i--)
                nestedListStack.push(curr.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
