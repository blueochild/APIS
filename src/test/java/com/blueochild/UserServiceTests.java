package com.blueochild;

import com.blueochild.datamodel.UserGradeEnum;
import com.blueochild.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {
    private final UserService userService;

    @Autowired
    public UserServiceTests(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void testGetUserGradeByTotalPaidPriceFirstGrade() {
        // Given
        int totalPaidAmount = 0;

        // When
        UserGradeEnum userGrade = this.userService.getUserGradeByTotalPaidPrice(totalPaidAmount);

        // Then
        assertEquals(userGrade, UserGradeEnum.FirstGrade);
    }

    @Test
    public void testGetUserGradeByTotalPaidPriceSecondGrade() {
        // Given
        int totalPaidAmount = 100_000;

        // When
        UserGradeEnum userGrade = this.userService.getUserGradeByTotalPaidPrice(totalPaidAmount);

        // Then
        assertEquals(userGrade, UserGradeEnum.SecondGrade);
    }

    @Test
    public void testGetUserGradeByTotalPaidPriceThirdGrade() {
        // Given
        int totalPaidAmount = 1_000_000;

        // When
        UserGradeEnum userGrade = this.userService.getUserGradeByTotalPaidPrice(totalPaidAmount);

        // Then
        assertEquals(userGrade, UserGradeEnum.ThirdGrade);
    }

    @Test
    public void testGetUserGradeByTotalPaidPriceFourthGrade() {
        // Given
        int totalPaidAmount = 3_000_000;

        // When
        UserGradeEnum userGrade = this.userService.getUserGradeByTotalPaidPrice(totalPaidAmount);

        // Then
        assertEquals(userGrade, UserGradeEnum.FourthGrade);
    }

    @Test
    public void testGetUserGradeByTotalPaidPriceTopTier() {
        // Given
        int totalPaidAmount = 10_000_000;

        // When
        UserGradeEnum userGrade = this.userService.getUserGradeByTotalPaidPrice(totalPaidAmount);

        // Then
        assertEquals(userGrade, UserGradeEnum.TopTier);
    }
}
