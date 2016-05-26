import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame extends JFrame {
	Vector patientList=new Vector();
	

MyFrame(){
		super("���˲�������ϵͳ");

		this.setTitle("���˲�������ϵͳ");
		this.setSize(700,360);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.readPatFile();
		this.showPatientPanel();
		this.setVisible(true);

		this.setResizable(false);
		this.setSize(700,360);
		this.setLocationRelativeTo(this.getOwner());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	void readPatFile(){
		try {
			FileInputStream fis;
			fis = new FileInputStream("Patient.txt");
			InputStreamReader dis=new InputStreamReader(fis);
			BufferedReader reader=new BufferedReader(dis);
			String s;
			while((s=reader.readLine())!=null)
			{
				Patient pat=new Patient();
				String[] temp=s.split(" ");
				pat.setPatientNo(temp[0]);
				pat.setPatientName(temp[1]);
				pat.setPatientSex(temp[2]);
				pat.setPatientCard(temp[3]);
				pat.setPatientAge(temp[4]);
				patientList.add(pat);
			}
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	void showPatientPanel(){
		PatientPanel patientPanel=new PatientPanel();
		patientPanel.patientList=this.patientList;
		this.add(patientPanel,BorderLayout.CENTER);
		patientPanel.showPatient(0);
		this.setVisible(true);
	}

}

class PatientPanel extends JPanel implements ActionListener {
	Vector patientList=new Vector();
	
	private JTextField patientNo=new JTextField();											//���
	private JTextField patientName=new JTextField();										//����
	private JTextField patientSex=new JTextField();											//�Ա�
	private JTextField patientAge=new JTextField();											//����
	private JTextField patientCard=new JTextField();										//���֤��
	
	private String[] btnStr={"��һ��","��һ��","��һ��","���һ��","���","�޸�","ɾ��"};
	private JButton[] btn= new JButton[btnStr.length];
	int count=0,current=0,inserting=0;

	PatientPanel(){
		this.setLayout(null);
		//��ʾ���
		JLabel lb1=new JLabel("��ţ�");
		lb1.setBounds(30, 10, 100, 20);
		this.add(lb1);
		patientNo.setBounds(100,10, 140, 20);
		this.add(patientNo);
		//��ʾ����
		JLabel lb2=new JLabel("������");
		lb2.setBounds(30, 60, 100, 20);
		this.add(lb2);
		patientName.setBounds(100,60, 140, 20);
		this.add(patientName);
		//��ʾ�Ա�
		JLabel lb3=new JLabel("�Ա�");
		lb3.setBounds(30, 110, 100, 20);
		this.add(lb3);
		patientSex.setBounds(100,110, 140, 20);
		this.add(patientSex);
		//��ʾ����
		JLabel lb4=new JLabel("���䣺");
		lb4.setBounds(30, 160, 100, 20);
		this.add(lb4);
		patientAge.setBounds(100,160, 140, 20);
		this.add(patientAge);
		//��ʾ���֤��
		JLabel lb5=new JLabel("���֤�ţ�");
		lb5.setBounds(30,210, 100, 20);
		this.add(lb5);
		patientCard.setBounds(100,210, 140, 20);
		this.add(patientCard);
		for(int i=0;i<btn.length;i++){
			btn[i]=new JButton(btnStr[i]);
			btn[i].setBounds(30+i*90, 260, 90, 30);
			btn[i].addActionListener(this);
			this.add(btn[i]);
		}
	}
	
	void showPatient(int offset){
		Patient pat=(Patient) patientList.get(offset);
		this.patientNo.setText(pat.getPatientNo());
		this.patientName.setText(pat.getPatientName());
		this.patientSex.setText(pat.getPatientSex());
		this.patientAge.setText(pat.getPatientAge());
		this.patientCard.setText(pat.getPatientCard());
	}
	public void actionPerformed(ActionEvent e) {
		count=this.patientList.size();
		if(e.getSource()==this.btn[0]){
			this.showPatient(0);
			current=0;
		}
		if(e.getSource()==this.btn[1] && current>0){
			this.showPatient(current-1);
			current=current-1;
		}
		if(e.getSource()==this.btn[2] && current<count-1){
			this.showPatient(current+1);
			current=current+1;
		}
		if(e.getSource()==this.btn[3]){
			this.showPatient(count-1);
			current=count-1;
		}
		if(e.getSource()==this.btn[4]){
			if(this.inserting==0){
				this.patientNo.setText("");
				this.patientName.setText("");
				this.patientSex.setText("");
				this.patientAge.setText("");
				this.patientCard.setText("");
				btn[4].setText("����");
				btn[5].setText("ȡ��");
				this.inserting=1;
			}else{
				Patient pat=new Patient();
				pat.setPatientNo(this.patientNo.getText().trim());
				pat.setPatientName(this.patientName.getText().trim());
				pat.setPatientSex(this.patientSex.getText().trim());
				pat.setPatientAge(this.patientAge.getText().trim());
				pat.setPatientCard(this.patientCard.getText().trim());
				patientList.add(pat);
				count++;
				current=count-1;
				btn[4].setText("���");
				btn[5].setText("�޸�");
				this.inserting=0;
			}
			for(int i=0;i<btn.length;i++){
				if(i==4||i==5) continue;
				btn[i].setEnabled(!btn[i].isEnabled());
			}
		}

		if(e.getSource()==this.btn[5]){
			if(this.inserting==0){
				Patient stu=(Patient)patientList.get(current);
				stu.setPatientNo(this.patientNo.getText().trim());
				stu.setPatientName(this.patientName.getText().trim());
				stu.setPatientSex(this.patientSex.getText().trim());
				stu.setPatientAge(this.patientAge.getText().trim());
				stu.setPatientAge(this.patientCard.getText().trim());
			}else{
				btn[4].setText("���");
				btn[5].setText("�޸�");
				for(int i=0;i<btn.length;i++){
					if(i==4||i==5) continue;
					btn[i].setEnabled(!btn[i].isEnabled());
				}
				this.inserting=0;
				this.showPatient(current);
			}
		}
		if(e.getSource()==this.btn[6]){
			if(count==0)
				return;
			patientList.remove(current);
			count--;
			if(count==0){
				this.patientNo.setText("");
				this.patientName.setText("");
				this.patientSex.setText("");
				this.patientAge.setText("");
				this.patientCard.setText("");
			}else{
				if(current>count-1){
					this.showPatient(current-1);
					current=current-1;
				}
				else
					this.showPatient(current);
			}
		}
		this.repaint();
	}
}


	class Case{
		private String caseName;																							//��������
		private String drugs;																								//ҩƷ
		private double money;																								//ҩƷ����
		private double days;																								//סԺ����
		private String operation;																							//������������
		
		public String getCaseName() {
			return caseName;
		}
		public void setCaseName(String caseName) {
			this.caseName = caseName;
		}
		public String getDrugs() {
			return drugs;
		}
		public void setDrugs(String drugs) {
			this.drugs = drugs;
		}
		public double getMoney() {
			return money;
		}
		public void setMoney(double money) {
			this.money = money;
		}
		public double getDays() {
			return days;
		}
		public void setDays(double days) {
			this.days = days;
		}
	    public String getOperation() {
		    return operation;
	    }
	    public void setOperation(String operation) {
		    this.operation = operation;
	    }

	class Doctor{ 
		private String doctorName;																							//ҽʦ����
		private String doctorSection;																						//��������
		private double doctorOffice;																						//�칫��
		
		public String getDoctorName() {
			return doctorName;
		}
		public void setDoctorName(String doctorName) {
			this.doctorName = doctorName;
		}
		public String getDoctorSection() {
			return doctorSection;
		}
		public void setDoctorSection(String doctorSection) {
			this.doctorSection = doctorSection;
		}
		public double getDoctorOffice() {
			return doctorOffice;
		}
		public void setDoctorOffice(double doctorOffice) {
			this.doctorOffice = doctorOffice;
		}
	}
}

