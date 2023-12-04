package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class BoardServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<form method='post' action='/exam04/board'>");
        out.println("취미 : <input type='checkbox' name='hobby' value='요리'>요리");
        out.println("<input type='checkbox' name='hobby' value='수영'>수영");
        out.println("<input type='checkbox' name='hobby' value='등산'>등산");
        out.println("<input type='checkbox' name='hobby' value='낮잠'>낮잠<br>");

        out.println("제목 : <input type='text' name='subject'><br>");
        out.println("내용 : <textarea name='content'></textarea><br>");
        out.println("<button type='submit'>작성하기</button>");
        out.println("</form>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");
        String hobby = req.getParameter("hobby");
        String[] hobbies = req.getParameterValues("hobby");
        System.out.printf("subject: %s\ncontent: %s\n",subject,content);
        System.out.printf("hobby: %s\n", Arrays.toString(hobbies));
    }
}
