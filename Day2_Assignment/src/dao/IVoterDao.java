package dao;

import java.sql.SQLException;


import pojos.Voters;

public interface IVoterDao {
	//Voter login and desplay details
   
   Voters authincateVoters(String email , String password) throws SQLException;
   //Casting a vote
   
  String castingVote(int id) throws SQLException;

}
