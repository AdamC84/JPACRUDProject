package com.skilldistillery.PGA.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.PGA.entities.Golfer;

@Transactional
@Service

public class PGADAOImpl implements PGADAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Golfer findGolferById(int id) throws SQLException {
		Golfer golfer = em.find(Golfer.class, id);
		return golfer;
	}

	@Override
	public List<Golfer> findGolferByKeyword(String keyword) throws SQLException {
		List<Golfer> golferList = new ArrayList<>();
		String query = "SELECT golfer FROM Golfer golfer where golfer.firstName like :keyword or golfer.lastName like :keyword";
		golferList = em.createQuery(query, Golfer.class).setParameter("keyword", "%" + keyword + "%").getResultList();

		return golferList;
	}

	@Override
	public Golfer createGolfer(Golfer golfer) throws SQLException {
		Golfer newGolfer = new Golfer();
		newGolfer.setFirstName(golfer.getFirstName());
		newGolfer.setLastName(golfer.getLastName());
		newGolfer.setPgaWins(golfer.getPgaWins());
		newGolfer.setCollegeAttended(golfer.getCollegeAttended());
		newGolfer.setTotalEarnings(golfer.getTotalEarnings());
		em.persist(newGolfer);
		em.flush();
		return newGolfer;
	}

	@Override
	public void deleteGolfer(Golfer golfer) throws SQLException {
		em.getTransaction();
		em.remove(golfer);
		em.getTransaction().commit();

	}

	@Override
	public Golfer updateGolfer(Golfer golfer) throws SQLException {
		Golfer newGolfer = em.find(Golfer.class, golfer.getId());
		newGolfer.setFirstName(golfer.getFirstName());
		newGolfer.setLastName(golfer.getLastName());
		newGolfer.setPgaWins(golfer.getPgaWins());
		newGolfer.setCollegeAttended(golfer.getCollegeAttended());
		newGolfer.setTotalEarnings(golfer.getTotalEarnings());
		em.persist(newGolfer);
		em.flush();

		return newGolfer;

	}

}
