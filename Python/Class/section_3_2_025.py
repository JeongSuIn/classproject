# section_3_2_025
# 문자열 관련 메서드

myStr = 'Hello, My little baby'
print(myStr.upper())
print(myStr.lower())
print(myStr.title())
print()

print(myStr.count('b'))
print(myStr.endswith('y'))
print(myStr.startswith('h'))
print(myStr.lower().startswith('h'))
print()

myStrylist1 = myStr.split()
print(myStrylist1)
myStrlist2 = myStr.split(',')
print(myStrlist2)
print()

myStrfill = myStr.zfill(30)
print(myStrfill)