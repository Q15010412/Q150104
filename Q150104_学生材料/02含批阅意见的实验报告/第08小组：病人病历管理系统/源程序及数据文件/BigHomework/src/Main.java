public class Main {

	public static void main(String[] args) {
		//����һ���������
		MyFrame f = new MyFrame();
	}

}

class Patient{
	private String patientNo;				//���
	private String patientName;				//����
	private String patientSex;				//�Ա�
	private String patientCard;			//���֤��
	private String patientAge;				//����
	
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




