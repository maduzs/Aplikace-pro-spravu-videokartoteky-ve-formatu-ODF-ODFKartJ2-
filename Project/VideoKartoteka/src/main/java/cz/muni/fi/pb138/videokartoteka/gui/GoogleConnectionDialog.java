package cz.muni.fi.pb138.videokartoteka.gui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import javax.swing.JOptionPane;

/**
 * Dialog establishing connection to Google Drive service
 *
 * @author matus
 */
public class GoogleConnectionDialog extends javax.swing.JDialog implements ClipboardOwner {

    public static final int RESULT_CLOSED = 0;
    public static final int RESULT_OK = 1;
    public static final int RESULT_CANCEL = 2;
    
    private int result = RESULT_CLOSED;
    /**
     * Creates new form GoogleConnectionDialog
     */
    public GoogleConnectionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        codeTF.requestFocusInWindow();
    }

    /**
     * Sets authentication URL to be displayed in the dialog
     * 
     * @param url authentication URL
     */
    public void setConnectionUrl(String url) {
        this.connectionUrlTF.setText(url);
    }

    /**
     * Returns code inserted to input field.
     * 
     * @return code inserted to input field.
     */
    public String getCode() {
        return codeTF.getText();
    }
    
    /**
     * Shows dialog.
     * 
     * @return dialog result.
     */
    public int showDialog() {
        this.setVisible(true);
        
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

        jLabel1 = new javax.swing.JLabel();
        copyButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        codeTF = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        connectionUrlTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Verify address:");

        copyButton.setText("Copy");
        copyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Insert generated code:");

        codeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeTFActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        connectionUrlTF.setEditable(false);
        connectionUrlTF.setBorder(null);
        connectionUrlTF.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(copyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codeTF)
                    .addComponent(connectionUrlTF)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(0, 133, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectionUrlTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copyButton)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        result = RESULT_CANCEL;
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (codeTF.getText().trim().isEmpty()) {
            int dialogResult = JOptionPane.showConfirmDialog(this, "Nevyplnil jste autorizační kód. Opravdu zrušit?", "Chyba", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                result = RESULT_CANCEL;
                this.setVisible(false);
            }
        } else {
            result = RESULT_OK;
            this.setVisible(false);
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonActionPerformed
        StringSelection stringSelection = new StringSelection( connectionUrlTF.getText() );
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, this);
    }//GEN-LAST:event_copyButtonActionPerformed

    private void codeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeTFActionPerformed
        this.okButtonActionPerformed(evt);
    }//GEN-LAST:event_codeTFActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField codeTF;
    private javax.swing.JTextField connectionUrlTF;
    private javax.swing.JButton copyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    public void lostOwnership(Clipboard clipboard, Transferable contents) {
    }
}
