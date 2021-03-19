# section_3_3_031
# 리스트 관련 내장 함수

floating = [12.837, 4.89, 4037.0, 11.19]

# 항목의 개수
print(len(floating))

# 항목 중 최대값
print(max(floating))

# 항목 중 최소값
print(min(floating))

# 항목들의 합
print(sum(floating))
print()

# 정렬된 새로운 리스트
print(sorted(floating))
print(floating)

string = "python"
# 괄호안의 시퀀스형 객체 string을 리스트로 만들어 준다.
print(list(string))