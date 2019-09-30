//yj
public class StaffTechnician extends Employee{
	//has degree
	private boolean Degree;
	//constructor
	StaffTechnician(){
		super();
		//increase pay
		super.SetPay(20.00);
		this.Degree = true;
	}
	//edits degree
	public void SetDegree(boolean value) {
		this.Degree = value;
	}
	//displays degree
	public boolean ShowDegree() {
		return this.Degree;
	}
	//prints info
	public void PrintStaffTechnician() {
		System.out.printf("ID: %d   Name: %s %s  rate: %.0f  Has Degree: %b \n",super.GetEmployeeNumber(), super.GetFirstName(), super.GetLastName(), super.GetPayRate(), this.ShowDegree());
	}
	
}