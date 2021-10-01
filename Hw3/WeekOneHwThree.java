package com.kodluyoruz.weekone;

import java.time.LocalDate;

public class WeekOneHwThree {
    public static void main(String[] args) {

        // Oluşturulacak Öğrencilerin PersonalData'ları
        PersonalData pdAhmet = new PersonalData(1999,8,6,123);
        PersonalData pdArif = new PersonalData(1998,11,11,456);
        PersonalData pdSila = new PersonalData(1999,2,2,180);
        PersonalData pdEren = new PersonalData(1999,7,12,231);
        PersonalData pdOzgur = new PersonalData(1999,4,12,502);

        // Oluşturulan Öğrenciler
        Student ahmet = new Student("Ahmet Akkulak",5005,82,pdAhmet);
        Student arif = new Student("Arif Can Üçer",2,90,pdArif);
        Student sila = new Student("Asrın Sıla Şimşek",3,80,pdSila);
        Student eren = new Student("Eren Demirel",4,70,pdEren);
        Student ozgur = new Student("Beşir Özgür Bilgili",5,75,pdOzgur);

        System.out.println("K129 Sınıfı Oluşturuldu, 4 Öğrenci Eklenmeye çalışıldı \n" +
                " Kapasite Dolduğu İçin Son Kayıt Alınamadı...");
        Course courseK129 = new Course("K129",3);
        courseK129.addStudent(ahmet);
        courseK129.addStudent(arif);
        courseK129.addStudent(sila);
        courseK129.addStudent(eren);

        System.out.println("K129 Sınıfının Öğrenci Listesi...");
        courseK129.list();

        courseK129.increaseCapacity();

        courseK129.addStudent(eren);
        courseK129.addStudent(ozgur);
        System.out.println("K129 Sınıfının Kapasitesi Arttı, 2 Yeni Öğrenci Eklendi...");

        System.out.println("K129 Sınıfı Öğrenci Listesi :");
        courseK129.list();

        courseK129.dropStudent(ahmet);
        System.out.println("ID5005 Ahmet, K129 Sınıfından çıkartıldı...");

        System.out.println("K129 Sınıfının Öğrenci Listesi :");
        courseK129.list();

        System.out.println("K129 Sınıfının Öğrenci Sayısı :");
        System.out.println(courseK129.getNumberOfStudents());

        System.out.println("K129 Sınıfının En iyi öğrencisinin doğum yılı");
        System.out.println(courseK129.getBestStudent().getPd().getBirthDate().getYear());

        Course courseK130 = new Course("K130");

        Student[] transportingStudents = courseK129.getStudents();

        for (Student std : transportingStudents)
            courseK130.addStudent(std);

        System.out.println("K129 Sınıfının Öğrencileri K130 Sınıfına Aktarıldı...");

        System.out.println("K129 Sınıfı Sıfırlandı...");
        courseK129.clear();

        System.out.println("K129'dan ID 5005 atılmaya çalışılıyor : " + courseK129.dropStudent(ahmet));

        System.out.println("K130 Öğrenci Listesi");
        courseK130.list();

        System.out.println("En genç öğrencinin ortalaması : " + courseK130.getYoungestStudent().getGpa());

        System.out.println("Kurs 129 Öğrenci Listesi :");
        courseK129.list();

        System.out.println("Kurs 130 Öğrenci Listesi");
        courseK130.list();

    }
}
