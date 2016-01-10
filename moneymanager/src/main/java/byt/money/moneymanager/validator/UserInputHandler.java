package byt.money.moneymanager.validator;

import java.awt.Color;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Lukasz
 */
public class UserInputHandler implements DocumentListener {

    private final Validator validator;
    private final JTextComponent component;
    private final ComponentValidator dependentComponentValidator;

    /**
     *
     * @param validator
     * @param component
     * @param dependentComponentValidator
     */
    public UserInputHandler(Validator validator, JTextComponent component, 
            ComponentValidator dependentComponentValidator) {
        this.validator = validator;
        this.component = component;
        this.dependentComponentValidator = dependentComponentValidator;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        process();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        process();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        process();
    }
    
    private void process() {
        String input = component.getText();
        boolean inputValid = validator.validate(input);
        dependentComponentValidator.validate();
        if (!inputValid) {
            component.setBackground(Color.PINK);
        } else {
            component.setBackground(Color.WHITE);
        }
    }

}
