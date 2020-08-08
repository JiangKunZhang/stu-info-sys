package jiangkunzhang.servlet;

import jiangkunzhang.dao.StudentDAO;
import jiangkunzhang.model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/2 10:29
 */

@WebServlet("/student/queryById")
public class StudentQueryByIdServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        Student student = StudentDAO.queryById(Integer.parseInt(id));
        return student;
    }
}
