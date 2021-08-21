package tester;

import java.util.Scanner;

import dao.CandidateDao;
import dao.VoterDao;

import pojos.Voters;

public class Tester {

	
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			boolean exit = false;
			VoterDao dao = new VoterDao();
			CandidateDao cdao = new CandidateDao();
			while(!exit) {
			System.out.println("Options 1.Voter login 2.Candidate registration 3.List all candidates 4.Cast a Vote ");
			try{
				switch(sc.nextInt()){
				case 1://Voters Validation
					System.out.println("Enter email id And password ");
					Voters v = dao.authincateVoters(sc.next(),sc.next());
					if (v!=null) {
						System.out.println("Log in succesfull....\n Here are your details");
					System.out.println(v.toString());
					}else
					System.out.println("Log in failed....\n Invalid email or Password");
					break;
			
				
				case 2://Candidate Registraton
					System.out.println("Enter Name and party Name ");
					System.out.println(cdao.addCandidate(sc.next(),sc.next()).toString());
					break;
			
				case 3://list all candidates
					System.out.println("List of candidates ");
					System.out.println(cdao.fetchCandDetails().toString());
					break;
				
				case 4://cast a vote
					System.out.println("Enter id to cast a vote");
					
					dao.castingVote(sc.nextInt());
					cdao.updatVote(sc.nextInt());
					System.out.println("Succefuly casted vote..!!!");
					break;
				
				}
				
			}catch (Exception e) {
			  e.printStackTrace();	
			}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
