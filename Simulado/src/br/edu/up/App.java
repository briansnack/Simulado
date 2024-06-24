package br.edu.up;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.up.model.*;
import br.edu.up.model.daos.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("--- SIMULADO --- ");
        
        GerenciadorDePessoas gPessoas = new GerenciadorDePessoas();
        GerenciadorDeEnderecos gEnderecos = new GerenciadorDeEnderecos();

        List<Pessoa> listaDePessoas;
        listaDePessoas = gPessoas.getPessoa();

        List<String[]> listaDeEnderecos = gEnderecos.getEnderecos();

        Map<String, String[]> enderecosMap = new HashMap<>();
        for(String[] endereco : listaDeEnderecos){
            String id = endereco[2].trim();
            enderecosMap.put(id, new String[]{endereco[0], endereco[1]});
        }

        for (Pessoa pessoa : listaDePessoas){
            String[] endereco = enderecosMap.get(pessoa.getId());
            if (endereco != null) {
                pessoa.setEndereco(endereco[0], endereco[1]);
            }
        }
        
        // Exibir pessoas com endereço
        System.out.println("Lista de Pessoas: ");
        if(listaDePessoas.isEmpty()){
            System.out.println("Não há pessoas cadastradas");
        } else {
            listaDePessoas.forEach(p -> System.out.println(p.toCSV()));
        }

        // Gravar o arquivo de pessoas com endereços
        if (gPessoas.gravar(listaDePessoas) == true) {
            System.out.println("Arquivo gravado com sucesso");
        } else {
            System.out.println("Falha ao gravar arquivo");
        }
    }
}
