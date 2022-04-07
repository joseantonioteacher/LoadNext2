
public class SB {

	private static final int OPS = 200000;
	private static final String KK = "·asñdfkajsdñf asdfñalskdfjasñldkfj asñdfk";

	public static final String plus() {
		String s = "";		
		for (int i = 0; i<OPS; i++) {
			s+=KK;
		}
		return s;
	}

	public static final String builder() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<OPS; i++) {
			sb.append(KK);
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		String s = null;
		long t0, t1, diff;
		
		t0 = System.currentTimeMillis();
		s = plus();
		t1 = System.currentTimeMillis();
		diff = t1 - t0;
		System.out.println("Plus Time: "+diff+"ms");
		
		t0 = System.currentTimeMillis();
		s = builder();
		t1 = System.currentTimeMillis();
		diff = t1 - t0;
		System.out.println("Builder Time: "+diff+"ms");
	}
}
