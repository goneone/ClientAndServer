package kt;

public class parseData {
	// String�� byte�� �ڸ���.
	public String getString(String str, int sPoint, int length) throws Exception {
		// euc-kr�� �ѱ��� 2����Ʈ utf-8�� �ѱ��� 3����Ʈ
		String EncodingLang = "euc-kr";
		byte[] bytes = str.getBytes("euc-kr");

		byte[] value = new byte[length];

		// �������� �ִ� ���̺��� ��� ����
		if (bytes.length < sPoint + length) {
			throw new Exception("���̿���");
		}

		for (int i = 0; i < length; i++) {
			value[i] = bytes[sPoint + i];
		}
		// Ʈ���� ������ �����ִ� �޼ҵ�
		return new String(value, EncodingLang).trim();
	}
}
