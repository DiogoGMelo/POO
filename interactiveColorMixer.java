// Raphael Monteiro Consoni Bonaccorsi - 12563366
// Diogo Gianezi de Melo - 12563522

package com.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

public class interactiveColorMixer {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Interactive Color Mixer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        // Create three JSlider components
        JSlider redSlider = new JSlider(0, 255);
        JSlider greenSlider = new JSlider(0, 255);
        JSlider blueSlider = new JSlider(0, 255);

        // Create three JLabel components
        JLabel redLabel = new JLabel("Red: " + redSlider.getValue());
        JLabel greenLabel = new JLabel("Green: " + greenSlider.getValue());
        JLabel blueLabel = new JLabel("Blue: " + blueSlider.getValue());

        // Create a JButton
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Set the value of all sliders to the predefined position
                redSlider.setValue(128);
                greenSlider.setValue(128);
                blueSlider.setValue(128);
            }
        });

        // Create a JPanel for the reset button and add the button to it
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resetButton);

        // Create a JPanel to hold the sliders and labels
        JPanel sliderPanel = new JPanel(new GridLayout(3, 2)); // Use GridLayout
        sliderPanel.add(redLabel);
        sliderPanel.add(redSlider);
        sliderPanel.add(greenLabel);
        sliderPanel.add(greenSlider);
        sliderPanel.add(blueLabel);
        sliderPanel.add(blueSlider);

        // Add the slider panel and the button panel to the frame
        frame.add(sliderPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH); // Add the button panel to the south area of the frame
        // Create a JPanel to display the color
        JPanel colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(500, 400)); // Set the preferred size
        frame.add(colorPanel, BorderLayout.CENTER); // Add the color panel to the center of the frame

        // Add a MouseListener to the color panel
        colorPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Print a message when the mouse is clicked
                System.out.println("Mouse clicked at: " + e.getX() + ", " + e.getY());
            }

            public void mouseEntered(MouseEvent e) {
                // Print a message when the mouse enters the color panel
                System.out.println("Mouse entered the color panel");
            }

            public void mouseExited(MouseEvent e) {
                // Print a message when the mouse leaves the color panel
                System.out.println("Mouse exited the color panel");
            }
        });

        // Add a MouseMotionListener to the color panel
        colorPanel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                // Print the mouse's x and y position while it's within the color panel
                System.out.println("Mouse moved at: " + e.getX() + ", " + e.getY());
            }
        });

        // Add the slider panel to the frame
        frame.add(sliderPanel, "North");
        
        // Add a change listener to each slider
        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // Get the value of the sliders
                int redValue = redSlider.getValue();
                int greenValue = greenSlider.getValue();
                int blueValue = blueSlider.getValue();
                
                // Set the text of the labels to the new values
                redLabel.setText("Red: " + redValue);
                greenLabel.setText("Green: " + greenValue);
                blueLabel.setText("Blue: " + blueValue);
                
                // Set the background color of the color panel
                colorPanel.setBackground(new Color(redValue, greenValue, blueValue));
                
                // Print the values in the terminal
                System.out.println("Red: " + redValue + ", Green: " + greenValue + ", Blue: " + blueValue);
            }
        };
        
        redSlider.addChangeListener(changeListener);
        greenSlider.addChangeListener(changeListener);
        blueSlider.addChangeListener(changeListener);
        
        frame.setVisible(true);
    }
}