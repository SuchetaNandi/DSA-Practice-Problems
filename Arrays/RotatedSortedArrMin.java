package Arrays;

// finding minimum in rotated sorted array
public class RotatedSortedArrMin {
    public static int minInArr(int[] arr){
        int s=0;
        int e= arr.length-1;
        int min= Integer.MAX_VALUE;
        while(s<=e){
            int mid= s+(e-s)/2;
            if(arr[s]<= arr[mid]){
                min= Math.min(min, arr[s]);
                s= mid+1;
            }
            else if(arr[mid]<arr[s]){
                min= Math.min(min, arr[mid]);
                e= mid-1;
            }
        }
        return min;
    }
    public static void main(String args[]){
        int[] arr= {4, 5, 6, 7, 0, 1, 2};
        System.out.println(minInArr(arr));
    }
}
