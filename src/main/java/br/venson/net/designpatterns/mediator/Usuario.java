package br.venson.net.designpatterns.mediator;

public class Usuario {
    private final String nome;
    private MediadorChat mediador;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario(String nome, MediadorChat mediador) {
        this.nome = nome;
        entrarNoChat(mediador);
    }

    public String getNome() {
        return nome;
    }

    public void entrarNoChat(MediadorChat mediador) {
        if (this.mediador != null) {
            this.mediador.removerUsuario(this);
        }
        this.mediador = mediador;
        if (this.mediador != null) {
            this.mediador.registrarUsuario(this);
        }
    }

    public void sairDoChat() {
        if (this.mediador != null) {
            this.mediador.removerUsuario(this);
            this.mediador = null;
        }
    }

    public void enviar(String mensagem) {
        if (mediador != null) {
            mediador.enviarMensagem(mensagem, this);
        } else {
            System.out.println(nome + " não está conectado a nenhuma sala de chat.");
        }
    }

    public void receber(String remetente, String mensagem) {
        System.out.println(nome + " recebeu de " + remetente + ": " + mensagem);
    }
}
