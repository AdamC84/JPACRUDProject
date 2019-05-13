package com.skilldistillery.PGA.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.PGA.entities.Golfer;

public interface PGADAO {
	public Golfer findGolferById(int filmId) throws SQLException;

	public List<Golfer> findGolferByKeyword(String keyword) throws SQLException;

	public Golfer createGolfer(Golfer golfer) throws SQLException;

	public void deleteGolfer(Golfer golfer) throws SQLException;

	public Golfer updateGolfer(Golfer golfer) throws SQLException;
}
