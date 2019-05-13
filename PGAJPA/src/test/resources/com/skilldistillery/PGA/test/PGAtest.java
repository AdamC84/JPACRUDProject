package com.skilldistillery.PGA.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.skilldistillery.PGA.entities.Golfer;

class PGAtest {


	private static EntityManagerFactory emf;
	private EntityManager em;
	private Golfer golfer;

	@BeforeAll
	public static void setUpAll() {
		emf = Persistence.createEntityManagerFactory("PGAJPA");

	}

	@AfterAll
	public static void closeAll() {
		emf.close();
	}

	@Disabled
	@Test
	void test() {
		fail("Not yet implemented");

	}

	@BeforeEach
	public void setUp() throws Exception {
		em = emf.createEntityManager();
		golfer = em.find(Golfer.class, 1);
	}

	@AfterEach
	public void tearDown() throws Exception {
		em.close();
		golfer = null;
	}

	@Test
	void test_PGA_mapping() {
		assertEquals("Jack", golfer.getFirstName());
		assertEquals("Nicklaus", golfer.getLastName());
		assertEquals("The Ohio State University", golfer.getCollegeAttended());
		assertEquals(73, golfer.getPgaWins());
		assertEquals(57000000, golfer.getTotalEarnings());
	}
}

