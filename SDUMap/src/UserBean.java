
public class UserBean {

	//验证登录
	public boolean valid(String username, String password){
		boolean isValid = false;
		DBAccess db = new DBAccess();
		
		if(db.creatConn()){
			String sql = "select * from user where username='"+username+"' and password='"+password+"'";
			db.query(sql);
			
			if(db.next()){
				isValid = true;
			}
			
			db.closeAll();
		}
	
		return isValid;
	}
	
	//验证用户名是否存在
	public boolean isExist(String username){
		boolean isExist = false;
		DBAccess db = new DBAccess();
		
		if(db.creatConn()){
			String sql = "select * from user where username='"+username+"'";
			db.query(sql);
			if(db.next()){
				isExist = true;
			}
			db.closeAll();
		}
		
		return isExist;
	}
	
	//添加账户信息
	public void add(String username, String password, String email){
		DBAccess db = new DBAccess();
		
		if(db.creatConn()){
			String sql = "insert into user(username,password,email) values('"+username+"','"+password+"','"+email+"')";
			db.closeAll();
		}
		
		
	}
}
