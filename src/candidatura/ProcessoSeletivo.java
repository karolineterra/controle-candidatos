package candidatura;

import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        // Array com a lista de candidatos
        selecaoCandidatos();
        
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};

        int totalcandidatosSelecionados = 0;
        String [] candidatosSelecionados = {null, null, null, null, null};
        int candidatoAtual = 0;
        
        while(totalcandidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            double salarioPretendido = valorPretendido();
            if (analisarCandidato(salarioPretendido) == "Ligar para o candidato" || analisarCandidato(salarioPretendido) == "Ligar para o candidato com contraproposta."){
                System.out.println("O candidato " + candidatos[candidatoAtual] + " participará da entrevista pois o salário pretendido é de R$ " + salarioPretendido);
                candidatosSelecionados[totalcandidatosSelecionados] = candidatos[candidatoAtual];
                totalcandidatosSelecionados++;

            } else {
                System.out.println("O candidato " + candidatos[candidatoAtual] + " não participará da entrevista pois sua pretensão salarial de " + salarioPretendido +" é muito alta");
            }
            candidatoAtual++;
        }
        for (String candidato : candidatosSelecionados) {
            System.out.println(candidato);
        }
    }

    static String analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            return("Ligar para o candidato");
        } else if(salarioBase == salarioPretendido){
            return("Ligar para o candidato com contraproposta.");
        } else {
            return("Aguardando resultado dos demais candidatos.");
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
   }
}