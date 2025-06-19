package Arrays;

public class FloorInSortedArr {
    public static int floor(int [] arr, int x){
        if(arr[0]>x){
            return -1;
        }
        int s=0; 
        int e= arr.length-1;
        
        int result= Integer.MIN_VALUE;
        
        
        while(s<=e){
            int mid= s+(e-s)/2;
            if(arr[mid]>x){
                e= mid-1;
            }
            else if(arr[mid]<= x){
                result= Math.max(result, mid);
                s= mid+1;
            }
        }
        
        return result;
    }
    public static void main(String args[]){
        int arr[]= {1, 2, 8, 10, 10, 12, 19};

        System.out.println(floor(arr, 11));
    }
}
