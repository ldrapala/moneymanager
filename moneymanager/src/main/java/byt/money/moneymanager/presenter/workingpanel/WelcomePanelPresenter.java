package byt.money.moneymanager.presenter.workingpanel;

import byt.money.moneymanager.common.WorkingPanelState;
import byt.money.moneymanager.gui.workingpanel.WelcomePanel;
import byt.money.moneymanager.service.ActiveUserService;
import byt.money.moneymanager.service.LocalizerListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Lukasz
 */
public class WelcomePanelPresenter implements IWorkingPresenter, LocalizerListener {
    
    private final WelcomePanel welcomePanel;
    private final ActiveUserService activeUserService;

    public WelcomePanelPresenter(WelcomePanel welcomePanel, ActiveUserService activeUserService) {
        this.welcomePanel = welcomePanel;
        this.activeUserService = activeUserService;
    }
    
    @Override
    public JPanel getPanel() {
        return welcomePanel;
    }

    @Override
    public WorkingPanelState getStateName() {
        return WorkingPanelState.WELCOME;
    }

    @Override
    public JButton getButton() {
        return null;
    }

    @Override
    public void beforeShow() {
        welcomePanel.update(activeUserService.getPerson().getLogin());
    }

    @Override
    public void localize() {
        welcomePanel.localize();
    }
    
}
