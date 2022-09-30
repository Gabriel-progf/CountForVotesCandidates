package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import entities.CandidatesForElection;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> totalVotesCantidates = new HashMap<>();
		
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				Integer votes = Integer.parseInt(fields[1]);
				
				CandidatesForElection candidate = new CandidatesForElection(name, votes);
				
				if (totalVotesCantidates.containsKey(candidate.getName())) {
					int totvotes = totalVotesCantidates.get(candidate.getName());
					
					totalVotesCantidates.put(candidate.getName(), votes + totvotes);
				}
				else {
					totalVotesCantidates.put(candidate.getName(), votes);
				}
				
				line = br.readLine();
			}
			
			for (String key: totalVotesCantidates.keySet()) {
				
				System.out.printf("%s: %d \n", key, totalVotesCantidates.get(key));
			}	
			
		}
		catch (IOException e ) {
			System.out.println("Error" + e.getMessage());
		}

		sc.close();
	}

}
