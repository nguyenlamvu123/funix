import numpy as np


def distance(p1, p2):
    """tính khoảng cách"""
    return np.sqrt((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2)


def find_furthest_people(people_positions):
    di_s = []

    for i, person1 in enumerate(people_positions):
        min_d = float('inf')
        for j, person2 in enumerate(people_positions):
            if i != j:  # Không tính khoảng cách tới chính bản thân
                di = distance(person1, person2)
                if di < min_d:
                    min_d = di
        di_s.append((min_d, person1))

    di_s.sort(reverse=True, key=lambda x: x[0])

    top_10_percent_count = int(len(people_positions) * 0.1)
    furthest_people = [di_s[i][1] for i in range(top_10_percent_count)]

    return furthest_people


people_positions = [  # tạo dữ liệu nháp
    (1, 10), (2, 5), (8, 3), (6, 7), (7, 2),
    (4, 4), (9, 9), (10, 10), (3, 8), (11, 12),
    (1, 110), (12, 5), (8, 31), (61, 7), (71, 2),
    (4, 41), (91, 9), (101, 10), (3, 18), (11, 121)
]

furthest_people = find_furthest_people(people_positions)

print("Những người ở xa nhất là:", furthest_people)
