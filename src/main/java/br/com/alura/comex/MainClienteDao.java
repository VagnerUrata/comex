package br.com.alura.comex;

import br.com.alura.comex.dao.ClienteDao;
import br.com.alura.comex.modelo.Cliente;
import br.com.alura.comex.modelo.Endereco;
import br.com.alura.comex.util.JpaUtil;

import javax.persistence.EntityManager;

public class MainClienteDao {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        ClienteDao clienteDao = new ClienteDao(em);

        Cliente c1 = new Cliente();
        c1.setNome("Frank Castle");
        c1.setCpf("11122233344");
        c1.setTelefone("123456789");
        c1.setProfissao("Contador");
        c1.setEmail("punisher@mail.com");
        c1.setStatus(Status.ATIVO);

        Cliente c2 = new Cliente();
        c2.setNome("Peter Parker");
        c2.setCpf("22233344455");
        c2.setTelefone("123456789");
        c2.setProfissao("Fotógrafo");
        c2.setEmail("spiderman@mail.com");
        c2.setStatus(Status.ATIVO);

        Cliente c3 = new Cliente();
        c3.setNome("Palmirinha");
        c3.setCpf("33344455566");
        c3.setTelefone("123456789");
        c3.setProfissao("Cozinheira");
        c3.setEmail("palmirinha@mail.com");
        c3.setStatus(Status.ATIVO);

        Endereco e1 = new Endereco();
        e1.setRua("Avenida Paulista");
        e1.setNúmero("2000");
        e1.setComplemento("Sala 8");
        e1.setBairro("Bela Vista");
        e1.setCidade("São Paulo");
        e1.setEstado("São Paulo");

        Endereco e2 = new Endereco();
        e2.setRua("Rua 1");
        e2.setNúmero("2");
        e2.setComplemento("Sala 3");
        e2.setBairro("Bairro 4");
        e2.setCidade("Cidade 5");
        e2.setEstado("São Paulo");

        Endereco e3 = new Endereco();
        e3.setRua("Rua 10");
        e3.setNúmero("0");
        e3.setComplemento("Sala 30");
        e3.setBairro("Bairro 40");
        e3.setCidade("Cidade 50");
        e3.setEstado("São Paulo");

        System.out.println("\n");
        em.getTransaction().begin();
        clienteDao.cadastrar(c1);
        clienteDao.cadastrar(c2);
        clienteDao.cadastrar(c3);
        em.getTransaction().commit();
        clienteDao.buscarTodos().forEach(System.out::println);
        System.out.println("Cadastro de 3 Clientes");

        System.out.println("\n");
        em.getTransaction().begin();
        c1.setStatus(Status.SUSPENSO);
        clienteDao.atualizar(c1);
        em.getTransaction().commit();
        clienteDao.buscarTodos().forEach(System.out::println);
        System.out.println("Alterar cliente para suspenso");

        System.out.println("\n");
        System.out.println(clienteDao.buscaClientePorNome("Peter Parker"));
        System.out.println("Pesquisar cliente pelo nome");

        System.out.println("\n");
        clienteDao.buscaTodosPorStatus(Status.ATIVO).forEach(System.out::println);
        System.out.println("Pesquisar clientes ativos");
    }
}
