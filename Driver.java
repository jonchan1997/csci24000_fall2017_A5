// Honor Pledge:
//
// I pledge that I have neither given nor 
// received any help on this assignment.
//
// youngjon

import java.util.Scanner;


//gui for the user
public class Driver {
	private static Scanner scanner = new Scanner( System.in );
	
	
	public static void main(String[] args){
		
		//initializing configurations/counters
		String saveText;
		int responseInitial = 0;
		StaffTechnician stafftech = new StaffTechnician();
		SeniorTechnician seniortech = new SeniorTechnician();
		StaffPharmacist staffpharma = new StaffPharmacist();
		PharmacyManager pharmamanager = new PharmacyManager();
		//initial menu
		while(responseInitial != 1 || responseInitial != 2){
			//print start menu
			System.out.println("");
			System.out.println("1. Load Employees (From File)");
			System.out.println("2. Exit Program");
			System.out.println("");
			System.out.print("Please enter your selection:");
			//user input
			responseInitial = scanner.nextInt();
			System.out.println("");
			//export text file and distribute
			if ( responseInitial == 1){
				//uses student.java to import employee data
				saveText = Employee.readfromFile();
				//organizes each employee imported
				String[] breaks = saveText.split("-");
				int len = breaks.length;
				for(int i=1; i<len; i++) {
					String[] info = breaks[i].split(",");
					int jobType = Integer.parseInt(info[0]);
					//Pharmacy Manager
					if(jobType == 1) {
						pharmamanager.SetFirstName(info[2]);
						pharmamanager.SetLastName(info[3]);
						pharmamanager.SetEmployeeNumber(Integer.parseInt(info[1]));
						
					}
					//Staff Pharmacist
					else if(jobType == 2) {
						staffpharma.SetFirstName(info[2]);
						staffpharma.SetLastName(info[3]);
						staffpharma.SetEmployeeNumber(Integer.parseInt(info[1]));
						
					}
					//Staff Technician
					else if(jobType == 3) {
						stafftech.SetFirstName(info[2]);
						stafftech.SetLastName(info[3]);
						stafftech.SetEmployeeNumber(Integer.parseInt(info[1]));
						
						
					}
					//Senior Technician
					else if(jobType == 4) {
						seniortech.SetFirstName(info[2]);
						seniortech.SetLastName(info[3]);
						seniortech.SetEmployeeNumber(Integer.parseInt(info[1]));
						
					}
					
				}
				break;
				
			}
			//leaves
			else if(responseInitial == 2){
				System.out.println("Goodbye!");
				break;
			//causes re-entry from input error!
			} else{
				System.out.println("Invalid Choice!");
			}
		}
		int responseLoad = 0;
		//2nd menu
		while(responseLoad != 4 && responseInitial != 2){
			System.out.println("");
			System.out.println("1. Print Employee Information");
			System.out.println("2. Enter Hours Worked");
			System.out.println("3. Calculate Paychecks");
			System.out.println("4. Exit Program");
			System.out.println("");
			System.out.print("Please enter your selection:");
			//user input
			responseLoad = scanner.nextInt();
			System.out.println("");
			//prints All employee types information
			if (responseLoad == 1) {
				stafftech.PrintStaffTechnician();
				staffpharma.PrintStaffPharmacist();
				pharmamanager.PrintPharmacyManager();
				seniortech.PrintSeniorTechnician();
			}
			//Adds hours to Employees
			else if(responseLoad == 2) {
				double hours = 0.0;
				System.out.print("Please enter the hours worked:");
				hours = scanner.nextDouble();
				stafftech.CalcPayCheck(hours);
				staffpharma.CalcPayCheck(hours);
				pharmamanager.CalcPayCheck(hours);
				seniortech.CalcPayCheck(hours);
			}
			//Prints all pay Amounts for all employees
			else if(responseLoad == 3) {
				stafftech.GetPayCheck();
				staffpharma.GetPayCheck();
				pharmamanager.GetPayCheck();
				seniortech.GetPayCheck();
				
			}
			else if(responseLoad == 4) {
				System.out.println("Goodbye!");
				break;
			}
			else{
				System.out.println("Invalid Choice!");
			}
		
		} 
	}

	

}