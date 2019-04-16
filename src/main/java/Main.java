import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main  {
    private static final Insets insets = new Insets(0, 0, 0, 0);
    private static final int countOfCell=12;

    private static Mul logic;

    public static void main(String args[])
    {
        logic = new Mul(1,2,3,4);
        logic.run();
        final JFrame frame = new JFrame("Laba 4");
        JLabel resultLabe2=new JLabel();
        JLabel resultLabe3=new JLabel();
        JButton button =new JButton("Count");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        final JTextField[] textFieldArray=new JTextField[countOfCell];
        for(int i=0;i<countOfCell;i++)
        {
            textFieldArray[i] = new JTextField( new Integer(i).toString());
        }

        addComponent(frame, textFieldArray[0], 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, textFieldArray[1], 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame,textFieldArray[2], 0, 1,1 , 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, textFieldArray[3], 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        addComponent(frame, button, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        addComponent(frame,resultLabe2,0,2,1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, textFieldArray[4], 0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame,textFieldArray[5], 1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, textFieldArray[6], 0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, textFieldArray[7], 1, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        addComponent(frame,resultLabe3,0,5,1,1,GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, textFieldArray[8], 0, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, textFieldArray[9], 1, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame,textFieldArray[10], 0, 7,1 , 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame, textFieldArray[11], 1, 7, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);


        button.addActionListener(new ActionListener() {
            Mul a1 = null;
            Mul a2 = null;
            Mul a3 = null;
            Mul a4 = null;
            public void actionPerformed(ActionEvent e) {
                boolean contin = true;
                for (int i = 0; i <  8; i++) {
                    try {
                        Integer.parseInt(textFieldArray[i].getText());
                        textFieldArray[i].setBackground(Color.green);
                    } catch (Exception e1) {
                        textFieldArray[i].setBackground(Color.red);
                        contin = false;
                    }
                }
                if (contin) {
                    a1 = new Mul(Integer.parseInt(textFieldArray[0].getText()),Integer.parseInt(textFieldArray[1].getText()),Integer.parseInt(textFieldArray[4].getText()),Integer.parseInt(textFieldArray[6].getText()));
                    a2 =new Mul(Integer.parseInt(textFieldArray[0].getText()),Integer.parseInt(textFieldArray[1].getText()),Integer.parseInt(textFieldArray[5].getText()),Integer.parseInt(textFieldArray[7].getText()));
                    a3 = new Mul(Integer.parseInt(textFieldArray[2].getText()),Integer.parseInt(textFieldArray[3].getText()),Integer.parseInt(textFieldArray[4].getText()),Integer.parseInt(textFieldArray[6].getText()));
                    a4 =new Mul(Integer.parseInt(textFieldArray[2].getText()),Integer.parseInt(textFieldArray[3].getText()),Integer.parseInt(textFieldArray[5].getText()),Integer.parseInt(textFieldArray[7].getText()));

                    Thread t1 = new Thread(a1);
                    Thread t2 = new Thread(a2);
                    Thread t3 = new Thread(a3);
                    Thread t4 = new Thread(a4);
                    t1.start();
                    t2.start();
                    t3.start();
                    t4.start();
                    try {
                        t1.join();

                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        t2.join();

                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        t3.join();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        t4.join();
                        textFieldArray[8].setText(new Double(a1.GetResult()).toString());
                        textFieldArray[9].setText(new Double(a2.GetResult()).toString());
                        textFieldArray[10].setText(new Double(a3.GetResult()).toString());
                        textFieldArray[11].setText(new Double(a4.GetResult()).toString());
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }


                }

            }
        });
        frame.setSize(500, 200);
        frame.setVisible(true);
    }
    private static void addComponent(Container container, Component component, int gridx, int gridy,
                                     int gridwidth, int gridheight, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
                anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }
}
