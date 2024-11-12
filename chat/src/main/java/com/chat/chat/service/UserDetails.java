// package com.chat.chat.service;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;

// import com.chat.chat.model.User;
// import com.chat.chat.repository.userRepository;

// public class UserDetails implements UserDetailsService{

//     @Autowired
//     private userRepository userRepo;

//     @Override
//     public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
//             throws UsernameNotFoundException {
//                 User user=userRepo.findByEmail(username);
//                 if(user==null){
//                     throw  new UsernameNotFoundException("user not found with email"+username);
//                 }
//                 List<GrantedAuthority> authorities=new ArrayList<>();
                

               
//       return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
//     }
    
// }
