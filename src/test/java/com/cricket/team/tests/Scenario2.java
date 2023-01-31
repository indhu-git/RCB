package com.cricket.team.tests;

import com.aventstack.extentreports.Status;
import com.cricket.team.models.Player;
import com.cricket.team.models.Team;
import com.cricket.team.utils.Global;
import com.cricket.team.utils.JsonReader;
import com.cricket.team.utils.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Scenario2 extends Reporter {

    @Test
    @Parameters("inputFilename")
    public void scenario2(String fileName){
        Team team = jsonReader.readTeam(fileName);
        Player[] players = team.getPlayer();
        int wicketkeeperPlayersCount = 0;
        for(int i = 0; i<players.length; i++){
            if(players[i].getRole().equalsIgnoreCase("Wicket-keeper")){
                wicketkeeperPlayersCount++;
                break;
            }
        }
        if(wicketkeeperPlayersCount>0) {
            test.log(Status.PASS, "Team have at least one Wicket-keeper");
        }else {
            test.log(Status.FAIL,"Team does not have Wicket-keeper");
        }
    }
}
