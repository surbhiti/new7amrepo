package generic_utility;

import java.util.Random;

public class Java_utility {
	/**
	 * @author Surbhi
	 * this method is for Random no
	 */
	
	public int getranno() 
	
	{
		Random r = new Random();
		int ranno = r.nextInt(1000);
		return ranno;
		
	}
	
	
}
