
public class UserBean {

	//验证是否有效，即用户名密码是否正确
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
	
	//添加用户
	public void add(String username, String password, String email){
		DBAccess db = new DBAccess();
		
		if(db.creatConn()){
			System.out.println("尝试插入信息");
			String sql = "insert into user(username,password,email) values('"+username+"','"+password+"','"+email+"')";
			if(db.update(sql)){
				System.out.println("插入成功");
			}
			else{
				System.out.println("插入失败");
			}
			db.closeAll();
		}
		
		
	}
}
