package mx.com.santander.interceptor;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component("validaInterceptor")
public class ValidaInterceptor implements HandlerInterceptor{
	
	private static final Logger logger = LoggerFactory.getLogger(ValidaInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		response.addHeader("ID_CLIENT_SESSION", "78965088");

		if(handler instanceof HandlerMethod) {
			HandlerMethod metodo = (HandlerMethod) handler;
			logger.info("Método del controlador: " + metodo.getMethod().getName());
		}
		
		if(request.getHeader("ID_CLIENT_SESSION").toString().equals("78965088")) {
				
		 }

		System.out.println("PANTALLA : "+request.getHeader("ID_CLIENT_SESSION"));

		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
//		if(request.getMethod().equalsIgnoreCase("post")) {
//			return;
//		}
		
		
	}

	
}

