class Node:
    def __init__(self, key: int, val: int):
        self.key = key
        self.val = val
        self.prev = None
        self.next = None


class LRUCache:

    def __init__(self, capacity: int):
        self.map = {}
        self.capacity = capacity
        self.head = None
        self.tail = None
        self.size = 0

    def get(self, key: int) -> int:
        if key not in self.map:
            return -1

        node = self.map[key]
        self.onKeyAcccessed(key)
        return node.val

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            self.map[key].val = value
            self.onKeyAcccessed(key)
            return

        if self.size == self.capacity:
            self.evict()

        node = Node(key, value)
        self.map[key] = node
        self.addFirst(node)
        self.size += 1

    def onKeyAcccessed(self, key: int) -> None:
        node = self.map[key]

        if node == self.head:
            return

        self.remove(key)
        self.addFirst(node)

    def remove(self, key: int) -> Node:
        node = self.map[key]

        nodePrev = node.prev
        nodeNext = node.next

        if nodePrev:
            nodePrev.next = nodeNext
        else:
            self.head = nodeNext

        if nodeNext:
            nodeNext.prev = nodePrev
        else:
            self.tail = nodePrev

        node.next = None
        node.prev = None

        return node

    def addFirst(self, node: Node) -> None:
        node.prev = None
        node.next = self.head

        if self.head:
            self.head.prev = node
        else:
            self.tail = node

        self.head = node

    def evict(self) -> None:
        victim = self.tail

        if victim:
            self.remove(victim.key)
            self.map.pop(victim.key)
            self.size -= 1