
package projectalgo;

/**
 *
 * @author M.P.T.R.Kumara 100277E
 * 
 * this class sorts a set of strings using merge sort algorithm.
 * numeric values of the strings are compared using "int comparTo(String s)" method in java standard library
 */
public class StringSort {
    
    
    
    public void Merge_Sort(String[] A,int p,int r){
        
        
            if(p<r){
            int q=(int) Math.floor((p+r)/2);// floor value of the division
            
            Merge_Sort(A,p,q); // recursive call to the first half of each subarray array
            Merge_Sort(A,q+1,r);//recursive call to the second half of each sub array 
            Merge(A,p,q,r);// merge then
                
            }
            
    }
    
        public void Merge(String []A,int p,int q,int r){
            int i,j;//loop counters
            int n1=q-p+1;
            int n2=r-q;

            String[]L=new String[n1+1];
            String[]R=new String[n2+1];

            for(i=0;i<n1;i++){
                L[i]=A[p+i];   
            }


            for(j=0;j<n2;j++){
                R[j]=A[q+j+1];
            }

            L[n1]="~";// in unicode representation "~" has a very high numerical value.hence assumed that no input is greater than this string
            R[n2]="~";// ""

            i=0;
            j=0;

            for(int k=p;k<=r;k++){
                if(L[i].compareToIgnoreCase(R[j]) <0){
                    A[k]=L[i];
                    i++;
                }
                else{
                    A[k]=R[j];
                    j++;
                }
            }
        }
}
