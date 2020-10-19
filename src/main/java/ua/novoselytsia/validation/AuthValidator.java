package ua.novoselytsia.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.novoselytsia.entities.User;
import ua.novoselytsia.service.UserService;

@Component
public class AuthValidator implements Validator {
    private final UserService userService;

    public AuthValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if(user.getPassword().length()<6) {
            errors.rejectValue("password","error.password");
        }

        if(userService.getByEmail(user.getEmail())!=null) {
            errors.rejectValue("email","error.email.already_exist");
        }

        if(user.getEmail().isEmpty()) {
            errors.rejectValue("email","error.email.null");
        }

        if(user.getFirstName().isEmpty()) {
            errors.rejectValue("firstName","error.first_name");
        }

        if(user.getLastName().isEmpty()) {
            errors.rejectValue("lastName","error.last_name");
        }
    }
}
