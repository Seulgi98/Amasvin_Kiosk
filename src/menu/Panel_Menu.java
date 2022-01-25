package menu;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//메뉴를 만들기 위한 클래스 입니다.
public class Panel_Menu extends JPanel{
	public Panel_Menu(JPanel Card_Panel, CardLayout Cd) {
	this.setBackground(Color.white); //색상 설정
	Color Cr_Menu = new Color(247,240,172); //색상 지정
	Font ft_Menu = new Font("돋움",Font.BOLD,20); //폰트 지정
	Dimension Size_Menu = new Dimension(220,50); //크기 지정
	JButton bt_bubble= new JButton("버블티"); //버튼 생성
	bt_bubble.setBackground(Cr_Menu); //색상 지정
	bt_bubble.setFont(ft_Menu); //폰트 지정
	bt_bubble.setPreferredSize(Size_Menu); //크기 지정
	bt_bubble.setBorderPainted(false); //테두리 없앰
	bt_bubble.setFocusPainted(false); //태두리 focus 없앰
	JButton bt_coffee = new JButton("커피");
	bt_coffee.setBackground(Cr_Menu);
	bt_coffee.setFont(ft_Menu);
	bt_coffee.setPreferredSize(Size_Menu);
	bt_coffee.setBorderPainted(false);
	bt_coffee.setFocusPainted(false);
	
	JButton bt_shake = new JButton("쉐이크/스무디");
	bt_shake.setBackground(Cr_Menu);
	bt_shake.setFont(ft_Menu);
	bt_shake.setPreferredSize(Size_Menu);
	bt_shake.setBorderPainted(false);
	bt_shake.setFocusPainted(false);
	
	JButton bt_dessert = new JButton("디저트");
	bt_dessert.setBackground(Cr_Menu);
	bt_dessert.setFont(ft_Menu);
	bt_dessert.setPreferredSize(Size_Menu);
	bt_dessert.setBorderPainted(false);
	bt_dessert.setFocusPainted(false);
	
	this.setLayout(new FlowLayout());
	this.add(bt_bubble);
	this.add(bt_coffee);
	this.add(bt_shake);
	this.add(bt_dessert);
	
	bt_bubble.setBackground(Color.white);
	
	bt_bubble.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e){
 		JButton bt_bubble = (JButton) e.getSource();
 		Cd.show(Card_Panel,"Bubble");
 		bt_bubble.setBackground(Color.white);
 		bt_coffee.setBackground(Cr_Menu);
 		bt_shake.setBackground(Cr_Menu);
 		bt_dessert.setBackground(Cr_Menu);
 		Card_Panel.setToolTipText("Bubble");
 		}
     	
     });
	
	bt_coffee.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e){
 		Cd.show(Card_Panel,"Coffee");
 		bt_coffee.setBackground(Color.white);
 		bt_bubble.setBackground(Cr_Menu);
 		bt_shake.setBackground(Cr_Menu);
 		bt_dessert.setBackground(Cr_Menu);
 		Card_Panel.setToolTipText("Coffee");
 		}
     	
     });
	
	bt_shake.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e){
 		Cd.show(Card_Panel,"Shake");
 		bt_shake.setBackground(Color.white);
 		bt_coffee.setBackground(Cr_Menu);
 		bt_bubble.setBackground(Cr_Menu);
 		bt_dessert.setBackground(Cr_Menu);
 		Card_Panel.setToolTipText("Shake");
 		}
     	
     });
	
	bt_dessert.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e){
 		Cd.show(Card_Panel,"Dessert");
 		bt_dessert.setBackground(Color.white);
 		bt_coffee.setBackground(Cr_Menu);
 		bt_shake.setBackground(Cr_Menu);
 		bt_bubble.setBackground(Cr_Menu);
 		Card_Panel.setToolTipText("Dessert");
 		}
     	
     });
}
}

