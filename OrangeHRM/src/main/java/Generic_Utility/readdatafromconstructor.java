package Generic_Utility;

public class readdatafromconstructor {
	public String id;
	public String emp_name;
	public String emp_address;
	public String phone_no;
	public readdatafromconstructor(String id,String emp_name,String emmp_address,String phone_no ) {
		this.id=id;
		this.emp_name=emp_name;
		this.emp_address=emmp_address;
		this.phone_no=phone_no;
		
	}
	@Override
	public String toString() {
		return "[employee id = " + id + ", employee name = " + emp_name + ", employee address = " + emp_address
				+ ", phone number = " + phone_no + "]";
	}
	

}
