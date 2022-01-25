package list;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

//������ ��ü�� ����� ���� Ŭ�����Դϴ�
public class Rows_Item extends JPanel{
	private int Quant=1; //����
	private String Name;
   DecimalFormat formatter = new DecimalFormat("###,###");  //�� ǥ�ø� ����
	 public void Refresh(JTable table, JLabel total) //�Ѱ��� ���ΰ�ħ
	   {
		 int tmp=0;
		   for(int i=0;i<table.getRowCount();i++)
			  tmp+=(int)table.getValueAt(i,3)*(int)table.getValueAt(i,2); //���� x ����
	        total.setText("�Ѿ� : " + formatter.format(tmp) +"��"); //�� ǥ��
			   
	   }

	public int getQuant() { //���� �ҷ�����
		return Quant;
	}
	
	public void setName(String name) { //�̸� ����
		this.Name=name;
	}
	
	public String getName() { //�̸� �ҷ�����
		return Name;
	}

	public void PlusQuant() { //��ǰ ���� +
		Quant++;
	}
	public void SubQuant() { //��ǰ ���� -
		Quant--;
		
	}
	
	//���̺� �� �� ��� ������ ���� �޼ҵ� �Դϴ�.
   public void tableCellCenter(JTable t) {
	   DefaultTableCellRenderer dtcr= new DefaultTableCellRenderer();
	   dtcr.setHorizontalAlignment(SwingConstants.CENTER);
	   TableColumnModel tcm = t.getColumnModel();
	   for(int i=0;i<tcm.getColumnCount();i++) { //�� rows�� ���� ����
		   tcm.getColumn(i).setCellRenderer(dtcr);
	   }
   }
   
  
	public Rows_Item(JPanel columnpanel,JTable table,JLabel total,String Sort,String Item_name,int index, int Price) {
		//�̹����� �ҷ��ɴϴ�(images//index//�������̸�.png)
		ImageIcon OIcon = new ImageIcon(System.getProperty("user.dir")+"//src//images//"+index+"//"+Item_name+".png");
		Image OImg = OIcon.getImage();
		Image CImg = OImg.getScaledInstance(180, 160, Image.SCALE_SMOOTH); //ũ�� ����
		ImageIcon Icon = new ImageIcon(CImg);
		Font ft_Item = new Font("����",Font.BOLD,10); //��Ʈ ����
	    JButton bt_Item = new JButton(Icon); //�̹��� ����
	    bt_Item.setBorderPainted(false); //�׵θ� ����
	    bt_Item.setFocusPainted(false); //focus �׵θ� ����
	    bt_Item.setBackground(Color.white); 
         this.setBackground(Color.white); //��������
	     JLabel lb_name = new JLabel(Item_name);
	     lb_name.setFont(ft_Item); //��Ʈ ����
	     JLabel lb_price = new JLabel(" " + Price + " "); //���� ����
	     lb_price.setFont(ft_Item); //��Ʈ ����
	     this.setPreferredSize(new Dimension(200,200)); //ũ�� ����
	     this.add(bt_Item);
	     this.add(lb_name);
	     this.add(lb_price);
	     columnpanel.add(this);
	     
	     setName(Item_name);
	     tableCellCenter(table);
	     
	     //��ư ���� �� 
	     bt_Item.addMouseListener(new MouseListener(){
	    		   @Override
	               public void mouseClicked(MouseEvent e) {	
	    			   int check=1; //���ο� ������ Ȯ��
	    			  for(int i=0;i<table.getRowCount();i++)
	    			   if (table.getValueAt(i,1).equals(Item_name)==true)
	    				   {  //�̹� �ִ� ���̶�� ���̺� ������ �߰��Ѵ�.
	    				     System.out.println(table.getValueAt(i,1));
	    				     check=0;
	    				     PlusQuant();
	    				     table.setValueAt(getQuant(),i,3);
	    				   }
	    			   
	    			   if (check==1) //���ο� ���̶��
	    				   {
	    				   
	    				   DefaultTableModel m = (DefaultTableModel)table.getModel();
				           //�𵨿� ������ �߰� , 1��° �⿡ ���ο� �����͸� �߰��մϴ�
				           m.insertRow(0, new Object[]{Sort,Item_name,Price,getQuant()});
				           //�߰��� ��ġ�� ������ ������ �˸��ϴ�.
				           table.updateUI();
				           }
	    			   Refresh(table,total);
	                     }

	               @Override
	               public void mouseEntered(MouseEvent e) {
	            	   bt_Item.setBackground(new Color(247,240,172));
	               }

	               @Override
	               public void mouseExited(MouseEvent e) {
	            	   bt_Item.setBackground(Color.WHITE);
	               }

	               @Override
	               public void mousePressed(MouseEvent e) {

	               }

	               @Override
	               public void mouseReleased(MouseEvent e) {
	               }
	          });
     }
}
