package develcode.devel.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import develcode.devel.model.User;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class UserRequestDTO {

  @NotEmpty
  @NotNull
  private String code;

  @Past(message = "Date é inválida para uma data de nascimento.")
  private final LocalDate birth_date;

  @NotEmpty
  @NotNull
  @Size(min = 3, message = "Nome deve ter mais de 2 caracteres")
  private String name;


  public UserRequestDTO(String code, LocalDate birth_date, String name) {
    this.code = code;
    this.birth_date = birth_date;
    this.name = name;
  }

  public String getNome() {
    return name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public LocalDate getBirth_date() {
    return birth_date;
  }

  public User converter() {

    return new User(getNome(), getCode(), getBirth_date());

  }
}
