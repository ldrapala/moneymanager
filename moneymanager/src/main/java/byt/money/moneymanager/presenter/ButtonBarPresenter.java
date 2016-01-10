package byt.money.moneymanager.presenter;

import byt.money.moneymanager.gui.ButtonBarPanel;
import byt.money.moneymanager.service.LocalizerListener;

/**
 *
 * @author Lukasz
 */
public class ButtonBarPresenter implements LocalizerListener {
    
    private final ButtonBarPanel buttonBarPanel;

    public ButtonBarPresenter(ButtonBarPanel buttonBarPanel) {
        this.buttonBarPanel = buttonBarPanel;
    }

    @Override
    public void localize() {
        buttonBarPanel.localize();
    }
    
}
