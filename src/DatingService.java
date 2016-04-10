/*
 * @Author: Dion de jong
 * @Version 1.0
 * 10-13-2013
 * This is the characteristic driver. it will create two characteristic objects and run the compatibility test 
 * for selected descriptions with selected ratings. 
 */

import java.util.Scanner;

public class DatingService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create a scanner
		Scanner keyboard = new Scanner(System.in);
		//ask Pat for the description she would like to rate and save it as a variable. 
		System.out.println("Pat, which characteristic would you like to test compatibility for?");
		String descriptionPat = keyboard.nextLine();
		//create a pat characteristic object with the above saved variable. 
		Characteristic Pat = new Characteristic(descriptionPat);

		//run the setRating method create in characteristic.java which will ask for a rating input and save it to the pat object. 
		Pat.setRating();
	

		//repeat the above lines for a chris object. 
		System.out.println("Chris, which characteristic would you like to test compatibility for?");
		String descriptionChris = keyboard.nextLine();
		Characteristic Chris = new Characteristic(descriptionChris);

		Chris.setRating();
		
		
		//run the getCompatibility method from pat against chris to return a compatibility test for the described characteristic. 
		System.out.println(Pat.getCompatability(Chris)); 



	}

}
