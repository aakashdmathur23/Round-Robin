/*
Author:    Aakash Dutt Mathur
Algorithm: Round Robin Algorithm
Date:      06.12.2022
Language:  Java

Definitions:

Arrival Time: It is the time when a process enters into the ready state. It means the process is ready for execution.

Response Time: It is the time when a process gets the CPU for the first time.

Turnaround Time: It is an amount of time the process exists in the system.

    Turnaround Time = Completion Time - Arrival Time  

Waiting Time: It is an amount of time taken by a process for their complete execution. In other words, the time spend by a process in the ready state waiting for CPU.

    Waiting Time = Turnaround Time - Burst Time  

Burst Time: Burst time is the total time taken by the process for its execution on the CPU. It is also known as execution time.

Completion Time: It is an amount of time taken by a process to complete. It is also known as exit time.

Throughput Time: It can be defined as the number of processes executed by the CPU in a given amount of time. It is used to find the efficiency of a CPU.

*/

import java.util.Scanner;

public class roundRobin {

    public static void main(String args[]) {

        int n, i, qt, count = 0, temp, sq = 0, bt[], wt[], tat[], rem_bt[];

        float awt = 0, atat = 0;

        bt = new int[10];

        wt = new int[10];

        tat = new int[10];

        rem_bt = new int[10];

        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of process (maximum 10) = ");

        n = s.nextInt();

        System.out.print("Enter the burst time of the process\n");

        for (i = 0; i < n; i++) {
            System.out.print("P" + i + " = ");
            bt[i] = s.nextInt();
            rem_bt[i] = bt[i];
        }

        System.out.print("Enter the quantum time: ");

        qt = s.nextInt();

        while (true) {
            for (i = 0, count = 0; i < n; i++) {

                temp = qt;
                if (rem_bt[i] == 0) {
                    count++;
                    continue;
                }
                if (rem_bt[i] > qt) {
                    rem_bt[i] = rem_bt[i] - qt;
                } else if (rem_bt[i] >= 0) {
                    temp = rem_bt[i];
                    rem_bt[i] = 0;
                }
                sq = sq + temp;
                tat[i] = sq;
            }

            if (n == count) {
                break;
            }
        }

        System.out.print("--------------------------------------------------------------------------------");
        System.out.print("\nProcess\t      Burst Time\t       Turnaround Time\t          Waiting Time\n");
        System.out.print("--------------------------------------------------------------------------------");

        for (i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
            awt = awt + wt[i];
            atat = atat + tat[i];
            System.out.print("\n " + (i + 1) + "\t " + bt[i] + "\t\t " + tat[i] + "\t\t " + wt[i] + "\n");
        }

        awt = awt / n;

        atat = atat / n;

        System.out.println("\nAverage waiting Time = " + awt + "\n");
        System.out.println("Average turnaround time = " + atat);
    }
}