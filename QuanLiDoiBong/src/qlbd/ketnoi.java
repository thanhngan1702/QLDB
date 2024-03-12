package qlbd;

import java.util.logging.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import qlbd.cauthu;

public class ketnoi {
	public static ArrayList<cauthu> findAllcauthu() {
		ArrayList<cauthu> listcauthu=new ArrayList<>();
		Connection connection = null;
        Statement statement = null;
    	
    	try {
    		connection =DriverManager.getConnection("jdbc:mysql://localhost:3307/qlbd","root","root");
            String sql="select*from cauthu";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
             while(rs.next()) {
            	cauthu cauthu=new cauthu();
            	cauthu.setten(rs.getString(1));
            	cauthu.setngaysinh(rs.getString(2));
            	cauthu.setvitri(rs.getString(3));
            	cauthu.setquoctich(rs.getString(4));
            	cauthu.setngaygianhap(rs.getString(5));
            	cauthu.settienluong(rs.getDouble(6));
            	cauthu.setcaulacbo(rs.getString(7));
            	
                listcauthu.add(cauthu);
            }
    	}catch(SQLException ex) {
            Logger.getLogger(ketnoi.class.getName()).log(Level.SEVERE, null, ex);
    	}finally {
    		if(statement!=null) {
    			try {statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ketnoi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ketnoi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
		return listcauthu;
	}
	public static void  insert(cauthu cauthu) {
		Connection connection = null;
        PreparedStatement st = null;
    	try {   
    		connection =DriverManager.getConnection("jdbc:mysql://localhost:3307/qlbd","root","root");
            String sql="insert into cauthu (tencauthu, ngaysinh, vitri, quoctich, ngaygianhap, tienluong, caulacbo)"+"values(?,?,?,?,?,?,?)";
            st = connection.prepareCall(sql);
    		st.setString(1, cauthu.getten());
            st.setString(2, cauthu.getngaysinh());
            st.setString(3, cauthu.getvitri());
            st.setString(4, cauthu.getquoctich());
            st.setString(5, cauthu.getngaygianhap());
            st.setDouble(6, cauthu.gettienluong());
            st.setString(7, cauthu.getcaulacbo());
            
           
            st.execute();
    		
    	} catch (SQLException ex) {
            Logger.getLogger(ketnoi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ketnoi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ketnoi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } // BÂY GIỜ CÙNG CHẠY CHƯƠNG TRÌNH NHA
    }
	public static void xoacauthu(String ten) {
		Connection connection = null;
	     PreparedStatement st = null;
	        
   	try {
		connection =DriverManager.getConnection("jdbc:mysql://localhost:3307/qlbd","root","root");
    		String sql="delete from cauthu where tencauthu=?";
    		st = connection.prepareCall(sql);
            st.setString(1, ten);
            st.execute();
	} catch (SQLException ex) {
        Logger.getLogger(ketnoi.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if(st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ketnoi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ketnoi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
	}
   
	public static ArrayList<cauthu> timkiemcauthu(String tencauthu ){
		ArrayList<cauthu> listcauthu=new ArrayList<>();
		Connection connection = null;
	    PreparedStatement st = null;
	        
  	try {
		connection =DriverManager.getConnection("jdbc:mysql://localhost:3307/qlbd","root","root");
  		String sql="select*from cauthu where tencauthu like?";
  		st = connection.prepareCall(sql);
        st.setString(1, "%"+tencauthu+"%");
        
        ResultSet rs = st.executeQuery();
        while (rs.next()) {  
        	cauthu cauthu=new cauthu();
        	cauthu.setten(rs.getString(1));
        	cauthu.setngaysinh(rs.getString(2));
        	cauthu.setquoctich(rs.getString(4));
        	cauthu.setvitri(rs.getString(3));
        	cauthu.setngaygianhap(rs.getString(5));
        	cauthu.settienluong(rs.getDouble(6));
        	cauthu.setcaulacbo(rs.getString(7));
        	
            listcauthu.add(cauthu);
        
        }
  	   }catch (SQLException ex) {
            Logger.getLogger(ketnoi.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ketnoi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ketnoi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return listcauthu;
	} 
}
