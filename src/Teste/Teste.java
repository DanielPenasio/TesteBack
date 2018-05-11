package Teste;

import Modelo.CustomerAccount;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.DAO;

/**
 *
 * @author Daniel Penasio
 */
public class Teste {

    public static void main(String[] args) throws SQLException {

        DAO dao = new DAO();

        //Adicinando 3000 registros no banco para o teste
//        long cpf = 11111111111L;
//        List<CustomerAccount> lista = new ArrayList<>();
//
//        for (int i = 1; i < 3000; i++) {
//            cpf = cpf+i;
//            CustomerAccount c = new CustomerAccount();
//            c.setCpf_cnpj(String.valueOf(cpf));
//            c.setNm_customer("customer"+i);
//            c.setIs_active(true);
//            c.setVl_total(300+i);
//            lista.add(c);
//        }
//        
//        for(CustomerAccount customer : lista){
//            CustomerAccount c = new CustomerAccount();
//            c.setCpf_cnpj(customer.getCpf_cnpj());
//            c.setNm_customer(customer.getNm_customer());
//            c.setIs_active(customer.isIs_active());
//            c.setVl_total(customer.getVl_total());
//            dao.adicionar(c);
//            
//        }
        //Código de teste para adicionar 1 único registro.
//        CustomerAccount customer = new CustomerAccount();
//        customer.setCpf_cnpj("123456789-00");
//        customer.setNm_customer("João da Silva");
//        customer.setIs_active(true);
//        customer.setVl_total(300.20);
//        
//        DAO dao = new DAO();
//        
//        dao.adicionar(customer);
        //Retorna lista de registro de acordo com o intervalo de id passado
        // e o valor de corte
        List<CustomerAccount> listaCustomer = dao.getListaVlTotalEntreIds(1500, 2700, 560);
        double total = 0;
        int reg = 0;

        // percorre o array exibindo todos os registros
        System.out.println("### Lista dos registros encontrados ###");
        System.out.println("");
        for (CustomerAccount customer : listaCustomer) {
            CustomerAccount c = new CustomerAccount();
            c.setCpf_cnpj(customer.getCpf_cnpj());
            c.setNm_customer(customer.getNm_customer());
            c.setIs_active(customer.isIs_active());
            c.setVl_total(customer.getVl_total());

            total += c.getVl_total();
            reg++;

            System.out.println("cpf_cnpj: " + c.getCpf_cnpj());
            System.out.println("Nome: " + c.getNm_customer());
            System.out.println("Ativo: " + c.isIs_active());
            System.out.println("vl_total: " + c.getVl_total());
            System.out.println("");

        }
        System.out.println("#######################");

        // Exibe a média
        System.out.println("");
        System.out.println("Total do campo vl_total: " + total);
        System.out.println("Qauntidade de registros encontrados: " + reg);
        System.out.println("Média:" + total / reg);

    }
}
