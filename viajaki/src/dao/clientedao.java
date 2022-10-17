
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conector.connectionsql;
import model.cliente;
import model.usuario;

public class clientedao {

public void save(cliente cliente) {
        
        String sql = "INSERT INTO cliente(id_cliente, nome, cpf, telefone, usuarios)" 
                    + "VALUES (?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = connectionsql.createconnectionsql();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, cliente.getId_cliente());
            pstm.setString(2, cliente.getNome());
            pstm.setInt(3, cliente.getCpf());
            pstm.setInt(4, cliente.getTelefone());
            pstm.setInt(5, cliente.getUsuarios().getId_usuario());
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            
            try {
                
                if(pstm != null) {
                    pstm.close();
                }
                
                if(conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
public void deleteById (int id) {
    
	String sql = "DELETE FROM cliente WHERE id_cliente= ?";
               
    Connection conn = null;
    PreparedStatement pstm = null;
       
    try {
        conn = connectionsql.createconnectionsql();
        pstm = conn.prepareStatement(sql);
        
        pstm.setInt(1, id);
        
        pstm.execute();
        
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        
        try {
            
            if(pstm != null) {
                pstm.close();
            }
            
            if(conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public void update(cliente cliente) {
    
    String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?" + "WHERE id_cliente = ?";
    
    Connection conn = null;
    PreparedStatement pstm = null;
    
    try {
        conn = connectionsql.createconnectionsql();
        pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, cliente.getNome());
        pstm.setInt(2, cliente.getCpf());
        pstm.setInt(3, cliente.getTelefone());
        pstm.setInt(4, cliente.getId_cliente());
        pstm.setInt(5, cliente.getId_usuario());
        
        pstm.execute();
        
    } catch (Exception e) {
        e.printStackTrace();
        
    } finally {
        
        try { 
            
            if(pstm != null) {
                pstm.close();
            }
            
            if(conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public List<cliente> getcliente() {
    
    String sql = "SELECT * FROM cliente AS l\n"
    		+ "JOIN usuario AS e ON l.id_usuario = e.id_usuario\n";
    
    List<cliente> cliente = new ArrayList<cliente>();
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rset = null;
    
    try {
        conn = connectionsql.createconnectionsql();
        pstm = conn.prepareStatement(sql);
        rset = pstm.executeQuery();
        
        while(rset.next()) {
            
            cliente clientes = new cliente();
            
            usuario usuarios = new usuario();
            
            clientes.setId_cliente(rset.getInt("id_clientes"));
            clientes.setNome(rset.getString("nome"));
            clientes.setCpf(rset.getInt("cpf"));
            clientes.setTelefone(rset.getInt("telefone"));
            
            usuarios.setId_usuario(rset.getInt("id_usuario"));
            usuarios.setNome_usuario(rset.getString("nome_usuario"));
            usuarios.setEmail(rset.getString("email"));
            usuarios.setSenha(rset.getString("senha"));
               
            clientes.setUsuarios(usuarios);
            
            cliente.add(clientes);
                        
        }
    } catch (Exception e) {
        e.printStackTrace();
        
    } finally {
        
        try {
            
            if(rset != null) {
                rset.close();
            }
            
            if(pstm != null) {
                pstm.close();
            }
            
            if(conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    return cliente;
}
public usuario getUsuarioById(int id) {
	
    String sql = "SELECT * FROM cliente AS \n"
    		+ "JOIN usuario AS e ON l.id_usuario= e.id_usuario\n"
    		+ "WHERE id_usuario = ?";
    cliente clientes= new cliente ();
    usuario usuario = new usuario();
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rset = null;
    
    try {
        conn = connectionsql.createconnectionsql();
        pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        rset = pstm.executeQuery();
        
        rset.next();
        
        clientes.setId_cliente(rset.getInt("id_cliente"));
        clientes.setNome(rset.getString("nome"));
        clientes.setTelefone(rset.getInt("telefone"));
        clientes.setCpf(rset.getInt("cpf"));
        
        usuario.setId_usuario(rset.getInt("id_usuario"));
        usuario.setNome_usuario(rset.getString("nome_usuario"));
        usuario.setEmail(rset.getString("email"));
        usuario.setSenha(rset.getString("senha"));
 
        clientes.setUsuarios(usuario);
        
    } catch (Exception e) {
        e.printStackTrace();
        
    } finally {
        
        try {
            
            if(rset != null) {
                rset.close();
            }
            
            if(pstm != null) {
                pstm.close();
            }
            
            if(conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    return usuario;
}
}