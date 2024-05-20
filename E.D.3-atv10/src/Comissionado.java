public class Comissionado extends Funcionario{

    public Comissionado(Departamento dep) {
        super(dep);
    }

    public double calcularSalario() {
        this.salario = (super.valorVendas * super.percentualComissao);
        return salario;
    }
}
