package Arrays;

import java.util.*;
public class FractionalKnapsack {
    public static double fractionalKnapsack(int[] val, int[]wt, int maxCap){
        int n= val.length;
        double items[][]= new double[n][2];
        for(int i=0; i<n; i++){
            items[i][0]= (double) val[i];
            items[i][1]=(double) wt[i];
        }

        Arrays.sort(items, new Comparator<double[]>(){
            public int compare(double[]a, double b[]){
                double ratioA= a[0]/a[1];
                double ratioB= b[0]/b[1];

                if(ratioA>ratioB){
                    return -1;
                }
                else if(ratioA<ratioB){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        });

        double value=0;
        int remaining=maxCap;

        for(int i=0; i<n && remaining>0; i++){
            double currWeight= items[i][1];
            double currVal= items[i][0];
            if(currWeight<= remaining){
                value+= currVal;
                remaining-= currWeight;
            }
            else{
                double frac= (double)remaining/currWeight;
                value+= frac*currVal;
                remaining=0;
            }
        }

        value= Math.round(value*1000000)/1000000.0;
        return value;
    }
    public static void main(String args[]){
        int wt[]= {10, 20, 30};
        int val[]={60, 100, 120};

        System.out.println(fractionalKnapsack(val, wt, 50));
    }
}
