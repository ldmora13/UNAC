import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmStart extends JFrame implements ActionListener {
    static JLabel lblNumero1, lblNumero2, resultadoTxt;
    static JTextField txtNumero1,txtNumero2;
    static JButton btnsumar;
    static frmLogin ventana;

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnsumar)){
            int Number1 = Integer.parseInt(txtNumero1.getText());
            int Number2 = Integer.parseInt(txtNumero2.getText());
            int suma = sumar.calcular(Number1, Number2);
            resultadoTxt.setText("El resultado de la suma es: " + suma);
            ventana = new frmLogin();
            setVisible(false);

        }

    }
    public frmStart(){

        //
        lblNumero1 = new JLabel("NUMBER ONE");
        lblNumero1.setBounds(30, 30, 100, 30);
        txtNumero1 = new JTextField();
        txtNumero1.setBounds(30, 60, 100, 30);
        lblNumero2 = new JLabel("NUMBER TWO");
        lblNumero2.setBounds(30, 90, 100, 30);
        txtNumero2 = new JTextField();
        txtNumero2.setBounds(30, 120, 100, 30);

        btnsumar = new JButton("+");
        btnsumar.setBounds(30, 200, 100, 30);
        btnsumar.addActionListener(this);

        resultadoTxt = new JLabel(" ");
        resultadoTxt.setBounds(150, 200, 200, 30);

        //
        add(lblNumero1);
        add(txtNumero1);
        add(lblNumero2);
        add(txtNumero2);
        add(btnsumar);
        add(resultadoTxt);

        //
        setLayout(null);
        setSize(400, 400);
        setTitle("Calculadora IUG");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300, 200);
        setVisible(true);

    }
    public static void main(String[] args) {
        frmStart ventana = new frmStart();
    }
}