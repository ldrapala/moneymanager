package byt.money.moneymanager.gui.workingpanel;

import byt.money.moneymanager.model.EventModel;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Lukasz
 */
public class HistoryPanel extends javax.swing.JPanel {

    private ComboBoxModel model;

    /**
     * Creates new form HistoryPanel
     */
    public HistoryPanel() {
        model = new ComboBoxModel();
        initComponents();
        localize();
        createCbModel();
        createSelectionListener();
    }

    public final void update(List<EventModel> models) {
        model.add(models);
    }

    public final void localize() {
        ResourceBundle I18N = ResourceBundle.getBundle("i18n/i18n");
        setBorder(javax.swing.BorderFactory.createTitledBorder(I18N.getString("HistoryPanelTitle")));
        addingPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(I18N.getString("AddingPanelTitle")));
        filterPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(I18N.getString("FilterPanelTitle")));
        model.localize(I18N);
        addingPanel1.localize();
        filterPanel1.localize();
    }

    private void createSelectionListener() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow == -1) {
                    addingPanel1.clear();
                } else {
                    EventModel eventModel = model.get(selectedRow);
                    addingPanel1.update(eventModel);
                }
            }
        });
    }

    private void createCbModel() {
        jTable1.setModel(model);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addingPanel1 = new byt.money.moneymanager.gui.workingpanel.AddingPanel();
        filterPanel1 = new byt.money.moneymanager.gui.workingpanel.FilterPanel();

        setLayout(new java.awt.GridBagLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        add(addingPanel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        add(filterPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private byt.money.moneymanager.gui.workingpanel.AddingPanel addingPanel1;
    private byt.money.moneymanager.gui.workingpanel.FilterPanel filterPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}