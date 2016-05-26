public class Main {

	public static void main(String[] args) {
		//建立一个窗体对象
		MyFrame f = new MyFrame();
	}

}

class Patient{
	private String patientNo;				//编号
	private String patientName;				//姓名
	private String patientSex;				//性别
	private String patientCard;			//身份证号
	private String patientAge;				//年龄
	
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientSex() {
		return patientSex;
	}
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	public String getPatientCard() {
		return patientCard;
	}
	public void setPatientCard(String patientCard) {
		this.patientCard = patientCard;
	}
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientAge() {
		return patientAge;
	}
	
}




