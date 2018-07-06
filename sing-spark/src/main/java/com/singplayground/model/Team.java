package com.singplayground.model;

import java.util.ArrayList;

public class Team {
	
	private String teamName;
	private String teamCode;
	private ArrayList <SubTeam> subTeam;
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public ArrayList<SubTeam> getSubTeam() {
		return subTeam;
	}
	public void setSubTeam(ArrayList<SubTeam> subTeam) {
		this.subTeam = subTeam;
	}

}
