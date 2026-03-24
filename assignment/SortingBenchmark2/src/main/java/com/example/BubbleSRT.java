package com.example;
import java.util.Scanner;

public class BubbleSRT {
    
    public static int []  sort (int [] arr ){
        for (int i = 0; i < arr.length; i++) {
            boolean sorted= true ;
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j]>arr[j+1]) {
                    int temp =  arr[j];
                    arr[j] = arr [j+1];
                    arr[j+1]=temp ;
                    sorted=false ;
                }

            }
            if ( sorted ) return arr;
        }
        
        return arr;
    }

    public static void main(String[] args) {
        Scanner Scan1 = new Scanner (System.in);
        int n = Integer.parseInt(Scan1.nextLine());
        int[] arr= new int [n];
        for (int i =0; i < arr.length; i++ ){
            arr[i] = Integer.parseInt(Scan1.nextLine());
        }
        for (int i = 0;i<sort(arr).length ;i++){
            System.out.println(" "+ arr[i]);
        }
    }
    
}
