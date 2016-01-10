package byt.money.moneymanager.presenter.workingpanel;

import byt.money.moneymanager.common.WorkingPanelState;
import byt.money.moneymanager.gui.workingpanel.RegistrationPanel;
import byt.money.moneymanager.service.LocalizerListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Lukasz
 */
public class RegistrationPanelPresenter implements IWorkingPresenter, LocalizerListener {

    private final RegistrationPanel registrationPanel;

    public RegistrationPanelPresenter(RegistrationPanel registrationPanel) {
        this.registrationPanel = registrationPanel;
    }
    
    @Override
    public JPanel getPanel() {
        return registrationPanel;
    }

    @Override
    public WorkingPanelState getStateName() {
         return WorkingPanelState.REGISTRATION;
    }

    @Override
    public JButton getButton() {
        return null;
    }

    @Override
    public void beforeShow() {
        registrationPanel.reset();
    }

    @Override
    public void localize() {
        registrationPanel.localize();
    }
    
}
