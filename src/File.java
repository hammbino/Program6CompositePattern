/*
 * Created by jeffrey hammond on 4/10/17.
 */
public class File extends FileSystemComponent {

	File (String name) {
		super.name = name;
//		super.level = level;
	}

	public void listall() {
		System.out.println(indent.toString() + getName());
	}
	public int getCount() {
		return 1;
	}
	public int countall() {
		return 1;
	}
	public FileSystemComponent chdir(String fileName) {
			return null;
	}
}
