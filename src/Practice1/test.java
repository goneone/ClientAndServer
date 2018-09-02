package Practice1;

public class test {
	public static void main(String[] args) {

		data dataTest = new data();
		dataTest.setAge(55);
		dataTest.setDataLength(30);
		dataTest.setRRN(9102061231234L);
		dataTest.setGBCode(0001); 
		dataTest.setPhoneNumber(01033331111);
		dataTest.setName("¹Ú¿µÀÏ");
		
		System.out.println(dataTest.getAge());
	}

