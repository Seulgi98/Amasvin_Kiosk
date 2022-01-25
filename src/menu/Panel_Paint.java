package menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Vector;

import javax.swing.JPanel;
//사인 기능 추가를 위한 클래스 입니다.(JPanel 상속시킴)
class Panel_Paint extends JPanel {
//마우스가 움직인 괘적을 담기 위한 Point 벡터 생성
Vector<Point> vStart = new Vector<Point>();

public Panel_Paint() {
	//배경 흰색 설정
	this.setBackground(Color.WHITE);
addKeyListener(new KeyListener() {

@Override
public void keyTyped(KeyEvent e) {
// TODO Auto-generated method stub

}

@Override
public void keyReleased(KeyEvent e) {
// TODO Auto-generated method stub

}

@Override
//enter 입력시 모두 삭제함
public void keyPressed(KeyEvent e) {
// TODO Auto-generated method stub
switch (e.getKeyCode()) {
case KeyEvent.VK_ENTER:
vStart.removeAllElements();
repaint();
break;
}
}
});

//마우스의 괘적을 벡터에 추가시키고 바로 표시함
addMouseMotionListener(new MouseMotionAdapter() {
public void mouseDragged(MouseEvent e) { 
vStart.add(e.getPoint());
repaint();
}
});
// 마우스 이벤트 처리
addMouseListener(new MouseAdapter() {
// 마우스를 누르면 호출된다.
public void mousePressed(MouseEvent e) {
vStart.add(null);
vStart.add(e.getPoint());
}
});
}

//draw 구현 메소드
public void paintComponent(Graphics g) {
super.paintComponent(g);
g.setColor(Color.BLUE); // 파란색을 선택한다.
for (int i = 1; i < vStart.size(); i++) {
if (vStart.get(i - 1) == null)
continue;
else if (vStart.get(i) == null)
continue;
else
	//저장한 벡터의 마우스 위치를 하나씩 표시해줌.
g.drawLine((int) vStart.get(i - 1).getX(), (int) vStart.get(i - 1).getY(),
(int) vStart.get(i).getX(), (int) vStart.get(i).getY());
}
}
}