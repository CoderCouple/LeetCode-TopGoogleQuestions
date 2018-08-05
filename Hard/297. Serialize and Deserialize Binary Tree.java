/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String spliter = ",";
    private static final String nullIndicator = "X";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        getSerializeBinaryTree(root,result);
        return result.toString();
    }
    
    public void getSerializeBinaryTree(TreeNode root, StringBuilder result){
        if(root==null){
            result.append(nullIndicator).append(spliter);
            return;
        }
        result.append(root.val).append(spliter);
        getSerializeBinaryTree(root.left,result);
        getSerializeBinaryTree(root.right,result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] dataArray = data.split(spliter);
        ArrayList<String> list= new ArrayList<String>(Arrays.asList(dataArray));
        Iterator<String> it = list.iterator();
        return getDeSerializeBinaryTree(it);
    }
    
    public TreeNode getDeSerializeBinaryTree(Iterator<String> it){
        TreeNode root = null;
        String s = it.next();
        if(s.equals("X"))
            return root;

            root = new TreeNode(Integer.valueOf(s));
            root.left = getDeSerializeBinaryTree(it);
            root.right = getDeSerializeBinaryTree(it); 
        
        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
