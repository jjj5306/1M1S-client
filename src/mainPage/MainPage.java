package mainPage;

import loginPage.loginPage;
import forumPage.forumPage;
import javax.swing.*;
import java.awt.*;

public class mainPage extends JFrame {
    private final Font mainFont = new Font("나눔고딕", Font.PLAIN, 20);
    public myPanel mainPanel = new myPanel();

    public mainPage() {
        //프레임 설정
        setTitle("1M1S");
        setVisible(false);
        setLayout(null);
        setResizable(false);
        setSize(1115, 824);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(mainPanel);

        //**************************************************************************************************************

        //패널 설정
        mainPanel.setSize(1100, 824);
        mainPanel.setLayout(null);
        mainPanel.setVisible(true);

        //**************************************************************************************************************

        //마이페이지 버튼 설정
        JButton button1 = new JButton("회원 정보");
        button1.addActionListener(e -> {
            //여기에 마이 페이지로 이동하는 부분 작성
            JOptionPane.showMessageDialog(null, "마이페이지로 이동합니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
        });
        button1.setFont(mainFont);
        button1.setBounds(0, 0, 200, 110);
        mainPanel.add(button1);

        //시간관리 버튼 설정
        JButton button2 = new JButton("시간 관리");
        button2.addActionListener(e -> {
            //여기에 시간관리 페이지로 이동하는 부분 작성
            JOptionPane.showMessageDialog(null, "시간관리로 이동합니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
        });
        button2.setFont(mainFont);
        button2.setBounds(0, 110, 200, 110);
        mainPanel.add(button2);

        //랭킹 버튼 설정
        JButton button3 = new JButton("랭킹");
        button3.addActionListener(e -> {
            //여기에 랭킹 페이지로 이동하는 부분 작성
            JOptionPane.showMessageDialog(null, "랭킹으로 이동합니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
        });
        button3.setFont(mainFont);
        button3.setBounds(0, 220, 200, 110);
        mainPanel.add(button3);

        //상담 버튼 설정
        JButton button4 = new JButton("상담");
        button4.addActionListener(e -> {
            //여기에 그룹 페이지로 이동하는 부분 작성
            JOptionPane.showMessageDialog(null, "상담으로 이동합니다.", "Message", JOptionPane.INFORMATION_MESSAGE);
        });
        button4.setFont(mainFont);
        button4.setBounds(0, 330, 200, 110);
        mainPanel.add(button4);

        //게시판 버튼 설정
        JButton button5 = new JButton("게시판");
        button5.addActionListener(e -> {
            forumPage forum = new forumPage();
        });
        button5.setFont(mainFont);
        button5.setBounds(0, 440, 200, 110);
        mainPanel.add(button5);

        //커리큘럼 버튼 설정
        //게시판 버튼 설정
        JButton button6 = new JButton("커리큘럼");
        button6.addActionListener(e -> JOptionPane.showMessageDialog(null, "커리큘럼으로 이동합니다.", "Message", JOptionPane.INFORMATION_MESSAGE));
        button6.setFont(mainFont);
        button6.setBounds(0, 550, 200, 250);
        mainPanel.add(button6);
    }

    static class myPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\mainPage\\background1.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }

    public static void main(String[] args) {
        mainPage p = new mainPage();
        loginPage loginP = new loginPage(p);
    }
}
