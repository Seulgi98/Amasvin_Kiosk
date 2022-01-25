package main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import list.Panel_Items;
import list.Rows_Item;
import menu.Frm_Order;
import menu.Panel_Menu;
import menu.Frm_Order;

//메인 프레임을 위한 클래스입니다
public class Myframe extends JFrame {
	int b_start=0; //버블티 표시 시작점
	int c_start=0; //커피 표시 시작점
	int s_start=0; //쉐이크 표시 시작점
	int d_start=0; //디저트 표시 시작점
	
	public Myframe() {
	     //창 이름 설정
		setTitle("\uC544\uB9C8\uC2A4\uBE48 \uD0A4\uC624\uC2A4\uD06C");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,960,650);
		//각 분류별 아이템을 어레이 리스트에 저장
		ArrayList<Rows_Item> LIST_b= new ArrayList<Rows_Item>();
		ArrayList<Rows_Item> LIST_c= new ArrayList<Rows_Item>();
		ArrayList<Rows_Item> LIST_s= new ArrayList<Rows_Item>();
		ArrayList<Rows_Item> LIST_d= new ArrayList<Rows_Item>();
		///////////////////////////////////////////////////////////////
		JPanel Card_Panel = new JPanel();  //CardPanel 을 위한 JPanel 생성
		CardLayout Cd = new CardLayout(); //CradPanel 생성

		//메인 프레임에 추가
		//JTabel 구현 부분
		String header[]= {"분류","상품명","상품 가격","수량"};
		String contents[][]=null;
		DefaultTableModel model = new DefaultTableModel(contents,header);
		JTable table = new JTable(model);
		//단일 모드 설정
		table.setSelectionMode(0);
		table.setBackground(Color.WHITE);
		
		JScrollPane scrollpane = new JScrollPane(table);
		JPanel Panel_Items_Bubble = new JPanel(); //버블티 Panel
		JPanel Panel_Items_Coffee = new JPanel(); //커피 Panel
		JPanel Panel_Items_Shake = new JPanel(); //쉐이크 Panel
		JPanel Panel_Items_Dessert = new JPanel(); //디저트 Panel
		
		///사이드 버튼 생성
				Color Cr_Menu = new Color(247,240,172); //색상 지정
				Font ft_Item = new Font("돋움",Font.BOLD,10); //폰트 설정
				JButton bt_Left = new JButton("<");
				JButton bt_Right = new JButton(">");
				JButton bt_Plus = new JButton("+");
				JButton bt_Sub = new JButton("-");
				JButton bt_Order = new JButton("주문");
				JLabel lb_total = new JLabel("주문을 해주세요!");
				
		//Panel별 아이템 불러오기(어레이 리스트,Panel명,테이블,총가격 라벨,분류, 메뉴 인덱스)
		new Panel_Items(LIST_b,Panel_Items_Bubble,table,lb_total,"Bubble", 0);
		new Panel_Items(LIST_c,Panel_Items_Coffee,table,lb_total,"Coffee", 1);
		new Panel_Items(LIST_s,Panel_Items_Shake,table,lb_total,"Shake", 2);
	    new Panel_Items(LIST_d,Panel_Items_Dessert,table,lb_total,"Dessert",3);
		
	    Card_Panel.setLayout(Cd); //카드레이아웃 설정
	    Card_Panel.setToolTipText("Bubble"); //첫 패널이 무엇인지 저장
	    //카드를 다 추가해주었습니다.
		Card_Panel.add(Panel_Items_Bubble,"Bubble");
		Card_Panel.add(Panel_Items_Coffee,"Coffee");
		Card_Panel.add(Panel_Items_Shake,"Shake");
		Card_Panel.add(Panel_Items_Dessert,"Dessert");
		
		
		bt_Left.setFont(ft_Item); //폰트 설정
		bt_Right.setFont(ft_Item);//폰트 설정
		bt_Left.setBorderPainted(false); //테두리 없앰
		bt_Left.setFocusPainted(false); //태두리 focus 없앰
		bt_Right.setBorderPainted(false); //테두리 없앰
		bt_Right.setFocusPainted(false); //태두리 focus 없앰
	
		bt_Plus.setFocusPainted(false); //태두리 focus 없앰
		
		bt_Sub.setFocusPainted(false); //태두리 focus 없앰
		
		bt_Order.setFocusPainted(false); //태두리 focus 없앰
		bt_Left.setBackground(Cr_Menu); //색상 지정
		bt_Right.setBackground(Cr_Menu); //색상 지정
		bt_Plus.setBackground(Cr_Menu); //색상 지정
		bt_Sub.setBackground(Cr_Menu); //색상 지정
		bt_Order.setBackground(Cr_Menu); //색상 지정
	    
