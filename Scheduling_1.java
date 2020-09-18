
import java.util.*;

public class Scheduling_1 {

    static int i;
    static int n;
    float atat = 0, awt = 0;
    static int p[][] = new int[100][100];

    int a[] = new int[100];
    int c[] = new int[100];
    int tat[] = new int[100];
    int wt[] = new int[100];

    void getdata() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no. of process :");
        n = sc.nextInt();

        for (i = 0; i < n; i++) {
            System.out.println("enter process ID for process " + (i + 1) + ":");
            p[i][0] = sc.nextInt();
            System.out.println("enter arrival time for process  : " + (i + 1) + " ");
            p[i][1] = sc.nextInt();
            System.out.println("enter burst time for process  :" + (i + 1) + " ");
            p[i][2] = sc.nextInt();
        }

        for (i = 0; i < n; i++) {
            a[i] = p[i][1];

        }

        System.out.println("-------arrival ");
        for (i = 0; i < n; i++) {

            System.out.println(+a[i] + "  ");
        }
        System.out.println("if arrival zero press 1 and for non zero press 2  ");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                //   if(isArrayEmpty(a)==0){
                System.out.println("OOOOOOOOOKKKK");
                turnaroundtime(p, c);
                waitingtime(tat, p);
                break;
            //   }

            //  else{
            case 2:
                System.out.println("elseOOOOOKKKK");
                int col = 2;
                sortbyColumn(p, col - 1);
                turnaroundtime(p, c);
                waitingtime(tat, p);
                break;
            // }
        }
    }

    public int isArrayEmpty(int array[]) {
        for (i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                return 0;
            }
        }
        return 1;
    }

    int[] turnaroundtime(int p[][], int c[]) {
        System.out.println("OO--------");
        c[0] = p[0][2];
        for (i = 1; i < n; i++) {
            //    for(int j=;j<n;j++)
            c[i] = c[i - 1] + p[i][2];

        }
        System.out.println("-------completion ");
        for (i = 0; i < n; i++) {

            System.out.println(+c[i] + "  ");
        }

        for (i = 0; i < n; i++) {
            tat[i] = c[i] - a[i];
        }

        System.out.println("-------turn ");
        for (i = 0; i < n; i++) {

            System.out.println(+tat[i] + "  ");
        }

        return tat;
    }

    int[] waitingtime(int tat[], int p[][]) {
        System.out.println("---------KKKK");

        for (i = 0; i < n; i++) {
            wt[i] = tat[i] - p[i][2];
        }
        System.out.println("-------waiting ");
        for (i = 0; i < n; i++) {

            System.out.println(+wt[i] + "  ");
        }

        return wt;
    }

    public static void sortbyColumn(int arr[][], int col) {

        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns 
            public int compare(final int[] entry1,
                    final int[] entry2) {

                // To sort in ascending order revert  
                // the '<' Operator 
                if (entry1[col] > entry2[col]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        /*      for (i = 0; i <n; i++) { 
            for (int j = 0; j < 3; j++) 
                System.out.print(p[i][j] + " "); 
            System.out.println(); 
        } */
/*}
    void printdata(int n) {

        for (i = 0; i < n; i++) {
            atat = atat + tat[i];
            awt = awt + wt[i];
        }

        System.out.println("process" + "    " + "arrival time      " + "burst time" + " " + "Completion time" + " " + " Turn around time" + " " + "waiting time");
        for (i = 0; i < n; i++) {
            System.out.println("P" + p[i][0] + "        " + p[i][1] + "                 " + p[i][2] + "              " + c[i] + "              " + tat[i] + "                 " + wt[i] + "      ");
        }
        System.out.println("average turn around time :" + String.format("%.2f", (atat / n)));
        System.out.println("average waiting time  :" + String.format("%.2f", (awt / n)));

    }

    public static void main(String args[]) {

        Scheduling_1 obj = new Scheduling_1();
        obj.getdata();
        obj.printdata(n);

    }
*/
  Scanner sc = new Scanner(System.in);
    static int i;
    static int n;
    float atat = 0, awt = 0;
    static int p[][] = new int[100][100];

    int a[] = new int[100];
    int c[] = new int[100];
    int tat[] = new int[100];
    int wt[] = new int[100];

    void getdata() {
 
        System.out.println("enter no. of process :");
        n = sc.nextInt();

        for (i = 0; i < n; i++) {
            System.out.println("enter process ID for process " + (i + 1) + ":");
            p[i][0] = sc.nextInt();
            System.out.println("enter arrival time for process  : " + (i + 1) + " ");
            p[i][1] = sc.nextInt();
            System.out.println("enter burst time for process  :" + (i + 1) + " ");
            p[i][2] = sc.nextInt();
        }

        for (i = 0; i < n; i++) {
            a[i] = p[i][1];
        }
                turnaroundtime(p, c);
                waitingtime(tat, p);
    }

    int[] turnaroundtime(int p[][], int c[]) {
            c[0] = p[0][2];
        for (i = 1; i < n; i++){
            c[i] = c[i - 1] + p[i][2];
        }
            for (i = 0; i < n; i++) {
            tat[i] = c[i] - a[i];
        }
        return tat;
    }

    int[] waitingtime(int tat[], int p[][]) {
  
        for (i = 0; i < n; i++) {
            wt[i] = tat[i] - p[i][2];
       }

        return wt;
    }


    void printdata(int n) {

        for (i = 0; i < n; i++) {
            atat = atat + tat[i];
            awt = awt + wt[i];
        }

        System.out.println("process" + "    " + "arrival time      " + "burst time" + " " + "Completion time" + " " + " Turn around time" + " " + "waiting time");
        for (i = 0; i < n; i++) {
            System.out.println("P" + p[i][0] + "        " + p[i][1] + "                 " + p[i][2] + "              " + c[i] + "              " + tat[i] + "                 " + wt[i] + "      ");
        }
        System.out.println("average turn around time :" + String.format("%.2f", (atat / n)));
        System.out.println("average waiting time here :" + String.format("%.2f", (awt / n)));

    }

    public static void main(String args[]) {

        Scheduling_1 obj = new Scheduling_1();
        obj.getdata();
        obj.printdata(n);

    }

}


    
    
    




