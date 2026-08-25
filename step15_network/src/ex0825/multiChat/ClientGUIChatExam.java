package ex0825.multiChat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUIChatExam  extends JFrame{
	
	JTextArea textArea = new JTextArea();
	JTextField textField = new JTextField();
	JScrollPane scrollPane = new JScrollPane(textArea);
	
	Socket sk;
	PrintWriter pw;
	BufferedReader br;
	
    public ClientGUIChatExam() {
    	super("채팅프로그램");
    	
    	Container con = getContentPane();
    	
    	//컴포넌트 추가
    	con.add(textField,BorderLayout.SOUTH);
    	con.add(scrollPane, BorderLayout.CENTER);
    	
    	//옵션 설정
    	textArea.setFocusable(false);//커서 놓기 안됨
    	textArea.setBackground(Color.CYAN);

    	//창크기
    	setSize(500,400);
    	
    	//정중앙놓기
    	setLocationRelativeTo(null);
    	
    	//보여줘
    	setVisible(true);
    	
    	//x클릭했을때 프로그램 종료
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //서버 연결
    	connection();
    	
    	//이벤트처리(JTextField에 값을 입력하고 enter했을때 서버에 데이터 전송)
    	textField.addActionListener((e)->{
            //textField 값을 읽기
            String input = textField.getText();

            //서버에 전송
            pw.println(input);

            //textField 내용 지우기
            textField.setText("");

    		
    	});
    	
    	//서버가 보내온 데이터를 받아서 JTextArea에 추가 하는 스레드 
    	new Thread(() -> {
            while (true) {
                try {
                    String data = br.readLine();
                    textArea.append(data + "\n");
                    textArea.setCaretPosition(textArea.getText().length());
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }).start();
    	
    	
    } //생성자 끝
    
    /**
     * 서버 접속 요청 메소드 
     * */
    public void connection() {
    	try {
    		sk = new Socket("192.168.0.10", 8002);
    	    br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
    	    pw = new PrintWriter(sk.getOutputStream(),true);

    	    //대화명 입력 창을 띄운다.
            String name;
            while (true) {
                name = JOptionPane.showInputDialog(this, "대화명을 입력하세요");
                pw.println(name);

                String response = br.readLine(); // 서버 응답(OK/DUP) 읽기
                if (response == null) {
                    System.exit(0);
                }

                if (response.equals("OK")) {
                    break; // 통과 → 채팅 시작
                } else {
                    JOptionPane.showMessageDialog(this, "중복된 닉네임입니다. 다시 입력해주세요.");
                }
            }
                setTitle("["+name+"]");

    	} catch (Exception e) {
			e.printStackTrace();
		}
    }

	public static void main(String[] args) {
		new ClientGUIChatExam();
	}

}









