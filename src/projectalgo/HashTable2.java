
package projectalgo;

/**
 *
 * @author M.P.T.R.Kumara 100277E
 * 
 * HahTable2 uses keywords as the key and stores page numbers.
 * This hash table is used to implement operations 1 and 2,"First<whitespace><Keyword>" & "List<whitespace><Keyword>".
 * 
 * Most variable names are used as given in conventional pseudo codes so that they make sense in the implementation.
 * 
 */
public class HashTable2 {
    private int size;//size is set as a variable to increase reusability,for this projects size will be 101
    private LinkedList[] chainedArray;// 
    
    
    public HashTable2(int size){
        this.size=size;
        chainedArray=new LinkedList[size];
        
        // initiallizing the array
        for(int i=0;i<size;i++){
            chainedArray[i]=new LinkedList();
        }
        
        
    
    
    }
    public int hashMe(String key){
        // every string is assigned a natural number based on their ASCII values.
        // ASCII values of all the characters of the string are added up to get an numeric representation for the key word.
        char arr[]=key.toCharArray();
        int stringValue=0;
        for(int i=0;i<arr.length;i++){
            stringValue += (int)arr[i];
        
        }
        
        return stringValue%size; // here I use a hashtable of size 101 to store a maximum of 500 character strings
    }
    
    
     public void showAll(int key){
        //int place=this.hashMe(key);
        ListNode y=this.chainedArray[key].head;
        while(y!=null){
            System.out.print(y.getKeyword()+y.getPage()+"--> ");
            y=y.next;
        }
        System.out.println();
    }
     
     public void scan(){
        for(int i=0;i<101;i++){
            System.out.print(i+"th chain ");
            this.showAll(i);
        
        }
    }
    
    public void chainedHashInsert(HashTable2 T,ListNode x){
        
        int place=T.hashMe(x.getKeyword()); // "place" refers to the location in the Hash table.
        chainedArray[place].insert_list(T.chainedArray[place], x);
    
    }
    
    public ListNode chainedHashSearch(HashTable2 T,String key){
        int place=T.hashMe(key);
        ListNode x=chainedArray[place].search_list(T.chainedArray[place], key);
        return x;
    }
    
}
