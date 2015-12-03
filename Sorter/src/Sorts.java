import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Sorts {
	
	@Test
	public void test()
	{
		Users user = new Users();
		user.setUsername("FGravil");
		user.setPassword("password");
		
		Users user2 = new Users();
		user2.setUsername("JGravil");
		user2.setPassword("pass");
		
		// 2 types of interface: Comparable, Comparator
		// 2 interfaces defined by Java -> Sort
		
		List<Users> list = new ArrayList<Users>();
		list.add(user2);
		list.add(user);
		
		Collections.sort(list);
		
		assertThat(list.get(0).getUsername(),is("FGravil"));
		assertThat(list.get(1).getUsername(),is("JGravil"));

	}
}