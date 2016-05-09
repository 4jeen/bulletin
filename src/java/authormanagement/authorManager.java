/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package authormanagement;

import utils.MySqlConnection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author jeen
 */
public class authorManager extends MySqlConnection{
    
    int errorCode=0;

    /** Creates a new instance of authorManager */
    public authorManager() {
        super();
    }
    
    protected void finalize(){
        super.close();
    }
    
    public Author getAuthor(int idd){
        Author anAuthor=new Author();
        String query="select FAM,FAM_EN,NAM,NAM_EN,OTC,OTC_EN,MADDR,UCHST,UCHST_EN,UCHZV,UCHZV_EN,DOLZHN,DOLZHN_EN,WORKPL,WORKPL_EN,WORKPLADDR,WORKPLADDR_EN,WORKPHONE from AUTHORS WHERE IDD="+idd;
        try{
            Statement st=super.connection.createStatement();
            ResultSet rs=st.executeQuery(query);
            if(rs.next()){
                anAuthor.setIdd(idd);
                if(rs.getString("FAM")!=null){
                    anAuthor.setFam(rs.getString("FAM"));
                }
                if(rs.getString("FAM_EN")!=null){
                    anAuthor.setFamEn(rs.getString("FAM_EN"));
                }
                if(rs.getString("NAM")!=null){
                    anAuthor.setNam(rs.getString("NAM"));
                }
                if(rs.getString("NAM_EN")!=null){
                    anAuthor.setNamEn(rs.getString("NAM_EN"));
                }
                if(rs.getString("OTC")!=null){
                    anAuthor.setOtc(rs.getString("OTC"));
                }
                if(rs.getString("OTC_EN")!=null){
                    anAuthor.setOtcEn(rs.getString("OTC_EN"));
                }
                if(rs.getString("MADDR")!=null){
                    anAuthor.setMaddr(rs.getString("MADDR"));
                }
                if(rs.getString("UCHST")!=null){
                    anAuthor.setUchst(rs.getString("UCHST"));
                }
                if(rs.getString("UCHST_EN")!=null){
                    anAuthor.setUchstEn(rs.getString("UCHST_EN"));
                }
                if(rs.getString("UCHZV")!=null){
                    anAuthor.setUchzv(rs.getString("UCHZV"));
                }
                if(rs.getString("UCHZV_EN")!=null){
                    anAuthor.setUchzvEn(rs.getString("UCHZV_EN"));
                }
                if(rs.getString("DOLZHN")!=null){
                    anAuthor.setDolzhn(rs.getString("DOLZHN"));
                }
                if(rs.getString("DOLZHN_EN")!=null){
                    anAuthor.setDolzhnEn(rs.getString("DOLZHN_EN"));
                }
                if(rs.getString("WORKPL")!=null){
                    anAuthor.setWorkpl(rs.getString("WORKPL"));
                }
                if(rs.getString("WORKPL_EN")!=null){
                    anAuthor.setWorkplEn(rs.getString("WORKPL_EN"));
                }
                if(rs.getString("WORKPLADDR")!=null){
                    anAuthor.setWorkpladdr(rs.getString("WORKPLADDR"));
                }
                if(rs.getString("WORKPLADDR_EN")!=null){
                    anAuthor.setWorkpladdrEn(rs.getString("WORKPLADDR_EN"));
                }
                if(rs.getString("WORKPHONE")!=null){
                    anAuthor.setWorkPhone(rs.getString("WORKPHONE"));
                }
                rs.close();
                st.close();
            }
        }
        catch(SQLException ex){
            //System.err.println(ex.getMessage());
            System.err.println(query);
            this.errorCode=-3;
        }
        return anAuthor;
    }
    
