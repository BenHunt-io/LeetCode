/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        boolean traversing = true;
        boolean doneFlag = false;
        TreeNode parent;
        TreeNode ptr = root;
        List<Integer> list = new ArrayList<>();      
        Stack<TreeNode> nodeStack = new Stack<>();
        
        if(root == null){
            return list;
        }
        // mimic normal tree-walk recursion with the use of a stack.
        // use flag done to signify if a left subtree has already been processed.
        while(traversing){
            
            if(ptr.left != null && !doneFlag){
                nodeStack.push(ptr);
                ptr = ptr.left;
            }
            else if(ptr.right != null){
                doneFlag = false;
                list.add(ptr.val);
                ptr = ptr.right;
            }
            else{
                list.add(ptr.val);
                if(!nodeStack.isEmpty()){
                    ptr = nodeStack.pop();
                    doneFlag = true;
                }
                else
                    break;
            }
            
            
        }
        
        return list;
        
    }
    
    
}



// Better iterative solution:
// public List<Integer> inorderTraversal(TreeNode root) {
//     List<Integer> list = new ArrayList<Integer>();

//     Stack<TreeNode> stack = new Stack<TreeNode>();
//     TreeNode cur = root;

//     while(cur!=null || !stack.empty()){
//         while(cur!=null){
//             stack.add(cur);
//             cur = cur.left;
//         }
//         cur = stack.pop();
//         list.add(cur.val);
//         cur = cur.right;
//     }

//     return list;
// }