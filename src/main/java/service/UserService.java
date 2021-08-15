package service;

import model.User;
import repository.UserRepository;
import java.util.List;

public class UserService {

    private UserRepository userRepository = new UserRepository();



    public void save(User user){

        userRepository.save(user);
    }

    public User findById(int id){

        return userRepository.getById(id);
    }

    public List<User> findAll(){

        return userRepository.getAll();
    }

    public void delete(int id){

        userRepository.deleteById(id);
    }

    public void update(User user){
        userRepository.update(user);
    }

}
