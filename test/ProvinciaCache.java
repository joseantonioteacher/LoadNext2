import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProvinciaCache {

	
	private HashMap<Multikey, List<Provincia>> provinciasByPais = null;
	
	
	public ProvinciaCache() {
		provinciasByPais = new HashMap<Multikey, List<Provincia>>());
		
		
	}
	
	public List<Provincia> getByPais(Integer id, String idioma) {
		return provinciasByPais.get(new Multikey(id, idioma));
	}
	
	public static void main(String[] args[]) {
		List<Pais> todos = paisDAO.findAll();
		List<Provincia> provincias;
		for (Pais p: todosd) {
			provincias = provinciaDAO.findByPais(p.getId());
			provinciasByPais.put(p.getId(), provincias);
		}
		
		
	}
}
