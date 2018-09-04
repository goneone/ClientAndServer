package Practice1;

public class parseData {
	public static void main(String[] args) throws Exception {
		String receiveData = "00450001��        055910206123123401033331111";
	
		String a = receiveData.substring(0, 4);
		String b = receiveData.substring(4, 8);
		String c = receiveData.substring(8, 16);
		String d = receiveData.substring(0, 4);

	
		System.out.println(getString(receiveData, 0, 4));
		System.out.println(getString(receiveData, 4, 4));
		System.out.println(getString(receiveData, 8, 10));
		System.out.println(getString(receiveData, 18, 3));
		System.out.println(getString(receiveData, 21, 13));
		System.out.println(getString(receiveData, 34, 11));
		System.out.println(getString(receiveData, 0, 45));

		
	}
	//String�� byte�� �ڸ���.
	public  static String getString(String str, int sPoint, int length) throws Exception{
	    //euc-kr�� �ѱ��� 2����Ʈ utf-8�� �ѱ��� 3����Ʈ 
		String EncodingLang = "euc-kr";
	    byte[] bytes = str.getBytes("euc-kr");

	    byte[] value = new byte[length];

	    //�������� �ִ� ���̺��� ��� ���� 
	    if(bytes.length < sPoint + length){
	        throw new Exception("���̿���");
	    }

	    for(int i = 0; i < length; i++){
	        value[i] = bytes[sPoint + i];
	    }
	    //Ʈ���� ������ �����ִ� �޼ҵ� 
	    return new String(value, EncodingLang).trim();
	}	
}
