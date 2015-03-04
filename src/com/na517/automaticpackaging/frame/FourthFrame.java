/**
 * @项目名称：AutomaticPackaging
 * @文件名：FourthFrame.java
 * @版本信息：
 * @日期：2015-1-8
 * @Copyright 2015 www.517na.com Inc. All rights reserved.
 */
package com.na517.automaticpackaging.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.na517.automaticpackaging.MainApp;
import com.na517.automaticpackaging.control.DataControler;

/**
 * @项目名称：AutomaticPackaging
 * @类名称：FourthFrame
 * @类描述：
 * @创建人：ningque
 * @创建时间：2015-1-8 下午7:30:25
 * @修改人：ningque
 * @修改时间：2015-1-8 下午7:30:25
 * @修改备注：
 * @version
 */
public class FourthFrame extends JFrame {
    /**
     * serialVersionUID:TODO（用一句话描述这个变量表示什么）
     * 
     * @since Ver 1.1
     */
    
    private static final long serialVersionUID = 1L;
    
    private String iconPath = ".";
    
    private String appUrlLine = "";
    
    private String appUrl;
    
    private JTextField txtAppname;
    
    private JTextField txtAppiconH;
    
    private JTextField txtName;
    
    private JTextField txtPid;
    
    private JTextField txtTel;
    
    private JTextField txtAppiconXH;
    
    private JTextField txtAppiconXXH;
    
    private JTextField txtAppUrl;
    
    public FourthFrame() {
        initView();
    }
    
    /**
     * 初始化显示数据
     * 
     * @description
     * @date 2015-1-13
     */
    public void initData() {
        HashMap<String, String> map = MainApp.mainFrame.controler.map;
        txtName.setText(map.get("AGENT_NAME"));
        txtPid.setText(map.get("AGENT_PID"));
        txtTel.setText(map.get("SERVICE_TEL"));
        appUrlLine = MainApp.mainFrame.controler.getFileString(DataControler.PROJECT_PATH + "\\src\\com\\na517\\croptravel\\flight\\UserCenterActivity.java",
                                                               "private String mAppUrl");
        appUrl = new String();
        int pos = appUrlLine.indexOf('"');
        appUrl = appUrlLine.substring(pos + 1);
        pos = appUrl.indexOf('"');
        appUrl = appUrl.substring(0, pos);
        txtAppUrl.setText(appUrl);
    }
    
