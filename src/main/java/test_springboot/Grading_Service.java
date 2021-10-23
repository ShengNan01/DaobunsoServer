package test_springboot;

import java.util.List;

public class Grading_Service {
	private GradingRepo gradingRepo;
	
	public List<Grading> getGradingsbyAccount(String account){
		return gradingRepo.findByUser_account(account);
	}
}






	
