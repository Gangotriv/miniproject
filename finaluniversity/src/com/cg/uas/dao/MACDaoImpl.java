package com.cg.uas.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.uas.dto.ApplicationBean;
import com.cg.uas.dto.ProgramScheduledBean;
import com.cg.uas.exception.UniversityException;

@Repository
@Transactional
public class MACDaoImpl implements IMACDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<ProgramScheduledBean> viewAllScheduledPrograms() throws UniversityException {
		TypedQuery<ProgramScheduledBean> tQuery = entityManager.createQuery(IQueryMapper.RETRIEVE_PROGRAMS_BY_ID, ProgramScheduledBean.class);
		return tQuery.getResultList();
	}

	@Override
	public List<ApplicationBean> viewApplicant(String scheduledProgramId) throws UniversityException {
		TypedQuery<ApplicationBean> tQuery = entityManager.createQuery(IQueryMapper.RETRIEVE_APPLICANTS, ApplicationBean.class);
		tQuery.setParameter(1, scheduledProgramId);
		return tQuery.getResultList();
	}

	@Override
	public ApplicationBean accept(Integer applicationId) throws UniversityException {
		Query query = entityManager.createQuery(IQueryMapper.SET_STATUS_ACCEPT);
		query.setParameter(1, applicationId);
		query.executeUpdate();
		return null;
	}

	@Override
	public List<ApplicationBean> confirmedApplicants(String scheduledProgramId) throws UniversityException {
		TypedQuery<ApplicationBean> tQuery = entityManager.createQuery(IQueryMapper.RETRIEVE_APPLICANTS_STATUS_ACCEPTED, ApplicationBean.class);
		tQuery.setParameter(1, scheduledProgramId);
		return tQuery.getResultList();
	}

	@Override
	public ApplicationBean interview(Integer applicationId, Date date) throws UniversityException {
		Query query = entityManager.createQuery(IQueryMapper.SET_INTERVIEW_DATE);
		query.setParameter(1, date);
		query.setParameter(2, applicationId);
		query.executeUpdate();
		return null;
	}

	@Override
	public ApplicationBean confirm(Integer applicationId) throws UniversityException {
		Query query = entityManager.createQuery(IQueryMapper.SET_STATUS_CONFIRMED);
		query.setParameter(1, applicationId);
		query.executeUpdate();
		return null;
	}

	@Override
	public ApplicationBean reject(Integer applicationId) throws UniversityException {
		Query query = entityManager.createQuery(IQueryMapper.SET_STATUS_REJECT);
		query.setParameter(1, applicationId);
		query.executeUpdate();
		return null;
	}
}