package com.testvagrant.tests;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.testvagrant.util.Common;

public class CricketTeamMemberValidation {
	static String userDirectory = System.getProperty("user.dir");
	//System.out.println("userDirectory::"+userDirectory);
	public static String JSONFilepath= userDirectory+"\\resources\\TeamRCB.json";
	//public String JSONPathExtratorCountry="";

	/**
	 * Test method to validate the Team RCB as 4 foreign players 
	 * @param Json file path 
	 * @param Json path extractor value
	 * @author LOKESH L R Jan032022
	 * @throws IOException ***/
	@Test(priority =0)
	@Parameters("JSONPathExtratorCountry")
	public static void numberForeignPlayerValidationInRCBTeam(String JSONPathExtratorCountry) throws IOException {
		System.out.println("-------------------------******----------------------------------");
		System.out.println("Validation validate the Team RCB as 4 foreign players Test -Start");
		System.out.println("-------------------------******----------------------------------");
		System.out.println("JSONFilepath::"+JSONFilepath);
		int indianPlayerCount = 0;
		int expectedForeignPlayersCount =4;
		int actualForeignPlayersCount =0;
		ArrayList<String> playerCountryName = Common.getData(JSONFilepath,JSONPathExtratorCountry);

		for(int i = 0; i<=playerCountryName.size()-1;i++) {
			if(playerCountryName.get(i).contentEquals("India")) {
				//System.out.println("Non india country"+playerCountryName.get(i));
				indianPlayerCount++;
			}
			else {
				System.out.println("Foreign player country name :: "+playerCountryName.get(i));
			}
		}

		actualForeignPlayersCount = playerCountryName.size() - indianPlayerCount ;
		Assert.assertEquals(actualForeignPlayersCount, expectedForeignPlayersCount);
		System.out.println("-------------------------******----------------------------------");
		System.out.println("Validation validate the Team RCB as 4 foreign players Test -COMPLETED");
		System.out.println("-------------------------******----------------------------------");
	}

	/**
	 * Test method to validate the Team RCB as at least one wicket keeper 
	 * @param Json file path 
	 * @param Json path extractor value
	 * @author LOKESH L R Jan032022
	 * @throws IOException ***/
	@Test(priority =1)
	@Parameters("JSONPathExtratorRole")
	public static void wicketKeeperInRCBTeam(String JSONPathExtratorRole) throws IOException {
		System.out.println("-------------------------******----------------------------------");
		System.out.println("Validation the Team RCB as at least one wicket keeper Test -Start");
		System.out.println("-------------------------******----------------------------------");
		String expectedRole ="Wicket-keeper"; 
		int expectedWicketKeeperCount=1,actualWicketKeepers =0;

		ArrayList<String> playerRole = Common.getData(JSONFilepath,JSONPathExtratorRole);
		for(String role:playerRole) {
			if(role.contentEquals(expectedRole)) {
				System.out.println("Player Role :: "+role);
				actualWicketKeepers++;

			}

		}
		boolean actual = actualWicketKeepers >=expectedWicketKeeperCount;//Verifying count of the Wicket keeper at least one 
		boolean expected = true;
		Assert.assertEquals(actual, expected);//Validating  count of the Wicket keeper at least one 
		System.out.println("-------------------------******----------------------------------");
		System.out.println("Validation the Team RCB as at least one wicket keeper Test -COMPLETED");
		System.out.println("-------------------------******----------------------------------");
	}
}