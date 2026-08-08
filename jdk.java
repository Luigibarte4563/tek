import javax.swing.JFrame;

public class jdk{
    
    private JFrame window;

public MainWindow() {}

window= new JFrame();

window.setTitle(title: "hello world");

window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

window.setSize(width: 800, height:500);

window.setLocation(p:null);

public void show(){

window.setVisible(true);
}

