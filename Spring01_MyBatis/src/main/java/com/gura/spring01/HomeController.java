package com.gura.spring01;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * @Controller 어노테이션을 붙여놓으면 component scan할때 객체가 생성이 되고 spring bean container에서 관리
 * Controller도 bean으로 관리된다. bean 이여야만 동작함!
 */
@Controller
public class HomeController {
	
	
	//@RequestMapping(value = "/home.do", method = RequestMethod.GET) : default로 GET방식 전송
	//@RequestMapping("/home.do") : .do 생략가능함
	@RequestMapping("/home")
	public String home(HttpServletRequest request) {
		
		/*
		 *  forward 이동될 jsp 페이지에 데이터(model)을 전달하고 싶으면 request scope에 담아서 전달하면 된다.
		 *  request scope에 담은 데이터는 응답하기 전까지 유지되는 데이터이다.
		 *  따라서 jsp 페이지로 forward 이동하면 아직은 응답을 하지 않은 상태이므로 request scope에 담은 데이터를 추출해서 사용할 수 있다.
		 *  
		 *  request scope 데이터를 담기 위해서는 HttpServletRequest 객체가 필요하다.
		 *  Spring Controller 의 메소드에는
		 *  HttpServletRequest, HttpServletResponse, HttpSession, ModelAndView 등의 객체가 필요한 경우,
		 *  메소드의 매개변수에 해당 type을 선언하면 자동으로 해당 객체가 인자로 전달된다. -> 갯수, 순서 상관없이 선언 가능!
		 */
		
		// DB 에서 읽어온 공지사항이라고 가정하자.
		List<String> list = new ArrayList<String>();
		list.add("전반기 수업이 한달도 남지 않았습니다.");
		list.add("곧 프로젝트가 시작됩니다.");
		list.add("!@#$%..");
		list.add("%^&*(_+..");
		
		
		request.setAttribute("noticeList", list);
		
		/*
		 *	이 메소드는 String type을 리턴하기로 되어있는데 여기서 리턴한 문자열의
		 *	접두어로 "/WEB-INF/views/"가 자동으로 붙고, 접미어로 ".jsp"가 붙어서
		 *	forward 이동될(응답이 위임될) jsp 페이지가 지정이 된다.
		 *	해당 설정은 DispatcherServlet 을 설정하는 servlet-context.xml 문서에 정의가 되어있다.
		 *
		 * 	따라서 "home"을 리턴하면
		 * 	"/WEB-INF/views/home.jsp"가 forward 이동될 jsp페이지가 된다.
		 */
		
		return "home";
	}
	
}
