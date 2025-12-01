class Node:
    def __init__(self, val):
        self.data = val
        self.left = None
        self.right = None

def postorder(root, arr):
    if root is None:
        return
    postorder(root.left, arr)
    postorder(root.right, arr)
    arr.append(root.data)

def post_order(root):
    arr = []
    postorder(root, arr)
    return arr

def print_list(lst):
    for num in lst:
        print(num, end=" ")
    print()

if __name__ == "__main__":
    # Creating a sample binary tree
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)

    # Getting postorder traversal
    result = post_order(root)

    # Printing the postorder traversal result
    print("Postorder traversal:", end=" ")
    print_list(result)
