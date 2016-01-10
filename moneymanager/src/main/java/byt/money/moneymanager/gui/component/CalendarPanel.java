package byt.money.moneymanager.gui.component;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Lukasz
 */
public class CalendarPanel extends JPanel {

    private final UtilDateModel model;
    private final JDatePanelImpl datePanel;
    private final JDatePickerImpl datePicker;

    public CalendarPanel() {
        model = new UtilDateModel();
        datePanel = new JDatePanelImpl(model);
        datePicker = new JDatePickerImpl(datePanel);
        add(datePicker);
    }

    public void setDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        datePicker.getModel().setDate(year, month, day);
    }
    
    public Date getDate(){
        return (Date) datePicker.getModel().getValue();
    }

}
