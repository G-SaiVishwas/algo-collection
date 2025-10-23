class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None

def inorder(root, arr):
    if root is None:
        return
    inorder(root.left, arr)
    arr.append(root.data)
    inorder(root.right, arr)

def in_order(root):
    arr = []
    inorder(root, arr)
    return arr

if __name__ == "__main__":
    # Creating a sample binary tree
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)

    # Getting inorder traversal
    result = in_order(root)

    # Displaying the inorder traversal result
    print("Inorder Traversal:", end=" ")
    for val in result:
        print(val, end=" ")
    print()
