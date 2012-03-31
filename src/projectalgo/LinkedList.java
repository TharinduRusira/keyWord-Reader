
package projectalgo;

/**
 *
 * @author M.P.T.R.Kumara 100277E
 * 
 * method search_list is overloaded with different arguments. There are two different forms of the method.
 */


public class LinkedList {
    ListNode head; // first node of the list
   
    

    public ListNode search_list(LinkedList L,String key){
        ListNode x;
        x=L.head;
        
        if(x==null){
            
            return null;
        }
        else if(x.getKeyword().equals(key)){
            
            return x;
        }
        else{
            while(x!=null && !x.getKeyword().equals(key)){
                x=x.getNext();

            }
            return x;
        }
        
    
    }
    
    public ListNode search_list(LinkedList L,int page){
        ListNode x;
        x=L.head;
        while(x!=null && x.getPage()!=page){
            x=x.getNext();
        
        }
        
        return x;
    
    
    }
    
    public void insert_list(LinkedList L,ListNode node){
        node.next=L.head;
        L.head=node;
        
        
    }
    
    public void delete(LinkedList L,ListNode x){
        
        // not implemented for this project
    
    }

    
}
