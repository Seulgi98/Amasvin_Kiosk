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

//���� �������� ���� Ŭ�����Դϴ�
public class Myframe extends JFrame {
	int b_start=0; //����Ƽ ǥ�� ������
	int c_start=0; //Ŀ�� ǥ�� ������
	int s_start=0; //����ũ ǥ�� ������
	int d_start=0; //����Ʈ ǥ�� ������
	
	public Myframe() {
	     //â �̸� ����
		setTitle("\uC544\uB9C8\uC2A4\uBE48 \uD0A4\uC624\uC2A4\uD06C");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,960,650);
		//�� �з��� �������� ��� ����Ʈ�� ����
		ArrayList<Rows_Item> LIST_b= new ArrayList<Rows_Item>();
		ArrayList<Rows_Item> LIST_c= new ArrayList<Rows_Item>();
		ArrayList<Rows_Item> LIST_s= new ArrayList<Rows_Item>();
		ArrayList<Rows_Item> LIST_d= new ArrayList<Rows_Item>();
		///////////////////////////////////////////////////////////////
		JPanel Card_Panel = new JPanel();  //CardPanel �� ���� JPanel ����
		CardLayout Cd = new CardLayout(); //CradPanel ����

		//���� �����ӿ� �߰�
		//JTabel ���� �κ�
		String header[]= {"�з�","��ǰ��","��ǰ ����","����"};
		String contents[][]=null;
		DefaultTableModel model = new DefaultTableModel(contents,header);
		JTable table = new JTable(model);
		//���� ��� ����
		table.setSelectionMode(0);
		table.setBackground(Color.WHITE);
		
		JScrollPane scrollpane = new JScrollPane(table);
		JPanel Panel_Items_Bubble = new JPanel(); //����Ƽ Panel
		JPanel Panel_Items_Coffee = new JPanel(); //Ŀ�� Panel
		JPanel Panel_Items_Shake = new JPanel(); //����ũ Panel
		JPanel Panel_Items_Dessert = new JPanel(); //����Ʈ Panel
		
		///���̵� ��ư ����
				Color Cr_Menu = new Color(247,240,172); //���� ����
				Font ft_Item = new Font("����",Font.BOLD,10); //��Ʈ ����
				JButton bt_Left = new JButton("<");
				JButton bt_Right = new JButton(">");
				JButton bt_Plus = new JButton("+");
				JButton bt_Sub = new JButton("-");
				JButton bt_Order = new JButton("�ֹ�");
				JLabel lb_total = new JLabel("�ֹ��� ���ּ���!");
				
		//Panel�� ������ �ҷ�����(��� ����Ʈ,Panel��,���̺�,�Ѱ��� ��,�з�, �޴� �ε���)
		new Panel_Items(LIST_b,Panel_Items_Bubble,table,lb_total,"Bubble", 0);
		new Panel_Items(LIST_c,Panel_Items_Coffee,table,lb_total,"Coffee", 1);
		new Panel_Items(LIST_s,Panel_Items_Shake,table,lb_total,"Shake", 2);
	    new Panel_Items(LIST_d,Panel_Items_Dessert,table,lb_total,"Dessert",3);
		
	    Card_Panel.setLayout(Cd); //ī�巹�̾ƿ� ����
	    Card_Panel.setToolTipText("Bubble"); //ù �г��� �������� ����
	    //ī�带 �� �߰����־����ϴ�.
		Card_Panel.add(Panel_Items_Bubble,"Bubble");
		Card_Panel.add(Panel_Items_Coffee,"Coffee");
		Card_Panel.add(Panel_Items_Shake,"Shake");
		Card_Panel.add(Panel_Items_Dessert,"Dessert");
		
		
		bt_Left.setFont(ft_Item); //��Ʈ ����
		bt_Right.setFont(ft_Item);//��Ʈ ����
		bt_Left.setBorderPainted(false); //�׵θ� ����
		bt_Left.setFocusPainted(false); //�µθ� focus ����
		bt_Right.setBorderPainted(false); //�׵θ� ����
		bt_Right.setFocusPainted(false); //�µθ� focus ����
	
		bt_Plus.setFocusPainted(false); //�µθ� focus ����
		
		bt_Sub.setFocusPainted(false); //�µθ� focus ����
		
		bt_Order.setFocusPainted(false); //�µθ� focus ����
		bt_Left.setBackground(Cr_Menu); //���� ����
		bt_Right.setBackground(Cr_Menu); //���� ����
		bt_Plus.setBackground(Cr_Menu); //���� ����
		bt_Sub.setBackground(Cr_Menu); //���� ����
		bt_Order.setBackground(Cr_Menu); //���� ����
	    
