package develcode.devel.controller;

import develcode.devel.dto.UserRequestDTO;
import develcode.devel.model.User;
import develcode.devel.service.UserService;
import java.io.IOException;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;


  @GetMapping()
  public List<User> listAll() {
    return userService.listAll();
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public User save(@RequestBody @Valid UserRequestDTO dto)
      throws IOException {

    User user = dto.converter();

    return userService.save(user);
  }


}
