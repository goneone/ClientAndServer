package Practice1;

public class data {
	public int dataLength;
	public int GBCode;
	public String Name;
	public int age;
	public long RRN; // 주민등록번호
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
		//데이터 길이 구하는 메소드 구현하세요
	}*/
	
	//이름이 5글자 이하면 뒤에 공백 붙여주는 메소드 구현하세요
	public String checkedName() {
		StringBuffer checkedName = new StringBuffer(Name);
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
	public static void main(String[] args) {
		data dataTest = new data();
		dataTest.setAge(55);
		dataTest.setRRN(9102061231234L);
		dataTest.setGBCode(0001); 
		dataTest.setPhoneNumber(01033331111);
		dataTest.setName("김자바");
		
		System.out.println(dataTest.checkedAge());
		System.out.println(dataTest.checkedName());
		
	}
}