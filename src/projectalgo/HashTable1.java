
package projectalgo;

/**
 *
 * @author M.P.T.R.Kumara 100277E
 * 
 * HashTable1 uses the page number as the key and saves keywords.
 * in this project, maximum number of pages are 200 
 * hence, I select a hash table of size 51 which implies that roughly there will be about 
 * four nodes for each key,if simple uniform hashing is assumed.
 * 
 * This hash table is used to implement operation 3,"Keywords<whitespace><page_number>"
 */
public class HashTable1{
    private int size; //here the size is 51.But I set it as a variable so that we can use this hashtable for any other similar project without modification
    private LinkedList chainedArray[];// an array of linked lists
    
    public HashTable1(int size){
        this.size=size;
        chainedArray=new LinkedList[size];
        
        // initiallizing the array
        for(int i=0;i<size;i++){
            chainedArray[i]=new LinkedList();
        
        }
    
    }
    
    public void showAll(int key){
        int place=this.hashMe(key);
        
        ListNode x=this.chainedArray[place].head;
        while(x!=null){
            System.out.print(x.getKeyword()+x.getPage()+"--> ");
            x=x.next;
        }
        System.out.println();
    
    }
    public void scan(){
        for(int i=0;i<51;i++){
            System.out.print(i+"th chain ");
            this.showAll(i);
        
        }
    }
    
    public int hashMe(int key){
        
            return key%size; //use a hashtable of size 51 to store a maaximum number of 200 pages
        
    }
    
    public void chainedHashInsert(HashTable1 T,ListNode x){
        int place=T.hashMe(x.getPage());
        chainedArray[place].insert_list(T.chainedArray[place],x);
        
    }
    
    public ListNode chainedHashSearch(HashTable1 T,int page){
        int place=T.hashMe(page);
        ListNode x= chainedArray[place].search_list(T.chainedArray[place],page);
        return x;
    }
    
  
}
