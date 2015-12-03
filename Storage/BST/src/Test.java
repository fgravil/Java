//@ model import org.jmlspecs.models.*;

public class Test <K extends Comparable<K>,O>{
	
	
		/*@ spec_public @*/ O obj;

		
		 /* @ public pure model JMLValueToObjectMap  getMappings(nullable Test<K,O> node)
		 	{	
		 		if(node == null)
		 		return new JMLValueToObjectMap();
		 		
		 		else
		 		{
		 			return new JMLValueToObjectMap ( null, node.obj);
		 		}
		 	
		 	 	}
		 */
}
