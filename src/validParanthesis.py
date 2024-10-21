def isValid(s) :
    stack = []
    matching = {')': '(', '}': '{', ']': '['}

    for char in s:
        if char in matching:
            if stack and stack[-1] == matching[char]:
                stack.pop()
            else:
                return False
        else:
            stack.append(char)

    return not stack

user_input = input("Enter a string with parentheses: ")

if isValid(user_input):
    print("The parentheses are valid.")
else:
    print("The parentheses are not valid.")
