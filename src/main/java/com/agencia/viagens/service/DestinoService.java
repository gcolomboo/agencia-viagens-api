package com.agencia.viagens.service;

import com.agencia.viagens.model.Avaliacao;
import com.agencia.viagens.model.Destino;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class DestinoService {

    private final List<Destino> destinos = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
    private final AtomicLong avaliacaoIdGenerator = new AtomicLong(1);

    // LISTAR TODOS
    public List<Destino> listarTodos() {
        return new ArrayList<>(destinos);
    }

    // BUSCAR POR ID
    public Destino buscarPorId(Long id) {
        return destinos.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Destino não encontrado com id: " + id));
    }

    // PESQUISAR POR NOME OU LOCALIZAÇÃO
    public List<Destino> buscar(String nome, String localizacao) {
        return destinos.stream()
                .filter(d -> nome == null || nome.isBlank()
                        || d.getNome().toLowerCase().contains(nome.toLowerCase()))
                .filter(d -> localizacao == null || localizacao.isBlank()
                        || correspondeLocalizacao(d, localizacao))
                .collect(Collectors.toList());
    }

    private boolean correspondeLocalizacao(Destino d, String localizacao) {
        String termo = localizacao.toLowerCase();
        boolean pais = d.getPais() != null && d.getPais().toLowerCase().contains(termo);
        boolean loc = d.getLocalizacao() != null && d.getLocalizacao().toLowerCase().contains(termo);
        return pais || loc;
    }

    // CADASTRAR
    public Destino criar(Destino destino) {
        destino.setId(idGenerator.getAndIncrement());
        destino.setDataCriacao(LocalDateTime.now());
        if (destino.getAvaliacoes() == null) {
            destino.setAvaliacoes(new ArrayList<>());
        }
        destino.setMediaAvaliacoes(null);
        destinos.add(destino);
        return destino;
    }

    // ATUALIZAR
    public Destino atualizar(Long id, Destino atualizado) {
        Destino destino = buscarPorId(id);

        destino.setNome(atualizado.getNome());
        destino.setPais(atualizado.getPais());
        destino.setLocalizacao(atualizado.getLocalizacao());
        destino.setDescricao(atualizado.getDescricao());
        destino.setPreco(atualizado.getPreco());

        return destino;
    }

    // EXCLUIR
    public void excluir(Long id) {
        Destino destino = buscarPorId(id);
        destinos.remove(destino);
    }

    // REGISTRAR AVALIAÇÃO E RECALCULAR MÉDIA
    public Destino avaliar(Long id, Avaliacao avaliacao) {
        if (avaliacao.getNota() == null || avaliacao.getNota() < 0 || avaliacao.getNota() > 5) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 5");
        }

        Destino destino = buscarPorId(id);

        avaliacao.setId(avaliacaoIdGenerator.getAndIncrement());
        destino.getAvaliacoes().add(avaliacao);

        double media = destino.getAvaliacoes().stream()
                .mapToDouble(Avaliacao::getNota)
                .average()
                .orElse(0.0);

        destino.setMediaAvaliacoes(media);

        return destino;
    }
}
