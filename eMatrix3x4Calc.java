/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package modul7.percobaan.latihan;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class eMatrix3x4Calc {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        ///Matriks 1
        int[][] arr= new int[3][4];
        for (int i=0; i<3; i++) {
            for (int j=0; j<4; j++) {
                System.out.print("Ketikkan data b"+i+"k"+j+": ");
                String data = input.nextLine();
                int n=Integer.parseInt(data);
                arr[i][j]=n;
            }
        }
        ///Operasi
        System.out.print("Operasi perhitungan ([1]kali, [2] jumlah): ");
        String op = input.nextLine();
         int opx=Integer.parseInt(op);
        ///Matriks 2
        int[][] arr1= new int[3][4];
        for (int i=0; i<3; i++) {
            for (int j=0; j<4; j++) {
                System.out.print("Ketikkan data b"+i+"k"+j+": ");
                String data = input.nextLine();
                int n=Integer.parseInt(data);
                arr1[i][j]=n;
            }
        }
        ///Swicth-case
        switch (opx) {
            case 1 -> {
                //Kali
                System.out.println();
                System.out.println(arr[0][0]+"\t"+arr[0][1]+"\t"+arr[0][2]+"\t"+arr[0][3]+"\t\t"+arr1[0][0]+"\t"+arr1[0][1]+"\t"+arr1[0][2]+"\t"+arr1[0][3]);
                System.out.println(arr[1][0]+"\t"+arr[1][1]+"\t"+arr[1][2]+"\t"+arr[1][3]+"\t"+" X \t"+arr1[1][0]+"\t"+arr1[1][1]+"\t"+arr1[1][2]+"\t"+arr1[1][3]);
                System.out.println(arr[2][0]+"\t"+arr[2][1]+"\t"+arr[2][2]+"\t"+arr[2][3]+"\t\t"+arr1[2][0]+"\t"+arr1[2][1]+"\t"+arr1[2][2]+"\t"+arr1[2][3]);
                System.out.println("\n\t\t\t\t = \n");
                System.out.println("  \t\t"+(arr[0][0]*arr1[0][0])+"\t"+(arr[0][1]*arr1[0][1])+"\t"+(arr[0][2]*arr1[0][2])+"\t"+(arr[0][3]*arr1[0][3]));
                System.out.println("  \t\t"+(arr[1][0]*arr1[1][0])+"\t"+(arr[1][1]*arr1[1][1])+"\t"+(arr[1][2]*arr1[1][2])+"\t"+(arr[1][3]*arr1[1][3]));
                System.out.println("  \t\t"+(arr[2][0]*arr1[2][0])+"\t"+(arr[2][1]*arr1[2][1])+"\t"+(arr[2][2]*arr1[2][2])+"\t"+(arr[2][3]*arr1[2][3]));
            }
            case 2 -> {
                //Tambah
                System.out.println();
                System.out.println(arr[0][0]+"\t"+arr[0][1]+"\t"+arr[0][2]+"\t"+arr[0][3]+"\t\t"+arr1[0][0]+"\t"+arr1[0][1]+"\t"+arr1[0][2]+"\t"+arr1[0][3]);
                System.out.println(arr[1][0]+"\t"+arr[1][1]+"\t"+arr[1][2]+"\t"+arr[1][3]+"\t"+" + \t"+arr1[1][0]+"\t"+arr1[1][1]+"\t"+arr1[1][2]+"\t"+arr1[1][3]);
                System.out.println(arr[2][0]+"\t"+arr[2][1]+"\t"+arr[2][2]+"\t"+arr[2][3]+"\t\t"+arr1[2][0]+"\t"+arr1[2][1]+"\t"+arr1[2][2]+"\t"+arr1[2][3]);
                System.out.println("\n\t\t\t\t = \n");
                System.out.println("  \t\t"+(arr[0][0]+arr1[0][0])+"\t"+(arr[0][1]+arr1[0][1])+"\t"+(arr[0][2]+arr1[0][2])+"\t"+(arr[0][3]+arr1[0][3]));
                System.out.println("  \t\t"+(arr[1][0]+arr1[1][0])+"\t"+(arr[1][1]+arr1[1][1])+"\t"+(arr[1][2]+arr1[1][2])+"\t"+(arr[1][3]+arr1[1][3]));
                System.out.println("  \t\t"+(arr[2][0]+arr1[2][0])+"\t"+(arr[2][1]+arr1[2][1])+"\t"+(arr[2][2]+arr1[2][2])+"\t"+(arr[2][3]+arr1[2][3]));

            }
            default -> System.out.println("Operasi tidak valid.");
        }
    }
}
