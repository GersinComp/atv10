import javax.swing.*;
import java.util.ArrayList;

public class Estaticos {

    public static void JOptionMenssage(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public static String JOptionInput(String input) {
        String JOinput = JOptionPane.showInputDialog(null, input);
        return JOinput;
    }

    public static String lowerCase(String tratar) {
        return tratar.toLowerCase();
    }

    public static String uperCase(String tratar) {
        return tratar.toUpperCase();
    }

    public static double toDouble(String tratar) {
        return Double.parseDouble(tratar);
    }

    public static String listarDepartamento(ArrayList<Departamento> departamentos) {
        String nomeDepartamentos = "";
        for (int i = 0; i < departamentos.size(); i++) {
            nomeDepartamentos += (i + 1) + " - " + departamentos.get(i).getDescricao() + "\n";
        }
        return nomeDepartamentos;
    }

    public static boolean validarcadastro(ArrayList<Departamento> departamentos, String nomeDepartamento) {
        Boolean controle = true; // permitido o cadastro
        for (int i = 0; i < departamentos.size(); i++) {
            if (departamentos.get(i).getDescricao().equals(nomeDepartamento)) {
                controle = false;
            }
        }
        return controle;
    }
}
