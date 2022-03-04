//package com.webmusic.service.user;
//
//import com.webmusic.model.security.User;
//import com.webmusic.service.IGeneral;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface IUserService extends IGeneral<User>, UserDetailsService {
//    Optional<User> findByUsername(String username);
//
//    Boolean existByEmail(String email);
//
//    User findByEmail(String email);
//}
