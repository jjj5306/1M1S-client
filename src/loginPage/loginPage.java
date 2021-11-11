package loginPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import signUpPage.signUpPage;
import mainPage.mainPage;

@SuppressWarnings("serial")
public class loginPage extends JFrame{
    private Font ButtonFont = new Font("나눔고딕", Font.PLAIN, 20);;
    private myPanel panel = new myPanel();

    public loginPage(){
        //패널 설정
        panel.setSize(1100, 824);
        panel.setLayout(null);

        //아이디 입력받는 박스
        Label idLabel = new Label();
        idLabel.setText("USER ID");
        idLabel.setFont(ButtonFont);
        idLabel.setBounds(320, 200, 88, 30);
        panel.add(idLabel);

        TextField idText = new TextField();
        idText.setFont(ButtonFont);
        idText.setBounds(320, 235, 370, 30);
        panel.add(idText);

        //비밀번호 입력받는 박스
        Label pwdLabel = new Label();
        pwdLabel.setText("PASSWORD");
        pwdLabel.setFont(ButtonFont);
        pwdLabel.setBounds(320, 280, 125, 30);
        panel.add(pwdLabel);

        TextField pwdText = new TextField();
        pwdText.setFont(ButtonFont);
        pwdText.setBounds(320, 315, 370, 30);
        pwdText.setEchoChar('*');
        panel.add(pwdText);

        //로그인 버튼
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //로그인 관련 부분 나중에 db연동하여 api사용
                var values = new HashMap<String, String>() {{
                    put("username", idText.getText());
                    put("password", pwdText.getText());
                }};
                var objectMapper = new ObjectMapper();
                try {
                    String requestBody = objectMapper.writeValueAsString(values);
                    System.out.println(requestBody);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }


                if(idText.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }else if(pwdText.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
                }
                else if(!(idText.getText().equals("aaa"))) {
                    JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.", "Message", JOptionPane.ERROR_MESSAGE);
                    idText.setText("");
                    pwdText.setText("");
                } else if(!(pwdText.getText().equals("bbb123"))){
                    JOptionPane.showMessageDialog(null, "틀린 비밀번호입니다.", "Message", JOptionPane.ERROR_MESSAGE);
                    pwdText.setText("");
                } else{
                    unvisible();
                }
            }
        });
        loginButton.setFont(ButtonFont);
        loginButton.setBounds(320, 355, 180, 80);
        panel.add(loginButton);

        //회원가입 버튼
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpPage signUp = new signUpPage();
                signUp.visible();
            }
        });

        signUpButton.setFont(ButtonFont);
        signUpButton.setBounds(510, 355, 180, 80);
        panel.add(signUpButton);

        //프레임 설정
        setTitle("1M1S");
        add(panel);
        setLayout(null);
        setResizable(false);
        setSize(1100,824);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        visible();
    }

    //myPanel정의 후 사용
    class myPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\loginPage\\background.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }

    public void visible(){
        setVisible(true);
    }

    public void unvisible(){
        setVisible(false);
    }
}
