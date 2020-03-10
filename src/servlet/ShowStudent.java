package servlet;

import jdbc.StudentHomeworkJdbc;
import model.Homework;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showstudent")
public class ShowStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从数据库读取所有作业记录
        List<Student> list = StudentHomeworkJdbc.showStudent();
        req.setAttribute("list",list);
        req.getRequestDispatcher("showstudent.jsp").forward(req,resp);






    }
}