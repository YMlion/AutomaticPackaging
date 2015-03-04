/**
 * @项目名称：AutomaticPackaging
 * @文件名：ThirdFrame.java
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
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.na517.automaticpackaging.MainApp;
import com.na517.automaticpackaging.control.DataControler;

/**
 * @项目名称：AutomaticPackaging
 * @类名称：ThirdFrame
 * @类描述：
 * @创建人：ningque
 * @创建时间：2015-1-8 下午6:16:59
 * @修改人：ningque
 * @修改时间：2015-1-8 下午6:16:59
 * @修改备注：
 * @version
 */
public class ThirdFrame extends JFrame {
    /**
     * serialVersionUID:TODO（用一句话描述这个变量表示什么）
     * 
     * @since Ver 1.1
     */
    
    private static final long serialVersionUID = 1L;
    
    private JTextField txtPushId;
    
    private JTextField txtPushKey;
    
    private JTextField txtPushSecret;
    
    private JButton btnNext;
    
    private JButton btnBack;
    
    JRadioButton radioTest;
    
    JRadioButton radioOffial;
    
    JRadioButton rdbtnDebugTrue;
    
    JRadioButton rdbtnDebugFalse;
    
    public ThirdFrame() {
        initView();
    }
    
    /**
     * 初始化显示数据
     * 
     * @description
     * @date 2015-1-12
     */
    public void initData() {
        HashMap<String, String> map = MainApp.mainFrame.controler.map;
        txtPushId.setText(map.get("PUSH_APPID"));
        txtPushKey.setText(map.get("PUSH_APPKEY"));
        txtPushSecret.setText(map.get("PUSH_APPSECRET"));
    }
    
