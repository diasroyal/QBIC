package sp.code.qbic.gui;

import com.birosoft.liquid.LiquidLookAndFeel;
import sp.code.qbic.Constants;
import sp.code.qbic.clustering.Cluster;
import sp.code.qbic.clustering.KMeans;
import sp.code.qbic.indexing.ClusterReader;
import sp.code.qbic.indexing.ClusterWriter;
import sp.code.qbic.search.ImageResult;
import sp.code.qbic.search.ImageSearcher;
import sp.code.qbic.indexing.Index;
import sp.code.qbic.indexing.IndexReader;
import sp.code.qbic.indexing.IndexWriter;
import sp.code.qbic.util.GraphicsUtilities;
import sp.code.qbic.util.ImageFileFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingWorker;


public class MainFrame extends javax.swing.JFrame {

    private JFileChooser folderChooser = new JFileChooser();
    private JFileChooser imageChooser = new JFileChooser();
    private SwingWorker<List<ImageResult>, ImageResult> searchWorker;
    private SwingWorker<String, Void> indexWorker;
    private SwingWorker<String, Void> browseWorker;
    private long time;
    private int numIndex;

  
    public MainFrame() {
        initComponents();
        try {
            inititalizeIndexBrowser();
        } catch (IOException ex) {
            browsePanel.setVisible(false);

        }
    }

