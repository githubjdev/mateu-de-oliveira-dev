package mat.dev.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainReflection1 {
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		
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
		
		/*CHamando o getNome para obter o valor*/
		Field fieldNome = user.getDeclaredField("nome");
		fieldNome.setAccessible(true); /*tornar o atributo privado aessivel por reflexão*/
		
		Usuario userTeste = new Usuario();
		System.out.println("Obtendo o valor do campo nome: " + fieldNome.get(userTeste));
		
		
		/*Setar o valor do nome ou alterar o valor*/
		fieldNome.set(userTeste, "Alex Fernando Egidio");
		System.out.println("Obtendo o valor do campo nome altertando: " + fieldNome.get(userTeste));
		
		
		
	}

}
