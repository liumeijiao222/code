package servlet;

import jdbc.StudentHomeworkJdbc;
import model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *该页面展示主页面，即提交作业页面
 */
@WebServlet("/homework")
public class HomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从数据库读取所有作业记录
        List<Homework> list = StudentHomeworkJdbc.showHomework();
        req.setAttribute("list",list);
        req.getRequestDispatcher("homework.jsp").forward(req,resp);
    }
}