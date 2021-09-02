package develcode.devel.Exception;

public class FormErrorValidation {

  private  String campo;
  private final String mensagem;

  public FormErrorValidation(String campo, String mensagem) {
    this.campo = campo;
    this.mensagem = mensagem;
  }

  public String getCampo() {
    return campo;
  }

  public String getMensagem() {
    return mensagem;
  }

  public FormErrorValidation(String mensagem) {
    this.mensagem = mensagem;
  }

}
