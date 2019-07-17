import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class LoginServlet extends HttpServlet {

//    构造方法和实例方法都只需要执行一次
    public LoginServlet(){
        System.out.println("LoginServlet 构造方法 被调用");
    }
    public void init(ServletConfig config) {
//       在构造方法之后执行
        System.out.println("init(ServletConfig)");
    }
    public void destroy() {
        System.out.println("destroy()");
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setStatus(400);
        response.getWriter().println("<h1>Hello Servlet!</h1><h2>Hello World</h2>");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//枚举所有的key
        Enumeration<String> paams = request.getParameterNames();
        while (paams.hasMoreElements()){
            String name=paams.nextElement();
            String value=request.getParameter(name);
            System.out.println("枚举内容"+name + "=" + value);
        }
        System.out.println("head==============");
        Enumeration<String> headerNames= request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            String value = request.getHeader(header);
            System.out.printf("%s\t%s%n",header,value);
        }
        System.out.println("head==============");
        Enumeration<String> gb = request.getAttributeNames();
        while (gb.hasMoreElements()){
            String name=gb.nextElement();
            System.out.println("GETATTRIBUTE:"+name);

        }

        request.setAttribute("this is set","ok");
//set get servelt 传参

        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println(name);
        System.out.printf("%s = %s%n", name, password);

//        response.setContentType("text/html; charset=UTF-8");
//        response.getWriter().printf("<h1>%s</h1><h2>%s</h2>",name,password);
        if ("admin".equals(name) && "123".equals(password)) {
//            服务端跳转
            request.getRequestDispatcher("success.html").forward(request, response);
        }else{
//            客户端跳转

            response.sendRedirect("fail.html");
        }

    }
}
