package develcode.devel.controller;

import develcode.devel.model.User;
import develcode.devel.service.UserService;
import develcode.devel.utils.ImageUploadUtils;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("photo")
public class ImageUploadController {

  @Autowired
  private UserService userService;

  @PostMapping("/upload/{id}")
  public ResponseEntity<?> uploadImage(@PathVariable Long id,
      @RequestParam("photo") MultipartFile file)
      throws IOException {

    User user = userService.findById(id)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário nao encontrado"));
    String fileName = StringUtils.cleanPath(user.getCode() + file.getOriginalFilename());
    String uploadDir = "users-photo";
    ImageUploadUtils.deleteFile(user.getPhoto());
    ImageUploadUtils.saveFile(uploadDir, fileName, file);
    user.setPhoto(uploadDir + '/' + fileName);
    userService.update(user);
    return ResponseEntity.ok().body(user);
  }
}

