/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> s = new Stack<>();
    NestedInteger nextel = null;
    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList != null) {
            s.push(nestedList.iterator());
        }
    }

    @Override
    public Integer next() {
        return nextel.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!s.isEmpty()) {
            if (!s.peek().hasNext()) {
                s.pop();
            } else if ((nextel = s.peek().next()).isInteger()) {
                return true;
            } else{
                s.push(nextel.getList().iterator());
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
