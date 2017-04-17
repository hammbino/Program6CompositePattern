/*
 * Created by jeffrey hammond on 4/10/17.
 */
public abstract class FileSystemComponent {
	static StringBuffer indent = new StringBuffer();
	String name;
	int level;

	public void add(FileSystemComponent fileSystemComponent) {
		throw new UnsupportedOperationException();
	}

	String getName() {
		return name;
	}

	int getLevel() {
		return level;
	}

	public void list() {
		throw new UnsupportedOperationException();
	}

	abstract void listall();

	public int getCount() {
		return 0;
	}

	public int count() {
		throw new UnsupportedOperationException();
	}

	abstract int countall();

	public FileSystemComponent up() {
		throw new UnsupportedOperationException();
	}

	public FileSystemComponent chdir(String fileName) {
		throw new UnsupportedOperationException();
	}

	public FileSystemComponent getParent() {
		throw new UnsupportedOperationException();
	}
}