    private void inititalizeIndexBrowser() throws IOException {
        IndexReader indexReader = new IndexReader();
        indexReader.open();
        int clustSize = indexReader.numCluster();
        indexReader.close();
        if (clustSize < 2) {
            browsePanel.setVisible(false);
            return;
        }


        
        Integer[] nums = new Integer[clustSize];
        for (int i = 0; i < clustSize; i++) {
            nums[i] = i + 1;
        }

        thumbIndexPanel.getListModel().clear();
        clustIdComboBox.setModel(new DefaultComboBoxModel(nums));
        browsePanel.setVisible(true);

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        cbirTab = new javax.swing.JTabbedPane();
        searchTab = new javax.swing.JPanel();
        queryPanel = new javax.swing.JPanel();
        imagePathText = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jcbirLogoSmallLabel = new javax.swing.JLabel();
        imagePanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        betaLabel1 = new javax.swing.JLabel();
        betaText = new javax.swing.JTextField();
        alphaLabel1 = new javax.swing.JLabel();
        alphaText = new javax.swing.JTextField();
        useClusterCheck = new javax.swing.JCheckBox();
        resultPanel = new javax.swing.JPanel();
        searchProgress = new javax.swing.JProgressBar();
        statusLabel = new javax.swing.JLabel();
        thumbnailPanel = new sp.code.qbic.gui.JThumbnailPanel();
        indexingTab = new javax.swing.JPanel();
        folderPanel = new javax.swing.JPanel();
        folderText = new javax.swing.JTextField();
        browseFolderButton = new javax.swing.JButton();
        startIndexButton = new javax.swing.JButton();
        numClusterLabel = new javax.swing.JLabel();
        numClusterCombo = new javax.swing.JComboBox();
        maxIterLabel = new javax.swing.JLabel();
        maxIterText = new javax.swing.JTextField();
        progressPanel = new javax.swing.JPanel();
        indexProgress = new javax.swing.JProgressBar();
        indexingStatusLabel = new javax.swing.JLabel();
        browsePanel = new javax.swing.JPanel();
        browseIndexProgress = new javax.swing.JProgressBar();
        browseIndexLabel = new javax.swing.JLabel();
        thumbIndexPanel = new sp.code.qbic.gui.JThumbnailPanel();
        selectClusterLabel = new javax.swing.JLabel();
        clustIdComboBox = new javax.swing.JComboBox();
        viewDataButton = new javax.swing.JButton();
        aboutTab = new javax.swing.JPanel();
        creditsPanel = new javax.swing.JPanel();
        jcbirImageBigLabel = new javax.swing.JLabel();
        descLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        creditArea = new javax.swing.JTextArea();
        itsLabel = new javax.swing.JLabel();
        luceneLabel1 = new javax.swing.JLabel();
        luceneLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel5.setText("Similarity Treshold :");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QBIC - Query By Image Content");

        queryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Images"));

        imagePathText.setEditable(false);

        browseButton.setText("Browse ...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Tahoma", 0, 18));
        searchButton.setForeground(new java.awt.Color(102, 102, 102));
        searchButton.setText("Search");
        searchButton.setEnabled(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jcbirLogoSmallLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/small.png")));

        imagePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        imagePanel.setPreferredSize(new java.awt.Dimension(128, 28));
        imagePanel.setLayout(new java.awt.BorderLayout());
        imagePanel.add(imageLabel, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        betaLabel1.setText("Rough filtering const");

        betaText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        betaText.setText("0.7");
        betaText.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                betaTextCaretUpdate(evt);
            }
        });

        alphaLabel1.setText("Precise Filtering Treshold");

        alphaText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        alphaText.setText("0.6");
        alphaText.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                alphaTextCaretUpdate(evt);
            }
        });

        useClusterCheck.setSelected(true);
        useClusterCheck.setText("K-Means");
        useClusterCheck.setVisible(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(betaLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(betaText, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alphaLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alphaText, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(useClusterCheck))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(betaLabel1)
                .addComponent(betaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(alphaLabel1)
                .addComponent(alphaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(useClusterCheck))
        );

        javax.swing.GroupLayout queryPanelLayout = new javax.swing.GroupLayout(queryPanel);
        queryPanel.setLayout(queryPanelLayout);
        queryPanelLayout.setHorizontalGroup(
            queryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(queryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(queryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(queryPanelLayout.createSequentialGroup()
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcbirLogoSmallLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, queryPanelLayout.createSequentialGroup()
                        .addComponent(imagePathText, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(browseButton)))
                .addContainerGap())
        );
        queryPanelLayout.setVerticalGroup(
            queryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
            .addGroup(queryPanelLayout.createSequentialGroup()
                .addComponent(jcbirLogoSmallLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(queryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imagePathText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(queryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        resultPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Result"));

        statusLabel.setText("Done ...");

        javax.swing.GroupLayout resultPanelLayout = new javax.swing.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thumbnailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultPanelLayout.createSequentialGroup()
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)))
                .addContainerGap())
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(thumbnailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(resultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel))
                .addContainerGap())
        );

        javax.swing.GroupLayout searchTabLayout = new javax.swing.GroupLayout(searchTab);
        searchTab.setLayout(searchTabLayout);
        searchTabLayout.setHorizontalGroup(
            searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(queryPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        searchTabLayout.setVerticalGroup(
            searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(queryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        cbirTab.addTab("Search", searchTab);

        folderPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Indexing Path"));

        folderText.setEditable(false);

        browseFolderButton.setText("Browse ...");
        browseFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseFolderButtonActionPerformed(evt);
            }
        });

        startIndexButton.setText("Start Indexing");
        startIndexButton.setEnabled(false);
        startIndexButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startIndexButtonActionPerformed(evt);
            }
        });

        numClusterLabel.setText("Number of Clusters : ");

        numClusterCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1" }));
        numClusterCombo.setEnabled(false);

        

        maxIterText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        maxIterText.setText("200");
        maxIterText.setEnabled(false);
        maxIterText.setVisible(false);
        maxIterText.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                maxIterTextCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout folderPanelLayout = new javax.swing.GroupLayout(folderPanel);
        folderPanel.setLayout(folderPanelLayout);
        folderPanelLayout.setHorizontalGroup(
            folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(folderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(folderPanelLayout.createSequentialGroup()
                        .addComponent(folderText, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseFolderButton))
                    .addGroup(folderPanelLayout.createSequentialGroup()
                        .addComponent(startIndexButton)
                        .addGap(18, 18, 18)
                        .addComponent(numClusterLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numClusterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(maxIterLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maxIterText, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        folderPanelLayout.setVerticalGroup(
            folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(folderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(folderText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseFolderButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(folderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startIndexButton)
                    .addComponent(numClusterLabel)
                    .addComponent(numClusterCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxIterLabel)
                    .addComponent(maxIterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        progressPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Indexing Progress"));

        javax.swing.GroupLayout progressPanelLayout = new javax.swing.GroupLayout(progressPanel);
        progressPanel.setLayout(progressPanelLayout);
        progressPanelLayout.setHorizontalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(indexingStatusLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                    .addComponent(indexProgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE))
                .addContainerGap())
        );
        progressPanelLayout.setVerticalGroup(
            progressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(indexProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(indexingStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
        );

        browsePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Browse Indexs"));

        browseIndexLabel.setText("Done ...");

        selectClusterLabel.setText("Select Cluster : ");

        clustIdComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2" }));

        viewDataButton.setText("View Data");
        viewDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDataButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout browsePanelLayout = new javax.swing.GroupLayout(browsePanel);
        browsePanel.setLayout(browsePanelLayout);
        browsePanelLayout.setHorizontalGroup(
            browsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, browsePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(browsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(thumbIndexPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                    .addGroup(browsePanelLayout.createSequentialGroup()
                        .addComponent(browseIndexLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browseIndexProgress, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, browsePanelLayout.createSequentialGroup()
                        .addComponent(selectClusterLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clustIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewDataButton)))
                .addContainerGap())
        );
        browsePanelLayout.setVerticalGroup(
            browsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, browsePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(browsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectClusterLabel)
                    .addComponent(clustIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewDataButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(thumbIndexPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(browsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(browseIndexProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseIndexLabel))
                .addContainerGap())
        );

        javax.swing.GroupLayout indexingTabLayout = new javax.swing.GroupLayout(indexingTab);
        indexingTab.setLayout(indexingTabLayout);
        indexingTabLayout.setHorizontalGroup(
            indexingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, indexingTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(indexingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(browsePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(folderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progressPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        indexingTabLayout.setVerticalGroup(
            indexingTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indexingTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(folderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(browsePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        cbirTab.addTab("Indexing", indexingTab);

        creditsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jcbirImageBigLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/isearch.png")));
        jcbirImageBigLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        descLabel.setFont(new java.awt.Font("Tahoma", 0, 18));
        descLabel.setText("QUERY BY IMAGE CONTENT");

        creditArea.setColumns(20);
        creditArea.setEditable(false);
        creditArea.setText(" QBIC (c) 2012 is a Java based Query By Image Content Application.\n We have developed this application based on  :\n \"Content Based Image Retrieval via Wavelet Transformation \" \n  \n Developers : \n - Calvin Dabre \n - Tejas Gaykar \n - Vishal Sarang \n\n Project Guide \n - Prof. Prajakta Bhangale \n\n      \t\n\t\n\n");
        creditArea.setAutoscrolls(false);
        creditArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        creditArea.setFocusable(false);
        creditArea.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(creditArea);

        itsLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/its.png"))); // NOI18N

        luceneLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/java.png"))); // NOI18N

     ; // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("POWERED BY");

        javax.swing.GroupLayout creditsPanelLayout = new javax.swing.GroupLayout(creditsPanel);
        creditsPanel.setLayout(creditsPanelLayout);
        creditsPanelLayout.setHorizontalGroup(
            creditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, creditsPanelLayout.createSequentialGroup()
                .addGroup(creditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                    .addGroup(creditsPanelLayout.createSequentialGroup()
                        .addGroup(creditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(creditsPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(descLabel))
                            .addGroup(creditsPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jcbirImageBigLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 405, Short.MAX_VALUE)
                        .addComponent(itsLabel))
                    .addGroup(creditsPanelLayout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(luceneLabel2)
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(luceneLabel1)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        creditsPanelLayout.setVerticalGroup(
            creditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creditsPanelLayout.createSequentialGroup()
                .addGroup(creditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(creditsPanelLayout.createSequentialGroup()
                        .addComponent(jcbirImageBigLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descLabel))
                    .addGroup(creditsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(itsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(creditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(creditsPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(luceneLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(creditsPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(creditsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(luceneLabel1)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18))))
        );

        javax.swing.GroupLayout aboutTabLayout = new javax.swing.GroupLayout(aboutTab);
        aboutTab.setLayout(aboutTabLayout);
        aboutTabLayout.setHorizontalGroup(
            aboutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(creditsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        aboutTabLayout.setVerticalGroup(
            aboutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(creditsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        cbirTab.addTab("About", aboutTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbirTab, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbirTab)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void browseFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseFolderButtonActionPerformed
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        folderChooser.setDialogTitle("Open Index Folder ...");
        folderChooser.showDialog(this, "Open");
        File f = folderChooser.getSelectedFile();
        if (f == null) {
            startIndexButton.setEnabled(false);
            numClusterCombo.setEnabled(false);
            maxIterText.setEnabled(false);
            return;
        }
        folderText.setText(f.getAbsolutePath());
        startIndexButton.setEnabled(true);


        File[] files = f.listFiles(new ImageFileFilter(false));
        if (files.length == 0) {
            return;
        }

        //enabled numCluster combobox
        int numOpt = (files.length / 2) - 1;
        Integer[] nums = new Integer[numOpt];
        for (int i = 0, j = 2; i < numOpt; j++, i++) {
            nums[i] = j;
        }


        numClusterCombo.setModel(new DefaultComboBoxModel(nums));
        numClusterCombo.setEnabled(true);
        maxIterText.setEnabled(true);


    }//GEN-LAST:event_browseFolderButtonActionPerformed

    private void startIndexButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startIndexButtonActionPerformed
        indexWorker = new SwingWorker<String, Void>() {

            String notes;

            @Override
            protected String doInBackground() throws Exception {
                File folder = folderChooser.getSelectedFile();
                // image filter masih nge-bug
                File[] files = folder.listFiles(new ImageFileFilter(false));
                //System.out.println(files.length);
                if (!folder.isDirectory() || folder == null || files.length == 0) {
                    notes = "FAIL";
                    return notes;
                }

                startIndexButton.setEnabled(false);
                viewDataButton.setEnabled(false);
                indexProgress.setStringPainted(true);
                time = System.currentTimeMillis();
                IndexWriter indexWriter = new IndexWriter();
                List<Index> indexes = new ArrayList<Index>();
                // feature extraction
                numIndex = 1;
                for (File f : files) {
                    try {
                        BufferedImage bufferedImage = ImageIO.read(f);
                        if (bufferedImage.getHeight(null) != Constants.IMAGE_HEIGHT
                                || bufferedImage.getWidth(null) != Constants.IMAGE_WIDTH) {
                            bufferedImage = GraphicsUtilities.resizeImage(bufferedImage,
                                    Constants.IMAGE_WIDTH, Constants.IMAGE_HEIGHT);
                        }
                        indexingStatusLabel.setText("Extracting image : " + f.getAbsolutePath());
                        Index index = indexWriter.getIndex(bufferedImage);
                        indexProgress.setValue(numIndex * 100 / files.length);
                        index.setFilePath(f.getAbsolutePath());
                        //indexWriter.addIndex(index);
                        indexes.add(index);
                        numIndex++;
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

                // k-means clustering
                KMeans kMeans = new KMeans();
                int maxIter = Integer.parseInt(maxIterText.getText());
                kMeans.setNumCluster(Integer.parseInt(numClusterCombo.getSelectedItem().toString()));
                kMeans.setMaxIteration(maxIter);
                indexingStatusLabel.setText("Clustering Indexs ....");
                indexProgress.setIndeterminate(true);
                kMeans.computeCluster(indexWriter, indexes);
                indexProgress.setIndeterminate(false);

                indexingStatusLabel.setText("Saving Indexs ....");
                // indexing ...
                Cluster[] clusters = kMeans.getClusters();
                // create root index
                indexWriter.open();
                for (Cluster c : clusters) {
                    indexWriter.addCluster(c);
                }
                indexWriter.close();


                //create clusters index
                numIndex = 1;
                ClusterWriter clusterWriter = new ClusterWriter();
                for (int idx = 0; idx < kMeans.getNumCluster(); idx++) {
                    clusterWriter.open(idx);
                    for (Index ix : clusters[idx].getMembers()) {
                        indexingStatusLabel.setText("Add image " + ix.getFilePath() + " to cluster-" + idx);
                        clusterWriter.addIndex(ix);
                        indexProgress.setValue(numIndex * 100 / files.length);
                        numIndex++;
                    }
                    clusterWriter.close();
                }

                notes = "SUCCESS";
                return notes;
            }

            @Override
            protected void done() {
                indexProgress.setValue(0);
                if ("FAIL".equals(notes)) {
                    indexingStatusLabel.setText("Can't Index images because path has no images");
                    browsePanel.setVisible(false);
                    return;
                }
                indexingStatusLabel.setText("Finished indexing " + (numIndex - 1) + " images in " + ((System.currentTimeMillis() - time) / 1000) + " s.");
                //enabled clustId combobox
                Integer clustSize = (Integer) numClusterCombo.getSelectedItem();
                Integer[] nums = new Integer[clustSize];
                for (int i = 0; i < clustSize; i++) {
                    nums[i] = i + 1;
                }

                thumbIndexPanel.getListModel().clear();
                clustIdComboBox.setModel(new DefaultComboBoxModel(nums));
                browsePanel.setVisible(true);
                //thumbIndexPanel.setVisible(false);
                startIndexButton.setEnabled(true);
                viewDataButton.setEnabled(true);
            }
        };

        indexWorker.execute();
        /**
        // TODO add your handling code here:
        ImageIndexer indexer = new ImageIndexer();
        startIndexButton.setEnabled(false);
        try {
        indexer.indexToDatabase(folderChooser.getSelectedFile(), !addCheck.isSelected());
        } catch (Exception e) {
        }
        startIndexButton.setEnabled(true);*/
    }//GEN-LAST:event_startIndexButtonActionPerformed

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        try {
            imageChooser.setFileFilter(new ImageFileFilter());
            imageChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            imageChooser.setDialogTitle("Open Query Image ...");
            imageChooser.showDialog(this, "Open");
            File f = imageChooser.getSelectedFile();
            if (f == null) {
                return;
            }
            imagePathText.setText(f.getAbsolutePath());
            BufferedImage bufferedImage = ImageIO.read(imageChooser.getSelectedFile());
            bufferedImage = GraphicsUtilities.resizeImage(bufferedImage, 125, 140);
            imageLabel.setIcon(new ImageIcon(bufferedImage));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        checkInputSearch();

    }//GEN-LAST:event_browseButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // check
        searchWorker = new SwingWorker<List<ImageResult>, ImageResult>() {

            @Override
            protected List<ImageResult> doInBackground() throws Exception {
                thumbnailPanel.setEnabled(false);
                ImageSearcher searcher = new ImageSearcher();
                BufferedImage bufferedImage = ImageIO.read(imageChooser.getSelectedFile());
                if (bufferedImage.getHeight(null) != Constants.IMAGE_HEIGHT
                        || bufferedImage.getWidth(null) != Constants.IMAGE_WIDTH) {
                    bufferedImage = GraphicsUtilities.resizeImage(bufferedImage,
                            Constants.IMAGE_WIDTH, Constants.IMAGE_HEIGHT);
                }
                time = System.currentTimeMillis();
                searchProgress.setIndeterminate(true);
                statusLabel.setText("Search Images ...");
                List<ImageResult> r = searcher.search(bufferedImage, Double.parseDouble(alphaText.getText()),
                        Double.parseDouble(betaText.getText()), useClusterCheck.isSelected());
                //System.out.println(r.size());
                return r;
            }

            @Override
            protected void done() {
                try {
                    thumbnailPanel.getListModel().clear();
                    List<ImageResult> r = get();
                    searchProgress.setIndeterminate(false);


                    if (r.isEmpty()) {
                        thumbnailPanel.changePageButtonState();
                        statusLabel.setText("No images found ...");
                    } else {
                        thumbnailPanel.getListModel().setPageOffset(0);
                        thumbnailPanel.getListModel().add(r);
                        thumbnailPanel.changePageButtonState();
                        statusLabel.setText("Finished in " + ((double) (System.currentTimeMillis() - time) / 1000) + " s.");
                    }



                } catch (Exception e) {
                    e.printStackTrace();
                    searchProgress.setIndeterminate(false);
                    statusLabel.setText("Can't search images. Please do indexing ...");
                } finally {
                    thumbnailPanel.setEnabled(true);
                }
            }
        };


        searchWorker.execute();
        /**
        try {
        ImageSearcher searcher = new ImageSearcher();
        BufferedImage bufferedImage = ImageIO.read(imageChooser.getSelectedFile());
        if (bufferedImage.getHeight(null) != Constants.IMAGE_HEIGHT
        || bufferedImage.getWidth(null) != Constants.IMAGE_WIDTH) {
        bufferedImage = GraphicsUtilities.createCompatibleImage(bufferedImage,
        Constants.IMAGE_WIDTH, Constants.IMAGE_HEIGHT);
        }
        List<ImageResult> r = searcher.search(bufferedImage, 0.3, 0.5);
        thumbnailPanel.getListModel().clear();
        thumbnailPanel.getListModel().add(r);
        thumbnailPanel.changePageButtonState();
        } catch (IOException ex) {
        }*/
    }//GEN-LAST:event_searchButtonActionPerformed

    private void betaTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_betaTextCaretUpdate

        checkInputSearch();
    }//GEN-LAST:event_betaTextCaretUpdate

    private void alphaTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_alphaTextCaretUpdate
        checkInputSearch();
    }//GEN-LAST:event_alphaTextCaretUpdate

    private void maxIterTextCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_maxIterTextCaretUpdate
        // TODO add your handling code here:
        try {
            int maxIter = Integer.parseInt(maxIterText.getText());
            if (maxIter < 1) {
                startIndexButton.setEnabled(false);
                return;
            }

        } catch (NumberFormatException nfe) {
            startIndexButton.setEnabled(false);
            return;
        }

        startIndexButton.setEnabled(true);
    }//GEN-LAST:event_maxIterTextCaretUpdate

    private void viewDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDataButtonActionPerformed
        browseWorker = new SwingWorker<String, Void>() {

            @Override
            protected String doInBackground() throws Exception {

                try {
                    thumbIndexPanel.setEnabled(false);
                    viewDataButton.setEnabled(false);
                    //thumbIndexPanel.changePageButtonState();
                    thumbIndexPanel.getListModel().setPageOffset(0);
                    thumbIndexPanel.getListModel().clear();
                    Integer clustId = (Integer) clustIdComboBox.getSelectedItem() - 1;
                    IndexReader indexReader = new IndexReader();
                    indexReader.open();
                    Cluster selectedCluster = indexReader.getCluster(clustId);
                    indexReader.close();
                    if (selectedCluster == null) {
                        return "";

                    }
                    ClusterReader clusterReader = new ClusterReader();
                    clusterReader.open(clustId);
                    List<Index> indexs = clusterReader.getIndexes();
                    int dataSize = indexs.size();
                    clusterReader.close();
                    int i = 1;
                    clustId++;
                    browseIndexLabel.setText("Viewing Data in cluster-" + clustId + " ...");
                    browseIndexProgress.setValue(0);
                    for (Index index : indexs) {
                        ImageResult imageResult = new ImageResult();
                        imageResult.setPath(index.getFilePath());
                        imageResult.setSimilarity(selectedCluster.getDistance(index));
                        try {
                            BufferedImage bufferedImage = ImageIO.read(new File(index.getFilePath()));
                            imageResult.setBufferedImage(GraphicsUtilities.resizeImage(bufferedImage,
                                    Constants.THUMB_WIDTH, Constants.THUMB_HEIGHT));
                            thumbIndexPanel.getListModel().add(imageResult);
                            browseIndexProgress.setValue(i * 100 / dataSize);
                        } catch (IOException ex) {
                        }
                        i++;
                    }
                    thumbIndexPanel.changePageButtonState();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                return "";
            }

            @Override
            protected void done() {
                browseIndexLabel.setText("Done.");
                thumbIndexPanel.setEnabled(true);
                viewDataButton.setEnabled(true);
            }
        };

        browseWorker.execute();

    }//GEN-LAST:event_viewDataButtonActionPerformed

    private void checkInputSearch() {
        if (imageChooser.getSelectedFile() == null) {
            searchButton.setEnabled(false);
            return;
        }

        try {
            double a = Double.parseDouble(alphaText.getText());
            double b = Double.parseDouble(betaText.getText());
            if (a > 1 || a < 0 || b > 1 || b < 0) {
                searchButton.setEnabled(false);
                return;
            }

        } catch (NumberFormatException nfe) {
            searchButton.setEnabled(false);
            return;
        }

        searchButton.setEnabled(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    LiquidLookAndFeel.setLiquidDecorations(true, "HP");
                    //LiquidLookAndFeel.setStipples(false);
                    LiquidLookAndFeel.setPanelTransparency(true);
                    javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
                    //javax.swing.UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");

                    new MainFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JPanel aboutTab;
    private javax.swing.JLabel alphaLabel1;
    private javax.swing.JTextField alphaText;
    private javax.swing.JLabel betaLabel1;
    private javax.swing.JTextField betaText;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton browseFolderButton;
    private javax.swing.JLabel browseIndexLabel;
    private javax.swing.JProgressBar browseIndexProgress;
    private javax.swing.JPanel browsePanel;
    private javax.swing.JTabbedPane cbirTab;
    private javax.swing.JComboBox clustIdComboBox;
    private javax.swing.JTextArea creditArea;
    private javax.swing.JPanel creditsPanel;
    private javax.swing.JLabel descLabel;
    private javax.swing.JPanel folderPanel;
    private javax.swing.JTextField folderText;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JTextField imagePathText;
    private javax.swing.JProgressBar indexProgress;
    private javax.swing.JLabel indexingStatusLabel;
    private javax.swing.JPanel indexingTab;
    private javax.swing.JLabel itsLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jcbirImageBigLabel;
    private javax.swing.JLabel jcbirLogoSmallLabel;
    private javax.swing.JLabel luceneLabel1;
    private javax.swing.JLabel luceneLabel2;
    private javax.swing.JLabel maxIterLabel;
    private javax.swing.JTextField maxIterText;
    private javax.swing.JComboBox numClusterCombo;
    private javax.swing.JLabel numClusterLabel;
    private javax.swing.JPanel progressPanel;
    private javax.swing.JPanel queryPanel;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JProgressBar searchProgress;
    private javax.swing.JPanel searchTab;
    private javax.swing.JLabel selectClusterLabel;
    private javax.swing.JButton startIndexButton;
    private javax.swing.JLabel statusLabel;
    private sp.code.qbic.gui.JThumbnailPanel thumbIndexPanel;
    private sp.code.qbic.gui.JThumbnailPanel thumbnailPanel;
    private javax.swing.JCheckBox useClusterCheck;
    private javax.swing.JButton viewDataButton;
    // End of variables declaration//GEN-END:variables
}
