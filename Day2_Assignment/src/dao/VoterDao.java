package dao;
import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import pojos.Voters;

public class VoterDao implements IVoterDao {
	
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	
	public VoterDao () throws ClassNotFoundException,SQLException{
		//get cn from DBUtils
       	cn =  fetchConnection();
       	//create pre - parsed and pre compiled stmnt : for dynamic repitative querues
       	pst1= cn.prepareStatement("Select * from voters where email=? and password=? ");
       	pst2=cn.prepareStatement("update voters set status=1 where id=? ");
	}

	@Override
	public Voters authincateVoters(String email, String password) throws SQLException {
		//set in paramas
		pst1.setString(1,email);
		pst1.setString(2,password);
		try(ResultSet rst = pst1.executeQuery()){
			if(rst.next()) {
				Voters vot = new Voters(rst.getInt(1),rst.getString(2),email,rst.getBoolean(5),rst.getString(6));
			return vot;
			}
			
		}
		return null;
	}

	
	
	
	@Override
	public  String castingVote(int id) throws SQLException {
	//	String mesg="Already voted ";
		//set in params
		pst2.setInt(1, id);
		pst2.executeUpdate();
		return null;
	}

	
	public void cleanUp () throws SQLException{
		if (pst1 != null)
			pst1.close();
		if(pst2 !=null)
			pst2.close();
	}
	
}
