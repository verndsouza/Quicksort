
package quicksort2;

import java.util.Scanner;

public class QuickSort2 {
    
    int partition(int a[], int l, int h)
    {
        int pivot = a[h]; 

        int i = (l-1);

        for (int j=l; j<h; j++)
        {
            if (a[j] <= pivot)
            {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i+1];
        a[i+1] = a[h];
        a[h] = temp;
 
        return i+1;
    }
    void QuickSort(int a[], int l, int h)
    {
        int stack[] = new int[h-l+1];
 
        int top = -1;
 
        stack[++top] = l;
        stack[++top] = h;
 
        while (top >= 0)
        {
            h = stack[top--];
            l = stack[top--];
 
            int x = partition(a, l, h);

            if ( x-1 > l )
            {
                stack[ ++top ] = l;
                stack[ ++top ] = x - 1;
            }

            if ( x+1 < h )
            {
                stack[ ++top ] = x + 1;
                stack[ ++top ] = h;
            }
       }
    }

    public static void main(String[] args) {
        int [] n = new int[1000];
        
        Scanner reader = new Scanner(System.in);
        
        System.out.println(" Enter array elements:");
        
        for(int i =0;i<1000;i++)
        {
           n[i] = reader.nextInt();
        }

        int x = n.length;
        QuickSort2 obj = new QuickSort2();
        obj.QuickSort(n, 0, x-1);

        for(int i =0;i<1000;i++)
        {
            if (i==0)
                System.out.println("Sorted Array:");
            
            System.out.print(n[i]+" ");
        }

    }
    
}