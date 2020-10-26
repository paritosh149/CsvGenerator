package com.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        File file = new File("txnData.csv");
        FileOutputStream fos = new FileOutputStream(file);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        LocalDateTime startDateTime = LocalDateTime.parse("2000-01-01T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        for (int i = 0; i < 100; i++) {
            startDateTime = startDateTime.plusMinutes(10);
            String line = (char) (Math.floor(Math.random() * 26) + 64) + "," + startDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "," + Math.random() * 100;

            bw.write(line);
            bw.newLine();
        }

        bw.close();

    }
}
