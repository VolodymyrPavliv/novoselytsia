package ua.novoselytsia.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.novoselytsia.entities.Place;

@Component
public class PlaceValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Place.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Place place = (Place) o;

        if(place.getName().isEmpty()) {
            errors.rejectValue("name","error.place.name");
        }


    }
}
