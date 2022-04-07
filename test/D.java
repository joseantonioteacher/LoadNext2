
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class D {

	
	
	public static final String append(String... objects) {
		StringBuilder sb = new StringBuilder();
		for (Object o: objects) {
			sb.append(o);
		}
	}
	
	
	
	
	public static void main(String args[]) {
		try {
			
			
			
			// Pasar un String a Date
			String s ="28/10/2020";

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date fecha = df.parse(s);
			System.out.println(fecha);
			
			df = new SimpleDateFormat("dd/MMM/yyyy");
			Date ahora = new Date();			
			String ahoraStr = df.format(ahora);
			System.out.println("Ahora: "+ahoraStr);
			
			
			//
			Calendar c = Calendar.getInstance();
			c.set(2020, Calendar.FEBRUARY, 3, 12, 0, 0);
			c.set(Calendar.MONTH, Calendar.MARCH);
			
			c.add(Calendar.DAY_OF_YEAR, -3);
			Date d = c.getTime();
			System.out.println(d);
			
			// Duration ...
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
