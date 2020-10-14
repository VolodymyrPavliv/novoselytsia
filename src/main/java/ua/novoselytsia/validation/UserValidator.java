package ua.novoselytsia.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.novoselytsia.entities.User;
import ua.novoselytsia.service.UserService;

@Component
public class UserValidator implements Validator {
    private final UserService userService;

    public UserValidator(UserService userService) {
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

        if(user.getEmail().length()==0) {
            errors.rejectValue("email","error.email.null");
        }

        if(user.getFirstName().length()==0) {
            errors.rejectValue("firstName","error.first_name");
        }

        if(user.getLastName().length()==0) {
            errors.rejectValue("lastName","error.last_name");
        }

        if(user.getAge()==0) {
            errors.rejectValue("age","error.age");
        }
    }
}
