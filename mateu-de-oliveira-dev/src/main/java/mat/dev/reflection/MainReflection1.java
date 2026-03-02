package mat.dev.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainReflection1 {
	
	public static void main(String[] args) {
		
		
		Class<Usuario> user = Usuario.class;
		
		System.out.println("Campos da classe: \n");
		for (Field campo : user.getDeclaredFields()) {
			System.out.println("Campo: " + campo.getName());
			System.out.println("Tipo: " + campo.getType());
			System.out.println("-----------------------------");
		}
		
		System.out.println("Métodos da classe: \n");

		for (Method metodo : user.getDeclaredMethods()) {
			System.out.println("Método: " + metodo.getName());
		}
	}

}
