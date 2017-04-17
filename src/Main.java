public class Main {
    public static void main(String[] args) {
        String fileName = null;

        //check to see if the program was run with the command line argument
        if(args.length > 0) {
            fileName = args[0];
        } else {
            System.out.println("Error: No file was provided.");
            System.exit(9);     // TERMINATE THE PROGRAM
        }

        Explorer exp = new Explorer(DirectoryFactory.createDirTree(fileName));
        exp.process();

	// write your code here
//        Folder root = new Folder(null, "root", 0), folder1 = new Folder(root,"folder1", 1), folder2 = new Folder(root, "folder2", 2);
//        File a = new File("a"), b = new File("b"), c = new File("c"), d = new File("d");
//        root.add(folder1);
//        folder1.add(a);
//        folder1.add(folder2);
//        folder2.add(a);
//        folder2.add(b);
//        folder2.add(c);
//        folder2.add(d);
//        root.add(a);
//        root.add(b);
//        root.listall();
//        System.out.println("\n");
//        root.list();
//        System.out.println("\n");
//        folder1.list();
//        System.out.println("\n");
//        folder1.listall();
//        System.out.println("\n");
//        folder2.list();
//        System.out.println("\n");
//        System.out.println(root.count());
//        System.out.println(folder1.count());
//        System.out.println(folder2.count());
//        System.out.println("\n");
//        System.out.println(root.countall());
//        System.out.println(folder1.countall());
//        System.out.println(folder2.countall());
    }
}
