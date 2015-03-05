/**
 * @项目名称：AutomaticPackaging
 * @文件名：SecondFrame.java
 * @版本信息：
 * @日期：2015-1-8
 * @Copyright 2015 www.517na.com Inc. All rights reserved.
 */
package com.xyxg.automaticpackaging.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.xyxg.automaticpackaging.MainApp;

/**
 * @项目名称：AutomaticPackaging
 * @类名称：SecondFrame
 * @类描述：
 * @创建人：ningque
 * @创建时间：2015-1-8 下午4:48:14
 * @修改人：ningque
 * @修改时间：2015-1-8 下午4:48:14
 * @修改备注：
 * @version
 */
public class SecondFrame extends JFrame {
    /**
     * serialVersionUID:TODO（用一句话描述这个变量表示什么）
     * 
     * @since Ver 1.1
     */
    
    private static final long serialVersionUID = 1L;
    
    private JTextField txtPackage;
    
    private JTextField txtVersionCode;
    
    private JTextField txtVersionName;
    
    private JTextField txtUAppKey;
    
    private JTextField txtUChannel;
    
    private JTextField txtBApiKey;
    
    public SecondFrame() {
        initView();
    }
    
    /**
     * 初始化显示数据
     * 
     * @description
     * @date 2015-1-12
     */
    public void initData() {
        MainApp.mainFrame.controler.listElement();
        HashMap<String, String> map = MainApp.mainFrame.controler.map;
        txtPackage.setText(map.get("package"));
        txtVersionCode.setText(map.get("versionCode"));
        txtVersionName.setText(map.get("versionName"));
        txtUAppKey.setText(map.get("UMENG_APPKEY"));
        txtUChannel.setText(map.get("UMENG_CHANNEL"));
        txtBApiKey.setText(map.get("com.baidu.lbsapi.API_KEY"));
    }
    
