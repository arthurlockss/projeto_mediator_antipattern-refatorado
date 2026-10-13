package br.venson.net.designpatterns.mediator;

import java.util.ArrayList;
import java.util.List;

public class SalaChat implements MediadorChat {
    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void registrarUsuario(Usuario usuario) {
        if (usuario != null && !usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }

    @Override
    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    @Override
    public void enviarMensagem(String mensagem, Usuario remetente) {
        for (Usuario usuario : usuarios) {
            // Regra de transmissão: todos recebem, exceto o próprio remetente
            if (usuario != remetente) {
                usuario.receber(remetente.getNome(), mensagem);
            }
        }
    }
}