    /**
     * 初始化Frame
     * 
     * @description
     * @date 2015-1-13
     */
    public void initView() {
        
        setTitle("步骤2");
        setResizable(false);
        setBounds(400, 200, 600, 400);
        BorderLayout layout = new BorderLayout(0, 15);
        getContentPane().setLayout(layout);
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));
        
        JLabel lblNewLabel = new JLabel("其他参数配置");
        panel.add(lblNewLabel);
        
        JPanel panelN = new JPanel();
        getContentPane().add(panelN, BorderLayout.CENTER);
        panelN.setLayout(new BorderLayout(0, 10));
        
        JPanel panelN1 = new JPanel();
        panelN.add(panelN1, BorderLayout.NORTH);
        panelN1.setLayout(new GridLayout(1, 2));
        
        JPanel panelN2 = new JPanel();
        panelN1.add(panelN2);
        panelN2.setLayout(new FlowLayout());
        
        JLabel lblNewLabel1 = new JLabel("调试模式开关:");
        panelN2.add(lblNewLabel1);
        
        JPanel panelN3 = new JPanel();
        panelN1.add(panelN3);
        panelN2.setLayout(new FlowLayout());
        
        ButtonGroup buttonGroup = new ButtonGroup();
        
        rdbtnDebugTrue = new JRadioButton("true");
        panelN3.add(rdbtnDebugTrue);
        buttonGroup.add(rdbtnDebugTrue);
        
        rdbtnDebugFalse = new JRadioButton("false", true);
        panelN3.add(rdbtnDebugFalse);
        buttonGroup.add(rdbtnDebugFalse);
        
        JPanel panel_3 = new JPanel();
        panelN.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_2 = new JPanel();
        panel_3.add(panel_2, BorderLayout.NORTH);
        panel_2.setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel panel_1 = new JPanel();
        panel_2.add(panel_1);
        panel_1.setLayout(new FlowLayout());
        
        JLabel label_4 = new JLabel("key选择:");
        panel_1.add(label_4);
        
        JPanel panel_14 = new JPanel();
        panel_2.add(panel_14);
        
        ButtonGroup buttonGroup1 = new ButtonGroup();
        
        radioTest = new JRadioButton("测试");
        panel_14.add(radioTest);
        buttonGroup1.add(radioTest);
        
        radioOffial = new JRadioButton("正式", true);
        panel_14.add(radioOffial);
        buttonGroup1.add(radioOffial);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(null, "个推参数", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_3.add(panel_5, BorderLayout.CENTER);
        panel_5.setLayout(new GridLayout(1, 2, 0, 0));
        
        JPanel panel_6 = new JPanel();
        panel_5.add(panel_6);
        panel_6.setLayout(new GridLayout(3, 1, 0, 0));
        
        JPanel panel_7 = new JPanel();
        panel_6.add(panel_7);
        
        JLabel label = new JLabel("PUSH_APPID:");
        panel_7.add(label);
        
        JPanel panel_8 = new JPanel();
        panel_6.add(panel_8);
        
        JLabel label_1 = new JLabel("PUSH_APPKEY:");
        panel_8.add(label_1);
        
        JPanel panel_9 = new JPanel();
        panel_6.add(panel_9);
        
        JLabel label_2 = new JLabel("PUSH_APPSECRET:");
        panel_9.add(label_2);
        
        JPanel panel_10 = new JPanel();
        panel_5.add(panel_10);
        panel_10.setLayout(new GridLayout(3, 1, 0, 0));
        
        JPanel panel_11 = new JPanel();
        panel_10.add(panel_11);
        
        txtPushId = new JTextField();
        txtPushId.setColumns(20);
        panel_11.add(txtPushId);
        
        JPanel panel_12 = new JPanel();
        panel_10.add(panel_12);
        
        txtPushKey = new JTextField();
        txtPushKey.setColumns(20);
        panel_12.add(txtPushKey);
        
        JPanel panel_13 = new JPanel();
        panel_10.add(panel_13);
        
        txtPushSecret = new JTextField();
        txtPushSecret.setColumns(20);
        panel_13.add(txtPushSecret);
        
        JPanel panel_4 = new JPanel();
        panelN.add(panel_4, BorderLayout.SOUTH);
        
        btnNext = new JButton("下一步");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                nextStep();
                MainApp.mainFrame.fourthFrame.setVisible(true);
            }
        });
        
        btnBack = new JButton("上一步");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                MainApp.mainFrame.secondFrame.setVisible(true);
                MainApp.mainFrame.thirdFrame.setVisible(false);
            }
        });
        panel_4.add(btnBack);
        panel_4.add(btnNext);
        
        JButton btnNewButton_1 = new JButton("开始打包");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                nextStep();
                DataControler.packaging();
                System.exit(0);
            }
        });
        panel_4.add(btnNewButton_1);
        // 添加界面关闭的监听方法
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainApp.mainFrame.firstFrame.setVisible(true);
                super.windowClosing(e);
            }
        });
        // 添加界面显示的监听方法
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (MainApp.packageFlag == MainApp.NA517_APK) {
                    btnNext.setVisible(false);
                }
                else {
                    btnNext.setVisible(true);
                }
                initData();
                super.componentShown(e);
            }
        });
    }
    
    /**
     * 执行下一步或打包时的操作
     * 
     * @description
     * @date 2015-1-13
     */
    public void nextStep() {
        MainApp.mainFrame.thirdFrame.setVisible(false);
        HashMap<String, String> map = MainApp.mainFrame.controler.map;
        // 修改AndroidManifest.xml参数
        map.put("PUSH_APPID", txtPushId.getText().trim());
        map.put("PUSH_APPKEY", txtPushKey.getText().trim());
        map.put("PUSH_APPSECRET", txtPushSecret.getText().trim());
        MainApp.mainFrame.controler.write(2);
        String name, password;
        if (radioTest.isSelected()) {
            name = "517key_test.keystore";
            password = "517natest";
        }
        else {
            name = "517key.keystore";
            password = "517na4203683";
        }
        // 写入ant.properties文件
        MainApp.mainFrame.controler.writePropertiesFile(name, password);
        // 修改AppConfig.java
        String filePath;
        if (MainApp.packageFlag == MainApp.NA517_APK) {
            filePath = DataControler.PROJECT_PATH + "\\src\\com\\na517\\util\\config\\Appconfig.java";
        }
        else {
            filePath = DataControler.PROJECT_PATH + "\\src\\com\\na517\\croptravel\\util\\config\\Appconfig.java";
        }
        if (rdbtnDebugFalse.isSelected()) {
            MainApp.mainFrame.controler.replaceTxtByStr(filePath,
                                                        "public static final boolean DEBUG = true;",
                                                        "public static final boolean DEBUG = false;");
        }
        else {
            MainApp.mainFrame.controler.replaceTxtByStr(filePath,
                                                        "public static final boolean DEBUG = false;",
                                                        "public static final boolean DEBUG = true;");
        }
    }
}
