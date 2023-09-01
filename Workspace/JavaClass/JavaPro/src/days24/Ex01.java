package days24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Map.Entry;

public class Ex01 {
	static HashMap<String, LinkedHashMap<String, String>> teamGroup = new LinkedHashMap<>();
	public static void main(String[] args) {
		String fileName = ".\\src\\days19\\1. Java 팀 구성.txt";
		String value = null;
		String group = null;

		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((value = br.readLine()) != null && !value.equals("")) {
				
					group = value;
					value = br.readLine();
					String[] team = value.split("\\s*,\\s*");
					addGroup(group, team);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		disp();
		
	} // main

	private static void disp() {
	
		Iterator<Entry<String, LinkedHashMap<String, String>>>  ir = teamGroup.entrySet().iterator();
		while (ir.hasNext()) {
			Entry<String, LinkedHashMap<String, String>> entry =  ir.next();

			String groupName = entry.getKey();
			HashMap<String, String> groupMap = entry.getValue();
			System.out.printf("* %s [%d명]\n", groupName, groupMap.size());

			Iterator<Entry<String, String>> ir2 = groupMap.entrySet().iterator();
			while (ir2.hasNext()) {
				Entry<String, String> entry2 = (Entry<String, String>) ir2.next();
				String name = entry2.getKey();
				String tier = entry2.getValue();
				System.out.printf("\t%s : %s\n", name, tier);
			}
		}
	}
		

	private static void addGroup(String group, String[] team) {
		String tier = null;
		String name = null;
		teamGroup.put(group, new LinkedHashMap<String, String>());
		for (int i = 0; i < team.length; i++) {
			if (team[i].contains(("팀장"))) {
				name = team[i].replace("(팀장)", "");
				tier = "[팀장]";
				HashMap<String, String> teamt = teamGroup.get(group);
				teamt.put(name, tier);
			} else {
				tier = "팀원";
				name = team[i];
				HashMap<String, String> teamt = teamGroup.get(group);
				teamt.put(name, tier);
			}
			
		} // for
		
	}
}
