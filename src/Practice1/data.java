package Practice1;

public class data {
	public String dataLength;
	public String gbCode;
	public String name;
	public String age;
	public String rrn; // �ֹε�Ϲ�ȣ
	public String phoneNumber;

	public String getDataLength() {
		return dataLength;
	}
	public void setDataLength(String dataLength) {
		this.dataLength = dataLength;
	}
	public String getGbCode() {
		return gbCode;
	}
	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getRrn() {
		return rrn;
	}
	public void setRrn(String rrn) {
		this.rrn = rrn;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	/*public String checkDataLength() {
		//������ ���� ���ϴ� �޼ҵ� �����ϼ���
	}*/
	

	//�̸��� 5���� ���ϸ� �ڿ� ���� �ٿ��ִ� �޼ҵ� �����ϼ���
	public String checkedName() {
		StringBuffer checkedName = new StringBuffer(name);
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
	//�̰Ŵٽ�.. ��Ʈ������ �ٽð����ϱ�..�� ������ �ڹ� 
	/*public String checkedPhoneNumber() {
		StringBuffer checkedPhoneNumber = new StringBuffer(age);
		int length = (int)(Math.log10(age)+1);
		if(length < 3) {
			for (int i = length; i < 3; i++) {
				checkedPhoneNumber.append(' ');
			}
		} return checkedPhoneNumber.toString();
	}*/


	public static void main(String[] args) {
		data dataTest = new data();
		dataTest.setAge("55");
		dataTest.setRrn("9102061231234");
		dataTest.setGbCode("0001"); 
		dataTest.setPhoneNumber("01033331111");
		dataTest.setName("���ڹ�");
		
		System.out.println(dataTest.checkedAge());
		System.out.println(dataTest.checkedName());
		//System.out.println(dataTest.checkedPhoneNumber());
		//������ byte��������, ������ ���δ� String���� 1���̸� 000010000�̷������� �տ��� 0000���� ä����. 
		//���ڸ� �տ� �����̰ų� �ڿ� ����
	}
}