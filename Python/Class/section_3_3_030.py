# section_3_3_030
# 리스트 관련 메서드

colors = ['red', 'orange', 'yellow', 'green', 'yellow']
print(colors)

# 항목 정렬하기
colors.sort()
print(colors)

# 역순 정렬하기
colors.reverse()
print(colors)
print()

# 항목 가져오기
print(colors.pop())
print(colors)

# 항목 삭제하기
colors.remove('red')
print(colors)

# 항목 개수 세기
print(colors.count('yellow'))