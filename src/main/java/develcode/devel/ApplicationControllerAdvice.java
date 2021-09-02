package develcode.devel;

import develcode.devel.Exception.ApiErrors;
import develcode.devel.Exception.BusinessException;
import develcode.devel.Exception.FormErrorValidation;
import develcode.devel.Exception.ResponseStatusError;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<FormErrorValidation> handleValidationException(
      MethodArgumentNotValidException exception) {
    BindingResult bindingResult = exception.getBindingResult();
    return new ApiErrors(bindingResult).getFormErrors();
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(BusinessException.class)
  public List<String> handleBusinessException(BusinessException exception) {
    return new ApiErrors(exception).getErro();

  }

  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<ResponseStatusError> handleResponseStatusException(
      ResponseStatusException exception) {
    ResponseStatusError erro = new ApiErrors().ResponseStatusError(exception);

    return ResponseEntity.status(erro.getStatus()).body(erro);
  }


}
