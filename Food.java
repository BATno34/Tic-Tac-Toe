package Feb28_LunchOrder;

/**The object of foods
 * @author Ardavan Alaei Fard
 * @version March 4, 2021
 */
public class Food {
	
	String [] item = new String[4];     //name of the food
	double [] price = new double[4];     //price of the food
	double [] fat = new double[4];     //fat of the food
	double [] carbs = new double[4];     //carbs of the food
	double [] fiber = new double[4];     //fiber of the food
	
	//Constructor
	public Food (String item, double price, double fat, double carbs, double fiber, int num){
		this.item[num] = item;
		this.price[num] = price;
		this.fat[num] = fat;
		this.carbs[num] = carbs;
		this.fiber[num] = fiber;
	}
	
}//end of the class
