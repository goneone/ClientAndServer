package kt;

public class parseData {
	// String을 byte로 자르기.
	public String getString(String str, int sPoint, int length) throws Exception {
		// euc-kr은 한글이 2바이트 utf-8은 한글이 3바이트
		String EncodingLang = "euc-kr";
		byte[] bytes = str.getBytes("euc-kr");

		byte[] value = new byte[length];

		// 데이터의 최대 길이보다 길면 오류
		if (bytes.length < sPoint + length) {
			throw new Exception("길이오버");
		}

		for (int i = 0; i < length; i++) {
			value[i] = bytes[sPoint + i];
		}
		// 트림은 공백을 없애주는 메소드
		return new String(value, EncodingLang).trim();
	}
}
