import bean.User;
import dao.UserDao;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import net.sf.json.JSONSerializer;
public class UserServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        UserDao userDao=new UserDao();
        List<User> users = userDao.list();
        for (User user : users) {
            System.out.println(user.getName());
//            String tr = String.format(trFormat, hero.getId(), hero.getName(), hero.getHp(), hero.getDamage());
//            sb.append(tr);
        }
//        JSONObject json= new JSONObject();
//        response.getWriter().print(JSONObject.fromObject(users));
        String result =JSONSerializer.toJSON(users).toString();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(result);
    }


}