		///메뉴 Panel 생성
		Panel_Menu MENU = new Panel_Menu(Card_Panel,Cd);
		
		JPanel P_List = new JPanel();
		
		//각 위젯 위치 설정 및 패널에 추가
		P_List.setLayout(null);
		scrollpane .setBounds(10,10,700,120);
		bt_Plus.setBounds(720,10,80,60);
		bt_Sub.setBounds(720,70,80,60);
		bt_Order.setBounds(810,70,120,60);
		lb_total.setBounds(810,10,100,30);
		P_List.add(scrollpane);
		P_List.add(bt_Plus);
		P_List.add(bt_Sub);
		P_List.add(bt_Order);
		P_List.add(lb_total);
		P_List.setBackground(Color.white);
		Dimension Dim_size = new Dimension(33,140);
		P_List.setPreferredSize(Dim_size);
		
		// 상품 추가 버튼 기능
		bt_Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()>=0) //테이블에 상품이 있다면
				{
					//선택한 리스트의 분류를 가져옴
				  String tmp = (String) table.getValueAt(table.getSelectedRow(),0);
				switch(tmp) //분류 확인
				{
				case "Bubble": //버블티 일 경우
					
						for(int i=0;i<LIST_b.size();i++) { //버블티의 모든 상품 중
						if(LIST_b.get(i).getName().equals(table.getValueAt(table.getSelectedRow(),1))==true)
						{ 
							//선택한 것이 있다면 그 객체의 수량을 증가 시킴
							LIST_b.get(i).PlusQuant();
							//테이블에 추가 시킴
					       table.setValueAt(LIST_b.get(i).getQuant(),table.getSelectedRow(),3);
					       //총 가격 새로고침 해줌
					       LIST_b.get(i).Refresh(table, lb_total);
					       }
					  }
				    break;
				    
				    //밑에 있는 case 문 또한 위와 동일함.
			case "Coffee":
				if (table.getSelectedRow()>=0)
				{
					for(int i=0;i<LIST_c.size();i++) {
					if(LIST_c.get(i).getName().equals(table.getValueAt(table.getSelectedRow(),1))==true)
					{
						LIST_c.get(i).PlusQuant();
				       table.setValueAt(LIST_c.get(i).getQuant(),table.getSelectedRow(),3);
				       LIST_c.get(i).Refresh(table, lb_total);
				       }
				  }
				}
			    break;
	
		case "Shake":
			
				for(int i=0;i<LIST_s.size();i++) {
				if(LIST_s.get(i).getName().equals(table.getValueAt(table.getSelectedRow(),1))==true)
				{
					LIST_s.get(i).PlusQuant();
			       table.setValueAt(LIST_s.get(i).getQuant(),table.getSelectedRow(),3);
			       LIST_s.get(i).Refresh(table, lb_total);
			       }
			  }
			
		    break;
		
		case "Dessert":
				for(int i=0;i<LIST_d.size();i++) {
				if(LIST_d.get(i).getName().equals(table.getValueAt(table.getSelectedRow(),1))==true)
				{
					LIST_d.get(i).PlusQuant();
			       table.setValueAt(LIST_d.get(i).getQuant(),table.getSelectedRow(),3);
			       LIST_d.get(i).Refresh(table, lb_total);
			       }
			}
		   break;
		}
		   }
		}
		});
		
		//상품 삭제 버튼 기능 
		bt_Sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//테이블에 상품이 있을 때만 기능 수행
				if (table.getSelectedRow()>=0)
				{
					//선택한 리스트의 상품 분류 저장
				String tmp = (String) table.getValueAt(table.getSelectedRow(),0);
				switch(tmp)
				{
				case "Bubble": //버블티 일 경우
						for(int i=0;i<LIST_b.size();i++) { //버블티 전체에서
						if(LIST_b.get(i).getName().equals(table.getValueAt(table.getSelectedRow(),1))==true)
						{ //테이블에서 선택한 이름과 같은 객체를 찾아냄
						   LIST_b.get(i).SubQuant(); //해당 객체의 수량 감소
						   //테이블 표시
						   table.setValueAt(LIST_b.get(i).getQuant(),table.getSelectedRow(),3);
					       //총 가격 새로고침
						   LIST_b.get(i).Refresh(table, lb_total);
					    }
						}
						
						//테이블의 전체 상품들 중에서
						for(int k=0;k<table.getRowCount();k++)
							//상품의 개수가 0인 것을 삭제시키기 위해 찾아봄
						  if (table.getValueAt(k, 3).equals(0)==true) 
							  //찾은 것 중 어레이리스트에서 해당 객체를 찾아봄
						  for(int j=0;j<LIST_b.size();j++)
						  {
							  System.out.println(j); 
							 //해당 객체의 수량이 0인 것을 확인하고
							  if(LIST_b.get(j).getQuant()==0)
							  {
								  //테이블에서 삭제함.
								  //어레이리스트는 삭제하면 안됨.
						       model.removeRow(k);
						       table.updateUI();
						       //수량 증가 시킴 (=초기화 1이므로 하나 증가)
						       LIST_b.get(j).PlusQuant();
						       //System.out.println(k); 
						   }
					      }
						
					  
					
				    break;
				    //아래 case 또한 위와 같음.
			case "Coffee":
				
					for(int i=0;i<LIST_c.size();i++) {
					if(LIST_c.get(i).getName().equals(table.getValueAt(table.getSelectedRow(),1))==true)
					{
						LIST_c.get(i).SubQuant();
				        table.setValueAt(LIST_c.get(i).getQuant(),table.getSelectedRow(),3);
				        LIST_c.get(i).Refresh(table, lb_total);
				       }
				  
				}
					
					for(int k=0;k<table.getRowCount();k++)
						  if (table.getValueAt(k, 3).equals(0)==true)
						  for(int j=0;j<LIST_c.size();j++)
						  {
							  if(LIST_c.get(j).getQuant()==0)
							  {
								 
						       model.removeRow(k);
						       table.updateUI();
						       LIST_c.get(j).PlusQuant();
						       System.out.println(k); 
						   }
					      }
			    break;
	
		case "Shake":
				for(int i=0;i<LIST_s.size();i++) {
				if(LIST_s.get(i).getName().equals(table.getValueAt(table.getSelectedRow(),1))==true)
				{
					LIST_s.get(i).SubQuant();
			        table.setValueAt(LIST_s.get(i).getQuant(),table.getSelectedRow(),3);
			        LIST_s.get(i).Refresh(table, lb_total);
			       }
			  
			}
				for(int k=0;k<table.getRowCount();k++)
					  if (table.getValueAt(k, 3).equals(0)==true)
					  for(int j=0;j<LIST_s.size();j++)
					  {
						  if(LIST_s.get(j).getQuant()==0)
						  {
							
				       model.removeRow(k);
					       table.updateUI();
					       LIST_s.get(j).PlusQuant();
					       System.out.println(k); 
					   }
				      }
		    break;
		
		case "Dessert":
			
				for(int i=0;i<LIST_d.size();i++) {
				if(LIST_d.get(i).getName().equals(table.getValueAt(table.getSelectedRow(),1))==true)
				{
					LIST_d.get(i).SubQuant();
			        table.setValueAt(LIST_d.get(i).getQuant(),table.getSelectedRow(),3);
			        LIST_d.get(i).Refresh(table, lb_total);
			       }
			  }
			
				for(int k=0;k<table.getRowCount();k++)
					  if (table.getValueAt(k, 3).equals(0)==true)
					  for(int j=0;j<LIST_d.size();j++)
					  {
						  if(LIST_d.get(j).getQuant()==0)
						  {
							  
					       model.removeRow(k);
					       table.updateUI();
					       LIST_d.get(j).PlusQuant();
					       System.out.println(k); 
					   }
				      }
		   break;
		}
		}
			
		   }
		});
		
		
		//오른쪽 증가 버튼
		bt_Right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				switch(Card_Panel.getToolTipText()) //카드 패널에서 현재 home 화면인 패널이 무엇인지 읽어옴
				{
				case "Bubble": //버블티 일경우
					System.out.println(LIST_b.size());
					if (b_start+8<LIST_b.size()) //상픔이 8개 이상인 경우
					{
					 b_start+=8; //시작점을 8~으로 
					for(int i=0;i<b_start;i++)
					  LIST_b.get(i).setVisible(false); //0~8 상품의 표시를 끈다
					 Panel_Items_Bubble.revalidate(); //패널의 화면이 변경될 시 이 작업이 없으면 표시가 되지 않음
					 Panel_Items_Bubble.repaint(); //따라서 repainting 시켜주어야 함
					 System.out.println(b_start);
					 }
				    break;
				    // 아래 case 문 또한 위와 같음
				case "Coffee":
					System.out.println(LIST_c.size());
					if (c_start+8<LIST_c.size())
					{
					 c_start+=8;
					for(int i=0;i<c_start;i++)
					  LIST_c.get(i).setVisible(false);
					 Panel_Items_Coffee.revalidate(); //패널의 화면이 변경될 시 이 작업이 없으면 표시가 되지 않음
					 Panel_Items_Coffee.repaint(); //따라서 repainting 시켜주어야 함
					 System.out.println(c_start);
					 }
					
					break;
				case "Shake":
					System.out.println(LIST_s.size());
					if (s_start+8<LIST_s.size())
					{
					 s_start+=8;
					for(int i=0;i<s_start;i++)
					  LIST_s.get(i).setVisible(false);
					 Panel_Items_Shake.revalidate(); //패널의 화면이 변경될 시 이 작업이 없으면 표시가 되지 않음
					 Panel_Items_Shake.repaint(); //따라서 repainting 시켜주어야 함
					 System.out.println(s_start);
					 }
					
					break;
				case "Dessert":
					System.out.println(LIST_d.size());
					if (d_start+8<LIST_d.size())
					{
					 d_start+=8;
					for(int i=0;i<d_start;i++)
					  LIST_d.get(i).setVisible(false);
					 Panel_Items_Dessert.revalidate(); //패널의 화면이 변경될 시 이 작업이 없으면 표시가 되지 않음
					 Panel_Items_Dessert.repaint(); //따라서 repainting 시켜주어야 함
					 System.out.println(d_start);
					 }
					
					break;
				}
		  		
		   }
		});
		//왼쪽 버튼인 경우
		bt_Left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				switch(Card_Panel.getToolTipText()) //현재 카드 패널의 home 화면을 읽어옴
				{
				case "Bubble": //버블티 화면인 경우
					System.out.println(LIST_b.size());
					if (b_start!=0) //시작점이 0이 아닌경우(=왼쪽에 표시할 상품이 있을 경우)
					{
						for(int i=b_start-8;i<b_start;i++)  //start-8~start 까지
						  LIST_b.get(i).setVisible(true); // 다시 표시해줌.
						 Panel_Items_Bubble.revalidate(); //패널의 화면이 변경될 시 이 작업이 없으면 표시가 되지 않음
						 Panel_Items_Bubble.repaint(); //따라서 repainting 시켜주어야 함
						 b_start-=8;
				    }
				    break;
				    //밑 case문은 모두 위와 같음
				case "Coffee":
					System.out.println(LIST_c.size());
					if (c_start!=0)
					{
						for(int i=c_start-8;i<c_start;i++)
						  LIST_c.get(i).setVisible(true);
						 Panel_Items_Coffee.revalidate(); //패널의 화면이 변경될 시 이 작업이 없으면 표시가 되지 않음
						 Panel_Items_Coffee.repaint(); //따라서 repainting 시켜주어야 함
						 c_start-=8;
				    }
					break;
				case "Shake":
					System.out.println(LIST_s.size());
					if (s_start!=0)
					{
						for(int i=s_start-8;i<s_start;i++)
						  LIST_s.get(i).setVisible(true);
						 Panel_Items_Shake.revalidate(); //패널의 화면이 변경될 시 이 작업이 없으면 표시가 되지 않음
						 Panel_Items_Shake.repaint(); //따라서 repainting 시켜주어야 함
						 s_start-=8;
				    }
					break;
				case "Dessert":
					System.out.println(LIST_d.size());
					if (d_start!=0)
					{
						for(int i=d_start-8;i<d_start;i++)
						  LIST_d.get(i).setVisible(true);
						 Panel_Items_Dessert.revalidate(); //패널의 화면이 변경될 시 이 작업이 없으면 표시가 되지 않음
						 Panel_Items_Dessert.repaint(); //따라서 repainting 시켜주어야 함
						 d_start-=8;
				    }
					break;
				}
		  		
		   }
		  		
		});
		
		//상품 주문 버튼 기능
		bt_Order.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if(table.getRowCount()==0) //선택한 상품이 존재하지 않는 경우
					JOptionPane.showMessageDialog(null, "상품을 선택해주세요!","미선택 오류", JOptionPane.ERROR_MESSAGE);
				else //존재 할 경우
					{
					String total = lb_total.getText();
					//현재 총 가격의 라벨의 문자열을 넘겨주고 새로운 주문 프레임을 표시.
					new Frm_Order(total);
					}
			}
		});
		
		//현재 패널에 각각 삽입.
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(MENU,BorderLayout.NORTH);
		getContentPane().add(bt_Left,BorderLayout.WEST);
		getContentPane().add(bt_Right,BorderLayout.EAST);
		getContentPane().add(Card_Panel,BorderLayout.CENTER);
		getContentPane().add(P_List,BorderLayout.SOUTH);
	}
	

}
