package com.blueochild.service;

import com.blueochild.datamodel.SaleGroupByUserId;
import com.blueochild.datamodel.UserGradeEnum;
import com.blueochild.datamodel.UserTotalPaidPrice;
import com.blueochild.model.User;
import com.blueochild.repository.SaleRepository;
import com.blueochild.repository.UserRepository;
import com.blueochild.vo.UserRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserService {
    private final UserRepository userRepository;
    private final SaleRepository saleRepository;

    @Autowired
    public UserService(UserRepository userRepository, SaleRepository saleRepository) {
        this.userRepository = userRepository;
        this.saleRepository = saleRepository;
    }

    public User find(int userId) throws Exception {
        Optional<User> searchedUser = this.userRepository.findById(userId);
        return searchedUser.orElseThrow(() -> new Exception("해당 유저를 찾지 못하였습니다."));
    }

    public List findAll() {
        return this.userRepository.findAll();
    }

    public void initializeUsers() {
        User user1 = User.builder()
                .email("example1@sample.com")
                .name("Mr. Example")
                .phone("01000000000")
                .build();

        User user2 = User.builder()
                .email("example2@sample.com")
                .name("Mrs. Sample")
                .phone("01000000000")
                .build();

        User user3 = User.builder()
                .email("example3@sample.com")
                .name("ms. Sample Data")
                .phone("01000000000")
                .build();

        this.userRepository.save(user1);
        this.userRepository.save(user2);
        this.userRepository.save(user3);
        this.userRepository.flush();
    }

    public int createUser(UserRegisterVO userRegisterVO) {
        User createUser = User.builder()
                .email(userRegisterVO.getEmail())
                .phone(userRegisterVO.getPhone())
                .name(userRegisterVO.getName())
                .build();

        this.userRepository.save(createUser);
        this.userRepository.flush();

        return createUser.getUserId();
    }

    public void deleteUser(int userId) {
        this.userRepository.deleteById(userId);
    }

    public UserGradeEnum getUserGrade(int userId) {
        SaleGroupByUserId groupData = this.saleRepository.PurchaseAmountGroupByUserId(userId);
        UserTotalPaidPrice userTotalPaidPrice = new UserTotalPaidPrice(groupData);

        if (userTotalPaidPrice.getTotalPaidPrice() < 100000) {
            return UserGradeEnum.FirstGrade;
        }
        else if (userTotalPaidPrice.getTotalPaidPrice() < 1000000) {
            return UserGradeEnum.SecondGrade;
        }
        else if (userTotalPaidPrice.getTotalPaidPrice() < 3000000) {
            return UserGradeEnum.ThirdGrade;
        }
        else if (userTotalPaidPrice.getTotalPaidPrice() < 10000000) {
            return UserGradeEnum.FourthGrade;
        }
        else {
            return UserGradeEnum.TopTier;
        }
    }
}
