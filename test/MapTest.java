import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapTest {
	
	
	public static void leer(Map<String, String> propietarioPorMatricula) {
		Scanner s = new Scanner(System.in);
		String matricula = null;
		String nombrePropietario = null;
		for (int i = 0; i<5; i++) {
			System.out.println("Matricula?:");			
			matricula = s.nextLine();
			System.out.println("Propietario?:");			
			nombrePropietario = s.nextLine();
			propietarioPorMatricula.put(matricula, nombrePropietario);
		}
	}
	
	
	public static void print(Map<String, String> m) {
		Set<String> keys = m.keySet();
		for (String k: keys) {
			System.out.println(k+"="+m.get(k));
		}
	}
	
	public static void main(String args[]) {
		Map<String, String> duenosDeCoche = new HashMap<String, String>();
		leer(duenosDeCoche);
		print(duenosDeCoche);
		
		
	}
}
