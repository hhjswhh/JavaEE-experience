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
		username = request.getParameter("username");
		password = request.getParameter("password");
			
		try {
			if (username == "" || password == "") {
				System.out.println("kong");
				RequestDispatcher rd = request
						.getRequestDispatcher("../Login.html");
				response.sendRedirect("../Login.html");
				return;
			}

			boolean isValid = false;
			UserBean userBean = new UserBean();
			isValid = userBean.valid(username, password);
			System.out.println(username + password);
			if (isValid) {
				//如果登录成功则发送Cookie，不管之前登录的内容，所以不检测是否存在
				Cookie name = new Cookie("username", username);
				name.setPath(request.getContextPath());
				name.setMaxAge(1000);
				response.addCookie(name);
				System.out.println("name: "+name.getName());
				response.sendRedirect("../index.jsp");
			} else {
				response.sendRedirect("../Login.html");
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
