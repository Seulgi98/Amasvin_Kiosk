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
	Font ft_Menu = new Font("돋움",Font.BOLD,25); //폰트 지정
	setTitle("카드 결제"); //타이틀 설정
	setBounds(500,300,300,400); //창 크기 및 시작 위치 설정 
	getContentPane().setLayout(new BorderLayout());
	JLabel lb_total = new JLabel(total); //받아온 total에 관한 문자열을 표시
	JButton bt_order = new JButton("주문 완료"); //버튼 생성
	lb_total.setFont(ft_Menu); //폰트 지정
	lb_total.setHorizontalAlignment(JLabel.CENTER);
	Panel_Paint ts = new Panel_Paint();
	
	bt_order.addActionListener(new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"주문이 완료되었습니다! 감사합니다.");
			dispose();
		}
	});
	
	//각 위젯 삽입 시킴
	this.add(lb_total,BorderLayout.NORTH);
	this.add(ts,BorderLayout.CENTER);
	this.add(bt_order,BorderLayout.SOUTH);
	
	setResizable(false);
	setVisible(true);
	
	
}

}
