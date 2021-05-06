package Feb28_LunchOrder;

/**Lunch order main method
 * @author Ardavan Alaei Fard
 * @version March 4, 2021
 */
import java.util.*;
public class LunchOrder {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int foodNum;     //number of the bought food 
		double price = 0.00;     //addition of total price
		
		for (int i = 0; i < 4; i++) {
			//Hamburger
			if (i == 0) {
				Food food = new Food ("hamburger", 1.85, 9.0, 33.0, 1.0, i);     //adding hamburger to the foods
				System.out.println("Enter number of hamburgers: ");
				foodNum = input.nextInt();     //number of hamburgers to buy
				System.out.printf("Each hamburger has %.1fg of fat, %.1fg of carbs, and %.1fg of fiber%n", food.fat[i], food.carbs[i], food.fiber[i]);     //information about hamburgers
				price += (foodNum * food.price[i]);     //add the price to total price
			}
			
			//Salad
			else if (i == 1) {
				Food food = new Food ("salad", 2.00, 1.0, 11.0, 5.0, i);     //adding salad to the foods
				System.out.println("Enter number of salads: ");
				foodNum = input.nextInt();     //number of salads to buy
				System.out.printf("Each salad has %.1fg of fat, %.1fg of carbs, and %.1fg of fiber%n", food.fat[i], food.carbs[i], food.fiber[i]);     //information about salads
				price += (foodNum * food.price[i]);     //add price to total price
			}
			
			//French Fries
			else if (i == 2) {
				Food food = new Food ("french fries", 1.30, 11.0, 36.0, 4.0, i);     //adding french fries to the foods
				System.out.println("Enter number of french fries: ");
				foodNum = input.nextInt();     //number of french fries to buy
				System.out.printf("French fries have %.1fg of fat, %.1fg of carbs, and %.1fg of fiber%n", food.fat[i], food.carbs[i], food.fiber[i]);     //information about french fries
				price += (foodNum * food.price[i]);     //add price to total price
			}
			
			//Soda
			else if (i == 3) {
				Food food = new Food ("soda", 0.95, 0.0, 38.0, 0.0, i);     //adding soda to the foods
				System.out.println("Enter number of sodas: ");
				foodNum = input.nextInt();     //number of sodas to buy
				System.out.printf("Each soda has %.1fg of fat, %.1fg of carbs, and %.1fg of fiber%n", food.fat[i], food.carbs[i], food.fiber[i]);     //information about soda
				price += (foodNum * food.price[i]);     //add price to total price
			}
		}
		
		System.out.printf("Your order comes to $%.2f", price);     //Outputting the total price

	}//end of the main method

}//end of the class
