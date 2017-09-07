package filter;



import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by LENOVO on 2017/9/5.
 */
public class BackServletFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpServletRequest request = (HttpServletRequest)servletRequest;
       /* 假定你的web application 名称为news,你在浏览器中输入请求路径：
        http://localhost:8080/news/main/list.jsp
        则执行下面向行代码后打印出如下结果：
        1、 System.out.println(request.getContextPath());
        打印结果：/news
        2、System.out.println(request.getServletPath());
        打印结果：/main/list.jsp
        3、 System.out.println(request.getRequestURI());
        打印结果：/news/main/list.jsp
        4、 System.out.println(request.getRealPath("/"));
        打印结果：F:\Tomcat 6.0\webapps\news\test*/

        String contextPath = request.getServletContext().getContextPath();
        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri,contextPath);

        if(uri.startsWith("/admin_")){
            String servletPath = StringUtils.substringBetween(uri,"_","_")+"Servlet";
            String method = StringUtils.substringAfterLast(uri,"_");
            request.setAttribute("method",method);
            request.getRequestDispatcher("/"+servletPath).forward(request,response);
            return ;
        }

        filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {

    }
}
