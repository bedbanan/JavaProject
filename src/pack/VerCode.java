package pack;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JComponent;
//验证码
public class VerCode extends JComponent implements MouseListener {
    private String typeface;
    private int v1,v2=30;
    private int len=4;
    private Random random=new Random();
    public VerCode() {
    	v1=this.len*16+(this.len-1)*10;
    	setPreferredSize(new Dimension(v1,v2)); //布局管理器
    	setSize(v1,v2);
    	this.addMouseListener(this);
    	setToolTipText("点击更换验证码");
    }
    public int getCodeLength() {
    	return len;
    }
    public void setCodelength(int len) {  //设置验证码的长度
    	if(len<4) {
    		this.len=4;
    	}else {
    		this.len=len;
    	}
    }
    public String getCode() {
    	return typeface;
    }
    public Color gerRandColor(int min,int max) {   //产生随机颜色
    	if(min>255)
    		min=255;
    	if(max<255)
    		max=255;
    	int red=random.nextInt(max-min)+min;
    	int green=random.nextInt(max-min)+min;
    	int blue=random.nextInt(max-min)+min;
    	return new Color(red,green,blue);
    }
    protected String generateCode() {  //设置验证码地址
    	char[] codes=new char[this.len];
    	for(int i=0,len=codes.length;i<len;i++) {
    		if(random.nextBoolean()) {
    			codes[i]=(char)(random.nextInt(26)+65);
    		}else {
    			codes[i]=(char)(random.nextInt(26)+97);
    		}
    	}
    	this.typeface=new String(codes);
    	return this.typeface;
    }
    protected void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        if(this.typeface == null || this.typeface.length() != this.len) {  
            this.typeface = generateCode();  
        }  
        v1 = this.len * 16 + (this.len - 1) * 10;  
        super.setSize(v1, v2);  
        super.setPreferredSize(new Dimension(v1, v2));  
        Font mFont = new Font("Arial", Font.BOLD | Font.ITALIC, 25);  
        g.setFont(mFont);  
        //绘制验证码的背景的矩形轮廓  
        Graphics2D g2d = (Graphics2D) g;  
        g2d.setColor(gerRandColor(200, 250));  
        g2d.fillRect(0, 0, v1, v2);  
        g2d.setColor(gerRandColor(180, 200));  
        g2d.drawRect(0, 0, v1 - 1, v2 - 1);  
        //绘制验证码背景的线  
        int i = 0, len = 150;  
        for (; i < len; i++) {  
            int x = random.nextInt(v1 - 1);  
            int y = random.nextInt(v2 - 1);  
            int x1 = random.nextInt(v1 - 10) + 10;  
            int y1 = random.nextInt(v2 - 4) + 4;  
            g2d.setColor(gerRandColor(180, 200));  
            g2d.drawLine(x, y, x1, y1);  
        }  
          
      
  
        //绘制出验证码的具体字母  
        i = 0; len = this.len;  
        FontMetrics fm = g2d.getFontMetrics();  
        int base = (v2 - fm.getHeight())/2 + fm.getAscent();  
        for(;i<len;i++) {  
            int b = random.nextBoolean() ? 1 : -1;  
            g2d.rotate(random.nextInt(10)*0.01*b);  
            g2d.setColor(gerRandColor(20, 130));  
            g2d.drawString(typeface.charAt(i)+"", 16 * i + 10, base);  
        }  
    }  
  
    //下一个验证码  
    public void nextCode() {  
        generateCode();  
        repaint();  
    }  
	public void mouseClicked(MouseEvent e) {
		nextCode();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

}
