package main.validation;

import main.dto.AccountDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsEqualConstraintValidator implements ConstraintValidator<PasswordsEqualConstraint, Object> {

    @Override
    public void initialize(PasswordsEqualConstraint arg0) {
    }

    @Override
    public boolean isValid(Object account, ConstraintValidatorContext arg1) {
        AccountDTO accountDTO = (AccountDTO) account;
        return accountDTO.getPassword().equals(accountDTO.getConfirmPassword());
    }
}