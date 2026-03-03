package mat.dev.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TarefaMain {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		
		/*Qualquer objeto*/
		Tarefa tarefa = new Tarefa();
		
		for (Method metodo : tarefa.getClass().getDeclaredMethods()) {
			if(metodo.isAnnotationPresent(Executar.class)) {
				metodo.invoke(tarefa);
			}
		}

	}

}
