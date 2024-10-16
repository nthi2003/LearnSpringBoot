package userRest.userRest.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import userRest.userRest.domain.RestRestponsive;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = IdInvalidException.class)
    public ResponseEntity<Object> handleException(IdInvalidException idException){
        RestRestponsive<Object> res = new RestRestponsive<Object>();
        res.setStatusCode(HttpStatus.BAD_REQUEST.value());
        res.setError(idException.getMessage());
        res.setMessage("IdInvalidExcention");
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
