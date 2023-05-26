package com.eicon.testecompra;

import com.eicon.testecompra.domain.Cliente;
import com.eicon.testecompra.domain.Pedido;
import com.eicon.testecompra.domain.Produto;
import com.eicon.testecompra.domain.ProdutosPedido;
import com.eicon.testecompra.repositories.ClienteRepository;
import com.eicon.testecompra.repositories.PedidoRepository;
import com.eicon.testecompra.repositories.ProdutoRepository;
import com.eicon.testecompra.repositories.ProdutosPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TestecompraApplication implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienterRepoitory;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutosPedidoRepository produtosPedidoRepository;


    public static void main(String[] args) {
        SpringApplication.run(TestecompraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Cliente c1 = new Cliente(null, "Michel lima", "michel@gmail.com", "3333333");
        Cliente c2 = new Cliente(null, "Gabriela lima", "gabriela@gmail.com", "22222222");
        Cliente c3 = new Cliente(null, "Maria lima", "maria@gmail.com", "555555555");
        Cliente c4 = new Cliente(null, "Alice lima", "alice@gmail.com", "77777777");
        Cliente c5 = new Cliente(null, "Geovanna lima", "geovanna@gmail.com", "000888833");
        Cliente c6 = new Cliente(null, "Junior lima", "junior@gmail.com", "987666666");
        Cliente c7 = new Cliente(null, "Agatha lima", "agatha@gmail.com", "1111122222");
        Cliente c8 = new Cliente(null, "Caramelo lima", "caramelo@gmail.com", "3332222344");
        Cliente c9 = new Cliente(null, "Pelucia lima", "pelucia@gmail.com", "666654433");
        Cliente c10 = new Cliente(null, "Jada lima", "jada@gmail.com", "877776666");

        c1.getTelefones().addAll(Arrays.asList("1234-1234", "4321-4321"));
        c2.getTelefones().addAll(Arrays.asList("2345-2345", "5678-4323"));
        c5.getTelefones().addAll(Arrays.asList("1234-5678", "1234-5678"));


        Produto p1 = new Produto(null, "cadeira", 70.00);
        Produto p2 = new Produto(null, "mesa", 150.00);
        Produto p3 = new Produto(null, "geladeira", 1900.00);
        Produto p4 = new Produto(null, "fogão", 700.90);
        Produto p5 = new Produto(null, "armario", 1600.00);


        Pedido ped1 = new Pedido(null, LocalDate.of(2023, 05, 24), c1);
        Pedido ped2 = new Pedido(null, null, c1);
        Pedido ped3 = new Pedido(null, LocalDate.of(2023, 05, 22), c2);


        ProdutosPedido pp1 = new ProdutosPedido(ped1, p1, 00.00, 6, 70.00);
        ProdutosPedido pp2 = new ProdutosPedido(ped3, p1, 00.00, 6, 70.00);
        ProdutosPedido pp3 = new ProdutosPedido(ped2, p3, 00.00, 6, 1900.00);
        ProdutosPedido pp4 = new ProdutosPedido(ped2, p4, 00.00, 6, 700.00);
        ProdutosPedido pp5 = new ProdutosPedido(ped2, p5, 00.00, 6, 1600.00);
        ProdutosPedido pp6 = new ProdutosPedido(ped2, p2, 00.00, 6, 150.00);
        c1.getPedidos().addAll(Arrays.asList(ped1,ped2));
      //  p1.getProdutosPedidos().addAll(Arrays.asList(pp1,pp2));

        clienterRepoitory.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));
        produtosPedidoRepository.saveAll(Arrays.asList(pp1, pp2, pp3, pp4, pp5, pp6));

       List<Cliente> clientes = clienterRepoitory.findAll();
        List<Produto> produtos = produtoRepository.findAll();

        Double x = produtos.get(1).getValor();
       int i = clientes.size();
        System.out.println(i+" "+x);

     /*   p1.getProdutosPedidos().addAll(Arrays.asList(pp1,pp2));
        p2.getProdutosPedidos().addAll(Arrays.asList(pp6));
        p3.getProdutosPedidos().addAll(Arrays.asList(pp3));
        p4.getProdutosPedidos().addAll(Arrays.asList(pp4));
        p5.getProdutosPedidos().addAll(Arrays.asList(pp5));

        c1.getPedidos().addAll(Arrays.asList(ped1,ped2));
        c2.getPedidos().addAll(Arrays.asList(ped3));*/

     /*   ped1.getProdutosPedido().addAll(Arrays.asList(pp1));
        ped2.getProdutosPedido().addAll(Arrays.asList(pp3,pp4,pp5));
        ped3.getProdutosPedido().addAll(Arrays.asList(pp2));*/


/*        for(Pedido pedido: pedidos){
            System.out.println(pedido);
        }

System.out.println("teste");*/

    }

}
