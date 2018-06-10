package datab.dbsql.dbsource;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Enter the First number");
        Scanner scanner = new Scanner(System.in);
        int no1 = scanner.nextInt();
        System.out.println("Enter the Second number");
        int no2 = scanner.nextInt();
        System.out.println("Length of the fibonacci series");
        int length = scanner.nextInt();
        System.out.print(no1+"\t"+no2);
        for(int k=1;k<=length;k++){
            int c = no1+no2;
            no1 = no2;
            no2 = c;
            System.out.print("\t"+no2+"\t ");
        }
    }
}
