package im.dhf.leetcode.p155;

/**
 * not thread safe
 */
public class MinStack {
    private Node top = null;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        Node node = new Node();
        node.value = x;
        node.previous = top;
        if (null != top && x > top.min) {
            node.min = top.min;
        } else {
            node.min = x;
        }
        top = node;
    }

    public void pop() {
        if (null == top) {
            return;
        }
        if (null == top.previous) {
            top = null;
            return;
        }

        top = top.previous;
    }

    public int top() {
        if (null == top) {
            throw new IllegalStateException();
        }
        return top.value;
    }

    public int getMin() {
        if (null == top) {
            throw new IllegalStateException();
        }
        return top.min;
    }

    static class Node {
        int value;
        int min;
        Node previous;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
