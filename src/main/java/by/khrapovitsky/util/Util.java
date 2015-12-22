package by.khrapovitsky.util;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Util {

    public static Date getDateWithoutTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getTomorrowDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    public static File createTxt(String path,String textNote){
        File file = null;
        Writer writer = null;
        try {
            file = new File(path);
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(textNote);
        }catch (IOException  e){
            e.printStackTrace();
            return null;
        }finally {
            try{
                if (writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
                return null;
            }
        }
        return file;
    }

    public static String addToZip(File imgFile, File txtFile,File zipFilePath){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zipFilePath);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            ZipEntry zipEntry = new ZipEntry(imgFile.getName());
            zipOutputStream.putNextEntry(zipEntry);

            byte[] buf = new byte[1024];
            int bytesRead;

            FileInputStream imgInputStream = new FileInputStream(imgFile);
            FileInputStream txtInputStream = new FileInputStream(txtFile);

            while ((bytesRead = imgInputStream.read(buf)) > 0) {
                zipOutputStream.write(buf, 0, bytesRead);
            }

            zipEntry = new ZipEntry(txtFile.getName());
            zipOutputStream.putNextEntry(zipEntry);


            while ((bytesRead = txtInputStream.read(buf)) > 0) {
                zipOutputStream.write(buf, 0, bytesRead);
            }

            zipOutputStream.closeEntry();

            zipOutputStream.close();
            fileOutputStream.close();
            imgInputStream.close();
            txtInputStream.close();

            imgFile.delete();
            txtFile.delete();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return zipFilePath.getName();
    }

}