    /**
     * 初始化界面
     * 
     * @description
     * @date 2015-1-9
     */
    public void initView() {
        setTitle("步骤3");
        setResizable(false);
        setBounds(400, 200, 600, 400);
        getContentPane().setLayout(new BorderLayout(0, 10));
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));
        
        JLabel lblNewLabel = new JLabel("差旅打包参数");
        panel.add(lblNewLabel);
        
        JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(null);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(101, 10, 109, 133);
        panel_1.add(panel_3);
        panel_3.setLayout(new GridLayout(4, 1, 0, 0));
        
        JPanel panel_5 = new JPanel();
        FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
        flowLayout_5.setAlignment(FlowLayout.RIGHT);
        panel_3.add(panel_5);
        
        JLabel lblNewLabel_1 = new JLabel("App名称");
        panel_5.add(lblNewLabel_1);
        
        JPanel panel_6 = new JPanel();
        FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
        flowLayout_4.setAlignment(FlowLayout.RIGHT);
        panel_3.add(panel_6);
        
        JLabel lblNewLabel_2 = new JLabel("低分辨率图标");
        panel_6.add(lblNewLabel_2);
        
        JPanel panel_8 = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel_8.getLayout();
        flowLayout_2.setAlignment(FlowLayout.RIGHT);
        panel_3.add(panel_8);
        
        JLabel lblNewLabel_3 = new JLabel("高分辨率图标");
        panel_8.add(lblNewLabel_3);
        
        JPanel panel_12 = new JPanel();
        FlowLayout flowLayout_3 = (FlowLayout) panel_12.getLayout();
        flowLayout_3.setAlignment(FlowLayout.RIGHT);
        panel_3.add(panel_12);
        
        JLabel lblNewLabel_4 = new JLabel("超高分辨率图标");
        panel_12.add(lblNewLabel_4);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(220, 10, 305, 133);
        panel_1.add(panel_4);
        panel_4.setLayout(new GridLayout(4, 1, 0, 0));
        
        JPanel panel_9 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_9.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel_4.add(panel_9);
        
        txtAppname = new JTextField();
        panel_9.add(txtAppname);
        txtAppname.setColumns(20);
        
        JPanel panel_10 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_10.getLayout();
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        panel_4.add(panel_10);
        
        txtAppiconH = new JTextField();
        panel_10.add(txtAppiconH);
        txtAppiconH.setColumns(20);
        
        JButton btnNewButton_2 = new JButton("选择");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                chooseIcon(1);
            }
        });
        panel_10.add(btnNewButton_2);
        
        JPanel panel_20 = new JPanel();
        FlowLayout flowLayout_6 = (FlowLayout) panel_20.getLayout();
        flowLayout_6.setAlignment(FlowLayout.LEFT);
        panel_4.add(panel_20);
        
        txtAppiconXH = new JTextField();
        panel_20.add(txtAppiconXH);
        txtAppiconXH.setColumns(20);
        
        JButton btnNewButton_3 = new JButton("选择");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooseIcon(2);
            }
        });
        panel_20.add(btnNewButton_3);
        
        JPanel panel_21 = new JPanel();
        FlowLayout flowLayout_7 = (FlowLayout) panel_21.getLayout();
        flowLayout_7.setAlignment(FlowLayout.LEFT);
        panel_4.add(panel_21);
        
        txtAppiconXXH = new JTextField();
        panel_21.add(txtAppiconXXH);
        txtAppiconXXH.setColumns(20);
        
        JButton btnNewButton_4 = new JButton("选择");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooseIcon(3);
            }
        });
        panel_21.add(btnNewButton_4);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBounds(42, 153, 520, 142);
        panel_1.add(panel_7);
        panel_7.setBorder(new TitledBorder(null, "其他参数", TitledBorder.LEADING, TitledBorder.TOP));
        panel_7.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_11 = new JPanel();
        panel_7.add(panel_11);
        panel_11.setLayout(new GridLayout(4, 1, 0, 0));
        
        JPanel panel_13 = new JPanel();
        panel_11.add(panel_13);
        
        JLabel label = new JLabel("名称:");
        panel_13.add(label);
        
        JPanel panel_14 = new JPanel();
        panel_11.add(panel_14);
        
        JLabel label_1 = new JLabel("名称PID:");
        panel_14.add(label_1);
        
        JPanel panel_15 = new JPanel();
        panel_11.add(panel_15);
        
        JLabel label_2 = new JLabel("客服电话:");
        panel_15.add(label_2);
        
        JPanel panel_22 = new JPanel();
        panel_11.add(panel_22);
        
        JLabel lblApp = new JLabel("APP下载地址:");
        panel_22.add(lblApp);
        
        JPanel panel_16 = new JPanel();
        panel_7.add(panel_16);
        panel_16.setLayout(new GridLayout(4, 1, 0, 0));
        
        JPanel panel_17 = new JPanel();
        panel_16.add(panel_17);
        
        txtName = new JTextField();
        txtName.setColumns(20);
        panel_17.add(txtName);
        
        JPanel panel_18 = new JPanel();
        panel_16.add(panel_18);
        
        txtPid = new JTextField();
        txtPid.setColumns(20);
        panel_18.add(txtPid);
        
        JPanel panel_19 = new JPanel();
        panel_16.add(panel_19);
        
        txtTel = new JTextField();
        txtTel.setColumns(20);
        panel_19.add(txtTel);
        
        JPanel panel_23 = new JPanel();
        panel_16.add(panel_23);
        
        txtAppUrl = new JTextField();
        panel_23.add(txtAppUrl);
        txtAppUrl.setColumns(20);
        
        JPanel panel_2 = new JPanel();
        getContentPane().add(panel_2, BorderLayout.SOUTH);
        
        JButton btnNewButton = new JButton("上一步");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainApp.mainFrame.fourthFrame.setVisible(false);
                MainApp.mainFrame.thirdFrame.setVisible(true);
            }
        });
        panel_2.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("开始打包");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (txtAppiconH.getText().trim().length() > 3 || txtAppname.getText().length() >= 1) {
                    MainApp.mainFrame.controler.updateAppName(txtAppname.getText().trim());
                }
                HashMap<String, String> map = MainApp.mainFrame.controler.map;
                map.put("AGENT_NAME", txtName.getText().trim());
                map.put("AGENT_PID", txtPid.getText().trim());
                String tel = txtTel.getText().trim();
                if (!tel.startsWith("TEL:")) {
                    tel += "TEL:";
                }
                map.put("SERVICE_TEL", tel);
                MainApp.mainFrame.controler.write(3);
                // 修改app下载地址
                String newAppUrlLine = appUrlLine.replace(appUrl, txtAppUrl.getText().trim());
                MainApp.mainFrame.controler.replaceTxtByStr(DataControler.PROJECT_PATH + "\\src\\com\\na517\\croptravel\\flight\\UserCenterActivity.java",
                                                            appUrlLine,
                                                            newAppUrlLine);
                DataControler.packaging();
                MainApp.mainFrame.fourthFrame.setVisible(false);
                System.exit(0);
            }
        });
        panel_2.add(btnNewButton_1);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainApp.mainFrame.firstFrame.setVisible(true);
                super.windowClosing(e);
            }
        });
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                initData();
                super.componentShown(e);
            }
        });
    }
    
    /**
     * 选择图标
     * 
     * @description
     * @date 2015-1-13
     * @param iconType
     */
    public void chooseIcon(int iconType) {
        JFileChooser chooser = new JFileChooser(iconPath);
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            String name = chooser.getSelectedFile().getPath();
            iconPath = name;
            String path;
            switch (iconType) {
                case 1:
                    txtAppiconH.setText(name);
                    path = "\\res\\drawable-hdpi\\ic_launcher.png";
                    break;
                case 2:
                    txtAppiconXH.setText(name);
                    path = "\\res\\drawable-xhdpi\\ic_launcher.png";
                    break;
                case 3:
                    txtAppiconXXH.setText(name);
                    path = "\\res\\drawable-xxhdpi\\ic_launcher.png";
                    break;
                default:
                    return;
            }
            
            try {
                Files.copy(Paths.get(name), new FileOutputStream(DataControler.PROJECT_PATH + path));
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
