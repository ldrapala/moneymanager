package byt.money.moneymanager.service;

import byt.money.moneymanager.common.WorkingPanelState;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import byt.money.moneymanager.presenter.workingpanel.IWorkingPresenter;

/**
 *
 * @author Lukasz
 */
public class ButtonBarService implements ActiveUserListener {

    private static final Comparator WORKING_PANEL_COMPARATOR = new IWorkingPanelComparator();
    private static final Dimension DIMENSION = new Dimension(64,64);

    private final Map<WorkingPanelState, IWorkingPresenter> panelsWithButtons;
    private final JPanel buttonBarPanel;
    private final WorkingPanelService workingPanelController;
    private final ActiveUserService activeUserProvider;

    public ButtonBarService(JPanel buttonBarPanel,
            WorkingPanelService workingPanelController, ActiveUserService activeUserProvider) {
        panelsWithButtons = new HashMap<>();
        this.buttonBarPanel = buttonBarPanel;
        this.workingPanelController = workingPanelController;
        this.activeUserProvider = activeUserProvider;
        activeUserProvider.registerListener(this);
    }

    public void registerPanel(IWorkingPresenter panel) {
        panelsWithButtons.put(panel.getStateName(), panel);
        panel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                workingPanelController.showWorkingPanel(panel.getStateName());
            }
        });
        panel.getButton().setPreferredSize(DIMENSION);
        panel.getButton().setMaximumSize(DIMENSION);
        panel.getButton().setMinimumSize(DIMENSION);
        panel.getButton().setEnabled(activeUserProvider.isUserLogin());
        update();
    }

    public void unregisterPanel(IWorkingPresenter panel) {
        panelsWithButtons.remove(panel.getStateName());
        update();
    }
    
      @Override
    public void notify(boolean userLogin) {
          for (IWorkingPresenter panel : panelsWithButtons.values()) {
              panel.getButton().setEnabled(userLogin);
          }
    }

    private void update() {
        buttonBarPanel.removeAll();
        Collection<IWorkingPresenter> values = panelsWithButtons.values();
        List<IWorkingPresenter> list = new LinkedList<>(values);
        Collections.sort(list, WORKING_PANEL_COMPARATOR);
        for (int i = 0; i < list.size(); i++) {
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = i;
            gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
            if (list.indexOf(list.get(i)) == list.size() - 1) {
                gridBagConstraints.weighty = 1;
            }
            buttonBarPanel.add(list.get(i).getButton(), gridBagConstraints);
        }
    }

    private static class IWorkingPanelComparator implements Comparator<IWorkingPresenter> {

        @Override
        public int compare(IWorkingPresenter p1, IWorkingPresenter p2) {
            return Integer.compare(p1.getStateName().getOrder(), p2.getStateName().getOrder());
        }

    }

}
