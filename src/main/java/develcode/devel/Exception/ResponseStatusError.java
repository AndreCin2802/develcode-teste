package develcode.devel.Exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResponseStatusError {

  private  Integer status;
  private  String mensagem;
  private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
  private String timestamp = LocalDateTime.now().format(format);

  public ResponseStatusError(Integer status, String mensagem) {
    this.status = status;
    this.mensagem = mensagem;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public static DateTimeFormatter getFormat() {
    return format;
  }

  public static void setFormat(DateTimeFormatter format) {
    ResponseStatusError.format = format;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }
}
