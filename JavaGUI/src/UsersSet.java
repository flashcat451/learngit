import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class UsersSet {

	private BufferedReader bir;
	private HashSet<User> usersSet = new HashSet<User>();
	
	
	public UsersSet() throws FileNotFoundException, IOException {
		//super();
		// TODO Auto-generated constructor stub
		
		String str = null;
		String[] userStr = null;
		FileReader fir = new FileReader("users.txt");
		bir = new BufferedReader(fir);
		while ((str = bir.readLine()) != null) {
			userStr = str.split(":");
			usersSet.add(new User(userStr[0].trim(), userStr[1].trim(), Integer.parseInt(userStr[2])));
					
		}
			
	}
	
	public boolean isValid(User user) {
		boolean userValid = false;
		if(usersSet.contains(user)){
			userValid = true;
		}
		return userValid;
		
	}

}
