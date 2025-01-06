public class Delete_NnodesafterM_LinkedList {
    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    static void linkdelete(Node head, int n, int m) {
        // your code here
        Node curr = head;
        Node prev = null;
        int skip = m;
        int delete = n;
        
        while (curr != null) {
            while (m != 0 && curr!= null) {
                prev = curr;
                curr = curr.next;
                m--;
            }
            
            while (n != 0 && curr != null) {
                curr = curr.next;
                n--;
            }
            
            prev.next = curr;
            m = skip;
            n = delete;
        }
    }
}
