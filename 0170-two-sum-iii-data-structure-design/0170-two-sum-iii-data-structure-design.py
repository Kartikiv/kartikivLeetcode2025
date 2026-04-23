class TwoSum:

    def __init__(self):
        self.list = []

    def add(self, number: int) -> None:
        self.list.append(number)

    def find(self, value: int) -> bool:
        map = {}
        for i, v in enumerate(self.list):
            diff = value - v
            if diff in map:
                return True
            map[v] = i
        return False
