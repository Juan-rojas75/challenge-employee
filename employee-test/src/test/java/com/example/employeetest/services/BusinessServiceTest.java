package com.example.employeetest.services;

import com.example.employeetest.service.BusinessService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BusinessServiceTest {

    private final BusinessService businessService = new BusinessService();

    @Test
    void testCalculateAnnualSalary() {
        // Arrange
        float monthlySalary = 3000f;
        float expectedAnnualSalary = 36000f;

        // Act
        float actualAnnualSalary = businessService.calculateAnnualSalary(monthlySalary);

        // Assert
        assertEquals(expectedAnnualSalary, actualAnnualSalary, 0.01, "Annual salary calculation is incorrect");
    }

    @Test
    void testCalculateAnnualSalary_WithZeroSalary() {
        // Arrange
        float monthlySalary = 0f;
        float expectedAnnualSalary = 0f;

        // Act
        float actualAnnualSalary = businessService.calculateAnnualSalary(monthlySalary);

        // Assert
        assertEquals(expectedAnnualSalary, actualAnnualSalary, "Annual salary for zero monthly salary should be zero");
    }

    @Test
    void testCalculateAnnualSalary_WithNegativeSalary() {
        float negativeSalary = -1000;
        float annualSalary = businessService.calculateAnnualSalary(negativeSalary);

        assertEquals(-12000, annualSalary);
    }
}
