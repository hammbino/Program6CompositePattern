/*
 * Created by jeffrey hammond on 4/16/17.
 */

import java.util.Scanner;

public class Explorer {
	FileSystemComponent directory;

	public Explorer (FileSystemComponent directory) {
		this.directory = directory;
	}

	public void process() {
		Scanner userInput = new Scanner(System.in);
		String input = "";

		while (!input.equals("q")) {
			System.out.printf("%s> ",directory.getName());
			input = userInput.nextLine().toLowerCase();
			if (input.equals("list")) {
				directory.list();
			} else if (input.equals("listall")) {
				directory.listall();
			} else if (input.matches("^chdir\\b\\s\\w+\\b")) {
				String[] parts = input.split("\\s");
				String folderName = parts[1];
				directory = directory.chdir(folderName);
			} else if (input.equals("up")) {
				directory = directory.up();
			} else if (input.equals("count")) {
				System.out.println(directory.count());
			} else if (input.equals("countall")) {
				System.out.println(directory.countall());
			} else if (input.equals("q")) {
				System.exit(0);
			} else {
				System.out.println("invalid command");
			}
		}
	}
}
