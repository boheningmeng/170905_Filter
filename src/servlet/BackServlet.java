package servlet;

import dao.CategoryDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by LENOVO on 2017/9/5.
 */
public abstract  class BackServlet extends HttpServlet{
    public abstract String add(HttpServletRequest request, HttpServletResponse response);

    public abstract String delete(HttpServletRequest request, HttpServletResponse response);

    public abstract String edit(HttpServletRequest request, HttpServletResponse response);

    public abstract String update(HttpServletRequest request, HttpServletResponse response);

    public abstract String list(HttpServletRequest request, HttpServletResponse response  );

    protected CategoryDao categoryDao = new CategoryDao();

    public void service(HttpServletRequest request, HttpServletResponse response) {
        try {


			/*借助反射，调用对应的方法*/
            String method = (String) request.getAttribute("method");
            Method m = this.getClass().getMethod(method, HttpServletRequest.class,
                    HttpServletResponse.class);
            String redirect = m.invoke(this, request, response).toString();

			/*根据方法的返回值，进行相应的客户端跳转，服务端跳转，或者仅仅是输出字符串*/

            if (redirect.startsWith("@"))
                response.sendRedirect(redirect.substring(1));
            else if (redirect.startsWith("%"))
                response.getWriter().print(redirect.substring(1));
            else
                request.getRequestDispatcher(redirect).forward(request, response);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
