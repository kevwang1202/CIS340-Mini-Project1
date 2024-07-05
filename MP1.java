// MP1; LK. Wang; CIS 340 T/TH 3:00PM
import java.util.Scanner;

public class MP1 {
	
	//Initialize the arrays
	private static String [] names;
	private static double [][] scores;
	Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Import scanner
		Scanner scnr = new Scanner(System.in);

		//Initialize variable to store user input
		int scoresNum = 0;
		
		//Get user input
		System.out.print("How many scores per student? ");
		scoresNum = Integer.parseInt(scnr.nextLine());
		
		//Initialize the arrays
		scores = new double [3][scoresNum];
		
		names = new String[3];	
		
		//Loop through arrays to store user input into arrays
		for(int i = 0; i < names.length; i++)
		{
			System.out.printf("\nEnter name for student %d: ",(i + 1));
			names[i] = scnr.nextLine();
			
			System.out.printf("\nEntering scores for %s\n", names[i].toUpperCase());

			for (int j = 0; j < scoresNum; j++)
			{
				System.out.printf("Quiz %d: ", (j + 1));
				scores[i][j] = Double.parseDouble(scnr.nextLine());
			}
		}
		
		//Initialize variables to store method result
		char result = '0';

		//Use do while loop to check if the condition meets the requirement for "result"
		do
		{
			result = menu();
			
			//Use switch statement to determine different functions user seek for
			switch (result)
			{
			
			//Case for class average function
			case '1':
				System.out.printf("Class average for all quizzes is %.2f\n", classAvg(scores));
				System.out.println("\n");
				System.out.println("Press Enter to continue... ");
				break;
				
			//Case for student average function
			case '2':				
				studentAvg(scores,names);
				System.out.println();
				System.out.println("Press Enter to continue... ");
				break;
				
			//Case for quiz average function
			case '3':				
				quizAvg(scores);
				
				System.out.println("Press Enter to continue... ");
				break;
			
			//Case for user to exit the program
			case 'x':
				System.exit(0);
				break;
				
			//Default for user input that didn't match any of the above options
			default:
				result = '0';
				break;
		}
		}while(result != 'x');
	
	}

	//Method for "Menu"
	private static char menu()
	{
		Scanner scnr = new Scanner(System.in);

		//Initialize variables to store the return
		char choice = '0';
		//Create the header of the menu
		System.out.println("\n\n\n\n\n\t\t\tMenu");
		System.out.println("1. Class Average");
		System.out.println("2. Student Average");
		System.out.println("3. Quiz Average\n");
	
		//Use nextLine to store user input
		System.out.print("Enter choice number, or x to exit: ");
		choice = scnr.nextLine().charAt(0);
		
		//Return for the method
		return choice;
		
	}

	//Method for "Class Average"
	private static double classAvg(double scores[][])
	{
		//Initialize variables to store class average and sum
		double cAvg = 0.0;
		double cSum = 0.0;
		
		//Use for loop to loop through scores array to get the sum of all scores
		for (int k = 0; k < scores.length; k++) 
		{
            for (int l = 0; l < scores[k].length; l++) 
            {
                cSum += scores[k][l];
            }
        }
		
		//Calculation for class average
		cAvg = cSum / (double) (scores.length * scores[0].length);
		
		//Return for the method
		return cAvg;
	}
	//Method for "Student Average"
	private static void studentAvg(double scores[][], String names[])
	{
		Scanner scnr = new Scanner(System.in);
		
		//Initialize variables to store the student name that user seek for 
		String name = "";
		
		//Initialize variables to store the index of the student that user seek for 
		int index = -1;
		
		//Initialize variables to store student average and sum
		double sSum = 0.0;
		double sAvg = 0.0;
		
		//Create the header of the student average function
		System.out.printf("Calculating average by student.\n");
		
		//Use nextLine to store user's input 
		System.out.printf("\nEnter student name: ");
		name = scnr.nextLine();

		//Use for loop to loop through name array to get the student index
		for(int a = 0; a < names.length; a++)
		{
			if(names[a].equalsIgnoreCase(name))
			{
				index = a;
				break;
			}
		}
		
		//Function for incorrect input of student name
		if(index == -1)
		{
			System.out.printf("Student not found.\n");
			return;
		}
		
		//Use printf function to display all scores for student
		System.out.printf("%s's scores are: ", name);
		
		//Use for loop to print scores and get the sum of all scores
		for(int n = 0; n < scores[index].length; n++)
		{
			
			System.out.printf("%.2f ", scores[index][n]);
            sSum += scores[index][n];
		}
		
		//Use println function to create new line
		System.out.println();
		
		//Calculation for student average
		sAvg = sSum / (double) (scores[index].length);
		
		//Print result for the user
		System.out.printf("%s's average is %.2f\n", name, sAvg);
	}
	
	//Method for "Quiz Average"
	private static void quizAvg(double scores[][])
	{
		Scanner scnr = new Scanner(System.in);

		//Initialize variables to store quiz number that the user seek for 
		int quizNum = 0;
		//Initialize variables to store quiz average and sum
		double qSum = 0.0;
		double qAvg = 0.0;
		
		//Create the header of the quiz average function
		System.out.printf("\nCalculating average by Quiz Number\n");
		
		//Use nextLine to store user's input 
		System.out.print("Enter Quiz number: ");
		quizNum = Integer.parseInt(scnr.nextLine());
		
		//Checking whether the quiz number that the user seek exist
		if(quizNum > scores[0].length)
		{
			System.out.println("Quiz not found.");
			return;
		}

		//Use for loop to get the sum of the quiz for all 3 students
		for(int e = 0; e < 3; e++)
		{
            qSum += scores[e][quizNum - 1];
		}
		
		//Calculation for quiz average
		qAvg = qSum / 3;
		
		//Print result for the user
		System.out.printf("\nQuiz %d average is %.2f\n", quizNum, qAvg);
	}
}
