package byt.money.moneymanager.service;

import byt.money.moneymanager.common.WorkingPanelState;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import byt.money.moneymanager.presenter.workingpanel.IWorkingPresenter;
import java.awt.GridBagConstraints;

/**
 *
 * @author Lukasz
 */
public class WorkingPanelService {
    
    private final Map<WorkingPanelState, IWorkingPresenter> panels;
    private final JPanel workingPanel;

    public WorkingPanelService(JPanel workingPanel) {
        panels = new HashMap<>();
        this.workingPanel = workingPanel;
    }
    
    public void registerPanel(IWorkingPresenter panel){
        panels.put(panel.getStateName(), panel);
    }
    
    public void unregisterPanel(IWorkingPresenter panel){
        panels.remove(panel.getStateName(), panel);
    }
    
    public void showWorkingPanel(WorkingPanelState panelState){
        IWorkingPresenter panel = panels.get(panelState);
        workingPanel.removeAll();
        panel.beforeShow();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        workingPanel.add(panel.getPanel(), gbc);
        workingPanel.revalidate();
        workingPanel.repaint();
    }
    
}
