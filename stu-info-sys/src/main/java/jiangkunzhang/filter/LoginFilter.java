package jiangkunzhang.filter;

import jiangkunzhang.model.Response;
import jiangkunzhang.util.JSONUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/2 12:04
 */

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getServletPath();
        HttpSession session = req.getSession(false);
        if (session == null) {

            //首页重定向到登录页面
            if ("/public/page/main.html".equals(uri)) {
                resp.setContentType("text/html; charset=UTF-8");
                String schema = req.getScheme();
                String host = req.getServerName();
                int port = req.getServerPort();
                String ctx = req.getContextPath();
                String basePath = schema + "://" + host + ":" + port + ctx;
                resp.sendRedirect(basePath + "/public/index.html");
                return;
            //后端非登录接口，未登陆不允许访问的请求，一般返回401状态码
            } else if ((!uri.startsWith("/public/") && !uri.startsWith("/static/") && !"/user/login".equals(uri))) {//后端非登录接口
                resp.setContentType("application/json; charset=UTF-8");
                PrintWriter pw = resp.getWriter();
                Response r = new Response();
                r.setCode("ERR401");
                r.setMessage("不允许访问");
                resp.setStatus(401);
                pw.println(JSONUtil.write(r));
                pw.flush();
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
