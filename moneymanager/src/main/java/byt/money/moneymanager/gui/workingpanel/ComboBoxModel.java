package byt.money.moneymanager.gui.workingpanel;

import byt.money.moneymanager.model.EventModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lukasz
 */
public class ComboBoxModel extends AbstractTableModel {
    
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MMM-dd");
    private static final int MAX_COLUMN = 4;
    private static final String[] COLUMN_NAMES = new String[MAX_COLUMN];
    
    private Vector<EventModel> repo = new Vector();
    ResourceBundle I18N = ResourceBundle.getBundle("i18n/i18n");

    public final void localize(ResourceBundle I18N) {
        this.I18N = I18N;
        String date = I18N.getString("ComboBoxModel.Date");
        String type = I18N.getString("ComboBoxModel.Type");
        String amount = I18N.getString("ComboBoxModel.Amount");
        String name = I18N.getString("ComboBoxModel.Name");
        COLUMN_NAMES[0] = date;
        COLUMN_NAMES[1] = type;
        COLUMN_NAMES[2] = amount;
        COLUMN_NAMES[3] = name;
    }

    @Override
    public int getRowCount() {
        return repo.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EventModel model = repo.get(rowIndex);
        Object result = null;
        switch (columnIndex) {
            case 0:
                Date date = (Date) model.getValue(EventModel.Key.DATE);
                result = DATE_FORMATTER.format(date);
                break;
            case 1:
                result = I18N.getString(model.getValue(EventModel.Key.EVENT).toString());
                break;
            case 2:
                result = model.getValue(EventModel.Key.AMOUNT);
                break;
            case 3:
                result = model.getValue(EventModel.Key.NAME);
                break;
            default:
        }
        return result;
    }

    @Override
    public String getColumnName(int col) {
        return COLUMN_NAMES[col];
    }

    public void add(List<EventModel> models) {
        repo.removeAllElements();
        repo.addAll(models);
        fireTableDataChanged();
    }
    
    public EventModel get(int row){
        return repo.get(row);
    }

    public void removeAll() {

    }

}
