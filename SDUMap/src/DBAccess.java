import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class DBAccess {
	private String user = "root";
	private String pwd = "123456";
	private String url = "jdbc:mysql://localhost:3306/J2EE_Experience?useUnicode=true&characterEncoding=UTF-8";
	private String driver = "com.mysql.jdbc.Driver";
	
	private Connection conn = null;
	private Statement stm = null;
	private ResultSet rs = null;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public Statement getStm() {
		return stm;
	}
	public void setStm(Statement stm) {
		this.stm = stm;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	public boolean creatConn(){
		System.out.println("建立连接");
		boolean b = false;
		try {
			Class.forName(driver).newInstance();
			conn = (Connection)DriverManager.getConnection(url, user, pwd);
			b=true;
		} catch (Exception e) {
		}
		return b;
	}
	
	public boolean update(String sql){
		System.out.println("更新");
		boolean b = false;
		try {
			stm = (Statement)conn.createStatement();
			stm.execute(sql);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}
	
	public void query(String sql){
		System.out.println("查询");
		try {
			stm = (Statement)conn.createStatement();
			rs = stm.executeQuery(sql);
			 
		} catch (Exception e) {
		}
	}
	
	public boolean next(){
		boolean b = false;
		try {
			if(rs.next()){ 
				b=true;
			}
		} catch (Exception e) {
		}
		return b;
	}
	
	public String getValue(String field){
		String value = null;
		try {
			if(rs!=null){
				value = rs.getString(field);
			}
		} catch (Exception e) {
		}
		return value;
	}
	
	public void closeRs(){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (Exception e) {
		}
	}
	
	public void closeStm(){
		try {
			if(stm!=null){
				stm.close();
			}
		} catch (Exception e) {
		}
	}
	
	public void closeConn(){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
		}
	}
	
	public void closeAll(){
		closeRs();
		closeStm();
		closeConn();
	}
}

