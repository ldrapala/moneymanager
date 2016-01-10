package byt.money.moneymanager.presenter.workingpanel;

import byt.money.moneymanager.common.Converter;
import byt.money.moneymanager.common.WorkingPanelState;
import byt.money.moneymanager.dao.Dao;
import byt.money.moneymanager.entity.IEntity;
import byt.money.moneymanager.gui.workingpanel.AddingManagerPanel;
import byt.money.moneymanager.model.Event;
import byt.money.moneymanager.model.EventModel;
import byt.money.moneymanager.service.ActiveUserService;
import byt.money.moneymanager.service.LocalizerListener;
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Lukasz
 */
public class AddingPanelPresenter implements IWorkingPresenter, LocalizerListener {
    
    private final AddingManagerPanel addingManagerPanel;
    private final DynamicHistoryPresenter dynamicHistoryPresenter;
    private final ActiveUserService activeUserService;
    private final JButton button;
    private final Dao depositDao;
    private final Dao inflowDao;
    private final Dao expenseDao;

    public AddingPanelPresenter(AddingManagerPanel addingManagerPanel, 
            DynamicHistoryPresenter dynamicHistoryPresenter, 
            Dao depositDao, Dao inflowDao, Dao expenseDao,
            ActiveUserService activeUserService) {
        this.addingManagerPanel = addingManagerPanel;
        this.dynamicHistoryPresenter = dynamicHistoryPresenter;
        this.depositDao = depositDao;
        this.inflowDao = inflowDao;
        this.expenseDao = expenseDao;
        this.activeUserService = activeUserService;
        button = new JButton(new ImageIcon(getClass().getClassLoader().getResource("./icon/add.png")));
    }
    
    public void save(Event event, String amount, String name, String details, Date date){
        EventModel eventModel = new EventModel();
        eventModel.setData(EventModel.Key.EVENT, event);
        eventModel.setData(EventModel.Key.AMOUNT, new BigDecimal(amount));
        eventModel.setData(EventModel.Key.NAME, name);
        eventModel.setData(EventModel.Key.DETAILS, details);
        eventModel.setData(EventModel.Key.DATE, date);
        eventModel.setData(EventModel.Key.PERSON, activeUserService.getPerson());
        IEntity entity = Converter.convert(eventModel, event);
        switch(event){
            case DEPOSIT:
                depositDao.create(entity);
                break;
            case EXPENSES:
                expenseDao.create(entity);
                break;
            case INFLOW:
                inflowDao.create(entity);
                break;
            default:
        }
        dynamicHistoryPresenter.beforeShow();
    }

    @Override
    public JPanel getPanel() {
        return addingManagerPanel;
    }

    @Override
    public WorkingPanelState getStateName() {
        return WorkingPanelState.ADDING;
    }

    @Override
    public JButton getButton() {
        return button;
    }

    @Override
    public void beforeShow() {
        addingManagerPanel.getAddingPanel().reset();
        dynamicHistoryPresenter.beforeShow();
    }

    @Override
    public void localize() {
        addingManagerPanel.localize();
        addingManagerPanel.getAddingPanel().localize();
    }
    
}
