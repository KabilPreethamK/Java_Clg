import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightDemo extends JFrame {
    private JPanel trafficLightPanel;
    private JButton redButton, yellowButton, greenButton;

    public TrafficLightDemo() {
        setTitle("Traffic Light Simulation");
        setSize(200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        trafficLightPanel = new JPanel();
        trafficLightPanel.setBackground(Color.black);
        add(trafficLightPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        redButton = new JButton("Red");
        yellowButton = new JButton("Yellow");
        greenButton = new JButton("Green");

        redButton.addActionListener(new ButtonClickListener(Color.RED));
        yellowButton.addActionListener(new ButtonClickListener(Color.YELLOW));
        greenButton.addActionListener(new ButtonClickListener(Color.GREEN));

        buttonPanel.add(redButton);
        buttonPanel.add(yellowButton);
        buttonPanel.add(greenButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        private Color lightColor;

        public ButtonClickListener(Color color) {
            this.lightColor = color;
        }

        public void actionPerformed(ActionEvent e) {
            if (lightColor == Color.RED) {
                trafficLightPanel.setBackground(Color.RED);
            } else if (lightColor == Color.YELLOW) {
                trafficLightPanel.setBackground(Color.YELLOW);
            } else if (lightColor == Color.GREEN) {
                trafficLightPanel.setBackground(Color.GREEN);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TrafficLightDemo();
            }
        });
    }
}
