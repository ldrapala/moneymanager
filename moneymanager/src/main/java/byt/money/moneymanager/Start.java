package byt.money.moneymanager;

import byt.money.moneymanager.common.WorkingPanelState;
import byt.money.moneymanager.dao.Dao;
import byt.money.moneymanager.dao.DepositDao;
import byt.money.moneymanager.dao.ExpenseDao;
import byt.money.moneymanager.dao.InflowDao;
import byt.money.moneymanager.dao.PersonDao;
import byt.money.moneymanager.dao.SessionProvider;
import byt.money.moneymanager.service.ButtonBarService;
import byt.money.moneymanager.service.WorkingPanelService;
import byt.money.moneymanager.gui.ButtonBarPanel;
import byt.money.moneymanager.gui.MainPanel;
import byt.money.moneymanager.gui.WorkingPanel;
import byt.money.moneymanager.gui.workingpanel.AddingManagerPanel;
import byt.money.moneymanager.gui.workingpanel.AddingPanel;
import byt.money.moneymanager.gui.workingpanel.DynamicHistoryPanel;
import byt.money.moneymanager.gui.workingpanel.GraphPanel;
import byt.money.moneymanager.gui.workingpanel.HistoryPanel;
import byt.money.moneymanager.gui.workingpanel.LoginPanel;
import byt.money.moneymanager.gui.workingpanel.RegistrationPanel;
import byt.money.moneymanager.gui.workingpanel.WelcomePanel;
import byt.money.moneymanager.presenter.ButtonBarPresenter;
import byt.money.moneymanager.presenter.workingpanel.AddingPanelPresenter;
import byt.money.moneymanager.presenter.workingpanel.DynamicHistoryPresenter;
import byt.money.moneymanager.presenter.workingpanel.GraphPanelPresenter;
import byt.money.moneymanager.presenter.workingpanel.HistoryPanelPresenter;
import byt.money.moneymanager.service.ActiveUserService;
import byt.money.moneymanager.service.LoginService;
import javax.swing.JFrame;
import byt.money.moneymanager.presenter.workingpanel.LoginPanelPresenter;
import byt.money.moneymanager.presenter.workingpanel.RegistrationPanelPresenter;
import byt.money.moneymanager.presenter.workingpanel.WelcomePanelPresenter;
import byt.money.moneymanager.service.LocalizerService;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author Lukasz
 */
public class Start {

    public static void main(String[] args) throws Exception {
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        ActiveUserService activeUserService = new ActiveUserService();
        SessionProvider sessionProvider = new SessionProvider();
        Dao personDao = new PersonDao(sessionProvider);
        Dao expenseDao = new ExpenseDao(sessionProvider, activeUserService);
        Dao inflowDao = new InflowDao(sessionProvider, activeUserService);
        Dao depositDao = new DepositDao(sessionProvider, activeUserService);

        MainPanel mainPanel = new MainPanel();
        ButtonBarPanel buttonBarPanel = mainPanel.getButtonBarPanel();
        WorkingPanel workingPanel = mainPanel.getWorkingPanel();

        LocalizerService localizerService = new LocalizerService();
        WorkingPanelService workingPanelService = new WorkingPanelService(workingPanel);
        ButtonBarService barPanelService
                = new ButtonBarService(buttonBarPanel, workingPanelService, activeUserService);
        LoginService loginService = new LoginService(personDao, activeUserService);

        AddingManagerPanel addingManagerPanel = new AddingManagerPanel();
        LoginPanel loginWorkingPanel = new LoginPanel();
        GraphPanel graphWorkingPanel = new GraphPanel();
        HistoryPanel historyWorkingPanel = new HistoryPanel();
        WelcomePanel welcomeWorkingPanel = new WelcomePanel();
        RegistrationPanel registrationWorkingPanel = new RegistrationPanel();
        DynamicHistoryPanel dynamicHistoryPanel = addingManagerPanel.getDynamicHistoryPanel();
        AddingPanel addingPanel = addingManagerPanel.getAddingPanel();

        DynamicHistoryPresenter dynamicHistoryWorkingPresenter = new DynamicHistoryPresenter(depositDao, expenseDao, inflowDao, dynamicHistoryPanel);
        AddingPanelPresenter addingWorkingPresenter = new AddingPanelPresenter(addingManagerPanel, dynamicHistoryWorkingPresenter, depositDao, inflowDao, expenseDao, activeUserService);
        LoginPanelPresenter loginWorkingPresenter = new LoginPanelPresenter(loginWorkingPanel);
        GraphPanelPresenter graphWorkingPresenter = new GraphPanelPresenter(graphWorkingPanel);
        HistoryPanelPresenter historyWorkingPresenter = new HistoryPanelPresenter(depositDao, expenseDao, inflowDao, historyWorkingPanel);
        WelcomePanelPresenter welcomeWorkingPresenter = new WelcomePanelPresenter(welcomeWorkingPanel, activeUserService);
        RegistrationPanelPresenter registrationWorkingPresenter = new RegistrationPanelPresenter(registrationWorkingPanel);
        ButtonBarPresenter buttonBarPresenter = new ButtonBarPresenter(buttonBarPanel);
        
        localizerService.registerListener(buttonBarPresenter);
        localizerService.registerListener(addingWorkingPresenter);
        localizerService.registerListener(loginWorkingPresenter);
        localizerService.registerListener(graphWorkingPresenter);
        localizerService.registerListener(historyWorkingPresenter);
        localizerService.registerListener(welcomeWorkingPresenter);
        localizerService.registerListener(registrationWorkingPresenter);
        workingPanelService.registerPanel(addingWorkingPresenter);
        workingPanelService.registerPanel(loginWorkingPresenter);
        workingPanelService.registerPanel(graphWorkingPresenter);
        workingPanelService.registerPanel(historyWorkingPresenter);
        workingPanelService.registerPanel(welcomeWorkingPresenter);
        workingPanelService.registerPanel(registrationWorkingPresenter);
        barPanelService.registerPanel(addingWorkingPresenter);
        barPanelService.registerPanel(graphWorkingPresenter);
        barPanelService.registerPanel(historyWorkingPresenter);
        addingPanel.setAddingWorkingPresenter(addingWorkingPresenter);
        loginWorkingPanel.setWorkingPanelService(workingPanelService);
        loginWorkingPanel.setLoginService(loginService);
        loginWorkingPanel.setLocalizerService(localizerService);
        registrationWorkingPanel.setWorkingPanelService(workingPanelService);
        registrationWorkingPanel.setLoginService(loginService);
        workingPanelService.showWorkingPanel(WorkingPanelState.LOGIN_MMI);
        JFrame frame = new JFrame();
        frame.add(mainPanel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
