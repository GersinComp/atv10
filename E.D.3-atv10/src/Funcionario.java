public class Funcionario {
    protected String nome;
    protected String cidade;
    protected String estado;
    protected double qntdHrsTrabalhadas;
    protected double salario;
    protected double valorVendas;
    protected double percentualComissao;
    protected Departamento dep;

    public Funcionario(Departamento dep) {
        this.dep = dep;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setQntdHrsTrabalhadas(double qntdHrsTrabalhadas) {
        this.qntdHrsTrabalhadas = qntdHrsTrabalhadas;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    public void setPercentualComissao(double porcentualComissao) {
        this.percentualComissao = porcentualComissao;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", horas trabalhadas=" + qntdHrsTrabalhadas +
                ", salario=" + salario +
                ", valor das vendas=" + valorVendas +
                ", percentual de comissao=" + percentualComissao +
                ", departamento='" + this.dep.getDescricao() + '\'' +
                ", valor por hora= R$ " + this.dep.getValorHrTrab() + '\'' +
                '}';
    }
}
