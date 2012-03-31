/*  M.P.T.R.Kumara 100277E
 *
 */ 
package projectalgo;

/**
 *
 * @author M.P.T.R.Kumara 100277E
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class ProjectAlgo{
    
    private HashTable1 ht1;
    private HashTable2 ht2;
    
    
    public ProjectAlgo(HashTable1 ht1,HashTable2 ht2){
        this.ht1=ht1;
        this.ht2=ht2;
    
    }

    
    public static void main(String[] args) {
        HashTable1 h1=new HashTable1(51);
        HashTable2 h2=new HashTable2(101);
        ProjectAlgo p= new ProjectAlgo(h1,h2);
        Scanner s=p.linkFile();
        p.readInput(s);
      
       
    }
    
    
    public int[] sort(int []A){ // sorts a list of integers using merge sort
        MergeSort sorter=new MergeSort();
        if(A!=null){
            sorter.Merge_Sort(A,0 ,A.length-1);  
        }
        return A;
        
    
    }
    
    public void stringSort(String[] A){
        
            StringSort ssorter=new StringSort();
            ssorter.Merge_Sort(A,0,A.length-1);
            
            for(int j=0;j<A.length;j++){
                System.out.print(A[j]+" ");
            }
            
            System.out.println();
    
    }
    
    public void showSorted(int[] A){
        if(A!= null){
            for(int i=0;i<A.length;i++){
                        System.out.print(A[i]+" ");
                    }
                    System.out.println();
        }
        else{
            System.out.println("Invalid Keyword");
        }
        
    }
    
    
    public void readInput(Scanner s){
        String line;
        Calendar cal=new GregorianCalendar();// a calendar object to show current time and date
        BufferedWriter bw;
        line=s.nextLine();
        
        while(s.hasNext()){
            
            
            if(line.trim().equals("Keyword List Start")){
                    line=s.nextLine().trim();
                    while(!(line.equals("Keyword List End"))){
                        
                        
                        char arr[]=line.toCharArray();
                        // now let's count the length of the keyword
                        int len=0;
                        while(arr[len]!='\t'){
                            len++;
                            if(len==arr.length-1){
                                
                                try {

                                    bw=new BufferedWriter(new FileWriter("output.txt"));
                                    bw.write("invalid input format given and program terminated on "+cal.getTime());
                                    bw.flush();
                                    bw.close();
                                    break;

                                }catch (IOException ex) {


                                }
                                System.exit(0);// terminate the program if input is invalid

                                
                            }
                        }
                        
                        
                        
                 
                            String kw=line.substring(0,len);                              //extract the keyword

                            /** now we check whether the keyword has spaces at both ends
                             * if white spaces present, that is an invalid input
                             * and the program will be terminated.
                             */

                            if(kw.equals(kw.trim()) && arr[len]=='\t'){


                                kw=kw.toLowerCase();                                                  // the reason for this action is described below
                                int pageNum=Integer.parseInt(line.trim().substring(len+1, arr.length));//extract the pagenumber

                                /**
                                 * now observe the two lines above.
                                 * we know that each line contains a keyword and a tab letter and an integer(page number)
                                 * if we perform trim() method on each line we get the string which has no spaces at two ends
                                 * then we insert the trimmed string into a char[] arr, say size n
                                 * page number is obviously the last element of the array,arr[n-1]
                                 * the tab letter is the arr[n-2] th element
                                 * then the sequence from arr[0] to arr[n-2] belongs to the keyword
                                 * It is said that keywords are not case sensitive.(e.g. "CSE" = "cSe")
                                 * hence all strings are stored after converting to the lower case
                                 * 
                                 */

                                ListNode node1=new ListNode(pageNum,kw);
                                ListNode node2=new ListNode(pageNum,kw);

                                ht2.chainedHashInsert(ht2,node2);
                                ht1.chainedHashInsert(ht1,node1);


                                line=s.nextLine().trim();

                            }
                            else{
                                try {

                                    bw=new BufferedWriter(new FileWriter("output.txt"));
                                    bw.write("invalid input format given and program terminated on "+cal.getTime());
                                    bw.flush();
                                    bw.close();
                                    break;

                                }catch (IOException ex) {


                                }
                                System.exit(0);// terminate the program if input is invalid
                            }
                        
                    }
                    
                    /*
                     * input is read and finished storing keywords
                       now we sacn queries
                     * 
                     */
                    
                    line=s.nextLine();
                    
                    String queryWord;// holds the command words, "First", "List" and "Keywords"
                    String qkeyword; // holds the keyword, queried by the commands
                    
                    if(line.trim().equals("Queries Start")){
                        while(!(line.trim().equals("Queries End"))){
                        /**
                           this block of code will read through the queries list and
                           perform the three operations First, List and Keywords
                          */
                            line=s.nextLine();
                            
                            String trimmed=line.trim(); // trim() to remove boundary white spaces and ignore input errors at ends
                            char[] array=trimmed.toCharArray(); 
                            if(trimmed.substring(0,4).equals("List") && trimmed.charAt(4)==' ' && trimmed.charAt(5)!=(' ')){
                                
                                queryWord="List"; // this string is not used. but I use it so that it can be used for future development purposes
                                qkeyword=trimmed.substring(5,array.length);
                                int[] pageArray=this.List(qkeyword.toLowerCase());
                                this.showSorted(pageArray);                                                                
                            
                            }
                            
                            else if(trimmed.substring(0,5).equals("First") && trimmed.charAt(5)==' ' && trimmed.charAt(6)!=(' ')){
                                
                                queryWord="First";
                                qkeyword=trimmed.substring(6,array.length);
                                this.First(qkeyword.toLowerCase());
                            
                            }
                            else if(trimmed.substring(0,8).equals("Keywords") && trimmed.charAt(8)==' ' && trimmed.charAt(9)!=(' ')){
                                queryWord="Keywords";
                                int pageNumber=Integer.parseInt(trimmed.substring(9,array.length));//extract the pagenumber
                                this.Keywords(pageNumber);
                                
                            }
                            else if(trimmed.equals("Queries End")){
                                System.exit(0);
                            }
                                    
                            else{ // if none of the above cases occur then it is an invalid input
                                    try {

                                    bw=new BufferedWriter(new FileWriter("output.txt"));
                                    bw.write("invalid input format given and program terminated on "+cal.getTime());
                                    bw.flush();
                                    bw.close();
                                    break;
                                    

                                    }catch (IOException ex) {

                                    }
                                    System.exit(0);
                            
                            }
                            
                        }
                    }
                    else{
                        try {
                        
                            bw=new BufferedWriter(new FileWriter("output.txt"));
                            bw.write("invalid input format at "+cal.getTime());
                            bw.flush();
                            bw.close();
                        }catch (IOException ex) {
                        
                        
                        }
                        
                        System.exit(0);
                    }
       
                }
                else{
                    try {
                        
                        bw=new BufferedWriter(new FileWriter("output.txt"));
                        bw.write("invalid input format at "+cal.getTime());
                        bw.flush();
                        bw.close();
                    }catch (IOException ex) {
                        
                        
                    }
                }
        }
    
    }
    
    public void First(String keyword){
        int []arr=this.List(keyword);
        if(arr!=null){
            System.out.println(arr[0]);// first element of the sorted array will be the first page containing the given keyword
        }
        else{
            System.out.println("Invalid Keyword");
        }
    }
    
    
    public int[] List(String keyword){
        int counter=0;// this counts the number of occurrences of the given keyword
        int []arr;// keeps page numbers of the given keyword
        ListNode result;
        int page;// holds the current page number
        
        
        
            result=ht2.chainedHashSearch(ht2,keyword);// check whether there's at least a single page with the given keyword,if the node prsent we get the first one,there can be more !!!
            
            
            if(result!=null){
            page=result.getPage();
            counter=1;// found one occurence of the keyword
            
            //now let's find all the other occurrences of the same keyword
            while(result.getNext()!=null){// iterate through the whole list
                result= result.getNext();
                if(result.getKeyword().equals(keyword)&& result.getPage()!=page){
                    counter++;
                    page=result.getPage();
                }
                
            }
            // now we know how many pages contain the given key word
            // let's create an array to hold all the page numbers
            arr=new int[counter];
            
            // let's iterate through the same linked list again to feed the array with page numbers
            counter=0; // reset to zero again
            result=ht2.chainedHashSearch(ht2, keyword);
            arr[0]=page=result.getPage();
            counter=1;
            while(result.getNext()!=null){
                
                result=result.getNext();
                
                if(result.getKeyword().equals(keyword)&& result.getPage()!=page){
                    arr[counter]=result.getPage();
                    counter++;
                }
            }
            
           this.sort(arr);
           return arr;  
        }
        else{
            return null;
        }
  
    }
    public void Keywords(int page){
        
        /**
         HashTable1 class is responsible for this action.
         It uses the page number as a keyword and stores all the keywords with that page number
         Observe the implementation of HashTable1 for further information
         */
        
        int counter;// number of keywords in the given page
     
        
        
        
        ListNode result=ht1.chainedHashSearch(ht1,page);// find the first occurence of the page number
        
        if(result!=null){       // if not null
            counter=1;
           
            
            while(result.getNext()!=null){
                
                result=result.getNext();
                if(result.getPage()==page){ //if equal to the given page number and not equal to the previous result's page number
                    counter++;
                   
                }
            }
            
            String kwordArr[]=new String[counter];
            counter=1;
            result=ht1.chainedHashSearch(ht1,page); // again go to the first node with the given keyword
            kwordArr[0]=result.getKeyword();
           
            while(result.getNext()!=null){
                
                result=result.getNext();
                if(page==result.getPage()){ //if equal to the given page number and not equal to the previous result's page number
                    kwordArr[counter]=result.getKeyword();
                    counter++;
                }
            
            }
            
            this.stringSort(kwordArr); // send the array for sorting
            
        }
        else{
            System.out.println("Invalid Page Number");
        }   
        
    } 
    
    // linkFile establishes a connection to an input file
    public Scanner linkFile(){ //returns a Scanner object with a link to the input file
        Scanner scan = null;
        try {
            scan=new Scanner(new BufferedReader(new FileReader("dist\\input.txt")));
        } catch (FileNotFoundException ex) {
            try {
                        Calendar cal=new GregorianCalendar();// a calendar object to show current time
                        BufferedWriter bw=new BufferedWriter(new FileWriter("output.txt"));
                        bw.write("file linking failed on "+cal.getTime());// an error message goes to a text file named output.txt
                        bw.flush();
                        bw.close();
                    }catch (IOException e) {
                        
                        
                    }
        }
        return scan;
    
    }
    
    
    
    
}
