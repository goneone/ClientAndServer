package Practice1;

public class data {
	public String dataLength;
	public String gbCode;
	public String name;
	public String age;
	public String rrn; // 주민등록번호
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

	// 전문만들기 
	public String serializeData() {
		String serializeData=dataLength+gbCode+this.checkedName()+this.checkedAge()+rrn+this.checkedPhoneNumber();
		
		return serializeData;
	} 
	
	// 전문타입 구분 메소드
	public String dataType() {
		if(gbCode == "0001" ) {
			
		}else if(gbCode == "0002"){
			
		}else if(gbCode == "0003"){
			
		}else if(gbCode == "0004"){
		
		}return "test";
	}
	// 이름이 5글자 미만이면 뒤에 공백 붙여주는 메소드
	// 5글자 이상 막는 로직 있어야 하나? 생각할것.
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
	  //나이가 3자이하면 050 이런식으로 앞에 0이붙도록하는 메서드 public String checkedAge() {
	  StringBuffer checkedAge = new StringBuffer(age); int checkedAgeLength =
	  checkedAge.toString().getBytes().length; if(checkedAgeLength == 2) {
	  checkedAge.insert(0, "0"); } return checkedAge.toString(); //return
	  checkedAge.toString(); }
	 */

	// 나이 2자리면 앞에 0붙여주는 메소드
	public String checkedAge() {
		if (age.length() == 2) {
			age = "0" + age;
		}
		return age;
		// return checkedAge.toString();
	}

	// 전화번호 10자리면 뒤에 공백붙도록.
	public String checkedPhoneNumber() {
		if (phoneNumber.length() == 10) {
			phoneNumber =phoneNumber+" ";
		}
		return phoneNumber;
	}

	public static void main(String[] args) {
		data dataTest = new data();
		dataTest.setDataLength("0045"); //바이트길이 45
		dataTest.setAge("55");
		dataTest.setRrn("9102061231234");
		dataTest.setGbCode("0001");
		dataTest.setPhoneNumber("0103333111");
		dataTest.setName("이웅");
		

		System.out.println(dataTest.checkedAge());
		System.out.println(dataTest.checkedName().length());
		System.out.println(dataTest.checkedPhoneNumber());
		System.out.println(dataTest.serializeData());
		System.out.println(dataTest.serializeData().getBytes().length);
		
		// 전문은 byte형식으로, 전문은 전부다 String으로 1억이면 000010000이런식으로 앞에는 0000으로 채워줌.
		// 숫자면 앞에 공백이거나 뒤에 공백, string.getBytes 하면 바이트형식으러감.
	}
}