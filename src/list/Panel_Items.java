package list;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

//�������� ����� ���� ������ ����Ʈ�� �ҷ����� Ŭ�����Դϴ�.
public class Panel_Items {
	public Panel_Items(ArrayList<Rows_Item> LIST,JPanel Panel_Main ,JTable table,JLabel total,String sort,int index) {
	String[] lists = new String[22]; //������ ���� ������ ���� lists �ʵ�
	for(int i=0;i<lists.length;i++)
	   lists[i]="/"; // �ʱ�ȭ �۾�
	new List_items(index,lists); //����� �ִ� ������ ����Ʈ�� �ҷ��ɴϴ�
	
	JPanel RowsPanel = new JPanel(); //������ ǥ�ø� ���� Panel
	RowsPanel.setPreferredSize(new Dimension(100,150)); //ũ�� ����
	Panel_Main.setLayout(new FlowLayout()); //���̾ƿ� ����
	Panel_Main.setBackground(Color.white); //���� ����
	
	String name,price; //�̸�, ���� ó��
	for(int i=0;i<lists.length;i++)
	 {
		if (!lists[i].equals("/"))
		{
		  name = lists[i].split("/")[0]; //���ڿ� �Ľ� / ����
		  price = lists[i].split("/")[1];
		  Rows_Item RI = new Rows_Item(Panel_Main,table,total,sort,name,index,Integer.parseInt(price)); //������ �߰� ��ü ����	
		  LIST.add(RI);
		}
	 }
	}
}
