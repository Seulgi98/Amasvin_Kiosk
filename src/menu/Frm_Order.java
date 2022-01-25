package menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Frm_Order extends JFrame{
public Frm_Order(String total)
{
	Font ft_Menu = new Font("����",Font.BOLD,25); //��Ʈ ����
	setTitle("ī�� ����"); //Ÿ��Ʋ ����
	setBounds(500,300,300,400); //â ũ�� �� ���� ��ġ ���� 
	getContentPane().setLayout(new BorderLayout());
	JLabel lb_total = new JLabel(total); //�޾ƿ� total�� ���� ���ڿ��� ǥ��
	JButton bt_order = new JButton("�ֹ� �Ϸ�"); //��ư ����
	lb_total.setFont(ft_Menu); //��Ʈ ����
	lb_total.setHorizontalAlignment(JLabel.CENTER);
	Panel_Paint ts = new Panel_Paint();
	
	bt_order.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"�ֹ��� �Ϸ�Ǿ����ϴ�! �����մϴ�.");
			dispose();
		}
	});
	
	//�� ���� ���� ��Ŵ
	this.add(lb_total,BorderLayout.NORTH);
	this.add(ts,BorderLayout.CENTER);
	this.add(bt_order,BorderLayout.SOUTH);
	
	setResizable(false);
	setVisible(true);
	
	
}

}
