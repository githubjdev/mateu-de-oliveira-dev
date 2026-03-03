package mat.dev.reflection;

import java.lang.reflect.Field;

public class MainReflection2 {

	public static void main(String[] args) throws Exception {

		/*validar campos null */
		Usuario u = new Usuario();
		
		for (Field atributo : u.getClass().getDeclaredFields()) {/*os atributos ou campos*/
			atributo.setAccessible(true);
			if (atributo.get(u) == null) {
				System.out.println("Campo: " + atributo.getName() + " está null."); 
			}
		}

	}

}
