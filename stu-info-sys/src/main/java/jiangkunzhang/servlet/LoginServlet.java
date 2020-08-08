package jiangkunzhang.servlet;

import jiangkunzhang.dao.UserDAO;
import jiangkunzhang.model.User;
import jiangkunzhang.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/2 11:45
 */

@WebServlet("/user/login")
public class LoginServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User u = JSONUtil.read(req.getInputStream(), User.class);
        User query = UserDAO.query(u);
        if (query == null) {
            throw new RuntimeException("用户名或密码校验失败");
        }
        HttpSession session = req.getSession();
        session.setAttribute("user", query);
        return null;
    }
}
