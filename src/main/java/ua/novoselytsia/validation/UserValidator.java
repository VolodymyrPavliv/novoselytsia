package ua.novoselytsia.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.novoselytsia.entities.User;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if(user.getFirstName().isEmpty()) {
            errors.rejectValue("firstName","error.first_name");
        }

        if(user.getLastName().isEmpty()) {
            errors.rejectValue("lastName","error.last_name");
        }
    }
}
