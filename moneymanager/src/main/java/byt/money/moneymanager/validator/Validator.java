package byt.money.moneymanager.validator;

/**
 *
 * @author Lukasz
 */
public interface Validator {
    
    boolean validate(String value);
    
    boolean isValid();
    
}
