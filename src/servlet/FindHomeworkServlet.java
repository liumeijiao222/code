package servlet;

import jdbc.StudentHomeworkJdbc;
import model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *该页面展示某项作业具体提交情况
 */

@WebServlet("/find")
public class FindHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        //从数据库读取指定作业id的所有记录
        List<StudentHomework> list = StudentHomeworkJdbc.selectAll(id);//访问数据库
        req.setAttribute("list",list);
        req.getRequestDispatcher("findhomework.jsp").forward(req,resp); //展示数据
    }
}