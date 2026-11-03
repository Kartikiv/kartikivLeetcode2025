class FileEntry {
    String name;
    boolean isFile;
    TreeMap<String, FileEntry> children;
    StringBuilder sb;

    public FileEntry(String name) {
        this.name = name;
        this.isFile = false;
        this.children = new TreeMap<>();
        this.sb = new StringBuilder();
    }
}

class FileSystem {
    FileEntry root;

    public FileSystem() {
        this.root = new FileEntry("/");
    }

    public List<String> ls(String path) {
        String[] paths = getPaths(path);
        FileEntry node = root;

        for (String p : paths) {
            if (p.isEmpty())
                continue;
            node = node.children.get(p);
        }

        if (node.isFile) {
            return List.of(node.name);
        }

        return new ArrayList<>(node.children.keySet());
    }

    public void addContentToFile(String filePath, String content) {
        String[] paths = getPaths(filePath);
        FileEntry node = root;

        for (String p : paths) {
            if (p.isEmpty())
                continue;

            FileEntry child = node.children.get(p);
            if (child == null) {
                child = new FileEntry(p);
                node.children.put(p, child);
            }
            node = child;
        }

        node.isFile = true;
        node.sb.append(content);
    }

    public String readContentFromFile(String filePath) {
        String[] paths = getPaths(filePath);
        FileEntry node = root;

        for (String p : paths) {
            if (p.isEmpty())
                continue;
            node = node.children.get(p);
        }

        return node.sb.toString();
    }

    public void mkdir(String path) {
        String[] paths = getPaths(path);
        FileEntry node = root;
        for (String p : paths) {
            if (p.equals(""))
                continue;
            FileEntry child = node.children.get(p);
            if (child == null) {
                child = new FileEntry(p);
                node.children.put(p, child);
            }
            node = child;
        }
    }

    
    private String[] getPaths(String path) {
        return path.split("/");
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */