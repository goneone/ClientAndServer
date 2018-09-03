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
	
	
	/*public String checkDataLength() {
		//데이터 길이 구하는 메소드 구현하세요
	}*/
	

	//이름이 5글자 이하면 뒤에 공백 붙여주는 메소드 구현하세요
	public String checkedName() {
		StringBuffer checkedName = new StringBuffer(name);
		int checkedNameLength = checkedName.toString().getBytes().length;
		if(checkedNameLength < 10) {
			for (int i = checkedNameLength; i < 10; i++) {
				checkedName.append(' ');
			}
		} return checkedName.toString();
		
	}
	//나이가 3자이하면 050 이런식으로 앞에 0이붙도록하는 메서드
	public String checkedAge() {
		StringBuffer checkedAge = new StringBuffer(age);
		return checkedAge.toString();
	}
	
	//전화번호 10자리면 뒤에 공백붙도록.
	//이거다시.. 스트링버퍼 다시공부하기..아 좃같은 자바 
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
		dataTest.setName("김자바");
		
		System.out.println(dataTest.checkedAge());
		System.out.println(dataTest.checkedName());
		//System.out.println(dataTest.checkedPhoneNumber());
		//전문은 byte형식으로, 전문은 전부다 String으로 1억이면 000010000이런식으로 앞에는 0000으로 채워줌. 
		//숫자면 앞에 공백이거나 뒤에 공백
	}
}