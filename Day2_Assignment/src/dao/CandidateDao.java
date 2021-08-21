package dao;
import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;

public class CandidateDao implements ICandidateDao {
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;
	
	public CandidateDao () throws ClassNotFoundException,SQLException{
		//get cn from DBUtils
       	cn =  fetchConnection();
       	//create pre - parsed and pre compiled stmnt : for dynamic repitative querues
       	pst1= cn.prepareStatement("insert into candidates values(default,?,?,0)");
       	pst2=cn.prepareStatement("select * from candidates");
       pst3=cn.prepareStatement("update candidates set votes=votes+1 where id=?");	
	}

	@Override
	public String addCandidate(String name, String party) throws SQLException {
		String mesg="Candidate added succesfully..!!!!!";
		//set In params
		pst1.setString(1, name);
		pst1.setString(2, party);
		
		int updateCount = pst1.executeUpdate();
		if(updateCount == 1)
			mesg="Inserting emp details succeeded!!!!";
		return mesg;
	}
	

	

	@Override
	public List<Candidate> fetchCandDetails() throws SQLException {
		List<Candidate> can = new ArrayList<>();
		//set In params
		try(ResultSet rst = pst2.executeQuery()){
      while(rst.next())
    	  can.add(new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
		}		return can;
	}
	
	@Override
	public String updatVote(int id) throws SQLException {
		
		pst3.setInt(1, id);
		pst3.executeUpdate();
		return null;
	}
	

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
	}
}
