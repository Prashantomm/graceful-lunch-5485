package com.masai.service;

import java.util.List;

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

public interface OnlineVotingServices {
	

	boolean registerVoter(Voter voter) 								throws AccessForbidden , InvalidCredentials  ,NoRecordFound, UnauthorizedAccess, UserMustBe18orAbove , SomeThingWentWrong , DuplicateEntry;
    Voter loginVoter(String email, String password) 				throws AccessForbidden , InvalidCredentials ,MaximumLoginAttemptReached ,NoRecordFound, UnauthorizedAccess ,SomeThingWentWrong;
    boolean castVote(Vote vote) 									throws AccessForbidden ,DuplicateEntry , NoRecordFound, UnauthorizedAccess , SomeThingWentWrong , WrongInput;
    List<Vote> viewVotingHistory(String emailID)					throws AccessForbidden ,DuplicateEntry , NoRecordFound, UnauthorizedAccess , SomeThingWentWrong , WrongInput;
    boolean voteConfirmation(String email, int electionId) 			throws AccessForbidden ,DuplicateEntry , NoRecordFound, UnauthorizedAccess , SomeThingWentWrong , WrongInput;
    List<String> electionResult(int electionId)						throws AccessForbidden ,DuplicateEntry , NoRecordFound, UnauthorizedAccess , SomeThingWentWrong , WrongInput;
    List<Election> viewElections() 									throws AccessForbidden ,DuplicateEntry , NoRecordFound, UnauthorizedAccess , SomeThingWentWrong , WrongInput;
    List<Candidate> viewCandidates() 								throws AccessForbidden ,DuplicateEntry , NoRecordFound, UnauthorizedAccess , SomeThingWentWrong , WrongInput;
    boolean addElection(Election election,List<Candidate> list)		throws AccessForbidden ,DuplicateEntry , NoRecordFound, UnauthorizedAccess , SomeThingWentWrong , WrongInput;
    boolean loginAdministrator(String username, String password) 	throws AccessForbidden , InvalidCredentials ,MaximumLoginAttemptReached ,NoRecordFound, UnauthorizedAccess , SomeThingWentWrong , WrongInput;
    boolean deleteElection(int id)									throws AccessForbidden ,DuplicateEntry , NoRecordFound, UnauthorizedAccess , SomeThingWentWrong , WrongInput;
    boolean updateElection(Election election,List<Candidate> list)  throws AccessForbidden ,DuplicateEntry , NoRecordFound, UnauthorizedAccess , SomeThingWentWrong , WrongInput;

}
