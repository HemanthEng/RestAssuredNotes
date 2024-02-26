package GenericUtils;

import java.util.Random;

public class JavaLibrary {


		
		/**
		 * This method will generate a random number and return it to user
		 * @return
		 */

		public int getRandomNumber()
		{
			Random ran = new Random();
			int random = ran.nextInt(500);
			return random;
		}
		
}
		

