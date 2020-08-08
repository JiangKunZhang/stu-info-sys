package jiangkunzhang.servlet;

import jiangkunzhang.model.Response;
import jiangkunzhang.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/26 12:22
 */

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        PrintWriter  pw = resp.getWriter();
        Response r = new Response();
        r.setCode("COK200");
        r.setMessage("操作成功");
        List<String> l = new ArrayList<>();
        l.add("A");
        l.add("B");
        l.add("C");

        r.setData(l);
        pw.println(JSONUtil.write(r));
        pw.flush();
    }
}
