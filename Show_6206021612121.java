import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Show_6206021612121 extends JFrame implements KeyListener, ActionListener {
    private int width, height;
    private JButton startBtn, stopBtn,redBtn, greenBtn, blueBtn, clearBtn,randomBtn;
    private int xMin, xMax, yMin, yMax;
    private int x, y, size, xSpeed, ySpeed;
    Timer swTimer;
    private Color color;
    private JPanel area1, area2;

    public Show_6206021612121() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        area1 = new JPanel();
        area1.setPreferredSize(new Dimension(750, 70));
        area1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));

        area2 = new JPanel();
        area2.setPreferredSize(new Dimension(750, 430));
        area2.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));

        startBtn = new JButton("Start");
        startBtn.addActionListener(this);
        startBtn.addKeyListener(this);
        c.add(startBtn);

        stopBtn = new JButton("Stop");
        stopBtn.addActionListener(this);
        stopBtn.addKeyListener(this);
        c.add(stopBtn);

        redBtn = new JButton("Red");
        redBtn.addActionListener(this);
        redBtn.addKeyListener(this);
        c.add(redBtn);

        greenBtn = new JButton("Green");
        greenBtn.addActionListener(this);
        greenBtn.addKeyListener(this);
        c.add(greenBtn);

        blueBtn = new JButton("Blue");
        blueBtn.addActionListener(this);
        blueBtn.addKeyListener(this);
        c.add(blueBtn);

        randomBtn = new JButton("Random");
        randomBtn.addActionListener(this);
        randomBtn.addKeyListener(this);
        c.add(randomBtn);

    

        color = Color.BLACK;

        width = 430;
        height = 700;
        xMin = 2;
        xMax = 700;
        yMin = 100;
        yMax = 430;
        xSpeed = 1; //2
        ySpeed = 1; //2
        x = 240;
        y = 160;
        size = 40;
        swTimer = new Timer(10, this);

        area1.add(startBtn);
        area1.add(stopBtn);
        area1.add(redBtn);
        area1.add(greenBtn);
        area1.add(blueBtn);
        area1.add(randomBtn);

        c.add(area1);
        c.add(area2);

    }

    public void paint(Graphics g) {
        super.paint(g);
        
        g.setColor(Color.black);
        g.fillRect(x, y, size, size);
        g.setColor(color);
    }

    public void keyPressed(KeyEvent event) {
        if (event.getKeyChar() == 'p')
            swTimer.start();
        else if (event.getKeyChar() == 's')
            swTimer.stop();
    }

    public void keyReleased(KeyEvent event) {
    }

    public void keyTyped(KeyEvent event) {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn)
            swTimer.start();
        else if (e.getSource() == stopBtn)
            swTimer.stop();
        else if (e.getSource() == redBtn)
            color = Color.RED;
        else if (e.getSource() == greenBtn)
            color = Color.GREEN;
        else if (e.getSource() == blueBtn)
            color = Color.BLUE;
        else {
            move();
            repaint();
        }
    }

    public void clear(Graphics g) {
        repaint();
        g.setColor(this.getBackground());
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void move() {
        x = x + xSpeed;
        y = y + ySpeed;
        if (x < xMin) {
            x = xMin;
            xSpeed = -xSpeed;
        } else if (x + size > xMax) {
            x = xMax - size;
            xSpeed = -xSpeed;
        }
        if (y < yMin) {
            y = yMin;
            ySpeed = -ySpeed;
        } else if (y + size > yMax) {
            y = yMax - size;
            ySpeed = -ySpeed;
        }
    }

    public static void main(String[] args) {
        Show_6206021612121 window = new Show_6206021612121();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}