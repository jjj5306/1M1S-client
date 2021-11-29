package consultingPage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.*;
import forumPage.forumPage;
import utils.Request;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class consultingPage extends JFrame {
    private final Font mainFont = new Font("나눔고딕", Font.PLAIN, 20);
    private final Font smallFont = new Font("나눔고딕", Font.PLAIN, 17);
    private final Font tinyFont = new Font("나눔고딕", Font.PLAIN, 13);
    private final Font bigFont = new Font("나눔고딕", Font.PLAIN, 25);
    private final Font giantFont = new Font("나눔고딕", Font.BOLD, 35);
    private final myPanel panel1 = new myPanel();
    private final myPanel panel2 = new myPanel();
    private final myPanel panelResult = new myPanel();

    public consultingPage() {
        //프레임 설정
        setTitle("1M1S-consulting");
        setVisible(true);
        setLayout(null);
        setResizable(false);
        setSize(1115, 824);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(panel1);
        add(panel2);
        add(panelResult);
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //패널 설정
        panel1.setSize(1100, 824);
        panel1.setLayout(null);
        panel1.setVisible(true);

        panel2.setSize(1100, 824);
        panel2.setLayout(null);
        panel2.setVisible(false);

        panelResult.setSize(1100, 824);
        panelResult.setLayout(null);
        panelResult.setVisible(false);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //패널 1 되돌아가기 버튼
        JButton panel1RollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\consultingPage\\rollback.png")));
        panel1RollBackButton.addActionListener(e -> dispose());
        panel1RollBackButton.setFont(mainFont);
        panel1RollBackButton.setBounds(155, 105, 80, 80);
        panel1RollBackButton.setContentAreaFilled(false);
        panel1.add(panel1RollBackButton);

        //설문조사 대답 선택지
        String[] ans = {"예", "아니요"};
        JRadioButton[] radioButton = new JRadioButton[12];
        for(int i=0; i<radioButton.length; i++) {
            if(i%2 == 0)
                radioButton[i] = new JRadioButton(ans[0]);
            else
                radioButton[i] = new JRadioButton(ans[1]);
            radioButton[i].setFont(smallFont);
        }

        //설문조사 1
        JLabel survey1 = new JLabel();
        survey1.setText("주/월 단위의 목표를 세우나요?");
        survey1.setFont(bigFont);
        survey1.setBounds(300, 120, 500, 70);
        panel1.add(survey1);

        //설문조사 1의 선택지
        ButtonGroup ans1 = new ButtonGroup();
        ans1.add(radioButton[0]);
        ans1.add(radioButton[1]);

        radioButton[0].setBounds(320, 190, 100, 50);
        radioButton[0].setContentAreaFilled(false);
        panel1.add(radioButton[0]);
        radioButton[1].setBounds(470, 190, 100, 50);
        radioButton[1].setContentAreaFilled(false);
        panel1.add(radioButton[1]);

        //설문조사 2
        JLabel survey2 = new JLabel();
        survey2.setText("일일계획을 세우나요?");
        survey2.setFont(bigFont);
        survey2.setBounds(300, 270, 500, 70);
        panel1.add(survey2);

        //설문조사 2의 선택지
        ButtonGroup ans2 = new ButtonGroup();
        ans2.add(radioButton[2]);
        ans2.add(radioButton[3]);

        radioButton[2].setBounds(320, 340, 100, 50);
        radioButton[2].setContentAreaFilled(false);
        panel1.add(radioButton[2]);
        radioButton[3].setBounds(470, 340, 100, 50);
        radioButton[3].setContentAreaFilled(false);
        panel1.add(radioButton[3]);

        //설문조사 3
        JLabel survey3 = new JLabel();
        survey3.setText("일정들간의 우선순의를 정해두시나요?");
        survey3.setFont(bigFont);
        survey3.setBounds(300, 420, 500, 70);
        panel1.add(survey3);

        //설문조사 3의 선택지
        ButtonGroup ans3 = new ButtonGroup();
        ans3.add(radioButton[4]);
        ans3.add(radioButton[5]);

        radioButton[4].setBounds(320, 490, 100, 50);
        radioButton[4].setContentAreaFilled(false);
        panel1.add(radioButton[4]);
        radioButton[5].setBounds(470, 490, 100, 50);
        radioButton[5].setContentAreaFilled(false);
        panel1.add(radioButton[5]);

        //다음 버튼
        JButton nextButton = new JButton();
        nextButton.addActionListener(e -> {
            //선택지 잘 선택 했는지 체크
            boolean flag = false;
            for(int i = 0;i < 6;i+=2) {
                if (!radioButton[i].isSelected() && !radioButton[i + 1].isSelected()) {
                    flag = true;
                    break;
                }
            }
            if(flag){
                JOptionPane.showMessageDialog(null, "모든 질문에 답변해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }
            else{
                panel1.setVisible(false);
                panel2.setVisible(true);
            }
        });
        nextButton.setText("Next");
        nextButton.setFont(mainFont);
        nextButton.setBounds(700, 600, 80, 50);
        panel1.add(nextButton);

        //현재 페이지 index 버튼
        JButton panel1Index1Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\consultingPage\\index1.png")));
        panel1Index1Button.addActionListener(e -> {
        });
        panel1Index1Button.setFont(mainFont);
        panel1Index1Button.setBounds(170, 185, 70, 50);
        panel1Index1Button.setContentAreaFilled(false);
        panel1.add(panel1Index1Button);

        //다음 페이지 index 버튼
        JButton panel1Index2Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index2.png")));
        panel1Index2Button.addActionListener(e -> {
            //선택지 잘 선택 했는지 체크
            boolean flag = false;
            for(int i = 0;i <6;i+=2) {
                if (!radioButton[i].isSelected() && !radioButton[i + 1].isSelected()) {
                    flag = true;
                    break;
                }
            }
            if(flag){
                JOptionPane.showMessageDialog(null, "모든 질문에 답변해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }
            else{
                panel1.setVisible(false);
                panel2.setVisible(true);
            }
        });
        panel1Index2Button.setFont(mainFont);
        panel1Index2Button.setBounds(170, 235, 70, 50);
        panel1Index2Button.setContentAreaFilled(false);
        panel1.add(panel1Index2Button);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //패널 1 되돌아가기 버튼
        JButton panel2RollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\consultingPage\\rollback.png")));
        panel2RollBackButton.addActionListener(e -> dispose());
        panel2RollBackButton.setFont(mainFont);
        panel2RollBackButton.setBounds(155, 105, 80, 80);
        panel2RollBackButton.setContentAreaFilled(false);
        panel2.add(panel2RollBackButton);


        //설문조사 4
        JLabel survey4 = new JLabel();
        survey4.setText("계획을 잘 지키시나요?");
        survey4.setFont(bigFont);
        survey4.setBounds(300, 120, 500, 70);
        panel2.add(survey4);

        //설문조사 4의 선택지
        ButtonGroup ans4 = new ButtonGroup();
        ans4.add(radioButton[6]);
        ans4.add(radioButton[7]);

        radioButton[6].setBounds(320, 190, 100, 50);
        radioButton[6].setContentAreaFilled(false);
        panel2.add(radioButton[6]);
        radioButton[7].setBounds(470, 190, 100, 50);
        radioButton[7].setContentAreaFilled(false);
        panel2.add(radioButton[7]);

        //설문조사 5
        JLabel survey5 = new JLabel();
        survey5.setText("시간관리의 중요성을 아시나요?");
        survey5.setFont(bigFont);
        survey5.setBounds(300, 270, 500, 70);
        panel2.add(survey5);

        //설문조사 5의 선택지
        ButtonGroup ans5 = new ButtonGroup();
        ans5.add(radioButton[8]);
        ans5.add(radioButton[9]);

        radioButton[8].setBounds(320, 340, 100, 50);
        radioButton[8].setContentAreaFilled(false);
        panel2.add(radioButton[8]);
        radioButton[9].setBounds(470, 340, 100, 50);
        radioButton[9].setContentAreaFilled(false);
        panel2.add(radioButton[9]);

        //설문조사 6
        JLabel survey6 = new JLabel();
        survey6.setText("휴식과 숙면의 중요성을 인지하고 계신가요?");
        survey6.setFont(bigFont);
        survey6.setBounds(300, 420, 800, 70);
        panel2.add(survey6);

        //설문조사 6의 선택지
        ButtonGroup ans6 = new ButtonGroup();
        ans6.add(radioButton[10]);
        ans6.add(radioButton[11]);

        radioButton[10].setBounds(320, 490, 100, 50);
        radioButton[10].setContentAreaFilled(false);
        panel2.add(radioButton[10]);
        radioButton[11].setBounds(470, 490, 100, 50);
        radioButton[11].setContentAreaFilled(false);
        panel2.add(radioButton[11]);

        //다음 버튼
        JButton nextButton2 = new JButton();
        nextButton2.addActionListener(e -> {
            //선택지 잘 선택 했는지 체크
            boolean flag = false;
            boolean good = true;
            for(int i = 0;i < radioButton.length;i+=2) {
                if (!radioButton[i].isSelected() && !radioButton[i + 1].isSelected()) {
                    flag = true;
                    break;
                }
                if(radioButton[i+1].isSelected()){
                    good = false;
                }
            }
            if(flag){
                JOptionPane.showMessageDialog(null, "모든 질문에 답변해주세요.", "Message", JOptionPane.ERROR_MESSAGE);
            }
            else{
                panel2.setVisible(false);
                panelResult.setVisible(true);
                if(good){
                    //모든 선택지가 예 인 경우 솔루션이 없음
                    //dispose 버튼
                    JButton panel3RollBackButton = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\consultingPage\\rollback.png")));
                    panel3RollBackButton.addActionListener(ee -> dispose());
                    panel3RollBackButton.setFont(mainFont);
                    panel3RollBackButton.setBounds(155, 105, 80, 80);
                    panel3RollBackButton.setContentAreaFilled(false);
                    panelResult.add(panel3RollBackButton);

                    JLabel goodResult = new JLabel();
                    goodResult.setText("상담 결과는 아주 좋음입니다!");
                    goodResult.setFont(giantFont);
                    goodResult.setBounds(330, 140, 500, 80);
                    panelResult.add(goodResult);

                    JLabel goodResult2 = new JLabel();
                    goodResult2.setText("하던대로 계속 하시면 좋은 결과가 나타날겁니다!");
                    goodResult2.setFont(mainFont);
                    goodResult2.setBounds(340, 230, 1000, 80);
                    panelResult.add(goodResult2);

                }else{
                    //선택지 결과에 따라 솔루션 다르게 설정
                    if(radioButton[1].isSelected()){
                        //1번 보여주기
                        JLabel sol1 = new JLabel();
                        sol1.setText("1. 큰 목표를 정하고 그에 대한 보상을 정해보세요.");
                        sol1.setFont(mainFont);
                        sol1.setBounds(310, 120, 1000, 80);
                        panelResult.add(sol1);
                    }
                    if(radioButton[3].isSelected()){
                        //2번 보여주기
                        JLabel sol2 = new JLabel();
                        sol2.setText("2. 작은 일부터 시작하세요.");
                        sol2.setFont(mainFont);
                        sol2.setBounds(310, 180, 1000, 80);
                        panelResult.add(sol2);
                        JLabel sol2_2 = new JLabel();
                        sol2_2.setText("큰 목표는 작은 일이 목표에 점점 다가갈때 이루어집니다.");
                        sol2_2.setFont(mainFont);
                        sol2_2.setBounds(310, 210, 1000, 80);
                        panelResult.add(sol2_2);
                    }
                    if(radioButton[5].isSelected()){
                        //3번 보여주기
                        JLabel sol3 = new JLabel();
                        sol3.setText("3. 일정 간의 우선순위를 정하고 선택과 집중을 해보세요.");
                        sol3.setFont(mainFont);
                        sol3.setBounds(310, 280, 1000, 80);
                        panelResult.add(sol3);
                    }
                    if(radioButton[7].isSelected()){
                        //4번 보여주기
                        JLabel sol4 = new JLabel();
                        sol4.setText("4. 실행은 완벽보다 낫습니다. 미루는 사이에 일해보세요");
                        sol4.setFont(mainFont);
                        sol4.setBounds(310, 360, 1000, 80);
                        panelResult.add(sol4);
                    }
                    if(radioButton[9].isSelected()){
                        //5번 보여주기
                        JLabel sol5 = new JLabel();
                        sol5.setText("5. 시간은 금으로도 살 수 없습니다.");
                        sol5.setFont(mainFont);
                        sol5.setBounds(310, 440, 1000, 80);
                        panelResult.add(sol5);
                    }
                    if(radioButton[11].isSelected()){
                        //6번 보여주기
                        JLabel sol6 = new JLabel();
                        sol6.setText("6. 휴식을 모르는 사람은 브레이크 없는 자동차와도 같습니다.");
                        sol6.setFont(mainFont);
                        sol6.setBounds(310, 520, 1000, 80);
                        panelResult.add(sol6);
                    }
                }
            }
        });
        nextButton2.setText("Submit");
        nextButton2.setFont(mainFont);
        nextButton2.setBounds(700, 600, 100, 50);
        panel2.add(nextButton2);

        //이전 페이지 index 버튼
        JButton panel2Index1Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\consultingPage\\index1.png")));
        panel2Index1Button.addActionListener(e -> {
            panel2.setVisible(false);
            panel1.setVisible(true);
        });
        panel2Index1Button.setFont(mainFont);
        panel2Index1Button.setBounds(170, 185, 70, 50);
        panel2Index1Button.setContentAreaFilled(false);
        panel2.add(panel2Index1Button);

        //현재 페이지 index 버튼
        JButton panel2Index2Button = new JButton(new ImageIcon(("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\signUpPage\\index2.png")));
        panel2Index2Button.addActionListener(e -> {
        });
        panel2Index2Button.setFont(mainFont);
        panel2Index2Button.setBounds(170, 235, 70, 50);
        panel2Index2Button.setContentAreaFilled(false);
        panel2.add(panel2Index2Button);


    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    static class myPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\consultingPage\\background4.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }
}
