package ex0820;

import javax.swing.*;
import java.io.*;

public class BufferedFileCopyExam {
    public BufferedFileCopyExam(String readFileName, String writeFileName) {
        // FileInputStream fis = null;
        // FileOutputStream fos = null;

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(readFileName));
            bos = new BufferedOutputStream(new FileOutputStream(writeFileName));

            while(true) {
                int i = bis.read();
                if (i == -1) break;
                bos.write(i);
            }
            System.out.println("복사가 완료 되었습니다.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) bis.close();
                if (bos != null) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } // 생성자 끝

    public static void main(String[] args) {
        String readFile = JOptionPane.showInputDialog("읽을 파일명은?");
        String writeFile = JOptionPane.showInputDialog("저장할 파일명은?");

        new BufferedFileCopyExam(readFile, writeFile);
    }
}
