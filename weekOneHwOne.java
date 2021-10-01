package com.kodluyoruz.weekone;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class weekOneHwOne {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Değişkenler
        int num;
        boolean printPlus = true;

        // Kullanıcıdan alınan sayı girişi.
        System.out.println("Bir Sayı Giriniz : ");
        num = scanner.nextInt();

        // i ve j değişkeniyle satır ve sütunları kontrol eder, ilk veya son satır
        // veya satırın başı veya sonundaysa '*' karakterini basar.
        // İlk satır '+' ile başlayacağı için printPlus 'true' ise '+' karakteriyle satırı başlatır.
        // 'false' ise boşluk karakteriyle satırı başlatır. Her satır sonunda printPlus tersine döner.
        for (var i = 0; i < num; i++){
            for (var j = 0; j < num; j++){
                if (i == 0 || j == 0 || i == num -1 || j == num -1){
                    System.out.print("*");
                }else if(j > 0 || j < num -1){
                    if (printPlus)
                        System.out.print("+");
                    else
                        System.out.print(" ");
                }

                if (j == num - 1){
                    System.out.println();
                }

                printPlus = !printPlus;
            }

            if (num % 2 == 0){
                printPlus = !printPlus;
            }
        }

    }
}
