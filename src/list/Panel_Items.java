package list;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

//아이템을 만들기 위해 아이템 리스트를 불러오는 클래스입니다.
public class Panel_Items {
	public Panel_Items(ArrayList<Rows_Item> LIST,JPanel Panel_Main ,JTable table,JLabel total,String sort,int index) {
	String[] lists = new String[22]; //아이템 정보 저장을 위한 lists 필드
	for(int i=0;i<lists.length;i++)
	   lists[i]="/"; // 초기화 작업
	new List_items(index,lists); //저장되 있는 아이템 리스트를 불러옵니다
	
	JPanel RowsPanel = new JPanel(); //아이템 표시를 위한 Panel
	RowsPanel.setPreferredSize(new Dimension(100,150)); //크기 설정
	Panel_Main.setLayout(new FlowLayout()); //레이아웃 설정
	Panel_Main.setBackground(Color.white); //색상 설정
	
	String name,price; //이름, 가격 처리
	for(int i=0;i<lists.length;i++)
	 {
		if (!lists[i].equals("/"))
		{
		  name = lists[i].split("/")[0]; //문자열 파싱 / 기준
		  price = lists[i].split("/")[1];
		  Rows_Item RI = new Rows_Item(Panel_Main,table,total,sort,name,index,Integer.parseInt(price)); //아이템 추가 객체 생성	
		  LIST.add(RI);
		}
	 }
	}
}
