package byt.money.moneymanager.validator;

/**
 *
 * @author Lukasz
 */
public class TextValidator implements Validator {
    
    private boolean valid;

    @Override
    public boolean validate(String value) {
        valid = (value != null && !value.isEmpty());
        return valid;
    }

    @Override
    public boolean isValid() {
        return valid;
    }
    
}
