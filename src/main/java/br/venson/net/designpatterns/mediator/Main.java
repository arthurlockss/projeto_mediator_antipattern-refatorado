package br.venson.net.designpatterns.mediator;

public class Main {

    public static void main(String[] args) {
        MediadorChat salaGeral = new SalaChat();

        Usuario ana = new Usuario("Ana", salaGeral);
        Usuario bruno = new Usuario("Bruno", salaGeral);
        Usuario carla = new Usuario("Carla", salaGeral);

        System.out.println("--- Mensagem inicial de Ana ---");
        ana.enviar("Bom dia, pessoal!");

        // Incluindo um novo usuario (Diego):
        // Bastou apenas instanciar/associar ao mediador. Nao mexeu em Ana, Bruno ou Carla!
        System.out.println("\n--- Diego entra na sala ---");
        Usuario diego = new Usuario("Diego", salaGeral);
        diego.enviar("Olá a todos, cheguei agora!");

        // Removendo Carla da sala:
        // Apenas a sala remove Carla. Nenhuma lista de outros usuarios precisa ser limpa manualmente.
        System.out.println("\n--- Carla sai da sala ---");
        carla.sairDoChat();
        bruno.enviar("Carla ainda está ouvindo?");

        // Demonstrando reuso: mesma classe Usuario em outra sala ou chat privado
        System.out.println("\n--- Chat Privado entre Bruno e Diego ---");
        MediadorChat chatPrivado = new SalaChat();
        bruno.entrarNoChat(chatPrivado);
        diego.entrarNoChat(chatPrivado);

        bruno.enviar("Oi Diego, essa conversa é privada.");
    }
}