    public Author getAuthor(String fam,String nam, String otc){
        Author anAuthor=new Author();
        String query="select IDD,FAM,FAM_EN,NAM,NAM_EN,OTC, OTC_EN, MADDR, UCHST, UCHST_EN, UCHZV, UCHZV_EN, DOLZHN,DOLZHN_EN,WORKPL,WORKPL_EN,WORKPLADDR,WORKPLADDR_EN,WORKPHONE from AUTHORS " +
                "WHERE FAM='"+fam+"' AND NAM='"+nam+"' AND OTC='"+otc+"'";
        try{
            Statement st=super.connection.createStatement();
            ResultSet rs=st.executeQuery(query);
            if(rs.next()){
                anAuthor.setIdd(rs.getInt("IDD"));
                if(rs.getString("FAM")!=null){
                    anAuthor.setFam(rs.getString("FAM"));
                }
                if(rs.getString("FAM_EN")!=null){
                    anAuthor.setFamEn(rs.getString("FAM_EN"));
                }
                if(rs.getString("NAM")!=null){
                    anAuthor.setNam(rs.getString("NAM"));
                }
                if(rs.getString("NAM_EN")!=null){
                    anAuthor.setNamEn(rs.getString("NAM_EN"));
                }
                if(rs.getString("OTC")!=null){
                    anAuthor.setOtc(rs.getString("OTC"));
                }
                if(rs.getString("OTC_EN")!=null){
                    anAuthor.setOtcEn(rs.getString("OTC_EN"));
                }
                if(rs.getString("MADDR")!=null){
                    anAuthor.setMaddr(rs.getString("MADDR"));
                }
                if(rs.getString("UCHST")!=null){
                    anAuthor.setUchst(rs.getString("UCHST"));
                }
                if(rs.getString("UCHST_EN")!=null){
                    anAuthor.setUchstEn(rs.getString("UCHST_EN"));
                }
                if(rs.getString("UCHZV")!=null){
                    anAuthor.setUchzv(rs.getString("UCHZV"));
                }
                if(rs.getString("UCHZV_EN")!=null){
                    anAuthor.setUchzvEn(rs.getString("UCHZV_EN"));
                }
                if(rs.getString("DOLZHN")!=null){
                    anAuthor.setDolzhn(rs.getString("DOLZHN"));
                }
                if(rs.getString("DOLZHN_EN")!=null){
                    anAuthor.setDolzhnEn(rs.getString("DOLZHN_EN"));
                }
                if(rs.getString("WORKPL")!=null){
                    anAuthor.setWorkpl(rs.getString("WORKPL"));
                }
                if(rs.getString("WORKPL_EN")!=null){
                    anAuthor.setWorkplEn(rs.getString("WORKPL_EN"));
                }
                if(rs.getString("WORKPLADDR")!=null){
                    anAuthor.setWorkpladdr(rs.getString("WORKPLADDR"));
                }
                if(rs.getString("WORKPLADDR_EN")!=null){
                    anAuthor.setWorkpladdrEn(rs.getString("WORKPLADDR_EN"));
                }
                if(rs.getString("WORKPHONE")!=null){
                    anAuthor.setWorkPhone(rs.getString("WORKPHONE"));
                }
                rs.close();
                st.close();
            }
        }
        catch(SQLException ex){
            //System.err.println(ex.getMessage());
            System.err.println(query);
            this.errorCode=-3;
            return null;
        }
        return anAuthor;
    }
    
    
    
