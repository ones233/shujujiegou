package BinarySort;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};
        if(binayfind(arr,2)){
            System.out.println("此数在该数组中");
        }

    }

    public static boolean binayfind(int arr[],int x){
        int  right = arr.length;
        int left =0;

        while(left<=right){
            int mid = left +(right-left)/2;///////很重要，如果要是(left+right)/2可能会造成int溢出
            if(arr[mid]==x){
                return true;
            }else if(arr[mid]<x){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return false;
    }
}

