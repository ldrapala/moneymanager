package byt.money.moneymanager.validator;

/**
 *
 * @author Lukasz
 */
public class AmountValidator implements Validator {
    
    private static final String AMMOUNT_VALIDATOR = "[0-9]+([,.][0-9]{1,2})?";
    private boolean validate;

    @Override
    public boolean validate(String value) {
        validate = value.matches(AMMOUNT_VALIDATOR);
        return validate;
    }

    @Override
    public boolean isValid() {
        return validate;
    }
    
}
