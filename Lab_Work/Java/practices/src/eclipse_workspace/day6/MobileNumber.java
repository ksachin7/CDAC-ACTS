package eclipse_workspace.day6;

public class MobileNumber {

	public static void formatMobileNumber(String m_no) {
		if(m_no.contains("-")) m_no=m_no.replace("-", "");
		
		if(m_no.contains("+91") && m_no.length() <13) {
			System.out.println("Invalid mobile number!");
		}
		else if(!m_no.contains("+91") && (m_no.length() <10 || m_no.length()>10)) {
			System.out.println("Invalid mobile number!");
		}
		else {
			StringBuilder builder= new StringBuilder();	
			builder.append(m_no);
			
			if(m_no.contains("+91")) {
				builder.insert(3, '-');
				builder.insert(7, '-');
				builder.insert(11, '-');
			}else {
				builder.append(m_no);
				builder.insert(0, "+91-");
				builder.insert(7, '-');
				builder.insert(11, '-');
			}
			System.out.println(builder);
	}
}
	
	public static void main(String[] args) {
//		Expected output +91-988-162-8598
		
		String m_no=null;
//		m_no="+91-988-162-8598";
//		m_no="+91-988-162-8598";
//		m_no="+919881628598";
		m_no="988162859";
		
		formatMobileNumber(m_no);
	}

}
