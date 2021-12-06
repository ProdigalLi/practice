//package com.yuan.practice.util;
//
///**
// * @author Yuan
// */
//
//import com.alibaba.fastjson.JSON;
//import com.yuan.practice.pojo.po.Question;
//
//import java.io.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
//@SuppressWarnings("all")
//public class DataImport {
//    public static void main(String[] args) throws Exception {
//        String url = "jdbc:mysql://119.91.148.123:3306/online_practice?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai";
//        String driver = "com.mysql.cj.jdbc.Driver";
//        String pass = "JjpypnLJkSp6cXmZ";
//        String user = "online_practice";
//
//        Class.forName(driver);
//        Connection connection = DriverManager.getConnection(url, user, pass);
//        String sql = "insert into question values(default, ?, ?, ?, ?, ?, ?, ?, ? , ?, ?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
////        List<Question> questions = JSON.parseArray(, Question.class);
//
//        String path = DataImport.class.getClassLoader().getResource("1.json").getPath();
//        String s = DataImport.readJsonFile(path);
//        System.out.println(s);
//        List<Question> questions = JSON.parseArray(s, Question.class);
//        System.out.println(questions.size() + "条数据插入中...");
//        questions.forEach(question -> {
//            try {
//                preparedStatement.setString(1, question.getQuestion());
//                if (null != question.option1) {
//                    String option = question.option1 + "#" + question.option2 + "#" + question.option3 + "#" + question.option4;
//                    preparedStatement.setString(2, option);
//                } else {
//                    preparedStatement.setString(2, null);
//                }
//                preparedStatement.setString(3, question.answer);
//                preparedStatement.setString(4, question.explain);
//                preparedStatement.setString(5, question.pic);
//                preparedStatement.setInt(6, 0);
//                preparedStatement.setInt(7, question.option1 == null ? 2 :
//                        question.answer.length() > 1 ? 1 : 0);
//                preparedStatement.setInt(8, 1);
//                preparedStatement.setString(9, question.getChapter());
//                preparedStatement.setString(10, question.getType());
//                preparedStatement.addBatch();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        });
//        preparedStatement.executeBatch();
//    }
//
//    public static String readJsonFile(String fileName) {
//        String jsonStr = "";
//        try {
//            File jsonFile = new File(fileName);
//            FileReader fileReader = new FileReader(jsonFile);
//
//            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
//            int ch = 0;
//            StringBuffer sb = new StringBuffer();
//            while ((ch = reader.read()) != -1) {
//                sb.append((char) ch);
//            }
//            fileReader.close();
//            reader.close();
//            jsonStr = sb.toString();
//            return jsonStr;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//}
//
