package com.kodluyoruz.weekone;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class weekOneHwTwo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Değişkenler
        String pattern, word;

        // Kullanıcıdan pattern ve word olarak değerleri alır,
        // patternin word içerisinde geçip geçmediğini kontrol eder.
        // Kullanıcı word olarak "exit" girerse uygulamadan çıkılır.
        while(true){
            System.out.println("Enter the Pattern (* ile başlayamaz) : ");
            pattern = scanner.nextLine();

            System.out.println("Enter a Word : ");
            word = scanner.nextLine();

            if (word == "exit")
                break;

            // pattern'i regex formatına çevirir.
          pattern.replace("*",".*");

          //occursIn metodu ile kontrol yapılıp sonuç kullanıcıya gösterilir.
            if (occursIn(pattern,word)){
                System.out.println(pattern + " occurs in \"" + word + "\"");
            }else{
                System.out.println(pattern + " does NOT occur in \"" + word + "\"");
            }
        }
    }

    // Kullanıcıdan alınan word içerisinde pattern kontrolünü yapar.
    public static boolean occursIn(String pattern, String str){
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);

        if (m.find()){
            return true;
        }else{
            return false;
        }
    }
}

