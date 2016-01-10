package byt.money.moneymanager.presenter.workingpanel;

import byt.money.moneymanager.common.WorkingPanelState;
import byt.money.moneymanager.gui.workingpanel.LoginPanel;
import byt.money.moneymanager.service.LocalizerListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Lukasz
 */
public class LoginPanelPresenter implements IWorkingPresenter, LocalizerListener {

    private final LoginPanel loginPanel;

    public LoginPanelPresenter(LoginPanel loginPanel) {
        this.loginPanel = loginPanel;
    }

    @Override
    public JPanel getPanel() {
        return loginPanel;
    }

    @Override
    public WorkingPanelState getStateName() {
         return WorkingPanelState.LOGIN_MMI;
    }

    @Override
    public JButton getButton() {
        return null;
    }

    @Override
    public void beforeShow() {
        loginPanel.reset();
    }

    @Override
    public void localize() {
        loginPanel.localize();
    }

}
