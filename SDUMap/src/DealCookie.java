import javax.servlet.http.Cookie;


public class DealCookie {
	Cookie cookie;
	
	public DealCookie(Cookie cookie){
		this.cookie = cookie;
	}
	
	public void setMaxAge(int time){
		cookie.setMaxAge(time);
	}
	
}
