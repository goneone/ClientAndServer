package Practice1;

public class data {
	public int dataLength;
	public int GBCode;
	public String Name;
	public int age;
	public long RRN; // �ֹε�Ϲ�ȣ
	public int phoneNumber;
	
	public int getDataLength() {
		return dataLength;
	}
	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
	}
	public int getGBCode() {
		return GBCode;
	}
	public void setGBCode(int gBCode) {
		GBCode = gBCode;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getRRN() {
		return RRN;
	}
	public void setRRN(long rRN) {
		RRN = rRN;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/*public String checkDataLength() {
		//������ ���� ���ϴ� �޼ҵ� �����ϼ���
	}*/
	
	//�̸��� 5���� ���ϸ� �ڿ� ���� �ٿ��ִ� �޼ҵ� �����ϼ���
	public String checkedName() {
		StringBuffer checkedName = new StringBuffer(Name);
		int checkedNameLength = checkedName.toString().getBytes().length;
		if(checkedNameLength < 10) {
			for (int i = checkedNameLength; i < 10; i++) {
				checkedName.append(' ');
			}
		} return checkedName.toString();
		
	}
	//���̰� 3�����ϸ� 050 �̷������� �տ� 0�̺ٵ����ϴ� �޼���
	public String checkedAge() {
		StringBuffer checkedAge = new StringBuffer(age);
		return checkedAge.toString();
	}
	
	//��ȭ��ȣ 10�ڸ��� �ڿ� ����ٵ���.
	public static void main(String[] args) {
		data dataTest = new data();
		dataTest.setAge(55);
		dataTest.setRRN(9102061231234L);
		dataTest.setGBCode(0001); 
		dataTest.setPhoneNumber(01033331111);
		dataTest.setName("���ڹ�");
		
		System.out.println(dataTest.checkedAge());
		System.out.println(dataTest.checkedName());
		
	}
}