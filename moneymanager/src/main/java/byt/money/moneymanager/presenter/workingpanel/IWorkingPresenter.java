package byt.money.moneymanager.presenter.workingpanel;

import byt.money.moneymanager.common.WorkingPanelState;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Lukasz
 */
public interface IWorkingPresenter {
    
    JPanel getPanel();
    
    WorkingPanelState getStateName();
    
    JButton getButton();
    
    void beforeShow();
    
}
