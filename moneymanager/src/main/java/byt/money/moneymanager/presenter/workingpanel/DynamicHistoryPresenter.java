package byt.money.moneymanager.presenter.workingpanel;

import byt.money.moneymanager.common.Converter;
import byt.money.moneymanager.dao.Dao;
import byt.money.moneymanager.entity.Deposit;
import byt.money.moneymanager.entity.Expense;
import byt.money.moneymanager.entity.Inflow;
import byt.money.moneymanager.gui.workingpanel.DynamicHistoryPanel;
import byt.money.moneymanager.model.Event;
import byt.money.moneymanager.model.EventModel;
import byt.money.moneymanager.util.EventModelComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lukasz
 */
public class DynamicHistoryPresenter {

    private static final int MAX = 5;
    private static final Comparator EVENT_MODEL_COMPARATOR = new EventModelComparator();

    private final Dao<Deposit> depositDao;
    private final Dao<Expense> expenseDao;
    private final Dao<Inflow> inflowDao;
    private final DynamicHistoryPanel panel;

    public DynamicHistoryPresenter(Dao<Deposit> depositDao,
            Dao<Expense> expenseDao, Dao<Inflow> inflowDao, DynamicHistoryPanel panel) {
        this.depositDao = depositDao;
        this.expenseDao = expenseDao;
        this.inflowDao = inflowDao;
        this.panel = panel;
    }

    public void beforeShow() {
        List<Deposit> deposits = depositDao.getNLastRaws(MAX);
        List<Expense> expenses = expenseDao.getNLastRaws(MAX);
        List<Inflow> inflows = inflowDao.getNLastRaws(MAX);
        List<EventModel> models = convert(deposits, expenses, inflows);
        Collections.sort(models, EVENT_MODEL_COMPARATOR);
        models = getNLastElements(models, MAX);
        panel.update(models);
    }

    private List<EventModel> getNLastElements(List<EventModel> models, int n) {
        List<EventModel> result;
        if (models.size() < n) {
            result = models.subList(0, models.size());
        } else {
            result = models.subList(0, n);
        }
        return result;
    }

    private List<EventModel> convert(List<Deposit> deposits, List<Expense> expenses, List<Inflow> inflows) {
        List<EventModel> result = new ArrayList<>();
        result.addAll(Converter.convert(deposits, Event.DEPOSIT));
        result.addAll(Converter.convert(expenses, Event.EXPENSES));
        result.addAll(Converter.convert(inflows, Event.INFLOW));
        return result;
    }

}
