/**
 * @��Ŀ���ƣ�AutomaticPackaging
 * @�ļ�����FirstFrame.java
 * @�汾��Ϣ��
 * @���ڣ�2015-1-8
 * @Copyright 2015 www.517na.com Inc. All rights reserved.
 */
package com.na517.automaticpackaging.frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.na517.automaticpackaging.MainApp;
import com.na517.automaticpackaging.control.DataControler;
import javax.swing.JTextField;

/**
 * @��Ŀ���ƣ�AutomaticPackaging
 * @�����ƣ�FirstFrame
 * @��������
 * @�����ˣ�ningque
 * @����ʱ�䣺2015-1-8 ����4:29:57
 * @�޸��ˣ�ningque
 * @�޸�ʱ�䣺2015-1-8 ����4:29:57
 * @�޸ı�ע��
 * @version
 */
public class FirstFrame extends JFrame {
    /**
     * serialVersionUID:TODO����һ�仰�������������ʾʲô��
     * 
     * @since Ver 1.1
     */
    
    private static final long serialVersionUID = 1L;
    
    private JTextField txtPath;
    
    public FirstFrame() {
        initView();
    }
    
    public void initView() {
        setTitle("��ҳ");
        setResizable(false);
        setSize(600, 400);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel panel1 = new JPanel();
        getContentPane().add(panel1, BorderLayout.NORTH);
        
        JLabel lblAndroid = new JLabel("Android�Զ�������ϵͳ");
        lblAndroid.setFont(new Font("����", Font.PLAIN, 32));
        panel1.add(lblAndroid);
        
        JPanel panel2 = new JPanel();
        getContentPane().add(panel2, BorderLayout.CENTER);
        panel2.setLayout(null);
        
        JButton btnNa517 = new JButton("517apk���");
        btnNa517.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (txtPath.getText().trim().length() < 1) {
                    return;
                }
                MainApp.packageFlag = MainApp.NA517_APK;
                MainApp.mainFrame.controler = new DataControler();
                if (!MainApp.mainFrame.controler.initData()) {
                    JOptionPane.showMessageDialog(null, "�����ݣ�����Ŀ¼�Ƿ���ȷ��", "����", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                MainApp.mainFrame.firstFrame.setVisible(false);
                MainApp.mainFrame.secondFrame.setVisible(true);
            }
        });
        btnNa517.setBounds(82, 190, 183, 35);
        panel2.add(btnNa517);
        
        JButton btnTravel = new JButton("����apk���");
        btnTravel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtPath.getText().trim().length() < 1) {
                    return;
                }
                MainApp.packageFlag = MainApp.TRAVEL_APK;
                MainApp.mainFrame.controler = new DataControler();
                if (!MainApp.mainFrame.controler.initData()) {
                    JOptionPane.showMessageDialog(null, "�����ݣ�����Ŀ¼�Ƿ���ȷ��", "����", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                MainApp.mainFrame.firstFrame.setVisible(false);
                MainApp.mainFrame.secondFrame.setVisible(true);
            }
        });
        btnTravel.setBounds(322, 190, 183, 35);
        panel2.add(btnTravel);
        
        txtPath = new JTextField();
        txtPath.setBounds(167, 102, 209, 21);
        panel2.add(txtPath);
        txtPath.setColumns(20);
        
        JLabel lblNewLabel = new JLabel("����Ŀ¼:");
        lblNewLabel.setBounds(82, 105, 75, 15);
        panel2.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("ѡ��Ŀ¼");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setDialogTitle("ѡ�񹤳�Ŀ¼");
                int result = chooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    DataControler.ROOT_PATH = chooser.getSelectedFile().getAbsolutePath();
                    txtPath.setText(DataControler.ROOT_PATH);
                }
            }
        });
        btnNewButton.setBounds(412, 101, 93, 23);
        panel2.add(btnNewButton);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                super.windowClosing(e);
            }
        });
    }
}
