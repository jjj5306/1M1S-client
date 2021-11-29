package myPage;

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

public class myPage extends JFrame {
    private final Font mainFont = new Font("나눔고딕", Font.PLAIN, 20);
    private final Font smallFont = new Font("나눔고딕", Font.PLAIN, 17);
    private final Font tinyFont = new Font("나눔고딕", Font.PLAIN, 13);
    private final Font bigFont = new Font("나눔고딕", Font.PLAIN, 25);
    private final Font giantFont = new Font("나눔고딕", Font.BOLD, 35);
    private final myPanel panel = new myPanel();
    //user_id 받아서 사용
    private final Long user_id = (long)1;
    public myPage() {
        //프레임 설정
        setTitle("1M1S-myPage");
        setVisible(true);
        setLayout(null);
        setResizable(false);
        setSize(1115, 824);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(panel);
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //패널 설정
        panel.setSize(1100, 824);
        panel.setLayout(null);
        panel.setVisible(true);

        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************
        //***********************************************************************************************************************************************************************

        //user_id의 인적사항 받아오기
        MemberInformation memberInformation = new MemberInformation("조준화", "nickname", "email", true, "aaa", "bbb123");
        //이름 라벨
        JLabel nameLabel = new JLabel();
        nameLabel.setText("이름  " + memberInformation.getName()+"                                   " + memberInformation.getGender());
        nameLabel.setFont(mainFont);
        nameLabel.setBounds(20, 90, 800, 60);
        panel.add(nameLabel);

        //닉네임 라벨
        JLabel nickNameLabel = new JLabel();
        nickNameLabel.setText("닉네임  " + memberInformation.getNickname());
        nickNameLabel.setFont(mainFont);
        nickNameLabel.setBounds(20, 180, 800, 60);
        panel.add(nickNameLabel);
        //닉네임 변경버튼
        JButton nickNameButton = new JButton();
        nickNameButton.addActionListener(e -> {
            String temp = JOptionPane.showInputDialog("변경할 닉네임을 입력하세요.");
            if(temp != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                HttpClient client = HttpClient.newHttpClient();

                //request 보내기
                String uri = "http://localhost:8080/api/user/" + user_id + "/information";
                //request body
                MemberInformation modifiedMember = new MemberInformation();
                modifiedMember.setNickname(temp);
                String requestBody = null;
                try {
                    requestBody = objectMapper.writeValueAsString(modifiedMember);
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(uri))
                            .header("Content-Type", "application/json; charset=UTF-8")  // content type, 인코딩형식 지정.
                            .PUT(HttpRequest.BodyPublishers.ofString(requestBody))  // HTTP 메소드, body 지정(위에서 만든 JSON 전달)
                            .build();
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
            }
        });
        nickNameButton.setText("변경하기");
        nickNameButton.setFont(mainFont);
        nickNameButton.setBounds(285, 185, 120, 40);
        panel.add(nickNameButton);

        //이메일 라벨
        JLabel emailLabel = new JLabel();
        emailLabel.setText("이메일  " + memberInformation.getNickname());
        emailLabel.setFont(mainFont);
        emailLabel.setBounds(20, 270, 800, 60);
        panel.add(emailLabel);
        //이메일 변경버튼
        JButton emailButton = new JButton();
        emailButton.addActionListener(e -> {
            String temp = JOptionPane.showInputDialog("변경할 이메일을 입력하세요.");
            if(temp != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                HttpClient client = HttpClient.newHttpClient();

                //request 보내기
                String uri = "http://localhost:8080/api/user/" + user_id + "/information";
                //request body
                MemberInformation modifiedMember = new MemberInformation();
                modifiedMember.setEmail(temp);
                String requestBody = null;
                try {
                    requestBody = objectMapper.writeValueAsString(modifiedMember);
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(uri))
                            .header("Content-Type", "application/json; charset=UTF-8")  // content type, 인코딩형식 지정.
                            .PUT(HttpRequest.BodyPublishers.ofString(requestBody))  // HTTP 메소드, body 지정(위에서 만든 JSON 전달)
                            .build();
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
            }
        });
        emailButton.setText("변경하기");
        emailButton.setFont(mainFont);
        emailButton.setBounds(285, 275, 120, 40);
        panel.add(emailButton);

        //아이디 라벨
        JLabel userIdLabel = new JLabel();
        userIdLabel.setText("아이디  " + memberInformation.getMember().getUsername());
        userIdLabel.setFont(mainFont);
        userIdLabel.setBounds(20, 360, 800, 60);
        panel.add(userIdLabel);
        //아이디 변경버튼
        JButton userIdButton = new JButton();
        userIdButton.addActionListener(e -> {
            String temp = JOptionPane.showInputDialog("변경할 아이디를 입력하세요.");
            if(temp != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                HttpClient client = HttpClient.newHttpClient();

                //request 보내기
                String uri = "http://localhost:8080/api/user/" + user_id + "/information";
                //request body
                MemberInformation modifiedMember = new MemberInformation(temp, memberInformation.getMember().getPassword());
                String requestBody = null;
                try {
                    requestBody = objectMapper.writeValueAsString(modifiedMember);
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(uri))
                            .header("Content-Type", "application/json; charset=UTF-8")  // content type, 인코딩형식 지정.
                            .PUT(HttpRequest.BodyPublishers.ofString(requestBody))  // HTTP 메소드, body 지정(위에서 만든 JSON 전달)
                            .build();
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
            }
        });
        userIdButton.setText("변경하기");
        userIdButton.setFont(mainFont);
        userIdButton.setBounds(285, 365, 120, 40);
        panel.add(userIdButton);

        //비밀번호 변경버튼
        JButton passwordButton = new JButton();
        passwordButton.setText("비밀번호 변경하기");
        passwordButton.addActionListener(e -> {
            String temp = JOptionPane.showInputDialog("변경할 비밀번호를 입력하세요.");
            if(temp != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                HttpClient client = HttpClient.newHttpClient();

                //request 보내기
                String uri = "http://localhost:8080/api/user/" + user_id + "/information";
                //request body
                MemberInformation modifiedMember = new MemberInformation(memberInformation.getMember().getUsername(), temp);
                String requestBody = null;
                try {
                    requestBody = objectMapper.writeValueAsString(modifiedMember);
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(uri))
                            .header("Content-Type", "application/json; charset=UTF-8")  // content type, 인코딩형식 지정.
                            .PUT(HttpRequest.BodyPublishers.ofString(requestBody))  // HTTP 메소드, body 지정(위에서 만든 JSON 전달)
                            .build();
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
            }
        });
        passwordButton.setFont(mainFont);
        passwordButton.setBounds(60, 450, 240, 40);
        panel.add(passwordButton);


        //table header
        String[] header = {"id", "interest", "title", "content"};

        //내가 쓴 글
        //라벨
        JLabel writeLabel = new JLabel();
        writeLabel.setText("내가 쓴 글");
        writeLabel.setFont(mainFont);
        writeLabel.setBounds(520, 90, 800, 60);
        panel.add(writeLabel);

        DefaultTableModel write_dtm = new DefaultTableModel(0, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable writeTable = new JTable(write_dtm);
        //칼럼 만들기
        write_dtm.setColumnIdentifiers(header);
        //id, interest안보이게 설정
        writeTable.getColumn("id").setWidth(0);
        writeTable.getColumn("id").setMinWidth(0);
        writeTable.getColumn("id").setMaxWidth(0);
        writeTable.getColumn("interest").setWidth(0);
        writeTable.getColumn("interest").setMinWidth(0);
        writeTable.getColumn("interest").setMaxWidth(0);
        writeTable.getColumn("title").setWidth(250);
        writeTable.getColumn("title").setMinWidth(250);
        writeTable.getColumn("title").setMaxWidth(250);
        writeTable.getColumn("content").setWidth(250);
        writeTable.getColumn("content").setMinWidth(250);
        writeTable.getColumn("content").setMaxWidth(250);
        //컬럼 크기, 위치 조절 불가
        writeTable.getTableHeader().setReorderingAllowed(false);
        writeTable.getTableHeader().setReorderingAllowed(false);
        //마우스 이벤트 추가
        writeTable.addMouseListener(new MyMouseListener());
        //스크롤팬 설정
        JScrollPane writeScrollPane = new JScrollPane(writeTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        writeScrollPane.setVisible(true);
        writeScrollPane.setBounds(520, 135, 500, 280);
        panel.add(writeScrollPane);
        updatePost(write_dtm);

        //내가 댓글 단 글
        //라벨
        JLabel commentLabel = new JLabel();
        commentLabel.setText("내가 쓴 댓글");
        commentLabel.setFont(mainFont);
        commentLabel.setBounds(520, 415, 800, 60);
        panel.add(commentLabel);
        DefaultTableModel comment_dtm = new DefaultTableModel(0, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable commentTable = new JTable(comment_dtm);
        //칼럼 만들기
        comment_dtm.setColumnIdentifiers(header);
        //id, interest안보이게 설정
        commentTable.getColumn("id").setWidth(0);
        commentTable.getColumn("id").setMinWidth(0);
        commentTable.getColumn("id").setMaxWidth(0);
        commentTable.getColumn("interest").setWidth(0);
        commentTable.getColumn("interest").setMinWidth(0);
        commentTable.getColumn("interest").setMaxWidth(0);
        commentTable.getColumn("title").setWidth(250);
        commentTable.getColumn("title").setMinWidth(250);
        commentTable.getColumn("title").setMaxWidth(250);
        commentTable.getColumn("content").setWidth(250);
        commentTable.getColumn("content").setMinWidth(250);
        commentTable.getColumn("content").setMaxWidth(250);
        //컬럼 크기, 위치 조절 불가
        commentTable.getTableHeader().setReorderingAllowed(false);
        commentTable.getTableHeader().setReorderingAllowed(false);
        //마우스 이벤트 추가
        commentTable.addMouseListener(new MyMouseListener());
        //스크롤팬 설정
        JScrollPane commentScrollPane = new JScrollPane(commentTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        commentScrollPane.setVisible(true);
        commentScrollPane.setBounds(520, 460, 500, 280);
        panel.add(commentScrollPane);
        updateComment(comment_dtm);


    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    //게시판 업데이트 함수
    void updatePost(DefaultTableModel dtm){
        dtm.setRowCount(0); //테이블 초기화
        try{
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper mapper = new ObjectMapper();

            //request보내기
            String uri = "http://localhost:8080/api/user/" + user_id + "/post";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))  // 위에서 만든 URI
                    .GET()  // HTTP 메소드, body 지정(GET의 경우 생략 가능)
                    .build();

            // 위에서 생성한 request를 보내고, 받은 response를 저장
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // responseBody to Post Class Array
            Post[] posts = mapper.readValue(response.body(), Post[].class);

            // Jtable에 일정 추가
            for(Post p : posts) {
                dtm.addRow(new Object[] {p.getId(), p.getInterest(), p.getTitle(), p.getContent()});
            }
        }catch(Exception e){
            System.out.println("게시글 업데이트 오류");
            e.printStackTrace();
        }
    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    //댓글 업데이트 함수
    private void updateComment(DefaultTableModel dtm) {
        dtm.setRowCount(0); //테이블 초기화
        try{
            HttpClient client = HttpClient.newHttpClient();
            ObjectMapper mapper = new ObjectMapper();

            //request보내기
            String uri = "http://localhost:8080/api/user/" + user_id + "/comment";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))  // 위에서 만든 URI
                    .GET()  // HTTP 메소드, body 지정(GET의 경우 생략 가능)
                    .build();

            // 위에서 생성한 request를 보내고, 받은 response를 저장
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // responseBody to Post Class Array
            Comment[] comments = mapper.readValue(response.body(), Comment[].class);

            // Jtable에 일정 추가
            for(Comment c : comments) {
                dtm.addRow(new Object[] {c.getPost().getId(),c.getPost().getInterest(), c.getPost().getTitle(), c.getContent()});
            }
        }catch(Exception e){
            System.out.println("댓글 업데이트 오류");
            e.printStackTrace();
        }
    }
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    //게시글 테이블 클릭 이벤트
    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e){
            if(e.getClickCount() == 2 ){

            }
        }
    }

    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************

    static class myPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            Dimension d = getSize();
            ImageIcon image = new ImageIcon("C:\\Users\\Asus\\IdeaProjects\\1M1S-client\\src\\myPage\\background6.png");
            g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
        }
    }
}
