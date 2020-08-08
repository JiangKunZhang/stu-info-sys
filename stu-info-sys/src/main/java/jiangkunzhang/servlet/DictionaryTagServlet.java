package jiangkunzhang.servlet;

import jiangkunzhang.dao.DictionaryTagDAO;
import jiangkunzhang.model.DictionaryTag;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/7/31 19:04
 */

@WebServlet("/dict/tag/query")
public class DictionaryTagServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String key = req.getParameter("dictionaryKey");
        List<DictionaryTag> tags = DictionaryTagDAO.query(key);
        return tags;
    }
}
