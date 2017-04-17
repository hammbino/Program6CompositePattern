/*
 * Created by jeffrey hammond on 4/16/17.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DirectoryFactory {
	private static FileSystemComponent root  = new Folder(null, "", -1);

	static FileSystemComponent createDirTree(String fileName) {
		Scanner fileReader = null;
		FileSystemComponent currentFolder = root;

		try {
			fileReader = new Scanner(new FileInputStream(fileName)).useDelimiter("\\n|\\r");
		} catch (FileNotFoundException x) {
			System.out.println("ERROR: Unable to open file " + fileName);
			x.printStackTrace();
			System.exit(7);   // TERMINATE THE PROGRAM
		}


		while (fileReader.hasNextLine()) {
			String name = fileReader.nextLine();

			if (!(name.isEmpty())) {
				int level = getLevel(name);

				name = name.trim();
				if (name.matches(".*:")) {
					name = name.replace(":", "");
					Folder newFolder = new Folder(currentFolder, name, level);
					if(level == (currentFolder.getLevel() + 1)) {
						currentFolder.add(newFolder);
						currentFolder = newFolder;
					} else {
						while (level != (currentFolder.getLevel() + 1)) {
							currentFolder = currentFolder.getParent();
						}
						currentFolder.add(newFolder);
						currentFolder = newFolder;
					}
				} else {
					File newFile = new File(name);
					if(level == (currentFolder.getLevel() + 1)) {
						currentFolder.add(newFile);
					} else {
						if (level == currentFolder.getLevel()) {
							currentFolder = currentFolder.getParent();
							currentFolder.add(newFile);
						}
					}
				}
			}
		}
		fileReader.close();
		return root;
	}

	public static int getLevel(String s) {
		String s2 = s.replaceAll("^\\s+", "");
		return ((s.length() - s2.length()) / 3);
	}

}
