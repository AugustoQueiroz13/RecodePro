package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conector.connectionsql;
import model.usuario;

public class usuariodao {
	public void save (usuario usuario) {
		
		String sql = "INSERT INTO usuario(id_usuario, nome_usuario, email, senha)"
				+ "VALUES(?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try	{
			conn = connectionsql.createconnectionsql();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1,  usuario.getId_usuario());
			pstm.setString(2, usuario.getNome_usuario());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getSenha());
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
				
		} finally {	
			
			try {
				
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {	
				e.printStackTrace();
			
			}
		}
	}
	
	public void deleteById(int id_usuario) {
		
		String sql = "DELETE FROM usuario WHERE id_usuario = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = connectionsql.createconnectionsql();
			pstm =  conn.prepareStatement(sql);
			
			pstm.setInt(1, id_usuario);
			
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
	
			try {
				
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
public void update(usuario usuario) {



    String sql = "UPDATE usuario SET nome_usuario = ?, email = ?, senha = ? "
                 + "WHERE id_usuario = ?";



    Connection conn = null;
     PreparedStatement pstm = null;



    try {
         conn = connectionsql.createconnectionsql();
         pstm = conn.prepareStatement(sql);



        pstm.setString(1, usuario.getNome_usuario());
        pstm.setString(2, usuario.getEmail());
        pstm.setString(3, usuario.getSenha());
        pstm.setInt(4, usuario.getId_usuario());

        pstm.execute();


    } catch (Exception e) {
         e.printStackTrace();



    } finally {



        try {



            if (pstm != null) {
                 pstm.close();
             }



            if (conn != null) {
                 conn.close();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 }



public List<usuario> getusuario() {
     
     String sql = "SELECT * FROM usuario";
     
     List<usuario> usuario = new ArrayList<usuario>();
     
     Connection conn = null;
     PreparedStatement pstm = null;
     ResultSet rset = null;
     
     try {
         conn = connectionsql.createconnectionsql();
         pstm = conn.prepareStatement(sql);
         rset = pstm.executeQuery();
         
         while(rset.next()) {
             
             usuario usuario1 = new usuario();
             
             usuario1.setId_usuario(rset.getInt("id_usuario"));
             usuario1.setNome_usuario(rset.getString("nome_usuario"));
             usuario1.setEmail(rset.getString("email"));
             usuario1.setSenha(rset.getString("senha"));
             
             usuario.add(usuario1);
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
     return usuario;
 }
 
 public usuario getusuarioById(int id) {
     
     String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
     
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
         
         usuario.setId_usuario(rset.getInt("id_usuario"));
         usuario.setNome_usuario(rset.getString("nome_usuario"));
         usuario.setEmail(rset.getString("email"));
         usuario.setSenha(rset.getString("senha"));
         
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

	