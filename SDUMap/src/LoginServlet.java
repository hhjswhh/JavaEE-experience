import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

	private String username = null;
	private String password = null;
	
	
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		username = request.getParameter("username");
		password = request.getParameter("password");
			
		try {
			if (username == "" || password == "") {
				System.out.println("kong");
//				RequestDispatcher rd = request
//						.getRequestDispatcher("../Login.html");
				response.sendRedirect("../Login.jsp");
				return;
			}
			
			
			boolean isValid = false;
			UserBean userBean = new UserBean();
			isValid = userBean.valid(username, password);
			System.out.println(username +"      "+ password);
			System.out.println(isValid);
			if (isValid) {
				//如果登录成功则发送Cookie，不管之前登录的内容，所以不检测是否存在
				Cookie name = new Cookie("username", java.net.URLEncoder.encode(username,"UTF-8"));//cookie不能包含中文要编码
				name.setPath(request.getContextPath());
				name.setMaxAge(1000);
				response.addCookie(name);
				System.out.println("name: "+name.getValue());
				response.sendRedirect("../index.jsp");
			} else if(userBean.isExist(username)){
//				out.println("<script lanuage=\"javascript\">");
//				out.println("alert(\"密码错误，请重新输入\")");
//				out.println("</script>");
				out.print("密码错误，请重新输入");
				response.setHeader("Refresh", "2;URL=/SDUMap/Login.jsp");
			} else{
				out.print("用户名不存在，请重新输入");
				response.setHeader("Refresh", "2;URL=/SDUMap/Login.jsp");
			}
		} catch (Exception e) {

		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
