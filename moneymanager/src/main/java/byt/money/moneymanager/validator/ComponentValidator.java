package byt.money.moneymanager.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComponent;

/**
 *
 * @author Lukasz
 */
public class ComponentValidator {
    
    private final JComponent component;
    List<Validator> validators;

    public ComponentValidator(JComponent component, Validator... validator) {
        this.component = component;
        validators = Arrays.asList(validator);
    }
    
    public void validate(){
        boolean result = true;
        for (Validator validator : validators) {
            result = result && validator.isValid();
        }
        component.setEnabled(result);
    }
    
}
