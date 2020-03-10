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
 *该页面展示提交情况缓冲液，即提交情况页
 */

@WebServlet("/showstudenthomework")
public class ShowHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从数据库读取所有作业记录
        List<Homework> list = StudentHomeworkJdbc.showHomework();
        req.setAttribute("list",list);
        req.getRequestDispatcher("showstudenthomework.jsp").forward(req,resp);






    }
}