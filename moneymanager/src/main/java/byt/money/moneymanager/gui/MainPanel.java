package byt.money.moneymanager.gui;

/**
 *
 * @author Lukasz
 */
public class MainPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();
    }

    public ButtonBarPanel getButtonBarPanel() {
        return buttonBarPanel1;
    }

    public WorkingPanel getWorkingPanel() {
        return workingPanel1;
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

        buttonBarPanel1 = new byt.money.moneymanager.gui.ButtonBarPanel();
        workingPanel1 = new byt.money.moneymanager.gui.WorkingPanel();

        setLayout(new java.awt.GridBagLayout());

        buttonBarPanel1.setMaximumSize(new java.awt.Dimension(70, 70));
        buttonBarPanel1.setMinimumSize(new java.awt.Dimension(70, 70));
        buttonBarPanel1.setPreferredSize(new java.awt.Dimension(70, 70));
        buttonBarPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 1.0;
        add(buttonBarPanel1, gridBagConstraints);

        workingPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(workingPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private byt.money.moneymanager.gui.ButtonBarPanel buttonBarPanel1;
    private byt.money.moneymanager.gui.WorkingPanel workingPanel1;
    // End of variables declaration//GEN-END:variables
}