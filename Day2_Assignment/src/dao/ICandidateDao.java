package dao;
import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;




public interface ICandidateDao {
   //Candidate Registration 
	String addCandidate(String name, String party) throws SQLException;
	//list All Candidate
   List<Candidate> fetchCandDetails() throws SQLException;
   //adding vote
   String updatVote(int id) throws SQLException;
}
