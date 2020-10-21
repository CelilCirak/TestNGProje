package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void test() throws IOException {
        String dosyaYolu = "src/test/resources/Ulkeler.xlsx";

        // Dosyayi acmak icin kullanilir ve dosya yolu yazilir
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // Workbook (Excel) dosyasini okumaya basladik
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // 1. sayfaya gider (index 0 dan baslar
        Sheet sheet = workbook.getSheetAt(0);

        // 1. satira gider (index 0 dan baslar)
        Row row = sheet.getRow(0);

        // 1. Hucreyi alalim (index 0 dan baslar.
        Cell ulkeler = row.getCell(0);
        Cell baskentler = row.getCell(1);
        Cell meshurlar = row.getCell(2);

        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshurlar);

        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(1));
        System.out.println(workbook.getSheetAt(0).getRow(7).getCell(2));
        System.out.println(workbook.getSheetAt(0).getRow(9).getCell(0));
        System.out.println(workbook.getSheetAt(0).getRow(10).getCell(0));

        // Son satır(Row)'ın numarasını almak için (indexini, index 0 dan başlar)
        int satirSayisi = workbook.getSheetAt(0).getLastRowNum() + 1;
        System.out.println("Satır sayısı : " + satirSayisi);

        // İçerisinde veri olan satır sayısını almak isterseniz
        // index'i 1'den başlıyor.
        int doluSatirSayisi = workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println("Dolu Satır Sayısı : " + doluSatirSayisi);

        int sonSatirinIndexi = workbook.getSheetAt(0).getLastRowNum(); // 10
        for (int i = 0; i <= sonSatirinIndexi; i++) {
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));

        }


            int sonSatirinIndex = workbook.getSheetAt(0).getLastRowNum(); // 10
            for (int j = 0; j <= sonSatirinIndex; j++) {
                System.out.println(workbook.getSheetAt(0).getRow(j).getCell(1));


            }

        // bir satırın son sütunun indexini alma. 1 den basliyor.
        int sonSutunIndex = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println("Son Sütun İndex : " + sonSutunIndex);


        int dorduncuSatir = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println("dorduncuSatir : " + dorduncuSatir);
        for (int i = 0 ; i < dorduncuSatir ; i++){
            System.out.println(workbook.getSheetAt(0).getRow(3).getCell(i));
        }

        }

    }



