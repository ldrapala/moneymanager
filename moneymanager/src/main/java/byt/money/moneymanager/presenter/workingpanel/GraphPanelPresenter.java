package byt.money.moneymanager.presenter.workingpanel;

import byt.money.moneymanager.common.WorkingPanelState;
import byt.money.moneymanager.gui.workingpanel.GraphPanel;
import byt.money.moneymanager.service.LocalizerListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Lukasz
 */
public class GraphPanelPresenter implements IWorkingPresenter, LocalizerListener {
    
    private final JButton button;
    private final GraphPanel graphPanel;

    public GraphPanelPresenter(GraphPanel graphPanel) {
        this.graphPanel = graphPanel;
        button = new JButton(new ImageIcon(getClass().getClassLoader().getResource("./icon/chart.png")));
    }

    @Override
    public JPanel getPanel() {
        return graphPanel;
    }

    @Override
    public WorkingPanelState getStateName() {
        return WorkingPanelState.GRAPH;
    }

    @Override
    public JButton getButton() {
        return button;
    }

    @Override
    public void beforeShow() {
        graphPanel.removeAll();
    }

    @Override
    public void localize() {
        graphPanel.localize();
    }
    
}
