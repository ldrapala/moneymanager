package byt.money.moneymanager.presenter.workingpanel;

import byt.money.moneymanager.common.Converter;
import byt.money.moneymanager.common.WorkingPanelState;
import byt.money.moneymanager.dao.Dao;
import byt.money.moneymanager.entity.Deposit;
import byt.money.moneymanager.entity.Expense;
import byt.money.moneymanager.entity.Inflow;
import byt.money.moneymanager.gui.workingpanel.HistoryPanel;
import byt.money.moneymanager.model.Event;
import byt.money.moneymanager.model.EventModel;
import byt.money.moneymanager.service.LocalizerListener;
import byt.money.moneymanager.util.EventModelComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Lukasz
 */
public class HistoryPanelPresenter implements IWorkingPresenter, LocalizerListener {
    
    private static final Comparator EVENT_MODEL_COMPARATOR = new EventModelComparator();

    private final JButton button;
    private final HistoryPanel historyPanel;
    private final Dao<Deposit> depositDao;
    private final Dao<Expense> expenseDao;
    private final Dao<Inflow> inflowDao;

    public HistoryPanelPresenter(Dao<Deposit> depositDao,
            Dao<Expense> expenseDao, Dao<Inflow> inflowDao, HistoryPanel historyPanel) {
        this.historyPanel = historyPanel;
        this.depositDao = depositDao;
        this.expenseDao = expenseDao;
        this.inflowDao = inflowDao;
        button = new JButton(new ImageIcon(getClass().getClassLoader().getResource("./icon/history.png")));
    }

    @Override
    public JPanel getPanel() {
        return historyPanel;
    }

    @Override
    public WorkingPanelState getStateName() {
        return WorkingPanelState.HISTORY;
    }

    @Override
    public JButton getButton() {
        return button;
    }

    @Override
    public void beforeShow() {
        List<Deposit> deposits = depositDao.getAll();
        List<Expense> expenses = expenseDao.getAll();
        List<Inflow> inflows = inflowDao.getAll();
        List<EventModel> models = convert(deposits, expenses, inflows);
        Collections.sort(models, EVENT_MODEL_COMPARATOR);
        historyPanel.update(models);
    }
    
    private List<EventModel> convert(List<Deposit> deposits, List<Expense> expenses, List<Inflow> inflows) {
        List<EventModel> result = new ArrayList<>();
        result.addAll(Converter.convert(deposits, Event.DEPOSIT));
        result.addAll(Converter.convert(expenses, Event.EXPENSES));
        result.addAll(Converter.convert(inflows, Event.INFLOW));
        return result;
    }

    @Override
    public void localize() {
        historyPanel.localize();
    }

}
