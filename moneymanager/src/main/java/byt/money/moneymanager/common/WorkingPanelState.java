package byt.money.moneymanager.common;

/**
 *
 * @author Lukasz
 */
public enum WorkingPanelState {
    
    LOGIN_MMI(0), ADDING(1), HISTORY(3), GRAPH(2), REGISTRATION(-1), WELCOME(-2);
    
    private final int order;

    private WorkingPanelState(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
    
}
