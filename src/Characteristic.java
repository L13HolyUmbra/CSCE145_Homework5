import java.util.Scanner;

/*
 * @Author: Dion de jong
 * @Version 1.0
 * 10-13-2013
 * This is the characteristic Class. It creates a constructor for the object "Characteristic". 
 * Then the methods below all manipulate the objects two parameters of Description and Rating. 
 * Lastly, the class also creates methods that will test for the compatibility of two people based
 * on a characteristic and their rating for the importance of this characteristic. 
 */

//main class name. 
public class Characteristic {

	//Instance variables 
	public String description; 
	public int rating; 

	//create the constructor 
	public Characteristic (String Inputdescription)
	{
		this.description = Inputdescription; 
		this.rating = 0; 
	}

	//Create the setRating method that takes input from the user
	public int setRating()
	{
		//create scanner and ask the user to type in the rating for a characteristic they will have previously typed when this method is called.
		Scanner keyboard = new Scanner(System.in); 
		System.out.println("What is the rating for this characteristic? The number should be from 1 to 10.");
		int aRating = keyboard.nextInt();
		//Call the isValid method [see below] in a while loop to ask the user to keep entering an input until it is deemed valid. 
		while (isValid(aRating) == false)
		{
			System.out.println("The rating is not valid, please enter a valid rating.");
			aRating = keyboard.nextInt(); 
		}
		setRating(aRating); 
		return aRating; 
	}

	//Create the isValid method to see if an input rating is a valid number. 
	private boolean isValid(int aRating)
	{
		//if it is between 1-10 it is valid.
		if (aRating >= 1 && aRating <= 10)
		{
			return true; 
		}
		else
		{
			return false; 
		}
	}


	//Create the setRating method that will name the variable in the constructor after the input number if it is valid
	public void setRating(int aRating)
	{ 
		if (isValid(aRating) == true)
		{
			this.rating = aRating; 
		}
		else 
		{
			System.out.println("The rating provided is not valid");
		}
	}


	//Getter for description
	public String getDescription()
	{
		return description; 
	}

	//Getter for the rating
	public int getRating()
	{
		return rating; 
	}

	//Creates the getCompatibilityMeasure that will calculate the value for how compatible the people are based on one characteristic. 
	private double getCompatibilityMeasure(Characteristic otherRating)
	{
		//as long as both ratings are not given as 0, run the formula to calculate the Compatibility measure.
		if (this.rating == 0 || otherRating.rating == 0)
		{
			return 0; 
		}
		else 
		{
			double m = 1 - ((double) this.rating - (double) otherRating.rating) * ((double)this.rating - (double)otherRating.rating)/81;
			return m; 
		}

	}

	//create the isMatch method that tests if the two people are rating the same characteristic (since that is necessary to get a compatibility measure.)
	private boolean isMatch(Characteristic otherRating)
	{
		if (this.description.equals(otherRating.description)) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}	

	//create the getCompatibility method that will run the above two methods to test they are for the same description and will then run the 
	//formula if the users also did not give 0 as the rating and return it. 
	public double getCompatability(Characteristic otherRating)
	{
		double m = 0.0; 
		if (isMatch(otherRating) == true)
		{
			m = getCompatibilityMeasure(otherRating);
			return m; 
		}
		else 
		{
			return 0; 
		}
}

}


