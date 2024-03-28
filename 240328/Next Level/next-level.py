class node:
    def __init__(self, name = "codetree", level = 10):
        self.name = name
        self.level = level


user1 = node()
print(f"user {user1.name} lv {user1.level}")
user2 = node()
user2.name = "hello"
user2.level = 28
print(f"user {user2.name} lv {user2.level}")