		///�޴� Panel ����
		Panel_Menu MENU = new Panel_Menu(Card_Panel,Cd);
		
		JPanel P_List = new JPanel();
		
		//�� ���� ��ġ ���� �� �гο� �߰�
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
		
		// ��ǰ �߰� ��ư ���
		bt_Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow()>=0) //���̺� ��ǰ�� �ִٸ�
				{
					//������ ����Ʈ�� �з��� ������
				  String tmp = (String) table.getValueAt(table.getSelectedRow(),0);
				switch(tmp) //�з� Ȯ��
				{
				case "Bubble": //����Ƽ �� ���
					
						for(int i=0;i<LIST_b.size();i++) { //����Ƽ�� ��� ��ǰ ��
						if(LIST_b.get(i).getName().equals(table.getValueAt(table.getSelectedRow(),1))==true)
						{ 
							//������ ���� �ִٸ� �� ��ü�� ������ ���� ��Ŵ
							LIST_b.get(i).PlusQuant();
							//���̺� �߰� ��Ŵ
					       table.setValueAt(LIST_b.get(i).getQuant(),table.getSelectedRow(),3);
					       //�� ���� ���ΰ�ħ ����
					       LIST_b.get(i).Refresh(table, lb_total);
					       }
					  }
				    break;
				    
				    //�ؿ� �ִ� case �� ���� ���� ������.
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
		
		//��ǰ ���� ��ư ��� 
		bt_Sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//���̺� ��ǰ�� ���� ���� ��� ����
				if (table.getSelectedRow()>=0)
				{
					//������ ����Ʈ�� ��ǰ �з� ����
				String tmp = (String) table.getValueAt(table.getSelectedRow(),0);
				switch(tmp)
				{
				case "Bubble": //����Ƽ �� ���
						for(int i=0;i<LIST_b.size();i++) { //����Ƽ ��ü����
						if(LIST_b.get(i).getName().equals(table.getValueAt(table.getSelectedRow(),1))==true)
						{ //���̺��� ������ �̸��� ���� ��ü�� ã�Ƴ�
						   LIST_b.get(i).SubQuant(); //�ش� ��ü�� ���� ����
						   //���̺� ǥ��
						   table.setValueAt(LIST_b.get(i).getQuant(),table.getSelectedRow(),3);
					       //�� ���� ���ΰ�ħ
						   LIST_b.get(i).Refresh(table, lb_total);
					    }
						}
						
						//���̺��� ��ü ��ǰ�� �߿���
						for(int k=0;k<table.getRowCount();k++)
							//��ǰ�� ������ 0�� ���� ������Ű�� ���� ã�ƺ�
						  if (table.getValueAt(k, 3).equals(0)==true) 
							  //ã�� �� �� ��̸���Ʈ���� �ش� ��ü�� ã�ƺ�
						  for(int j=0;j<LIST_b.size();j++)
						  {
							  System.out.println(j); 
							 //�ش� ��ü�� ������ 0�� ���� Ȯ���ϰ�
							  if(LIST_b.get(j).getQuant()==0)
							  {
								  //���̺��� ������.
								  //��̸���Ʈ�� �����ϸ� �ȵ�.
						       model.removeRow(k);
						       table.updateUI();
						       //���� ���� ��Ŵ (=�ʱ�ȭ 1�̹Ƿ� �ϳ� ����)
						       LIST_b.get(j).PlusQuant();
						       //System.out.println(k); 
						   }
					      }
						
					  
					
				    break;
				    //�Ʒ� case ���� ���� ����.
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
		
		
		//������ ���� ��ư
		bt_Right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				switch(Card_Panel.getToolTipText()) //ī�� �гο��� ���� home ȭ���� �г��� �������� �о��
				{
				case "Bubble": //����Ƽ �ϰ��
					System.out.println(LIST_b.size());
					if (b_start+8<LIST_b.size()) //������ 8�� �̻��� ���
					{
					 b_start+=8; //�������� 8~���� 
					for(int i=0;i<b_start;i++)
					  LIST_b.get(i).setVisible(false); //0~8 ��ǰ�� ǥ�ø� ����
					 Panel_Items_Bubble.revalidate(); //�г��� ȭ���� ����� �� �� �۾��� ������ ǥ�ð� ���� ����
					 Panel_Items_Bubble.repaint(); //���� repainting �����־�� ��
					 System.out.println(b_start);
					 }
				    break;
				    // �Ʒ� case �� ���� ���� ����
				case "Coffee":
					System.out.println(LIST_c.size());
					if (c_start+8<LIST_c.size())
					{
					 c_start+=8;
					for(int i=0;i<c_start;i++)
					  LIST_c.get(i).setVisible(false);
					 Panel_Items_Coffee.revalidate(); //�г��� ȭ���� ����� �� �� �۾��� ������ ǥ�ð� ���� ����
					 Panel_Items_Coffee.repaint(); //���� repainting �����־�� ��
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
					 Panel_Items_Shake.revalidate(); //�г��� ȭ���� ����� �� �� �۾��� ������ ǥ�ð� ���� ����
					 Panel_Items_Shake.repaint(); //���� repainting �����־�� ��
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
					 Panel_Items_Dessert.revalidate(); //�г��� ȭ���� ����� �� �� �۾��� ������ ǥ�ð� ���� ����
					 Panel_Items_Dessert.repaint(); //���� repainting �����־�� ��
					 System.out.println(d_start);
					 }
					
					break;
				}
		  		
		   }
		});
		//���� ��ư�� ���
		bt_Left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				switch(Card_Panel.getToolTipText()) //���� ī�� �г��� home ȭ���� �о��
				{
				case "Bubble": //����Ƽ ȭ���� ���
					System.out.println(LIST_b.size());
					if (b_start!=0) //�������� 0�� �ƴѰ��(=���ʿ� ǥ���� ��ǰ�� ���� ���)
					{
						for(int i=b_start-8;i<b_start;i++)  //start-8~start ����
						  LIST_b.get(i).setVisible(true); // �ٽ� ǥ������.
						 Panel_Items_Bubble.revalidate(); //�г��� ȭ���� ����� �� �� �۾��� ������ ǥ�ð� ���� ����
						 Panel_Items_Bubble.repaint(); //���� repainting �����־�� ��
						 b_start-=8;
				    }
				    break;
				    //�� case���� ��� ���� ����
				case "Coffee":
					System.out.println(LIST_c.size());
					if (c_start!=0)
					{
						for(int i=c_start-8;i<c_start;i++)
						  LIST_c.get(i).setVisible(true);
						 Panel_Items_Coffee.revalidate(); //�г��� ȭ���� ����� �� �� �۾��� ������ ǥ�ð� ���� ����
						 Panel_Items_Coffee.repaint(); //���� repainting �����־�� ��
						 c_start-=8;
				    }
					break;
				case "Shake":
					System.out.println(LIST_s.size());
					if (s_start!=0)
					{
						for(int i=s_start-8;i<s_start;i++)
						  LIST_s.get(i).setVisible(true);
						 Panel_Items_Shake.revalidate(); //�г��� ȭ���� ����� �� �� �۾��� ������ ǥ�ð� ���� ����
						 Panel_Items_Shake.repaint(); //���� repainting �����־�� ��
						 s_start-=8;
				    }
					break;
				case "Dessert":
					System.out.println(LIST_d.size());
					if (d_start!=0)
					{
						for(int i=d_start-8;i<d_start;i++)
						  LIST_d.get(i).setVisible(true);
						 Panel_Items_Dessert.revalidate(); //�г��� ȭ���� ����� �� �� �۾��� ������ ǥ�ð� ���� ����
						 Panel_Items_Dessert.repaint(); //���� repainting �����־�� ��
						 d_start-=8;
				    }
					break;
				}
		  		
		   }
		  		
		});
		
		//��ǰ �ֹ� ��ư ���
		bt_Order.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				if(table.getRowCount()==0) //������ ��ǰ�� �������� �ʴ� ���
					JOptionPane.showMessageDialog(null, "��ǰ�� �������ּ���!","�̼��� ����", JOptionPane.ERROR_MESSAGE);
				else //���� �� ���
					{
					String total = lb_total.getText();
					//���� �� ������ ���� ���ڿ��� �Ѱ��ְ� ���ο� �ֹ� �������� ǥ��.
					new Frm_Order(total);
					}
			}
		});
		
		//���� �гο� ���� ����.
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(MENU,BorderLayout.NORTH);
		getContentPane().add(bt_Left,BorderLayout.WEST);
		getContentPane().add(bt_Right,BorderLayout.EAST);
		getContentPane().add(Card_Panel,BorderLayout.CENTER);
		getContentPane().add(P_List,BorderLayout.SOUTH);
	}
	

}
