package ex0821;

import java.io.*;

public class BufferedFileReaderWriterExam {
    public BufferedFileReaderWriterExam() {
        // 문자단위로 파일을 읽기/쓰기(저장)
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 객체생성
            br = new BufferedReader(new FileReader("src/ex0820/a.txt"));
            // 한문자씩 읽기(Reads a single character)
            /*int data = 0;
            while ((data = br.read()) != -1){
                System.out.println(data + " = " + (char)data);
            }*/
            String str = null;
            while((str = br.readLine()) != null ) {
                System.out.println(str);
            }

            //파일에 저장하기
            bw = new BufferedWriter(new FileWriter("src/ex0821/info.txt"));
            bw.write("쉬고싶지요?");
            bw.write("곧쉬어요");
            bw.newLine();
            bw.write("즐거운 금요일\n");
            bw.write("주말에 푹쉬기");

            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BufferedFileReaderWriterExam();
    }
}
