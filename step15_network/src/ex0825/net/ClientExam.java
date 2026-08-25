package ex0825.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExam {
    public ClientExam() {
        try (Socket socket = new Socket("192.168.0.40", 8000)) {
            // 서버에 데이터 전송
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("서버 접속 허용 요청");

            // 서버가 보내온 데이터 읽기
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverData = bufferedReader.readLine();
            System.out.println("서버가 보내온 내용 = " + serverData);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientExam();
    }
}
