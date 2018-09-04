package Practice1;

public class parseData {
	public static void main(String[] args) throws Exception {
		String receiveData = "00450001이        055910206123123401033331111";
	
		System.out.println(getString(receiveData, 0, 4)); //바이트길이
		System.out.println(getString(receiveData, 4, 4)); //구분코드
		System.out.println(getString(receiveData, 8, 10));//이름
		System.out.println(getString(receiveData, 18, 3));//나이
		System.out.println(getString(receiveData, 21, 13));//주민등록번호
		System.out.println(getString(receiveData, 34, 11));//핸드폰번호
		System.out.println(getString(receiveData, 0, 45));//전체데이터 

		
	}
	//String을 byte로 자르기.
	public  static String getString(String str, int sPoint, int length) throws Exception{
	    //euc-kr은 한글이 2바이트 utf-8은 한글이 3바이트 
		String EncodingLang = "euc-kr";
	    byte[] bytes = str.getBytes("euc-kr");

	    byte[] value = new byte[length];

	    //데이터의 최대 길이보다 길면 오류 
	    if(bytes.length < sPoint + length){
	        throw new Exception("길이오버");
	    }

	    for(int i = 0; i < length; i++){
	        value[i] = bytes[sPoint + i];
	    }
	    //트림은 공백을 없애주는 메소드 
	    return new String(value, EncodingLang).trim();
	}	
}
