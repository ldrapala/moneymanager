package byt.money.moneymanager.gui.workingpanel;

import byt.money.moneymanager.model.Event;
import byt.money.moneymanager.model.EventModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 *
 * @author Lukasz
 */
public class OneDynamicPanel extends javax.swing.JPanel {
    
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MMM-dd");
    
    /**
     * Creates new form OneDynamicPanel
     */
    public OneDynamicPanel() {
        initComponents();
    }

    public void update(EventModel eventModel) {
        Event event = (Event)eventModel.getValue(EventModel.Key.EVENT);
        String color = selectColor(event);
        String title = generateTitle(color, event);
        setBorder(javax.swing.BorderFactory.createTitledBorder(title));
        Date date = (Date) eventModel.getValue(EventModel.Key.DATE);
        dateLabel.setText(DATE_FORMATTER.format(date));
        amountLabel.setText(eventModel.getValue(EventModel.Key.AMOUNT).toString());
        detailsLabel.setText(eventModel.getValue(EventModel.Key.NAME).toString());
    }
    
    private String generateTitle(String color, Event event){
        ResourceBundle I18N = ResourceBundle.getBundle("i18n/i18n");
        StringBuilder result = new StringBuilder();
        result.append("<html><font color='");
        result.append(color);
        result.append("'>");
        result.append(I18N.getString(event.name()));
        result.append("</font></html>");
        return result.toString();
    }

    private String selectColor(Event event) {
        String result;
        switch (event) {
            case DEPOSIT:
                result = "blue";
                break;
            case EXPENSES:
                result = "red";
                break;
            case INFLOW:
                result = "green";
                break;
            default:
                result = "black";
        }
        return result;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        dateLabel = new javax.swing.JLabel();
        amountLabel = new javax.swing.JLabel();
        detailsLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setLayout(new java.awt.GridBagLayout());

        dateLabel.setMaximumSize(new java.awt.Dimension(120, 24));
        dateLabel.setMinimumSize(new java.awt.Dimension(120, 24));
        dateLabel.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(dateLabel, gridBagConstraints);

        amountLabel.setMaximumSize(new java.awt.Dimension(120, 24));
        amountLabel.setMinimumSize(new java.awt.Dimension(120, 24));
        amountLabel.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(amountLabel, gridBagConstraints);

        detailsLabel.setMaximumSize(new java.awt.Dimension(120, 24));
        detailsLabel.setMinimumSize(new java.awt.Dimension(120, 24));
        detailsLabel.setPreferredSize(new java.awt.Dimension(120, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(detailsLabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel detailsLabel;
    // End of variables declaration//GEN-END:variables
}
