package develcode.devel.service;

import develcode.devel.Exception.BusinessException;
import develcode.devel.model.User;
import develcode.devel.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
     UserRepository userRepository;


    public User save(User user) {

      if(userRepository.existsByCode(user.getCode())) {
          throw new BusinessException("Código já cadastrado");
      }

      return userRepository.save(user);

    }

    public User update(User user) {
      return userRepository.save(user);
    }


    public Optional<User> findById(Long id){
      return userRepository.findById(id);
    }

    public List<User> listAll() {
      return userRepository.findAll();
    }

}
