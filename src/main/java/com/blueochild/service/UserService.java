package com.blueochild.service;

import java.util.List;

import com.blueochild.model.User;
import com.blueochild.repository.ProductRepository;
import com.blueochild.repository.SaleRepository;
import com.blueochild.repository.UserRepository;
import com.blueochild.vo.UserRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, SaleRepository saleRepository, ProductRepository productRepository){
        this.userRepository = userRepository;
    }

    public User find(int userId) throws Exception{
        Optional<User> searchedUser = this.userRepository.findById(userId);
        return searchedUser.orElseThrow(()->new Exception("해당 유저를 찾지 못했습니다."));

//        if(searchedUser == null){
//            throw new Exception("해당 유저를 찾지 못했습니다.");
//        }
//        return searchedUser.get();
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public void initializeUsers(){
        User user1 = User.builder()
                .email("example1@sample.com")
                .name("Mr. Example")
                .phone("01000000000")
                .build();

        User user2 = User.builder()
                .email("example2@sample.com")
                .name("Mrs. Sample")
                .phone("01000001234")
                .build();

        User user3 = User.builder()
                .email("example3@sample.com")
                .name("Ms. Sample Data")
                .phone("01056781234")
                .build();

        this.userRepository.save(user1);
        this.userRepository.save(user2);
        this.userRepository.save(user3);
        this.userRepository.flush();
    }

    public void createUser(UserRegisterVO userRegisterVO){
        User createuser = User.builder()
                .email(userRegisterVO.getEmail())
                .name(userRegisterVO.getName())
                .phone(userRegisterVO.getPhone())
                .build();

        this.userRepository.save(createuser);
        this.userRepository.flush();
    }
}
