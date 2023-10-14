package CustomFilter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter initialization logic (if needed)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	HttpSession session  = ((HttpServletRequest) request).getSession();
		String attribute = (String) session.getAttribute("Role");
		
		System.out.println(attribute);
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		if (attribute == null) {
	        httpResponse.sendRedirect("/LoginForm");
	        return;
	    }else {
	    	if(attribute.equals("Cadre Administrateur")) {
	    		System.out.println("Hello");
	    	}else {
	    		 httpResponse.sendRedirect("/GoProfile");
	    	}
	    }
        
		 // Proceed to the next filter or servlet
		
		
		chain.doFilter(request, response);
    }

    
    @Override
    public void destroy() {
        // Filter cleanup logic (if needed)
    }
}