    /**
     * 初始化界面
     * 
     * @description
     * @date 2015-1-13
     */
    public void initView() {
        setTitle("步骤1");
        setResizable(false);
        setBounds(400, 200, 600, 400);
        BorderLayout layout = new BorderLayout(0, 15);
        getContentPane().setLayout(layout);
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));
        
        JLabel lblNewLabel = new JLabel("可变参数配置");
        panel.add(lblNewLabel);
        
        JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(2, 1, 0, 10));
        
        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(null, "版本参数", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.add(panel_3);
        panel_3.setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel panel_5 = new JPanel();
        panel_3.add(panel_5);
        panel_5.setLayout(new GridLayout(3, 1, 0, 0));
        
        JPanel panel_8 = new JPanel();
        panel_5.add(panel_8);
        
        final JLabel lblPackageName = new JLabel("package name:");
        panel_8.add(lblPackageName);
        
        JPanel panel_9 = new JPanel();
        panel_5.add(panel_9);
        
        JLabel lblVersionCode = new JLabel("versionCode");
        panel_9.add(lblVersionCode);
        
        JPanel panel_7 = new JPanel();
        panel_5.add(panel_7);
        
        JLabel lblVersionName = new JLabel("versionName");
        panel_7.add(lblVersionName);
        
        JPanel panel_6 = new JPanel();
        panel_3.add(panel_6);
        panel_6.setLayout(new GridLayout(3, 1, 0, 0));
        
        JPanel panel_11 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_11.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel_6.add(panel_11);
        
        txtPackage = new JTextField();
        panel_11.add(txtPackage);
        txtPackage.setColumns(20);
        
        JPanel panel_12 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_12.getLayout();
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        panel_6.add(panel_12);
        
        txtVersionCode = new JTextField();
        panel_12.add(txtVersionCode);
        txtVersionCode.setColumns(20);
        
        JPanel panel_10 = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panel_10.getLayout();
        flowLayout_2.setAlignment(FlowLayout.LEFT);
        panel_6.add(panel_10);
        
        txtVersionName = new JTextField();
        panel_10.add(txtVersionName);
        txtVersionName.setColumns(20);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(null, "友盟参数", TitledBorder.LEADING, TitledBorder.TOP));
        panel_1.add(panel_2);
        panel_2.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_14 = new JPanel();
        panel_2.add(panel_14);
        panel_14.setLayout(new GridLayout(3, 1, 0, 0));
        
        JPanel panel_16 = new JPanel();
        panel_14.add(panel_16);
        
        JLabel lblUAppKey = new JLabel("UMENG_APPKEY");
        panel_16.add(lblUAppKey);
        
        JPanel panel_17 = new JPanel();
        panel_14.add(panel_17);
        
        JLabel lblUChannel = new JLabel("友盟渠道(代理人简称:数字或字母)");
        panel_17.add(lblUChannel);
        
        JPanel panel_15 = new JPanel();
        panel_14.add(panel_15);
        
        JLabel lblBApiKey = new JLabel("百度API_KEY");
        panel_15.add(lblBApiKey);
        
        JPanel panel_13 = new JPanel();
        panel_2.add(panel_13);
        panel_13.setLayout(new GridLayout(3, 1, 0, 0));
        
        JPanel panel_19 = new JPanel();
        FlowLayout flowLayout_3 = (FlowLayout) panel_19.getLayout();
        flowLayout_3.setAlignment(FlowLayout.LEFT);
        panel_13.add(panel_19);
        
        txtUAppKey = new JTextField();
        panel_19.add(txtUAppKey);
        txtUAppKey.setColumns(20);
        
        JPanel panel_20 = new JPanel();
        FlowLayout flowLayout_4 = (FlowLayout) panel_20.getLayout();
        flowLayout_4.setAlignment(FlowLayout.LEFT);
        panel_13.add(panel_20);
        
        txtUChannel = new JTextField();
        panel_20.add(txtUChannel);
        txtUChannel.setColumns(20);
        
        JPanel panel_18 = new JPanel();
        FlowLayout flowLayout_5 = (FlowLayout) panel_18.getLayout();
        flowLayout_5.setAlignment(FlowLayout.LEFT);
        panel_13.add(panel_18);
        
        txtBApiKey = new JTextField();
        panel_18.add(txtBApiKey);
        txtBApiKey.setColumns(20);
        
        JPanel panel_4 = new JPanel();
        getContentPane().add(panel_4, BorderLayout.SOUTH);
        
        JButton btnNewButton = new JButton("下一步");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                nextStep();
                MainApp.mainFrame.thirdFrame.setVisible(true);
                MainApp.mainFrame.secondFrame.setVisible(false);
            }
        });
        panel_4.add(btnNewButton);
        
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
     * 执行下一步时的操作
     * 
     * @description
     * @date 2015-1-13
     */
    public void nextStep() {
        HashMap<String, String> map = MainApp.mainFrame.controler.map;
        if (map.get("package").equals(txtPackage.getText()) && map.get("versionCode").equals(txtVersionCode.getText())
            && map.get("versionName").equals(txtVersionName.getText())
            && map.get("UMENG_APPKEY").equals(txtUAppKey.getText())
            && map.get("UMENG_CHANNEL").equals(txtUChannel.getText())
            && map.get("com.baidu.lbsapi.API_KEY").equals(txtBApiKey.getText())) {
            return;
        }
        map.put("package", txtPackage.getText().trim());
        map.put("versionCode", txtVersionCode.getText().trim());
        map.put("versionName", txtVersionName.getText().trim());
        map.put("UMENG_APPKEY", txtUAppKey.getText().trim());
        map.put("UMENG_CHANNEL", txtUChannel.getText().trim());
        map.put("com.baidu.lbsapi.API_KEY", txtBApiKey.getText().trim());
        MainApp.mainFrame.controler.write(1);
        MainApp.mainFrame.controler.writeConfig();
    }
}
