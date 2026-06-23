package mat.dev.sprinboot.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/* Para erro que não estamos esperando RuntimeException*/
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> erroGeralRuntime(RuntimeException ex) {
		
		ex.printStackTrace();

		return ResponseEntity.internalServerError()
				               .contentType(MediaType.APPLICATION_JSON)
				               .body(ex.getMessage());
	}
	
	

	/* Para erro que não estamos esperando RuntimeException*/
	@ExceptionHandler(PSQLException.class)
	public ResponseEntity<String> erroGeralPsql(PSQLException ex) {
		
		ex.printStackTrace();

		return ResponseEntity.internalServerError()
				               .contentType(MediaType.APPLICATION_JSON)
				               .body(ex.getMessage());
	}

	/* Para erro que não estamos esperando Exception*/
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> erroGeralException(Exception ex) {
		
		ex.printStackTrace();

		return ResponseEntity.internalServerError().
				             contentType(MediaType.APPLICATION_JSON)
				             .body(ex.getMessage());
	}
	
	
	/* Captura erro do Bean Validator */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex) {

		List<String> lista = new ArrayList<String>();

		for (ObjectError erro : ex.getAllErrors()) {
			lista.add(erro.getDefaultMessage());
		}

		return ResponseEntity.ok().body(lista);
	}
	
	
	/* Para erro que não estamos esperando MsgApiException*/
	@ExceptionHandler(MsgApiException.class)
	public ResponseEntity<ResponseApi> erroGeralMsgApiException(MsgApiException ex, 
			                                                   HttpServletRequest request) {
		
		ex.printStackTrace();
		
		ResponseApi responseApi = new ResponseApi(LocalDateTime.now(),
				                ex.getStatus().value(),
				                ex.getStatus().getReasonPhrase(),
				                ex.getMessage(), 
				                request.getRequestURI());

		return ResponseEntity.status(ex.getStatus())
				             .contentType(MediaType.APPLICATION_JSON)
				             .body(responseApi);
	}

}
