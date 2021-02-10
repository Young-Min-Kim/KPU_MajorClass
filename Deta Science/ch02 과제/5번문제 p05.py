a = "abcde"
b = [1,3,5,6,9]

c =[]
for x,y in zip(a,b):
    c.append((x,y))

print(c)