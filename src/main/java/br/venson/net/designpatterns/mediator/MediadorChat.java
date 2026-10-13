package br.venson.net.designpatterns.mediator;

public interface MediadorChat {
    void registrarUsuario(Usuario usuario);
    void removerUsuario(Usuario usuario);
    void enviarMensagem(String mensagem, Usuario remetente);
}
