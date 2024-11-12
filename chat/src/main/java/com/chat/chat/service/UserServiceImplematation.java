package com.chat.chat.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.chat.chat.model.User;
import com.chat.chat.repository.userRepository;

@Service
public class UserServiceImplematation implements UserService{

   @Autowired 
   private  userRepository repository;

    @Override
    public List<User> getAllUser() {
       List<User> user=repository.findAll();
       return user;
    }

    @Override
    public User getUserById(@PathVariable("userId") Integer userId) throws Exception {
       Optional<User> user1=repository.findById(userId);
       if(user1.isEmpty()){
        throw new Exception("user not exit with id " + userId);
       }
       return user1.get();

    }

    @Override
    public User registerUser(@RequestBody User user) {
        User newUser=new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        User user1=repository.save(newUser);

        return user1;
       
    }

    @Override
    public User updateUser(@RequestBody User user,Integer userId) throws Exception {
        Optional<User> user1=repository.findById(userId);

        if(user1.isEmpty()){
            throw new Exception("user not exit with id" + userId);
        }

        User newUser=user1.get();
        if(user.getFirstName()!=null){
            newUser.setFirstName(user.getFirstName());
        }
        if(user.getLastName()!=null){
            newUser.setLastName(user.getLastName());
        }
        if(user.getEmail()!=null){
            newUser.setEmail(user.getEmail());
        }
        if(user.getPassword()!=null){
            newUser.setPassword(user.getPassword());
        }
        User updateUser=repository.save(newUser);

        return updateUser;

      
    }

    @Override
    public String deleteUserById(@PathVariable("userid") Integer userid)  throws Exception{
        Optional<User> user=repository.findById(userid);
        if(user.isEmpty()){
            throw new Exception("user not exits with Id " + userid);
        }
        repository.deleteById(userid);
        return "successfully delete user ";
       
    }

    public User findUserById(Integer userid){
        Optional<User> user=repository.findById(userid);
        return user.get();
    }
    @Override
    public User followUser(@PathVariable Integer id1,@PathVariable Integer id2) {
     User user1=findUserById(id1);
     User user2=findUserById(id2);
     user2.getFollowers().add(user1.getId());
     user1.getFollowings().add(user2.getId());
     repository.save(user1);
     repository.save(user2);
     return user1;

    }

   

    @Override
    public List<User> searchUser(String query) {
       
        return repository.searchUser(query);
    }
    // @Override
    // public User findByEmail(String email){
    //     return repository.findByEmail(email);
    // }
    
}
