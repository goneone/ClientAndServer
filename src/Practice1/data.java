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

	// ��������� 
	public String serializeData() {
		String serializeData=dataLength+gbCode+this.checkedName()+this.checkedAge()+rrn+this.checkedPhoneNumber();
		
		return serializeData;
	} 
	
	// ����Ÿ�� ���� �޼ҵ�
	public String dataType() {
		if(gbCode == "0001" ) {
			
		}else if(gbCode == "0002"){
			
		}else if(gbCode == "0003"){
			
		}else if(gbCode == "0004"){
		
		}return "test";
	}
	// �̸��� 5���� �̸��̸� �ڿ� ���� �ٿ��ִ� �޼ҵ�
	// 5���� �̻� ���� ���� �־�� �ϳ�? �����Ұ�.
	public String checkedName() {
		StringBuffer checkedName = new StringBuffer(name);
		int checkedNameLength = checkedName.toString().getBytes().length;
		if (checkedNameLength < 10) {
			for (int i = checkedNameLength; i < 10; i++) {
				checkedName.append(' ');
			}
		}
		return checkedName.toString();

	}
	/*
	  //���̰� 3�����ϸ� 050 �̷������� �տ� 0�̺ٵ����ϴ� �޼��� public String checkedAge() {
	  StringBuffer checkedAge = new StringBuffer(age); int checkedAgeLength =
	  checkedAge.toString().getBytes().length; if(checkedAgeLength == 2) {
	  checkedAge.insert(0, "0"); } return checkedAge.toString(); //return
	  checkedAge.toString(); }
	 */

	// ���� 2�ڸ��� �տ� 0�ٿ��ִ� �޼ҵ�
	public String checkedAge() {
		if (age.length() == 2) {
			age = "0" + age;
		}
		return age;
		// return checkedAge.toString();
	}

	// ��ȭ��ȣ 10�ڸ��� �ڿ� ����ٵ���.
	public String checkedPhoneNumber() {
		if (phoneNumber.length() == 10) {
			phoneNumber =phoneNumber+" ";
		}
		return phoneNumber;
	}

	public static void main(String[] args) {
		data dataTest = new data();
		dataTest.setDataLength("0045"); //����Ʈ���� 45
		dataTest.setAge("55");
		dataTest.setRrn("9102061231234");
		dataTest.setGbCode("0001");
		dataTest.setPhoneNumber("0103333111");
		dataTest.setName("�̿�");
		

		System.out.println(dataTest.checkedAge());
		System.out.println(dataTest.checkedName().length());
		System.out.println(dataTest.checkedPhoneNumber());
		System.out.println(dataTest.serializeData());
		System.out.println(dataTest.serializeData().getBytes().length);
		
		// ������ byte��������, ������ ���δ� String���� 1���̸� 000010000�̷������� �տ��� 0000���� ä����.
		// ���ڸ� �տ� �����̰ų� �ڿ� ����, string.getBytes �ϸ� ����Ʈ����������.
	}
}