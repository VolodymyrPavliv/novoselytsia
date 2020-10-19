package ua.novoselytsia.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.novoselytsia.entities.Post;

@Component
public class PostValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Post.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Post post = (Post) o;

        if(post.getTitle().isEmpty()) {
            errors.rejectValue("title","error.post.title");
        }

        if(post.getText().isEmpty()) {
            errors.rejectValue("text","error.post.text");
        }
    }
}
