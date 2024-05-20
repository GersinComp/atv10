public class Horista extends Funcionario{

    public Horista(Departamento dep) {
        super(dep);
    }

    public double calculaSalario() {
        this.salario = super.dep.getValorHrTrab() * super.getQntdHrsTrabalhadas();
        return salario;
    }
}
