
package sp.code.qbic.gui;

import javax.swing.JPopupMenu;


public class JThumbnailPanel extends javax.swing.JPanel {

    public static final int THUMBSIZE_SMALL = 32;
    public static final int THUMBSIZE_MEDIUM = 64;
    public static final int THUMBSIZE_LARGE = 160;

    public JThumbnailPanel() {

        initComponents();
        this.setFixedCellHeight(THUMBSIZE_LARGE + 50);
        this.setFixedCellWidth(THUMBSIZE_LARGE + 20);
        this.imageList.setModel(new ImageListModel());
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        imageList = new javax.swing.JList();
        javax.swing.JPanel pagePanel = new javax.swing.JPanel();
        pageLabel = new javax.swing.JLabel();
        pageUpBtn = new javax.swing.JButton();
        pageDownBtn = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        imageList.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        imageList.setCellRenderer(cellRenderer);
        imageList.setDoubleBuffered(true);
        imageList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        imageList.setVisibleRowCount(0);
        imageList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(imageList);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pagePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        pageLabel.setText("Number of Results : 0");
        pagePanel.add(pageLabel);

        pageUpBtn.setText("Previous");
        pageUpBtn.setEnabled(false);
        pageUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pageUpBtnActionPerformed(evt);
            }
        });
        pagePanel.add(pageUpBtn);

        pageDownBtn.setText("Next");
        pageDownBtn.setEnabled(false);
        pageDownBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pageDownBtnActionPerformed(evt);
            }
        });
        pagePanel.add(pageDownBtn);

        add(pagePanel, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void imageListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageListMouseClicked


    }//GEN-LAST:event_imageListMouseClicked

    private void pageDownBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pageDownBtnActionPerformed
        
        getListModel().pageDown();
        changePageButtonState();
    }//GEN-LAST:event_pageDownBtnActionPerformed

    private void pageUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pageUpBtnActionPerformed

        getListModel().pageUp();
        changePageButtonState();
    }//GEN-LAST:event_pageUpBtnActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList imageList;
    private javax.swing.JButton pageDownBtn;
    private javax.swing.JLabel pageLabel;
    private javax.swing.JButton pageUpBtn;
    // End of variables declaration//GEN-END:variables
    private ResultListCellRenderer cellRenderer = new ResultListCellRenderer();

   
    public ImageListModel getListModel() {
        return (ImageListModel) this.imageList.getModel();
    }

  
    public void setListModel(ImageListModel model) {
        this.imageList.setModel(model);
        changePageButtonState();
    }

    public int getFixedCellHeight() {
        return this.getImageList().getFixedCellHeight();
    }

   
    public void setFixedCellHeight(int fixedCellHeight) {
        this.getImageList().setFixedCellHeight(fixedCellHeight);

    }

    public int getFixedCellWidth() {
        return this.getImageList().getFixedCellWidth();
    }

    
    public void setFixedCellWidth(int fixedCellWidth) {
        this.getImageList().setFixedCellWidth(fixedCellWidth);
    }

    public javax.swing.JList getImageList() {
        return imageList;
    }

    public void setImageList(javax.swing.JList imageList) {
        this.imageList = imageList;
    }

    public void setRankingEnabled(boolean b) {
        cellRenderer.setRankingEnabled(b);
        this.imageList.repaint();
    }
    private JPopupMenu popupMenu;

    public void setPopupMenu(JPopupMenu menu) {
        this.popupMenu = menu;
    }

    public void changePageButtonState() {
        pageUpBtn.setEnabled(getListModel().canPageUp());
        pageDownBtn.setEnabled(getListModel().canPageDown());
        pageLabel.setText("Number of Results  : " + getListModel().getRealRowCount()
                + ". Page " + (getListModel().getPageOffset() + 1)
                + " of " + getListModel().getPageCount());
    }
}
