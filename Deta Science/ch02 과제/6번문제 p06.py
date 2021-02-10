def avg(*args):
    sum = 0

    for i in args:
        sum += i

    result = sum/ len(args)

    print(result)

avg(1,2,3,4,5,6,7,8,9,10)