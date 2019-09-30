//yj
public class SeniorTechnician extends StaffTechnician{
	//has service award
	private boolean ServiceAward;
	//constructor
	SeniorTechnician() {
		super();
		//increase pay
		super.SetPay(25.00);
		this.ServiceAward = true;
	}
	//set Service Award
	public void SetServiceAward(boolean value) {
		this.ServiceAward = value;
	}
	//Display Service Award
	public boolean ShowServiceAward() {
		return this.ServiceAward;
	}
	//prints info
	public void PrintSeniorTechnician() {
		System.out.printf("ID: %d   Name: %s %s  rate: %.0f  Has Degree: %b Has Service Award: %b \n",super.GetEmployeeNumber(), super.GetFirstName(), super.GetLastName(), super.GetPayRate(), super.ShowDegree(), this.ShowServiceAward());
	}
}