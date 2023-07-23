package com.masai.service;

import java.util.List;

import com.masai.dao.VotingSystemDao;
import com.masai.dao.VotingSystemDaoImpl;
import com.masai.entity.Candidate;
import com.masai.entity.Election;
import com.masai.entity.Vote;
import com.masai.entity.Voter;
import com.masai.exceptions.AccessForbidden;
import com.masai.exceptions.DuplicateEntry;
import com.masai.exceptions.InvalidCredentials;
import com.masai.exceptions.MaximumLoginAttemptReached;
import com.masai.exceptions.NoRecordFound;
import com.masai.exceptions.SomeThingWentWrong;
import com.masai.exceptions.UnauthorizedAccess;
import com.masai.exceptions.UserMustBe18orAbove;
import com.masai.exceptions.WrongInput;

public class OnlineVotingImpl implements OnlineVotingServices{
	VotingSystemDaoImpl votingSystemImplements = new VotingSystemDaoImpl();
	int adminLoginCounter = 0;
	int voterLoginCounter = 0;

	@Override
	public boolean registerVoter(Voter voter) throws AccessForbidden, InvalidCredentials, NoRecordFound,
			UnauthorizedAccess, UserMustBe18orAbove, SomeThingWentWrong, DuplicateEntry {
		// TODO Auto-generated method stub
		
		if (voter.getAge() < 17) {
			throw new UserMustBe18orAbove("User is Not Above 18");
		}
		return votingSystemImplements.registerVoter(voter);
		
	}

	@Override
	public Voter loginVoter(String email, String password) throws AccessForbidden, InvalidCredentials,
			MaximumLoginAttemptReached, NoRecordFound, UnauthorizedAccess, SomeThingWentWrong {
		voterLoginCounter++;
		Voter voter = votingSystemImplements.loginVoter(email,password);
		if (voterLoginCounter > 3) {
			throw new MaximumLoginAttemptReached("You have Atempted more then 3 time ");
		}else if (voter != null) {
			voterLoginCounter = 0;
		}else {
			throw new InvalidCredentials("Wrong Username and Password Provided");
		}
		return voter;
	}

	@Override
	public boolean castVote(Vote vote)
			throws AccessForbidden, DuplicateEntry, NoRecordFound, UnauthorizedAccess, SomeThingWentWrong, WrongInput {
		if (votingSystemImplements.castVote(vote) )return true;
		else throw new NoRecordFound("Record Not Found");
	}
	
	@Override
	public boolean loginAdministrator(String username, String password) throws AccessForbidden, InvalidCredentials,
			MaximumLoginAttemptReached, NoRecordFound, UnauthorizedAccess, SomeThingWentWrong, WrongInput {
		adminLoginCounter++;
		
		if (adminLoginCounter > 3) {
			throw new MaximumLoginAttemptReached("You have Atempted more then 3 time ");
		}else if (adminLoginCounter < 4 &&  username.equals("admin") && password.equals("12345")) {
			adminLoginCounter = 0;
			return true;
		}else {
			throw new InvalidCredentials("Wrong Username and Password Provided");
		}
		
	}

	@Override
	public boolean voteConfirmation(String email, int electionId)
			throws AccessForbidden, DuplicateEntry, NoRecordFound, UnauthorizedAccess, SomeThingWentWrong, WrongInput {
		if (votingSystemImplements.voteConfirmation(email ,electionId)) return true;
		throw new SomeThingWentWrong("Something went Wrong");
	}
	
	@Override
	public boolean addElection(Election election , List<Candidate> list)
			throws AccessForbidden, DuplicateEntry, NoRecordFound, UnauthorizedAccess, SomeThingWentWrong, WrongInput {
		if (votingSystemImplements.addElection(election , list)) return true;
		throw new SomeThingWentWrong("Something went Wrong");
		
	}

	@Override
	public List<Election> viewElections()
			throws AccessForbidden, DuplicateEntry, NoRecordFound, UnauthorizedAccess, SomeThingWentWrong, WrongInput {
		// TODO Auto-generated method stub
		return votingSystemImplements.viewElections();
	}

	@Override
	public boolean deleteElection(int id)
			throws AccessForbidden, DuplicateEntry, NoRecordFound, UnauthorizedAccess, SomeThingWentWrong, WrongInput {
		if (votingSystemImplements.deleteElection(id)) return true;
		throw new SomeThingWentWrong("Something went Wrong");
	}

	@Override
	public boolean updateElection(Election election, List<Candidate> list)
			throws AccessForbidden, DuplicateEntry, NoRecordFound, UnauthorizedAccess, SomeThingWentWrong, WrongInput {
		if (votingSystemImplements.updateElection(election , list)) return true;
		throw new SomeThingWentWrong("Something went Wrong");
	}
	
	// This is pending
	@Override
	public List<Vote> viewVotingHistory(String emailID)
			throws AccessForbidden, DuplicateEntry, NoRecordFound, UnauthorizedAccess, SomeThingWentWrong, WrongInput {
		return votingSystemImplements.viewVotingHistory(emailID); 
		
	}
	// This is pending
	@Override
	public List<String> electionResult(int electionId)
			throws AccessForbidden, DuplicateEntry, NoRecordFound, UnauthorizedAccess, SomeThingWentWrong, WrongInput {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> viewCandidates()
			throws AccessForbidden, DuplicateEntry, NoRecordFound, UnauthorizedAccess, SomeThingWentWrong, WrongInput {
		return votingSystemImplements.viewCandidates();
	}

	@Override
	public Candidate addCandidate(Candidate candidate) throws SomeThingWentWrong {
		// TODO Auto-generated method stub
	VotingSystemDao vsd = new VotingSystemDaoImpl();
		return vsd.addCandidate(candidate);
	}

}
