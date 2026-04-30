package mat.dev.sprinboot.exception;

import java.time.LocalDateTime;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/* Para erro que não estamos esperando RuntimeException*/
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> erroGeralRuntime(RuntimeException ex) {

		return ResponseEntity.internalServerError()
				               .contentType(MediaType.APPLICATION_JSON)
				               .body(ex.getMessage());
	}

	/* Para erro que não estamos esperando Exception*/
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> erroGeralException(Exception ex) {

		return ResponseEntity.internalServerError().
				             contentType(MediaType.APPLICATION_JSON)
				             .body(ex.getMessage());
	}
	
	
	/* Para erro que não estamos esperando MsgApiException*/
	@ExceptionHandler(MsgApiException.class)
	public ResponseEntity<ResponseApi> erroGeralMsgApiException(MsgApiException ex, 
			                                                   HttpServletRequest request) {
		
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
