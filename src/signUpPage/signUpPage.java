package signUpPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class signUpPage extends JFrame {
    private Font ButtonFont = new Font("나눔고딕", Font.PLAIN, 20);;
    private myPanel panel1 = new myPanel();

    public signUpPage(){
        //패널 설정
        //패널1에서 회원가입 기본 정보입력 받기
        panel1.setSize(1100, 824);
        panel1.setLayout(null);

        //패널 2~...에서 설문조사 정보 입력받기

        //프레임 설정
        setTitle("1M1S");
        add(panel1);
        setLayout(null);
        setResizable(false);
        setSize(1100,824);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //myPanel정의 후 사용
    class myPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\background.png");
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
