package com.tka.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tka.entity.Address;
import com.tka.entity.Person;
import com.tka.entity.VoterID;

public class VoterDao {
	List<Person> list = null;
	Session session = null;
	Transaction t = null;
	 Scanner scanner = null;
	public List<Person> allPersons() {

		try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Person.class)
				.addAnnotatedClass(VoterID.class).addAnnotatedClass(Address.class).buildSessionFactory()) {

			session = sessionFactory.openSession();
			t = session.beginTransaction();

			Query query = session.createQuery("from Person");
			list = query.list();
			

			t.commit();
			session.close();

		}  catch (Exception e) {
	        if (t != null) {   
	            t.rollback(); 
	        }
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close(); 
	        }
	    }
	    
	    return list; 

	}

	public List<Person> insertPerson() {
	   
	    list = new ArrayList<>();
	    scanner = new Scanner(System.in);
	    try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Person.class)
	            .addAnnotatedClass(VoterID.class).addAnnotatedClass(Address.class).buildSessionFactory()) {

	        session = sessionFactory.openSession();
	        t = session.beginTransaction();

	        // Input Address details
	        System.out.print("Enter Address Pincode: ");
	        int pincode = scanner.nextInt();
	        scanner.nextLine();
	        System.out.print("Enter Address City Name: ");
	        String cityName = scanner.nextLine();

	        Address address = new Address(pincode, cityName);

	        // Input the number of persons to insert
	        System.out.print("Enter the number of persons you want to insert: ");
	        int numPersons = scanner.nextInt();

	        for (int i = 1; i <= numPersons; i++) {
	            System.out.println("\nEntering details for Person " + i + ":");

	            // Input VoterID details
	            System.out.print("Enter VoterID Number: ");
	            int voterNumber = scanner.nextInt();
	            scanner.nextLine(); 
	            System.out.print("Enter VoterID Identifier (e.g., TMS1234): ");
	            String voterIdentifier = scanner.nextLine();
	            System.out.print("Enter VoterID Constituency: ");
	            String constituency = scanner.nextLine();

	            VoterID voterID = new VoterID(voterNumber, voterIdentifier, constituency);

	            // Input Person details
	            System.out.print("Enter Person Aadhar Number: ");
	            int aadharNumber = scanner.nextInt();
	            scanner.nextLine(); 
	            System.out.print("Enter Person Name: ");
	            String name = scanner.nextLine();

	            Person person = new Person(aadharNumber, name, voterID, address);
	            list.add(person);
	        }

	        // Set bidirectional relationship
	        address.setPerson(list);

	        
	        session.save(address);

	        t.commit();
	        System.out.println("Data successfully inserted!");
	    } catch (Exception e) {
	        if (t != null) {
	            t.rollback();
	        }
	        System.out.println("Error while inserting data: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }

	    return list;
	}


	public List<Person> deleteCandidate(int Person_aadhar) {
		list = new ArrayList<>();

		try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Person.class)
				.addAnnotatedClass(VoterID.class).addAnnotatedClass(Address.class).buildSessionFactory()) {

			Session session = sessionFactory.openSession();
			t = session.beginTransaction();

			Person p1 = session.get(Person.class, Person_aadhar);

			if (p1 != null) {
				session.delete(p1);
				System.out.println("Candidate deleted successfully!");
			} else {
				System.out.println("Candidate with ID " + Person_aadhar + " not found.");
			}
			t.commit();
			list = session.createQuery("from Person", Person.class).getResultList();

		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		}

		return list;
	}

	public List<Person> updatePerson(int personAadhar) {
	    Scanner scanner = new Scanner(System.in);
	    list = new ArrayList<>();

	    try (SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Person.class)
	            .addAnnotatedClass(VoterID.class).addAnnotatedClass(Address.class).buildSessionFactory()) {

	        Session session = sessionFactory.openSession();
	        t = session.beginTransaction();

	        Person person = session.get(Person.class, personAadhar);

	        if (person != null) {
	            System.out.println("Person found: " + person);

	            // Update name
	            System.out.print("Enter new name: ");
	            String newName = scanner.nextLine();
	            person.setName(newName);

	            // Update VoterID details
	            System.out.println("Updating VoterID details:");
	            System.out.print("Enter new VoterID Number: ");
	            int voterNumber = scanner.nextInt();
	            scanner.nextLine(); 
	            System.out.print("Enter new VoterID Identifier (e.g., TMS1234): ");
	            String voterIdentifier = scanner.nextLine();
	            System.out.print("Enter new VoterID Constituency: ");
	            String constituency = scanner.nextLine();

	            VoterID newVoterID = new VoterID(voterNumber, voterIdentifier, constituency);
	            person.setVoterId(newVoterID);

	            
	            session.update(person);
	            t.commit();

	            System.out.println("Person details updated successfully!");
	        } else {
	            System.out.println("Person with Aadhar number " + personAadhar + " not found.");
	        }
	    } catch (Exception e) {
	        if (t != null) {
	            t.rollback();
	        }
	        System.out.println("Error updating person details: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }

	    return list;
	}

}
