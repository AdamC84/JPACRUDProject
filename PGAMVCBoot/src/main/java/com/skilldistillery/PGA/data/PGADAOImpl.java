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
		String query = "SELECT golfer FROM Golfer golfer where golfer.firstName like '%:keyword%' or golfer.lastName like '%:keyword%'";
		golferList = em.createQuery(query, Golfer.class).setParameter(":keyword", keyword).getResultList();

		return golferList;
	}

	@Override
	public void createGolfer(Golfer golfer) throws SQLException {
		String sql = "INSERT INTO Golfer  (firstName, lastName, pgaWins, collegeAttended, totalEarnings) VALUE (:fN, :lN, :pW, :cA, tE)";
		em.createQuery(sql, Golfer.class).setParameter(":fN", golfer.getFirstName())
				.setParameter(":lN", golfer.getLastName()).setParameter(":pW", golfer.getPgaWins())
				.setParameter(":cA", golfer.getCollegeAttended()).setParameter(":tE", golfer.getTotalEarnings());
	}

	@Override
	public void deleteGolfer(Golfer golfer) throws SQLException {
		em.getTransaction();
		em.remove(golfer);
		em.getTransaction().commit();

	}

	@Override
	public void updateGolfer(Golfer golfer) throws SQLException {
		String sql = "UPDATE Golfer golfer set firstName = :fN, lastName = :lN, pgaWins = :pW, collegeAttended =:cA, totalEarnings = :tE where golfer.id = :id";
		em.createQuery(sql, Golfer.class).setParameter(":fN", golfer.getFirstName())
				.setParameter(":lN", golfer.getLastName()).setParameter(":pW", golfer.getPgaWins())
				.setParameter(":cA", golfer.getCollegeAttended()).setParameter(":tE", golfer.getTotalEarnings())
				.setParameter(":id", golfer.getId());

	}

}
