package Arrays;

public class InversionCount {
    public static void main(String args[]) {
        int arr[]= {2, 4, 1, 3 , 5};
        System.out.println(mergeSort(arr, 0, arr.length-1));
    }
    public static int mergeSort(int arr[], int left, int right){
        int count=0;
        if(left< right){
            int mid= left+(right-left)/2;
            count+= mergeSort(arr, left, mid);
            count+= mergeSort(arr, mid+1, right);
            count+= mergeCount(arr, left, right, mid);
        }
        return count;
    }
    public static int mergeCount(int arr[], int left, int right, int mid){
        int[] leftArr= new int[mid-left+1];
        int [] rightArr= new int[right- mid];
        
        for(int i=0; i< leftArr.length; i++){
            leftArr[i]= arr[i+left];
        }
        
        for(int j=0; j< rightArr.length; j++){
            rightArr[j]= arr[mid+1+j];
        }
        
        int i=0, j=0, k= left, swaps=0;
        while(i<leftArr.length && j<rightArr.length){
            if(leftArr[i]<= rightArr[j]){
                arr[k++]= leftArr[i++];
            }
            else{
                arr[k++]= rightArr[j++];
                swaps+= (mid+1)-(left+i);
            }
        }
        while(i<leftArr.length){
                arr[k++]= leftArr[i++];
            }
            
        while(j<rightArr.length){
            arr[k++]= rightArr[j++];
        }
        
        return swaps;
    }

}
