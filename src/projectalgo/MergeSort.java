
package projectalgo;

/**
 *
 * @author M.P.T.R.Kumara 100277E
 * 
 * this class is implemented to sort a set of integers using merge sort algorithm
 */
public class MergeSort {
    
    public void Merge_Sort(int[] A,int p,int r){
        
        
            if(p<r){
            int q=(int) Math.floor((p+r)/2);// floor value of the division
            
            Merge_Sort(A,p,q); // recursive call to the first half of each subarray array
            Merge_Sort(A,q+1,r);//recursive call to the second half of each sub array 
            Merge(A,p,q,r);// merge then
            
            
                
            }
    }
    
    public void Merge(int []A,int p,int q,int r){
        int i,j;//loop counters
        int n1=q-p+1;
        int n2=r-q;
        
        int[]L=new int[n1+1];
        int[]R=new int[n2+1];

        for(i=0;i<n1;i++){
            L[i]=A[p+i];   
        }
        
             
        for(j=0;j<n2;j++){
            R[j]=A[q+j+1];
        }
    
        L[n1]=10000;// it is assumed that no input value is greater than 10000
        R[n2]=10000;// ""
        
        i=0;
        j=0;
        
        for(int k=p;k<=r;k++){
            if(L[i]<R[j]){
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
