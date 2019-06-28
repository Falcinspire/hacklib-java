package com.falcinspire.hacklib.tree

object BinaryNodePrinter {
    fun inorder(tree: BinaryNode?) {
        if (tree == null) return
        inorder(tree.left)
        print("${tree.value} ")
        inorder(tree.right)
    }
    fun preorder(tree: BinaryNode?) {
        if (tree == null) return
        print("${tree.value} ")
        preorder(tree.left)
        preorder(tree.right)
    }
    fun postorder(tree: BinaryNode?) {
        if (tree == null) return
        postorder(tree.left)
        postorder(tree.right)
        print("${tree.value} ")
    }
}