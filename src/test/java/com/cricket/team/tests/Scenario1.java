package com.cricket.team.tests;

import com.aventstack.extentreports.Status;
import com.cricket.team.models.Player;
import com.cricket.team.models.Team;
import com.cricket.team.utils.Global;
import com.cricket.team.utils.Reporter;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Scenario1 extends Reporter {

    @Test
    @Parameters("inputFilename")
    public void scenario1(String fileName){
        Team team = jsonReader.readTeam(fileName);
        Player[] players = team.getPlayer();
        int foreignPlayersCount = 0;
        for(int i = 0; i<players.length; i++){
            if(!players[i].getCountry().equalsIgnoreCase("India")){
                foreignPlayersCount++;
            }
        }
        try {
            Assert.assertEquals(foreignPlayersCount, 4);
            test.log(Status.PASS, "Team has only 4 players");
        } catch (Throwable t){
            test.log(Status.FAIL, "Team should have at least '"+foreignPlayersCount+"' foreign players, which is not expected "+t.fillInStackTrace());
            throw new RuntimeException(t.getMessage());
        }
    }

}
