
public class Users implements Comparable<Users> {
	
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int compareTo(Users user) {
		// TODO Auto-generated method stub
		/**Should return 1 , 0, or -1
		 * 1 - the object is greater than the object we're comparing it against
		 * 0 - the object is equal to the other object we're comparing it against
		 *-1 - the object is less than the other object we're comparing it against
		 */
		return this.username.compareTo(user.getUsername());
		
	}

}
