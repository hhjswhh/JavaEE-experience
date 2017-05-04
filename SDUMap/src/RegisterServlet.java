import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {

	String username = null;
	String password1 = null;
	String password2 = null;
	String email = null;
	
	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
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

		doPost(request, response);
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
		PrintWriter out = response.getWriter();
		
		UserBean userbean = new UserBean();
		username = request.getParameter("username");
		password1 = request.getParameter("password1");
		password2 = request.getParameter("password2");
		email = request.getParameter("email");
		
		//用户名已存在
		if(userbean.isExist(username)){
			out.print("用户名已存在，请重新输入");
			response.setHeader("Refresh", "2;URL=/SDUMap/Register.jsp");
		}else
		//密码不一致
		if(!password1.equals(password2)){
			out.print("您两次输入的密码不一致");
			response.setHeader("Refresh", "2;URL=/SDUMap/Register.jsp");
		}else{
		//注册成功
			System.out.println("尝试注册");
			try{
				userbean.add(username, password1, email);
				out.print("注册中");
				System.out.println("注册");
			
			}catch(Exception e){
				out.print("注册失败");
				System.out.println("注册失败");
			}
			response.setHeader("Refresh", "3;URL=/SDUMap/index.jsp");
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
