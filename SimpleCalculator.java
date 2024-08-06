package POO2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * SimpleCalculator é uma aplicação GUI básica em Java que realiza
 * operações aritméticas como adição, subtração, multiplicação e 
 * divisão em dois números de entrada fornecidos pelo usuário. Permite 
 * que o usuário insira dois números, selecione uma operação e exibe o 
 * resultado. O tratamento de erros é implementado para entradas inválidas
 * e divisão por zero.
 * 
 * Desafios:
 * - Implementar a interface ActionListener para lidar com cliques de botão
 * - Lidar com exceções para entradas inválidas e divisão por zero
 */

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField numField1, numField2, resultField;
    private JButton addButton, subButton, mulButton, divButton;

    public SimpleCalculator() {
        // Configurando o layout
        setTitle("Simple Calculator");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        // Criando e adicionando componentes
        add(new JLabel("Número 1:"));
        numField1 = new JTextField(10);
        add(numField1);

        add(new JLabel("Número 2:"));
        numField2 = new JTextField(10);
        add(numField2);

        addButton = new JButton("+");
        addButton.addActionListener(this);
        add(addButton);

        subButton = new JButton("-");
        subButton.addActionListener(this);
        add(subButton);

        mulButton = new JButton("*");
        mulButton.addActionListener(this);
        add(mulButton);

        divButton = new JButton("/");
        divButton.addActionListener(this);
        add(divButton);

        add(new JLabel("Resultado:"));
        resultField = new JTextField(10);
        resultField.setEditable(false);
        add(resultField);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(numField1.getText());
            double num2 = Double.parseDouble(numField2.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subButton) {
                result = num1 - num2;
            } else if (e.getSource() == mulButton) {
                result = num1 * num2;
            } else if (e.getSource() == divButton) {
                if (num2 == 0) {
                    throw new ArithmeticException("Divisão por zero não é permitida!");
                }
                result = num1 / num2;
            }

            resultField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            resultField.setText("Erro: Entrada inválida!");
        } catch (ArithmeticException ex) {
            resultField.setText(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calculator = new SimpleCalculator();
            calculator.setVisible(true);
        });
    }
}
