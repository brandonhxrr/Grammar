package grammar;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTree {
    public static class TreeNode{
        String val;
        public List<TreeNode> children = new LinkedList<>();

        TreeNode(String data){
            val = data;
        }

        TreeNode(String data,List<TreeNode> child){
            val = data;
            children = child;
        }
    }

    static String printNAryTree(TreeNode root){
        String deriv = "";
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) {
                TreeNode node = queue.poll();
                assert node != null;
                deriv += node.val + "\t";
                System.out.print(node.val + "\t");
                node.children.forEach(item -> {
                    queue.offer(item);
                });
            }
            deriv += "\n\n";
            System.out.println("\n");
        }
        return deriv;
    }
    
}

