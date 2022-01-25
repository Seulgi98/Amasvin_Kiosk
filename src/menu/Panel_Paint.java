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
//���� ��� �߰��� ���� Ŭ���� �Դϴ�.(JPanel ��ӽ�Ŵ)
class Panel_Paint extends JPanel {
//���콺�� ������ ������ ��� ���� Point ���� ����
Vector<Point> vStart = new Vector<Point>();

public Panel_Paint() {
	//��� ��� ����
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
//enter �Է½� ��� ������
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

//���콺�� ������ ���Ϳ� �߰���Ű�� �ٷ� ǥ����
addMouseMotionListener(new MouseMotionAdapter() {
public void mouseDragged(MouseEvent e) { 
vStart.add(e.getPoint());
repaint();
}
});
// ���콺 �̺�Ʈ ó��
addMouseListener(new MouseAdapter() {
// ���콺�� ������ ȣ��ȴ�.
public void mousePressed(MouseEvent e) {
vStart.add(null);
vStart.add(e.getPoint());
}
});
}

//draw ���� �޼ҵ�
public void paintComponent(Graphics g) {
super.paintComponent(g);
g.setColor(Color.BLUE); // �Ķ����� �����Ѵ�.
for (int i = 1; i < vStart.size(); i++) {
if (vStart.get(i - 1) == null)
continue;
else if (vStart.get(i) == null)
continue;
else
	//������ ������ ���콺 ��ġ�� �ϳ��� ǥ������.
g.drawLine((int) vStart.get(i - 1).getX(), (int) vStart.get(i - 1).getY(),
(int) vStart.get(i).getX(), (int) vStart.get(i).getY());
}
}
}