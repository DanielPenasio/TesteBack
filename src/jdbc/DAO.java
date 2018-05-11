
package jdbc;

import Modelo.CustomerAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Penasio
 */
public class DAO {
        private Connection connection;

    public DAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adicionar(CustomerAccount customer){
        String sql = "insert into tb_customer_account "
                + "(cpf_cnpj, nm_customer, is_active, vl_total)"
                + "values (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customer.getCpf_cnpj());
            ps.setString(2, customer.getNm_customer());
            ps.setBoolean(3, customer.isIs_active());
            ps.setDouble(4, customer.getVl_total());
            
            ps.execute();
            ps.close();
            
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }        
    }
        
    public List<CustomerAccount> getListaVlTotalEntreIds (int idMin, int idMax, double vl){
        List<CustomerAccount> lista = new ArrayList<>();
        String sqlLista = "select * from tb_customer_account "
                + "where id_customer>=? and id_customer<=? and vl_total>=? "
                + "order by vl_total";
        try{
            PreparedStatement ps = connection.prepareStatement(sqlLista);
            ps.setInt(1, idMin);
            ps.setInt(2, idMax);
            ps.setDouble(3, vl);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                CustomerAccount c = new CustomerAccount();
                c.setCpf_cnpj(rs.getString("cpf_cnpj"));
                c.setNm_customer(rs.getString("nm_customer"));
                c.setIs_active(rs.getBoolean("is_active"));
                c.setVl_total(rs.getInt("vl_total"));
                
                lista.add(c);
            }
            rs.close();
            ps.close();
            return lista;
            
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        
    }
        
        
}
