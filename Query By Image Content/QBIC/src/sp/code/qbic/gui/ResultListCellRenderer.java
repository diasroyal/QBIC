
package sp.code.qbic.gui;

import sp.code.qbic.search.ImageResult;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ResultListCellRenderer extends javax.swing.JPanel implements ListCellRenderer {

  
    public ResultListCellRenderer() {
        initComponents();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageLabel = new javax.swing.JLabel();
        rankSlider = new javax.swing.JSlider();
        subPanel = new javax.swing.JPanel();
        distanceLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new java.awt.BorderLayout());
        add(imageLabel, java.awt.BorderLayout.CENTER);

        rankSlider.setMaximum(10);
        rankSlider.setValue(0);
        StrokedShapeSliderUI sui = new StrokedShapeSliderUI();
        sui.setPrimaryColor(Color.YELLOW);
        rankSlider.setUI(sui);
        add(rankSlider, java.awt.BorderLayout.NORTH);

        subPanel.setLayout(new java.awt.BorderLayout());
		distanceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subPanel.add(distanceLabel, java.awt.BorderLayout.NORTH);

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subPanel.add(nameLabel, java.awt.BorderLayout.SOUTH);

        add(subPanel, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    public Component getListCellRendererComponent(
            JList list,
            Object value, 
            int index, 
            boolean isSelected, 
            boolean cellHasFocus) 
    {
        ImageResult result = (ImageResult) value;
        imageLabel.setIcon(new ImageIcon(result.getBufferedImage()));
        nameLabel.setText(getName(result.getPath()));
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        String num = nf.format(result.getSimilarity());
        distanceLabel.setText("Distance : " + num);
        if (rankingEnabled) {
            int val = (int)(Double.parseDouble(num) * 10);
            rankSlider.setValue(val);
            rankSlider.setToolTipText(val + "%");
        }
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            subPanel.setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
            subPanel.setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
            subPanel.setBackground(list.getBackground());
            subPanel.setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        return this;
    }

    public String getName(String image) {
        return image.substring(image.lastIndexOf(File.separatorChar) + 1);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel distanceLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JSlider rankSlider;
    private javax.swing.JPanel subPanel;
    // End of variables declaration//GEN-END:variables
    private boolean rankingEnabled = true;

    
    public boolean isRankingEnabled() {
        return rankingEnabled;
    }

    
    public void setRankingEnabled(boolean rankingEnabled) {
        this.rankingEnabled = rankingEnabled;
        this.rankSlider.setVisible(this.rankingEnabled);
    }
}
