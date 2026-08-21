package ex0820;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyExam {
    public FileCopyExam(String readFileName, String writeFileName) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(readFileName);
            fos = new FileOutputStream(writeFileName);

            while(true) {
                int i = fis.read();
                if (i == -1) break;
                fos.write(i);
            }
            System.out.println("복사가 완료 되었습니다.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } // 생성자 끝

    public static void main(String[] args) {
        String readFile = JOptionPane.showInputDialog("읽을 파일명은?");
        String writeFile = JOptionPane.showInputDialog("저장할 파일명은?");

        new FileCopyExam(readFile, writeFile);
    }
}
