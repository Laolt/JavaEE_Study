package org.example.config;

import javax.servlet.*;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.io.IOException;

public class ServletContainerConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    //处理乱码，过滤器，Post请求传参乱码问题利用过滤器进行过滤即可
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter=new CharacterEncodingFilter();//字符串过滤
        filter.setEncoding("utf-8");

        return new Filter[]{new filterDIY()/*传递自定义过滤器，也可以传递上述声明过滤器*/};//super.getServletFilters()//需要一个过滤集合对象
    }

}
//-----------------------------------自定义过滤器------------------------------
class filterDIY implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {
    }
}