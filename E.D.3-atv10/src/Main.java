import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Departamento> departamentos = new ArrayList<>();
        int indiceDepartamento = 0;

        Boolean controle = true;
        while(controle) {
            int option = Integer.parseInt(Estaticos.JOptionInput("Escolha uma opção para continuar: \n" +
                    "1- Cadastrar novo departamento \n" +
                    "2- Registrar funcionário \n" +
                    "3- Exibir folha do departamento \n" +
                    "4- Exibir folha da empresa (todos os departamentos) \n" +
                    "5- Sair"));

            switch (option) {
                case 1:
                    String descricaoDep = Estaticos.lowerCase(Estaticos.JOptionInput("Digite a descrição do departamento: "));
                    double valorHoraDep = Estaticos.toDouble(Estaticos.JOptionInput("Digite o valor da hora trabalhada: "));
                    if (Estaticos.validarcadastro(departamentos, descricaoDep)) {
                        Departamento departamento = new Departamento();
                        departamento.setDescricao(descricaoDep);
                        departamento.setValorHrTrab(valorHoraDep);
                        departamentos.add(departamento);
                    } else
                        Estaticos.JOptionMenssage("Departamento já registrado");
                    break;
                case 2:
                    int option2 = Integer.parseInt(Estaticos.JOptionInput("Escolha o tipo do funcionário: \n" +
                            "1- Mensalista \n" +
                            "2- Horista \n" +
                            "3- Comissionado \n"
                            ));
                    indiceDepartamento = (Integer.parseInt(Estaticos.JOptionInput("Selecione o departamento:\n" + Estaticos.listarDepartamento(departamentos))) - 1);
                    switch (option2) {
                        case 1:
                            if (indiceDepartamento > -1) {
                                Mensalista mensalista = new Mensalista(departamentos.get(indiceDepartamento));
                                mensalista.setNome(Estaticos.JOptionInput("Informe o nome do funcionário: "));
                                mensalista.setCidade(Estaticos.JOptionInput("Informe a cidade: "));
                                mensalista.setEstado(Estaticos.JOptionInput("Informe o estado: "));
                                mensalista.setSalario(Estaticos.toDouble(Estaticos.JOptionInput("Informe o salário do funcionário: ")));
                                departamentos.get(indiceDepartamento).addFuncionario(mensalista);
                            } else
                                Estaticos.JOptionMenssage("Departamento inesistente!");
                            break;
                        case 2:
                            if (indiceDepartamento > -1) {
                                Horista horista = new Horista(departamentos.get(indiceDepartamento));
                                horista.setNome(Estaticos.JOptionInput("Informe o nome do funcionário: "));
                                horista.setCidade(Estaticos.JOptionInput("Informe a cidade: "));
                                horista.setEstado(Estaticos.JOptionInput("Informe o estado: "));
                                horista.setQntdHrsTrabalhadas(Estaticos.toDouble(Estaticos.JOptionInput("Informe as horas trabalhadas: ")));
                                horista.calculaSalario();
                                departamentos.get(indiceDepartamento).addFuncionario(horista);
                            } else
                                Estaticos.JOptionMenssage("Departamento inesistente!");
                            break;
                        case 3:
                            if (indiceDepartamento > -1) {
                                Comissionado comissionado = new Comissionado(departamentos.get(indiceDepartamento));
                                comissionado.setNome(Estaticos.JOptionInput("Informe o nome do funcionário: "));
                                comissionado.setCidade(Estaticos.JOptionInput("Informe a cidade: "));
                                comissionado.setEstado(Estaticos.uperCase(Estaticos.JOptionInput("Informe o estado: ")));
                                comissionado.setValorVendas(Estaticos.toDouble(Estaticos.JOptionInput("Informe o valor total das vendas do funcionário: ")));
                                comissionado.setPercentualComissao((Estaticos.toDouble(Estaticos.JOptionInput("Informe a porcentagem da comissao do funcionário: ")))/100);
                                comissionado.calcularSalario();
                                departamentos.get(indiceDepartamento).addFuncionario(comissionado);
                            } else
                                Estaticos.JOptionMenssage("Departamento inesistente!");
                            break;
                        default:
                            Estaticos.JOptionMenssage("Opção inválida!");
                    }
                    break;
                case 3:
                    indiceDepartamento = (Integer.parseInt(Estaticos.JOptionInput("Selecione o departamento que deseja consultar a folha:\n" + Estaticos.listarDepartamento(departamentos))) - 1);
                    System.out.printf(departamentos.get(indiceDepartamento).folhaDepartamento());
                    break;
                case 4:
                    double folhaTotal = 0.0;
                    String folhaDepartamento = "";
                    for (int i = 0; i < departamentos.size(); i++) {
                        folhaTotal += departamentos.get(i).folhaTotalDep();
                        folhaDepartamento = String.valueOf(departamentos.get(i).folhaTotalDep());
                        System.out.println("======================================================\n" +
                                "Folha do departamento " + departamentos.get(i).getDescricao() + ": R$" + folhaDepartamento);
                    }
                    System.out.println("A folha total de todos os departamentos: R$" + folhaTotal);
                    break;
                case 5:
                    controle = false;
                    break;
                default:
                    Estaticos.JOptionMenssage("Opção inválida!");
                    break;
            }
        }
    }
}
