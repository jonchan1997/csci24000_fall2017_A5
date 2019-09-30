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
		int employeeAmount = 0;
		int stafftechnicianAmount = 0;
		int seniortechnicianAmount = 0;
		int staffpharmacistAmount = 0;
		int pharmacymanagerAmount = 0;
		
		//predict file size
		saveText = Employee.readfromFile();
		String[] count = saveText.split("-");
		employeeAmount = count.length - 1;
		
		//create estimated amount of objects needed
		StaffTechnician[] stafftech = new StaffTechnician[employeeAmount];
		SeniorTechnician[] seniortech = new SeniorTechnician[employeeAmount];
		StaffPharmacist[] staffpharma = new StaffPharmacist[employeeAmount];
		PharmacyManager[] pharmamanager = new PharmacyManager[employeeAmount];
		
		for(int i=0; i< employeeAmount; i++ ) {
			stafftech[i] = new StaffTechnician();
			seniortech[i] = new SeniorTechnician();
			staffpharma[i] = new StaffPharmacist();
			pharmamanager[i] = new PharmacyManager();
			
		}
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
				//reset amounts
				stafftechnicianAmount = 0;
				seniortechnicianAmount = 0;
				staffpharmacistAmount = 0;
				pharmacymanagerAmount = 0;
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
						pharmamanager[pharmacymanagerAmount].SetFirstName(info[2]);
						pharmamanager[pharmacymanagerAmount].SetLastName(info[3]);
						pharmamanager[pharmacymanagerAmount].SetEmployeeNumber(Integer.parseInt(info[1]));
						pharmacymanagerAmount++;
						
					}
					//Staff Pharmacist
					else if(jobType == 2) {
						staffpharma[staffpharmacistAmount].SetFirstName(info[2]);
						staffpharma[staffpharmacistAmount].SetLastName(info[3]);
						staffpharma[staffpharmacistAmount].SetEmployeeNumber(Integer.parseInt(info[1]));
						staffpharmacistAmount++;
						
					}
					//Staff Technician
					else if(jobType == 3) {
						stafftech[stafftechnicianAmount].SetFirstName(info[2]);
						stafftech[stafftechnicianAmount].SetLastName(info[3]);
						stafftech[stafftechnicianAmount].SetEmployeeNumber(Integer.parseInt(info[1]));
						stafftechnicianAmount++;
						
						
					}
					//Senior Technician
					else if(jobType == 4) {
						seniortech[seniortechnicianAmount].SetFirstName(info[2]);
						seniortech[seniortechnicianAmount].SetLastName(info[3]);
						seniortech[seniortechnicianAmount].SetEmployeeNumber(Integer.parseInt(info[1]));
						seniortechnicianAmount++;
						
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
				for(int i=0; i<stafftechnicianAmount; i++) {
					stafftech[i].PrintStaffTechnician();
				}
				for(int i=0; i<staffpharmacistAmount; i++) {
					staffpharma[i].PrintStaffPharmacist();
				}
				for(int i=0; i<pharmacymanagerAmount; i++) {
					pharmamanager[i].PrintPharmacyManager();
				}
				for(int i=0; i<seniortechnicianAmount; i++) {
					seniortech[i].PrintSeniorTechnician();
				}
			}
			//Adds hours to Employees
			else if(responseLoad == 2) {
				double hours = 0.0;
				int employeeNumber = 0;
				System.out.print("Please enter the employee's number:");
				employeeNumber = scanner.nextInt();
				System.out.println("");
				System.out.print("Please enter the hours worked:");
				hours = scanner.nextDouble();
				for(int i=0; i<employeeAmount; i++) {
					
					if(stafftech[i].GetEmployeeNumber() == employeeNumber){
						stafftech[i].CalcPayCheck(hours);
					}
					else if(staffpharma[i].GetEmployeeNumber() == employeeNumber) {
						staffpharma[i].CalcPayCheck(hours);
					}
					else if(pharmamanager[i].GetEmployeeNumber() == employeeNumber){
						pharmamanager[i].CalcPayCheck(hours);
					}
					else if(seniortech[i].GetEmployeeNumber() == employeeNumber){
						seniortech[i].CalcPayCheck(hours);
					}
				}
				
			}
			//Prints all pay Amounts for all employees
			else if(responseLoad == 3) {
				for(int i=0; i<stafftechnicianAmount; i++) {
					stafftech[i].GetPayCheck();
				}
				for(int i=0; i<staffpharmacistAmount; i++) {
					staffpharma[i].GetPayCheck();
				}
				for(int i=0; i<pharmacymanagerAmount; i++) {
					pharmamanager[i].GetPayCheck();
				}
				for(int i=0; i<seniortechnicianAmount; i++) {
					seniortech[i].GetPayCheck();
				}
				
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