//yj
public class StaffPharmacist extends Employee{
	//has license
	private boolean Licensed;
	//constructor
	StaffPharmacist() {
		super();
		//increase pay
		super.SetPay(40.00);
		this.Licensed = true;
	}
	//edits license
	public void SetLicense(boolean value) {
		this.Licensed = value;
	}
	//displays license
	public boolean ShowLicense(){
		return this.Licensed;
	}
	//prints info
	public void PrintStaffPharmacist() {
		System.out.printf("ID: %d   Name: %s %s  rate: %.0f  Licensed: %b \n",super.GetEmployeeNumber(), super.GetFirstName(), super.GetLastName(), super.GetPayRate(), this.ShowLicense());
	}
}