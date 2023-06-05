package org.example;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

// Do zmiany :)
// 0 -> Poczytaj sobie to -> https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design#open-closed-principle
// 1 -> bmi == 16.99 -> Do naprawy przedzialy.
// 2 -> Wydzielić logikę do zewnętrznej klasy. Zaprojektuj klasę -> dodaj metodę z argumentem
public class bmi_kalkulator {

    public static void main(String[] args){

        JFrame frame = new JFrame("Kalkulator BMI");

        String htmlText = "<html><h3>Witaj w programie obliczającym BMI!</h3></html>";

        JLabel tytul = new JLabel(htmlText);
        JLabel wzrost = new JLabel("Podaj swój wzrost(cm):  ");
        JLabel waga = new JLabel("Podaj swoją wagę(kg):  ");
        JButton oblicz = new JButton("Oblicz BMI");

        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMaximumFractionDigits(2);

        JFormattedTextField textFieldwzrost = new JFormattedTextField(format);
        textFieldwzrost.setColumns(10);

        JFormattedTextField textFieldwaga = new JFormattedTextField(format);
        textFieldwaga.setColumns(10);

        oblicz.addActionListener(e -> {
            try {
                double waga2 = format.parse(textFieldwaga.getText()).doubleValue();
                double wzrost2 = format.parse(textFieldwzrost.getText()).doubleValue();

                double finalheight = wzrost2 / 100;
                double potegaheight = finalheight * finalheight;
                double bmi = waga2 / potegaheight;

                DecimalFormat decimalFormat = new DecimalFormat("#.00");

                if (bmi < 16) {
                    JOptionPane.showMessageDialog(frame, "twoje BMI wynosi: " + decimalFormat.format(bmi) + ". Jesteś wygłodzony!");
                } else if (bmi >= 16 && bmi < 17) {// bmi == 16.99 -> Do naprawy przedzialy
                    JOptionPane.showMessageDialog(frame, "twoje BMI wynosi: " + decimalFormat.format(bmi) + ". Jesteś wychudzony!");
                } else if (bmi >= 17 && bmi <= 18.49) {
                    JOptionPane.showMessageDialog(frame, "twoje BMI wynosi: " + decimalFormat.format(bmi) + ". Masz niedowagę!");
                } else if (bmi >= 18.5 && bmi <= 24.99) {
                    JOptionPane.showMessageDialog(frame, "twoje BMI wynosi: " + decimalFormat.format(bmi) + ". Waga prawidłowa!");
                } else if (bmi >= 25 && bmi <= 29.99) {
                    JOptionPane.showMessageDialog(frame, "twoje BMI wynosi: " + decimalFormat.format(bmi) + ". Masz nadwagę!");
                } else if (bmi >= 30 && bmi <= 34.99) {
                    JOptionPane.showMessageDialog(frame, "twoje BMI wynosi: " + decimalFormat.format(bmi) + ". Otyłość 1 stopnia!");
                } else if (bmi >= 35 && bmi <= 39.99) {
                    JOptionPane.showMessageDialog(frame, "twoje BMI wynosi: " + decimalFormat.format(bmi) + ". Otyłość 2 stopnia!");
                } else if (bmi >= 40) {
                    JOptionPane.showMessageDialog(frame, "twoje BMI wynosi: " + decimalFormat.format(bmi) + ". Otyłość 3 stopnia!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame,"Wprowadź poprawne wartości");
            }

        });

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
        panel.add(tytul);
        panel.add(wzrost);
        panel.add(textFieldwzrost);
        panel.add(waga);
        panel.add(textFieldwaga);
        panel.add(oblicz);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);

        bmi_kalkulator kalkulator = new bmi_kalkulator();

    }
}
