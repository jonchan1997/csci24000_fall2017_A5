//yj
public class PharmacyManager extends StaffPharmacist{
	//has leadership
	private boolean Leadership;
	//constructor
	PharmacyManager() {
		super();
		//increase pay
		super.SetPay(50.00);
		this.Leadership = true;
	}
	//change leadership
	public void SetLeadership(boolean value) {
		this.Leadership = value;
	}
	//display Leadership
	public boolean ShowLeadership() {
		return this.Leadership;
	}
	//prints info
	public void PrintPharmacyManager() {
		System.out.printf("ID: %d   Name: %s %s  rate: %.0f  Licensed: %b Has Leadership: %b \n",super.GetEmployeeNumber(), super.GetFirstName(), super.GetLastName(), super.GetPayRate(), super.ShowLicense(), this.ShowLeadership());
	}
}