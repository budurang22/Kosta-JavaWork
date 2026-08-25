package ex0825.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {
    public ServerExam() {
        try (ServerSocket server = new ServerSocket(8000)) {
            while (true) {
                System.out.println("클라이언트 접속 대기 중");
                Socket socket = server.accept(); // 클라이언트 접속 대기 - 접속되면 수락되어 Socket 반환

                // 접속된 클라이언트 IP조회
                String ip = socket.getInetAddress().toString();
                System.out.println(ip + "님 접속 되었습니다.");

                // 클라이언트로 부터 전송된 데이터 읽기
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientData = bufferedReader.readLine();
                System.out.println("클라이언트가 보내온 내용 = " + clientData);

                // 클라이언트에게 데이터 전송
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println("서버 접속 확인");

                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerExam();
    }
}
