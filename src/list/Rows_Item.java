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

//아이템 객체를 만들기 위한 클래스입니다
public class Rows_Item extends JPanel{
	private int Quant=1; //수량
	private String Name;
   DecimalFormat formatter = new DecimalFormat("###,###");  //돈 표시를 위함
	 public void Refresh(JTable table, JLabel total) //총가격 새로고침
	   {
		 int tmp=0;
		   for(int i=0;i<table.getRowCount();i++)
			  tmp+=(int)table.getValueAt(i,3)*(int)table.getValueAt(i,2); //수량 x 가격
	        total.setText("총액 : " + formatter.format(tmp) +"원"); //라벨 표시
			   
	   }

	public int getQuant() { //수량 불러오기
		return Quant;
	}
	
	public void setName(String name) { //이름 설정
		this.Name=name;
	}
	
	public String getName() { //이름 불러오기
		return Name;
	}

	public void PlusQuant() { //상품 갯수 +
		Quant++;
	}
	public void SubQuant() { //상품 갯수 -
		Quant--;
		
	}
	
	//테이블 내 라벨 가운데 정렬을 위한 메소드 입니다.
   public void tableCellCenter(JTable t) {
	   DefaultTableCellRenderer dtcr= new DefaultTableCellRenderer();
	   dtcr.setHorizontalAlignment(SwingConstants.CENTER);
	   TableColumnModel tcm = t.getColumnModel();
	   for(int i=0;i<tcm.getColumnCount();i++) { //각 rows에 대해 적용
		   tcm.getColumn(i).setCellRenderer(dtcr);
	   }
   }
   
  
	public Rows_Item(JPanel columnpanel,JTable table,JLabel total,String Sort,String Item_name,int index, int Price) {
		//이미지를 불러옵니다(images//index//아이템이름.png)
		ImageIcon OIcon = new ImageIcon(System.getProperty("user.dir")+"//src//images//"+index+"//"+Item_name+".png");
		Image OImg = OIcon.getImage();
		Image CImg = OImg.getScaledInstance(180, 160, Image.SCALE_SMOOTH); //크기 조절
		ImageIcon Icon = new ImageIcon(CImg);
		Font ft_Item = new Font("돋움",Font.BOLD,10); //폰트 설정
	    JButton bt_Item = new JButton(Icon); //이미지 삽입
	    bt_Item.setBorderPainted(false); //테두리 없앰
	    bt_Item.setFocusPainted(false); //focus 테두리 없앰
	    bt_Item.setBackground(Color.white); 
         this.setBackground(Color.white); //색상지정
	     JLabel lb_name = new JLabel(Item_name);
	     lb_name.setFont(ft_Item); //폰트 지정
	     JLabel lb_price = new JLabel(" " + Price + " "); //가격 삽입
	     lb_price.setFont(ft_Item); //폰트 지정
	     this.setPreferredSize(new Dimension(200,200)); //크기 조절
	     this.add(bt_Item);
	     this.add(lb_name);
	     this.add(lb_price);
	     columnpanel.add(this);
	     
	     setName(Item_name);
	     tableCellCenter(table);
	     
	     //버튼 선택 시 
	     bt_Item.addMouseListener(new MouseListener(){
	    		   @Override
	               public void mouseClicked(MouseEvent e) {	
	    			   int check=1; //새로운 것인지 확인
	    			  for(int i=0;i<table.getRowCount();i++)
	    			   if (table.getValueAt(i,1).equals(Item_name)==true)
	    				   {  //이미 있는 것이라면 테이블에 수량을 추가한다.
	    				     System.out.println(table.getValueAt(i,1));
	    				     check=0;
	    				     PlusQuant();
	    				     table.setValueAt(getQuant(),i,3);
	    				   }
	    			   
	    			   if (check==1) //새로운 것이라면
	    				   {
	    				   
	    				   DefaultTableModel m = (DefaultTableModel)table.getModel();
				           //모델에 데이터 추가 , 1번째 출에 새로운 데이터를 추가합니다
				           m.insertRow(0, new Object[]{Sort,Item_name,Price,getQuant()});
				           //추가를 마치고 데이터 갱신을 알립니다.
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
