/*
 * Created by jeffrey hammond on 4/10/17.
 */
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemComponent {
	private List folder = new ArrayList();
	private FileSystemComponent parent;

	Folder(FileSystemComponent parent, String name, int level){
		super.name = name;
		super.level = level;
		this.parent = parent;
	}

	@Override
	public void add( FileSystemComponent fileSystemComponent ) {
		folder.add(fileSystemComponent);
	}

	@Override
	public void list() {
		for (Object aFolder : folder) {
			FileSystemComponent fileSystemComponent = (FileSystemComponent) aFolder;
			System.out.printf("%s ", fileSystemComponent.getName());
		}
		System.out.println();
	}

	@Override
	public void listall() {
		System.out.println(indent.toString() + getName() + ":");
		indent.append("   ");
		Iterator iterator = folder.iterator();
		while (iterator.hasNext()) {
			FileSystemComponent fileSystemComponent = (FileSystemComponent) iterator.next();
			fileSystemComponent.listall();
		}
		indent.setLength(indent.length() - 3);
	}

	@Override
	public int count() {
		int fileCount = 0;
		Iterator iterator = folder.iterator();
		while (iterator.hasNext()) {
			FileSystemComponent fileSystemComponent = (FileSystemComponent) iterator.next();
			fileCount += fileSystemComponent.getCount();
		}
		return fileCount;
	}

	@Override
	public int countall() {
		int fileCount = 0;
		Iterator iterator = folder.iterator();
		while (iterator.hasNext()) {
			FileSystemComponent fileSystemComponent = (FileSystemComponent) iterator.next();
			fileCount += fileSystemComponent.countall();
		}
		return fileCount;
	}

	@Override
	public FileSystemComponent up() {
		return parent;
	}

	@Override
	public FileSystemComponent chdir(String fileName) {
		FileSystemComponent toReturn = this;
		if (this.getName().equals(fileName)) {
			return this;
		}
		Iterator iterator = folder.iterator();
		while (iterator.hasNext()) {
			FileSystemComponent temp = (FileSystemComponent) iterator.next();
			String compName = temp.getName();
			if (compName.equals(fileName)) {
				toReturn = temp.chdir(fileName);
			}
		}

		if(toReturn == null) {
			System.out.println("no such directory");
			return this;
		}
		return toReturn;
	}

	public FileSystemComponent getParent() {
		return parent;
	}

}
