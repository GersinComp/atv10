import java.util.ArrayList;

public class Departamento {
    private String descricao;
    private double valorHrTrab;
    private ArrayList<Funcionario> funcionarios;

    public Departamento() {
        funcionarios = new ArrayList<>();
    }

    public void addFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
        this.funcionarios = new ArrayList<>();
    }

    public double getValorHrTrab() {
        return valorHrTrab;
    }

    public void setValorHrTrab(double valorHrTrab) {
        this.valorHrTrab = valorHrTrab;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "descricao='" + this.descricao + '\'' +
                ", valorHrTrab=" + this.valorHrTrab +
                ", funcionarios=" + this.funcionarios +
                '}';
    }

    public String folhaDepartamento() {
        String folha = "======================================================\n";
        double folhaTotal = 0.0;
        for (Funcionario f : this.funcionarios) {
            folha += "Funcionário: " + f.getNome() + "\t\t" +
                    "Salário: R$ " + f.getSalario() + "\n";
            folhaTotal += f.getSalario();
        }
        folha += "Folha total do departamento de " + getDescricao() + ": R$ " + folhaTotal + "\n";
        folha += "======================================================\n";
        return folha;
    }

    public double folhaTotalDep() {
        double folhaTotal = 0.0;
        for (Funcionario f : this.funcionarios) {
            folhaTotal += f.getSalario();
        }
        return folhaTotal;
    }
}