    public int createAuthor(String fam,String nam,String otc , String emailaddr, 
            String uchst, String uchzv,String dolzhn, String workpl, String workpladdr,String workPhone ){
        int result=0;
        String queryFish="insert into AUTHORS (FAM,NAM,OTC,MADDR,UCHST,UCHZV,DOLZHN,WORKPL,WORKPLADDR,WORKPHONE) values('";
        String query=queryFish+fam+"','"+nam+"','"+otc+"','"+emailaddr+"','"+uchst+"','"+uchzv+"','"+dolzhn+"','"+workpl+"','"+workpladdr+"','"+workPhone+"')";
        try{
            Statement st=super.connection.createStatement();
            result=st.executeUpdate(query);
            st.close();
        }
        catch(SQLException ex){
            //System.err.println(ex.getMessage());
            System.err.println(query);
            result=-3;
            this.errorCode=-3;
        }
        return result;
    }
    public int createAuthorEn(String fam,String famEn ,String nam, String namEn,String otc ,
            String otcEn,String emailaddr, String uchst, String uchstEn,String uchzv,String uchzvEn,
            String dolzhn, String dolzhnEn,String workpl, String workplEn,String workpladdr,String workpladdrEn,String workPhone ){
        int result=0;
        String queryFish="insert into AUTHORS (FAM,FAM_EN,NAM,NAM_EN,OTC,OTC_EN,MADDR,UCHST,UCHST_EN,UCHZV,UCHZV_EN,DOLZHN,DOLZHN_EN,WORKPL,WORKPL_EN,WORKPLADDR,WORKPLADDR_EN,WORKPHONE) values('";
        String query=queryFish+fam+"','"+famEn+"','"+nam+"','"+namEn+"','"+otc+"','"+otcEn+"','"+
                emailaddr+"','"+uchst+"','"+uchstEn+"','"+uchzv+"','"+uchzvEn+"','"+dolzhn+"','"+dolzhnEn+"','"+workpl+"','"+workplEn+"','"+workpladdr+"','"+workpladdrEn+"','"+workPhone+"')";
        try{
            Statement st=super.connection.createStatement();
            result=st.executeUpdate(query);
            st.close();
        }
        catch(SQLException ex){
            //System.err.println(ex.getMessage());
            System.err.println(query);
            result=-3;
            this.errorCode=-3;
        }
        return result;
    }
    public int deleteAuthor(int idd){
        int result=0;
        String query="delete from AUTHORS WHERE IDD="+idd;
        try{
            Statement st=super.connection.createStatement();
            result=st.executeUpdate(query);
            st.close();
        }
        catch(SQLException ex){
            //System.err.println(ex.getMessage());
            System.err.println(query);
            result=-3;
            this.errorCode=-3;
        }
        return result;
    }
    public int editAuthor(int idd,String fam,String nam,String otc , String emailaddr,
            String uchst, String uchzv,String dolzhn, String workpl, String workpladdr,String workPhone ){
        int result=0;
        String query="update AUTHORS SET FAM='"+fam+"', NAM='"+nam+"', OTC='"+otc+"',MADDR='"+emailaddr+
                "',UCHST='"+uchst+"',UCHZV='"+uchzv+"',DOLZHN='"+dolzhn+"',WORKPL='"+workpl+"',WORKPLADDR='"+workpladdr+"',WORKPHONE='"+workPhone+"' where IDD="+idd;
        
        try{
            Statement st=super.connection.createStatement();
            result=st.executeUpdate(query);
            st.close();
        }
        catch(SQLException ex){
            //System.err.println(ex.getMessage());
            System.err.println(query);
            result=-3;
            this.errorCode=-3;
        }
        return result;
    }

    public int editAuthorEn(int idd,String fam,String famEn ,String nam, String namEn,String otc ,
            String otcEn,String emailaddr, String uchst, String uchstEn,String uchzv,String uchzvEn,
            String dolzhn, String dolzhnEn,String workpl, String workplEn,String workpladdr,String workpladdrEn,String workPhone  ){
        int result=0;
        String query="update AUTHORS SET FAM='"+fam+"', FAM_EN='"+famEn+"', NAM='"+nam+"', NAM_EN='"+namEn+
                "', OTC='"+otc+"' ,OTC_EN='"+otcEn+"',MADDR='"+emailaddr+
                "',UCHST='"+uchst+"' ,UCHST_EN='"+uchstEn+"',UCHZV='"+uchzv+"' , UCHZV_EN='"+uchzvEn+
                "',DOLZHN='"+dolzhn+"' ,DOLZHN_EN='"+dolzhnEn+"',WORKPL='"+workpl+"' , WORKPL_EN='"+workplEn+
                "' ,WORKPLADDR='"+workpladdr+"' ,WORKPLADDR_EN='"+workpladdrEn+"',WORKPHONE='"+workPhone+"' where IDD="+idd;

        try{
            Statement st=super.connection.createStatement();
            result=st.executeUpdate(query);
            st.close();
        }
        catch(SQLException ex){
            //System.err.println(ex.getMessage());
            System.err.println(query);
            result=-3;
            this.errorCode=-3;
        }
        return result;
    }
}
