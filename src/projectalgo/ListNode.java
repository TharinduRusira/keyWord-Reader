
package projectalgo;

/**
 *
 * @author M.P.T.R.Kumara 100277E
 * 
 * each node represents a keyword and a page which has the given keyword.
 * The name ListNode is given due to its connection with class LinkedList
 * 
 */
public class ListNode {
    private int page;// page number
    private String keyWord;// keyword
    ListNode next;// links this node to the next node 
    
    public ListNode(int number,String data){ // constructor to initialize
        this.page=number;
        this.keyWord=data;
        
    }
    
    public int getPage(){ // get page number
        return page;
    }
    public String getKeyword(){  // get keyword
        return keyWord;
    }
    public ListNode getNext(){
        return next;
    }

    
}
