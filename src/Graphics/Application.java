package Graphics;

import javax.swing.JFrame;

public class Application {

    private JFrame window;
    private ContentPanel cpanel;

    public Application()
    {
        window.setTitle("Visualization");
        window.setSize(1280, 720);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cpanel = new ContentPanel();
    }
}
