import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Employee{

	//general Initialization
	
	// will be Employee names
	private int employeeNum;
	private String fName ;
	private String lName;
	// will be pay rate;
	private double payRate;
	private double checkAmount;
	
	//constructor
	public Employee() {
		this.employeeNum = 0;
		this.fName = null;
		this.lName = null;
		this.payRate = 0.0;
		this.checkAmount = 0.0;
	}
	
	//add Employee First Name
	public void SetFirstName(String first) {
		this.fName= first;
	}
	
	//add Employee Last Name
	public void SetLastName(String last) {
		this.lName = last;	
	}
	
	//set Employee payRate
	public void SetPay(double value) {
		this.payRate = value;
	}
	//set Employee number
	public void SetEmployeeNumber(int value) {
		this.employeeNum = value;
	}
	// get first name
	public String GetFirstName() {
		return this.fName;
	}
	// get last name
	public String GetLastName(){
		return this.lName;
	}
	// get employee number
	public int GetEmployeeNumber() {
		return this.employeeNum;
	}
	//get pay rate
	public double GetPayRate() {
		return this.payRate;
	}
	//calculate pay
	public void CalcPayCheck(double hours){
		this.checkAmount = payRate * hours;
		
	}
	//see pay
	public void GetPayCheck() {
		System.out.printf("ID: %d  Check Amount: $%.1f \n", this.GetEmployeeNumber(), this.checkAmount);
	}
	
	//imports employee data from file
	public static String readfromFile(){
			
		//get each line of the file
		try{
				
			InputStream fileinput = new FileInputStream("employees.txt");
			InputStreamReader readinput = new InputStreamReader(fileinput);
			BufferedReader buffer = new BufferedReader(readinput);
				
			// Get's the first line in the file.
			String line = buffer.readLine();
			String save = line;
			String newline;
			while(line != null){	
			// Get the next line in the file...
			line = buffer.readLine();
			newline = "-" + line;
			save += newline;
			}
			buffer.close();
			String[] parts = save.split("-null");
			save= parts[0];
			return save;
		}
		catch (IOException ex) 
		{
			System.err.println(ex);
		}
		return null;
	}


}