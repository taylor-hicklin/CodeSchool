package controller;

import dao.BaseballLeaguePersistenceException;
import dto.Player;
import dto.Team;
import service.BaseballLeagueServiceLayer;
import service.TeamNotFoundException;
import ui.BaseballLeagueView;

import java.util.List;

public class BaseballLeagueController {

    private BaseballLeagueView view;
    private BaseballLeagueServiceLayer service;

    public BaseballLeagueController(BaseballLeagueView view, BaseballLeagueServiceLayer service) {
        this.view = view;
        this.service = service;
    }


    public void run(){
        boolean isRunning = true;
        int userSelection = 0;

        displayOpeningBanner();

        while(isRunning){
            userSelection = displayMenuAndPromptUserForSelection();

            switch(userSelection){
                case 1:
                    createTeam();
                    break;
                case 2:
                    createPlayer();
                    break;
                case 3:
                    ListAllTeams();
                    break;
                case 4:
                    displayAllPlayersOnATeam();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    isRunning = false;
                    displayExitMessage();
                    break;
            }
        }
    }

    private void displayOpeningBanner(){
        view.displayOpeningBanner();
    }

    private int displayMenuAndPromptUserForSelection(){
        return view.displayMenuAndPromptForSelection();
    }

    private void displayExitMessage(){
        view.displayExitMessage();
    }

    private void createTeam(){

        try {
            // get new team name & league from the user
            String teamName = view.promptForTeamName();
            String leagueName = view.promptForTeamLeague();

            // call service to create team
            Team newTeam = service.createTeam(teamName, leagueName);

            if(newTeam != null) {
                //display success
                view.displaySuccessCreateNewTeam(newTeam);
            }

            view.promptUserToHitEnterToContinue();

        }catch (BaseballLeaguePersistenceException e){
            view.displayError(e.getMessage());
        }


    }

    private void ListAllTeams(){
        try {
            List<Team> allTeams = service.retrieveAllTeams();
            view.displayAllTeams(allTeams);
        } catch(BaseballLeaguePersistenceException e){
            view.displayError(e.getMessage());
        }
    }

    private void createPlayer(){

        try {
            // get new player details from user
            Player newPlayer = view.promptForNewPlayerInfo();
            // pass to service
            service.createPlayer(newPlayer);
        } catch(BaseballLeaguePersistenceException | TeamNotFoundException e){
            view.displayError(e.getMessage());
        }
    }

    private void displayAllPlayersOnATeam(){
        try {
            String teamName = view.promptForTeamName();
            List<Player> allPlayers = service.retrieveAllPlayersWithTeamName(teamName);
            view.displayAllPlayers(allPlayers);
        } catch(TeamNotFoundException | BaseballLeaguePersistenceException e){
            view.displayError(e.getMessage());
        }
    }


}
