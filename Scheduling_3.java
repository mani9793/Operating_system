import java.util.*;
public class Scheduling_3 {

    int p[][] = new int[100][4];//arrival time
    static int np, nap = 0, i,j,time = 0;//toal process & total arrived & time slots
    int scheduler[] = new int[1000];//gantt chart array
    int arrivedpr[] = new int[100];//arrived processes
      int tat[] = new int[100];
       int c[] = new int[100];
    Scanner sc = new Scanner(System.in);
    float atat,awt;
    public void getSystem() {
        System.out.println("no. of process");
        np = sc.nextInt();
        for ( i = 0; i < np; i++) {
            System.out.println("enter arrival time for process  :" + (i + 1) + " ");
            p[i][0] = sc.nextInt();
            System.out.println("enter burst time for process  :" + (i + 1) + " ");
            p[i][1] = sc.nextInt();
            p[i][2] = p[i][1];
            System.out.println("-------------------------------- ");
        }
    }

    public void printSystem() {
        
        System.out.println("process" + " " + "Arrival time" + " " + " Burst time" + " " + "Remaining time");

        for ( i = 0; i < np; i++) {
            System.out.println("P" + (i + 1) + "       " + p[i][0] + "                     " + p[i][1] + "                 " + p[i][2]);
        }
       
        System.out.println("-------------------------------- ");
    }

    int remaintimes() {
        for ( i = 0; i < np; i++) {
            if (p[i][2] > 0) {
                return 1;
            }
        }
        return 0;
    }
    
  int[] turnaroundtime(int p[][], int c[]) {
        System.out.println("arrival... ");
          for (i = 0; i < np; i++) {
              System.out.println(+p[i][0]+" ");
          }
      
      System.out.println("completion ... ");
          for (i = 0; i < np; i++) {
              System.out.println(+c[i]+" ");
          }
            for (i = 0; i < np; i++) {
            tat[i] = c[i] - p[i][0];
        }
        return tat;
    }
    
    
    void addarrivedprocess() {
        for ( i = 0; i < np; i++) {
            if (p[i][0] == time) {
                arrivedpr[nap] = i;
                nap++;

            }
        }
    }

    int getSRT() { //shortest remaining time
        if (nap == 0) {
            return -1;
        }
        int smallestRTP, smallestRTPindex;
        smallestRTPindex = arrivedpr[0];
        smallestRTP = p[arrivedpr[0]][2];
        for ( i = 0; i < nap; i++) {
            if (p[arrivedpr[i]][2] < smallestRTP) {
                smallestRTP = p[arrivedpr[i]][2];
                smallestRTPindex = arrivedpr[i];
            }
        }
        return smallestRTPindex;
    }

    void printarrivedprocess() {
        for ( i = 0; i < nap; i++) {
            System.out.println(arrivedpr[i] + 1);
        }
    }

    void removefromarrivedprocess(int toRun) {
        int temp[] = new int[100];
        int x = 0;
        for (i = 0; i < nap; i++) {
            if (arrivedpr[i] != toRun) {
                temp[x] = arrivedpr[i];
                x++;

            }
        }
        nap = nap - 1;
        for (i = 0; i < nap; i++) {
            arrivedpr[i] = temp[i];
        }
    }

    void Schedule() {
        int x;
        int toRun;//variable name
        while (remaintimes() != 0) {

            addarrivedprocess();
            printarrivedprocess();
            toRun = getSRT();
            scheduler[time] = toRun;
            p[toRun][2]--;
            
            if (p[toRun][2] == 0) {
                removefromarrivedprocess(toRun);
            }
            if (toRun == -1) {
                System.out.println("Run=[IDLE], Time " + time);
            }
            else {
                System.out.println("Run=[IDLE]  " + (toRun + 1) + " " + "Time  " + time);
            }
            printSystem();
            time++;
        }
    }

    void printScheduler() {
        System.out.println("\nSchedular:\n");
        for (int t = 0; t < time; t++) {
            if (scheduler[t] == -1) {
                System.out.println(+t + " " + (t + 1));
            } else {
                System.out.println(+t + " " + (t + 1) + scheduler[t] + 1);
            }
        }
    }

    void waitingtime() {
        int releasetime, t;
        for ( i = 0; i < np; i++) {
            for (t = time - 1; scheduler[t] != i ; t--) {
                releasetime = t + 1;
                p[i][3] = releasetime - p[i][0] - p[i][1];
            }
        }

    }

    void printwaitingtime() {
        int waitingtimesum = 0;
        float awt;
        System.out.println("waiting time for each process\n");
        for ( i = 0; i < np; i++) {
            System.out.println(+(i + 1) + " " + p[i][3]);
            waitingtimesum +=p[i][3];
        }
        
        
          for (i = 0; i < np; i++) {
              System.out.println(+tat[i]+" ");
          }
        
        turnaroundtime(p,c);
           for (i = 0; i < np; i++) {
            atat = atat + tat[i];
    }
           
               atat = atat / (float) np;
          System.out.println("average waitng time " + atat);
        awt = waitingtimesum / (float) np;
        System.out.println("average waitng time " + awt);
    }

    public static void main(String args[]) {
        Scheduling_3 obj = new Scheduling_3();
        obj.getSystem();
        obj.printSystem();
        obj.Schedule();
        obj.printScheduler();
        obj.waitingtime();
        obj.printwaitingtime();
    }
}
