package Arrays;

public class Sort012 {
    public static int[] sort(int arr[]){
        int low=0, mid=0;
        int high= arr.length-1;
        while(mid<= high){
            if(arr[mid]==0){
                int temp= arr[mid];
                arr[mid]= arr[low];
                arr[low]= temp;
                low++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else if(arr[mid]==2){
                int temp= arr[mid];
                arr[mid]= arr[high];
                arr[high]= temp;
                high--;
            }
        }
        return arr;
    }
    public static void main(String arge[]){
        int[]arr={0,1,1,0,1,2,1,2,0,0,0,1};

        arr= sort(arr);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}
