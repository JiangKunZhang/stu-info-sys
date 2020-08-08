package jiangkunzhang.servlet;

import jiangkunzhang.dao.StudentDAO;
import jiangkunzhang.model.Page;
import jiangkunzhang.model.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/31 21:22
 */

@WebServlet("/student/query")
public class StudentQueryServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Page p = Page.parse(req);
        List<Student> students = StudentDAO.query(p);
        return students;
    }
}
