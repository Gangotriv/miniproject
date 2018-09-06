package com.cg.uas.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.uas.dto.ApplicationBean;
import com.cg.uas.dto.ProgramScheduledBean;
import com.cg.uas.exception.UniversityException;

@Service
public class MACServiceImpl implements IMACService {

	@Autowired
	IMACService MACdao;
	
	@Override
	public List<ProgramScheduledBean> viewAllScheduledPrograms() throws UniversityException {
		return MACdao.viewAllScheduledPrograms();
	}
	
	@Override
	public List<ApplicationBean> viewApplicant(String scheduledProgramId) throws UniversityException {
		return MACdao.viewApplicant(scheduledProgramId);
	}
	
	@Override
	public ApplicationBean accept(Integer applicationId) throws UniversityException {
		return MACdao.accept(applicationId);
	}
	
	@Override
	public List<ApplicationBean> confirmedApplicants(String scheduledProgramId) throws UniversityException {
		return MACdao.confirmedApplicants(scheduledProgramId);
	}
	
	@Override
	public ApplicationBean interview(Integer applicationId, Date date) throws UniversityException {
		return MACdao.interview(applicationId, date);
	}
	
	@Override
	public ApplicationBean confirm(Integer applicationId) throws UniversityException {
		return MACdao.confirm(applicationId);
	}
	
	@Override
	public ApplicationBean reject(Integer applicationId) throws UniversityException {
		return MACdao.reject(applicationId);
	}
}